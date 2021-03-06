/* ServerPush2.java

	Purpose:
		
	Description:
		
	History:
		Mon Nov 22 10:46:57 TST 2010, Created by tomyeh

Copyright (C) 2009 Potix Corporation. All Rights Reserved.

*/
package org.zkoss.zktest.test2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.lang.Threads;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.EventQueue;
import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.sys.DesktopCtrl;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Separator;
import org.zkoss.zul.Textbox;

/**
 * Used to test the server-push's schedule feature.
 *
 * @author tomyeh
 */
public class ServerPush2 {
	private static final Logger log = LoggerFactory.getLogger(ServerPush2.class);

	public static void start(Component info, Textbox tb) throws InterruptedException {
		start(null, info, tb);
	}
	public static class ServerPushEventListener implements EventListener {
		private Component info;
		private Textbox tb;
		public ServerPushEventListener(Component info, Textbox tb) {
			this.info = info;
			this.tb = tb;
		}
        public void onEvent(Event evt) {
        	ServerPush2.updateInfo(info, tb, "comet(sched) => event queue");
        }
    }
	public static void start(org.zkoss.zk.ui.sys.ServerPush sp, final Component info, final Textbox tb) throws InterruptedException {
		final Desktop desktop = Executions.getCurrent().getDesktop();
		if (desktop.isServerPushEnabled()) {
			Messagebox.show("Already started");
		} else {
			desktop.removeAttribute("sp.ceased");
			if (sp != null)
				((DesktopCtrl)desktop).enableServerPush(sp);
			else
				desktop.enableServerPush(true);
			new WorkingThread(info, tb).start();
			ServerPushEventListener spel = new ServerPushEventListener(info,tb);
			desktop.setAttribute("spel", spel);
			 que.subscribe(spel); 
		}
	}
	public static void stop() throws InterruptedException {
		final Desktop desktop = Executions.getCurrent().getDesktop();
		if (desktop.isServerPushEnabled()) {
			desktop.enableServerPush(false);
			desktop.setAttribute("sp.ceased", Boolean.TRUE);
			que.unsubscribe((ServerPushEventListener)desktop.getAttribute("spel"));
		} else {
			Messagebox.show("Already stopped");
		}
	}
	public static void updateInfo(Component info, Textbox tb, String postfix) {
		Integer i = (Integer)info.getAttribute("count");
		int v = i == null ? 0: i.intValue() + 1;
		if (info.getChildren().size() >= 10) {
			((Component)info.getChildren().get(0)).detach();
			((Component)info.getChildren().get(0)).detach();
		}
		info.setAttribute("count", new Integer(v));
		info.appendChild(new Label(" " + v + ", " + tb.getValue() + " " + postfix));
		info.appendChild(new Separator());
			//create a new component that is easier to detect bugs
	}
	static EventQueue que = EventQueues.lookup("chat", EventQueues.APPLICATION, true);
	private static class WorkingThread extends Thread {
		private final Desktop _desktop;
		private final Component _info;
		private final Textbox _tb;
		private WorkingThread(Component info, Textbox tb) {
			_desktop = info.getDesktop();
			_info = info;
			_tb = tb;
		}
		public void run() {
			while (_desktop.getAttribute("sp.ceased") == null) {
				if (!_desktop.isServerPushEnabled())
					break;
				que.publish(new Event("onChat", _tb, _info));
				Executions.schedule(_desktop,
					new EventListener() {
						public void onEvent(Event event) {
							updateInfo(_info, _tb, "comet(sched)");
						}
					}, null);
				Threads.sleep(2000); //Update every two seconds
			}
			log.info("The server push thread ceased");
		}
	}
}
