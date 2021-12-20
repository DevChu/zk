/* InterpretResolver.java

	Purpose:
		
	Description:
		
	History:
		Sat Sep 17 17:03:58     2005, Created by tomyeh

Copyright (C) 2004 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under LGPL Version 2.1 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.web.servlet.dsp.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.web.servlet.dsp.Interpretation;
import org.zkoss.web.servlet.dsp.action.ActionContext;
import org.zkoss.xel.VariableResolver;
import org.zkoss.xel.XelException;
import org.zkoss.xel.util.Evaluators;

/**
 * The resolver used to interpret an {@link Interpretation}.
 *
 * @author tomyeh
 */
class InterpretResolver implements VariableResolver {
	private final VariableResolver _parent;
	private final Map<String, Object> _attrs = new HashMap<String, Object>();

	InterpretResolver(VariableResolver parent) {
		assert !(parent instanceof InterpretResolver);
		_parent = parent;
	}

	/** Returns the attributes of the given scope.
	 */
	@SuppressWarnings("unchecked")
	Map<String, Object> getAttributes(int scope) throws XelException {
		if (scope == ActionContext.PAGE_SCOPE)
			return _attrs;

		Map attrs = null;
		if (_parent != null) {
			switch (scope) {
			case ActionContext.REQUEST_SCOPE:
				attrs = (Map) Evaluators.resolveVariable(_parent, "requestScope");
				break;
			case ActionContext.SESSION_SCOPE:
				attrs = (Map) Evaluators.resolveVariable(_parent, "sessionScope");
				break;
			case ActionContext.APPLICATION_SCOPE:
				attrs = (Map) Evaluators.resolveVariable(_parent, "applicationScope");
				break;
			}
		}
		return attrs != null ? attrs : Collections.EMPTY_MAP;
	}

	//-- VariableResolver --//
	public Object resolveVariable(String name) throws XelException {
		if ("pageScope".equals(name))
			return _attrs;
		final Object o = _attrs.get(name);
		return o != null ? o : Evaluators.resolveVariable(_parent, name);
	}
}
