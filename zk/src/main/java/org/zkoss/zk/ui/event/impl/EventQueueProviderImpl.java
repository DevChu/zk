/* EventQueueProviderImpl.java

	Purpose:
		
	Description:
		
	History:
		Thu Jul 23 19:36:16     2009, Created by tomyeh

	Copyright (C) 2009 Potix Corporation. All Rights Reserved.

*/
package org.zkoss.zk.ui.event.impl;

import static org.zkoss.lang.Generics.cast;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.WebApp;
import org.zkoss.zk.ui.WebApps;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventQueue;
import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.ext.Scope;
import org.zkoss.zk.ui.impl.DesktopImpl;
import org.zkoss.zk.ui.impl.PollingServerPush;
import org.zkoss.zk.ui.sys.ExecutionCtrl;
import org.zkoss.zk.ui.util.Callback;

/**
 * A simple implementation of {@link EventQueueProvider}.
 *
 * @author tomyeh
 * @since 5.0.0
 */
public class EventQueueProviderImpl implements EventQueueProvider {
	private static final Logger log = LoggerFactory.getLogger(EventQueueProviderImpl.class);

	/** The attribute used to store the map of event queues.
	 */
	protected static final String ATTR_EVENT_QUEUES = "org.zkoss.zk.ui.event.eventQueues";

	public <T extends Event> EventQueue<T> lookup(String name, String scope, boolean autoCreate) {

		final boolean bAppScope = EventQueues.APPLICATION.equals(scope);
		final boolean bSessionScope = EventQueues.SESSION.equals(scope);

		// if the scope is in session or application, it won't need an Execution
		// to work with this event queue for publishing
		if (bSessionScope && Sessions.getCurrent() == null) {
			throw new IllegalStateException("Current session is not available");
		} else if (bAppScope || bSessionScope) {
			return lookup0(name, bAppScope ? (Scope) WebApps.getCurrent() : Sessions.getCurrent(), autoCreate);
		} else if (EventQueues.DESKTOP.equals(scope)) {
			final Execution exec = Executions.getCurrent();

			if (exec == null)
				throw new IllegalStateException("Not in an execution");

			final Desktop desktop = exec.getDesktop();
			Map<String, EventQueue<T>> eqs = cast((Map) desktop.getAttribute(ATTR_EVENT_QUEUES));
			if (eqs == null)
				desktop.setAttribute(ATTR_EVENT_QUEUES, eqs = new HashMap<String, EventQueue<T>>(4));

			EventQueue<T> eq = eqs.get(name);
			if (autoCreate && eq == null)
				eqs.put(name, eq = new DesktopEventQueue<T>());

			if (log.isDebugEnabled()) {
				log.debug("Lookup event queue: name [{}], scope [{}], autoCreate [{}]", name, scope, autoCreate);
			}
			return eq;
		} else
			throw new UnsupportedOperationException("Unknown scope: " + scope);
	}

	public <T extends Event> EventQueue<T> lookup(String name, Session sess, boolean autoCreate) {
		return lookup0(name, sess, autoCreate);
	}

	public <T extends Event> EventQueue<T> lookup(String name, WebApp wapp, boolean autoCreate) {
		return lookup0(name, wapp, autoCreate);
	}

	/** Looks up a session or application scoped event queue. */
	private <T extends Event> EventQueue<T> lookup0(String name, Scope ctxscope, boolean autoCreate) {
		Map<String, EventQueue<T>> eqs;
		synchronized (ctxscope) {
			eqs = cast((Map) ctxscope.getAttribute(ATTR_EVENT_QUEUES));
			if (eqs == null)
				ctxscope.setAttribute(ATTR_EVENT_QUEUES, eqs = new HashMap<String, EventQueue<T>>(4));
		}

		EventQueue<T> eq;
		synchronized (eqs) {
			eq = eqs.get(name);
			if (autoCreate && eq == null)
				eqs.put(name, eq = new ServerPushEventQueue<T>());
		}

		if (log.isDebugEnabled()) {
			log.debug("Lookup event queue: name [{}], scope [{}], autoCreate [{}]", name, ctxscope, autoCreate);
		}
		return eq;
	}

	public boolean remove(String name, String scope) {
		final Execution exec = Executions.getCurrent();
		if (exec == null)
			throw new IllegalStateException("Not in an execution");

		if (EventQueues.DESKTOP.equals(scope))
			return remove0(name, exec.getDesktop());
		if (EventQueues.APPLICATION.equals(scope))
			return remove0(name, exec.getDesktop().getWebApp());
		if (EventQueues.SESSION.equals(scope))
			return remove0(name, exec.getSession());
		return false;
	}

	public boolean remove(String name, Session sess) {
		return remove0(name, sess);
	}

	public boolean remove(String name, WebApp wapp) {
		return remove0(name, wapp);
	}

	private boolean remove0(String name, Scope ctxscope) {
		Map<String, EventQueue> eqs;
		synchronized (ctxscope) {
			eqs = cast((Map) ctxscope.getAttribute(ATTR_EVENT_QUEUES));
		}
		if (eqs != null) {
			EventQueue eq;
			synchronized (eqs) {
				eq = eqs.remove(name);
			}
			if (eq != null) {
				Execution execution = Executions.getCurrent();
				DesktopImpl desktopImpl = (execution != null ? (DesktopImpl) execution.getDesktop() : null);

				// if the runtime is not in servlet 3.0, we use the original way to close.
				if (execution == null || WebApps.getCurrent().getServletContext().getMajorVersion() < 3
						|| (desktopImpl != null && desktopImpl.isServerPushEnabled() && desktopImpl.getServerPush() instanceof PollingServerPush)) {
					eq.close();
				} else {
					// Bug ZK-2574
					final EventQueue callbackEq = eq;
					((ExecutionCtrl) execution).addOnDeactivate(new Callback<Object>() {
						public void call(Object data) {
							callbackEq.close();
						}
					});
				}
				if (log.isDebugEnabled()) {
					log.debug("Remove the event queue: name [{}], scope [{}]", name, ctxscope);
				}
				return true;
			}
		}
		if (log.isDebugEnabled()) {
			log.debug("Fail to remove the event queue: name [{}], scope [{}]", name, ctxscope);
		}
		return false;
	}
}
