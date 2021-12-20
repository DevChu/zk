/* Textarea.java

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 15:05:13     2005, Created by tomyeh

Copyright (C) 2005 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under LGPL Version 2.1 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.zhtml;

import org.zkoss.lang.Objects;
import org.zkoss.zhtml.impl.PageRenderer;
import org.zkoss.zhtml.impl.TagRenderContext;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.ext.AfterCompose;

/**
 * The TEXTAREA tag.
 *
 * <p>
 * If you instantiate {@link Textarea} directly, you shall use {@link #setValue} to set up the
 * value. You shall not add children to it.
 * 
 * @author tomyeh
 */
public class Textarea extends Input implements AfterCompose {
	private String _value = "";

	static {
		addClientEvent(Textarea.class, Events.ON_CHANGE, 0);
		// don't declare as CE_IMPORTANT since it is not applicable
		// (all zhtml components share the same widget class)
	}

	public Textarea() {
		super("textarea");
	}

	public Textarea(String value) {
		super("textarea");
		_value = value != null ? value : "";
	}

	/**
	 * Returns the cols of this textarea tag.
	 * @since 8.0.3
	 */
	public Integer getCols() {
		return (Integer) getDynamicProperty("cols");
	}

	/**
	 * Sets the cols of this textarea tag.
	 * @since 8.0.3
	 */
	public void setCols(Integer cols) throws WrongValueException {
		setDynamicProperty("cols", cols);
	}
	/**
	 * Returns the rows of this textarea tag.
	 * @since 8.0.3
	 */
	public Integer getRows() {
		return (Integer) getDynamicProperty("rows");
	}

	/**
	 * Sets the rows of this textarea tag.
	 * @since 8.0.3
	 */
	public void setRows(Integer rows) throws WrongValueException {
		setDynamicProperty("rows", rows);
	}
	/**
	 * Returns the wrap of this textarea tag.
	 * <p>Notice that this attribute refers to the corresponding attribute of the HTML5 specification.
	 * Hence, it would still be rendered to client-side as a DOM attribute even if the browser doesn’t support it.
	 * @since 8.0.3
	 */
	public String getWrap() {
		return (String) getDynamicProperty("wrap");
	}

	/**
	 * Sets the wrap of this textarea tag.
	 * <p>Notice that this attribute refers to the corresponding attribute of the HTML5 specification.
	 * Hence, it would still be rendered to client-side as a DOM attribute even if the browser doesn’t support it.
	 * @since 8.0.3
	 */
	public void setWrap(String wrap) throws WrongValueException {
		setDynamicProperty("wrap", wrap);
	}

	public void afterCompose() {
		String content = PageRenderer.childrenToContent(this);
		if (content != null)
			setValue(content);
	}

	public void setDynamicProperty(String name, java.lang.Object value) throws WrongValueException {
		if ("value".equals(name)) {
			_value = Objects.toString(value);
			if (_value == null)
				_value = "";
		} else {
			super.setDynamicProperty(name, value);
		}
	}

	public java.lang.Object getDynamicProperty(String name) {
		return "value".equals(name) ? _value : super.getDynamicProperty(name);
	}

	// -- Component --//
	/**
	 * Returns the widget class, "zhtml.Input".
	 * 
	 * @since 8.0.0
	 */
	public String getWidgetClass() {
		return "zhtml.Input";
	}

	protected void renderProperties(org.zkoss.zk.ui.sys.ContentRenderer renderer)
			throws java.io.IOException {
		super.renderProperties(renderer);
		render(renderer, "value", _value);
	}

	protected void redrawChildrenDirectly(TagRenderContext rc, Execution exec, java.io.Writer out)
			throws java.io.IOException {
		out.write(_value);
		super.redrawChildrenDirectly(rc, exec, out);
	}
}
