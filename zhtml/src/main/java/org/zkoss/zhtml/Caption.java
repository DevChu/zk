/* Caption.java

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 14:59:34     2005, Created by tomyeh

Copyright (C) 2005 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under LGPL Version 2.1 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.zhtml;

import org.zkoss.zhtml.impl.AbstractTag;

/**
 * The CAPTION tag.
 * 
 * @author tomyeh
 */
public class Caption extends AbstractTag {
	public Caption() {
		super("caption");
	}

	public Caption(String label) {
		this();
		new Text(label).setParent(this);
	}
}
