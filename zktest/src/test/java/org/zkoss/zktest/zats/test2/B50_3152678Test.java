/* B50_3152678Test.java

		Purpose:
                
		Description:
                
		History:
				Thu Mar 21 15:24:13 CST 2019, Created by charlesqiu

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;

import org.zkoss.zktest.zats.WebDriverTestCase;
import org.zkoss.zktest.zats.ztl.JQuery;

public class B50_3152678Test extends WebDriverTestCase {

	@Test
	public void test() {
		connect();
		for (JQuery button : jq(".z-button")) {
			click(button);
			waitResponse();
			JQuery panelBody = jq(".z-panel-body");
			int height = 0;
			for (JQuery child : panelBody.children()) {
				height += child.outerHeight();
			}
			Assert.assertEquals(panelBody.height(), height);
		}
	}
}
