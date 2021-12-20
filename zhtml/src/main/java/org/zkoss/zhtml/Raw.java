/* Raw.java

	Purpose:
		
	Description:
		
	History:
		Tue Oct  4 09:15:59     2005, Created by tomyeh

Copyright (C) 2005 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under LGPL Version 2.1 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.zhtml;

import org.zkoss.zhtml.impl.AbstractTag;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.ext.DynamicTag;

/**
 * The raw component used to generate raw HTML elements.
 *
 * @author tomyeh
 */
public class Raw extends AbstractTag implements DynamicTag {
	public Raw(String tagname) {
		super(tagname);
	}

	public Raw() {
	}

	// -- DynamicTag --//
	public boolean hasTag(String tagname) {
		return tagname != null && !"zscript".equals(tagname) && !"attribute".equals(tagname);
	}

	public void setTag(String tagname) throws WrongValueException {
		if (tagname == null || tagname.length() == 0)
			throw new WrongValueException("A tag name is required");
		_tagnm = tagname;
	}
}
