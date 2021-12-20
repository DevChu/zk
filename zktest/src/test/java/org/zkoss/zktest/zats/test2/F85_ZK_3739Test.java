/* F85_ZK_3739Test.java

	Purpose:
		
	Description:
		
	History:
		Wed Jun 19 12:41:37 CST 2019, Created by rudyhuang

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;

import org.zkoss.zktest.zats.WebDriverTestCase;
import org.zkoss.zktest.zats.ztl.JQuery;

/**
 * @author rudyhuang
 */
public class F85_ZK_3739Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();

		JQuery textbox = jq("@textbox");
		click(textbox);
		setCursorPosition(textbox, 2);

		click(jq("@toolbarbutton:eq(0)"));
		waitResponse();
		click(jq("@toolbarbutton:eq(3)"));
		waitResponse();

		// Check client
		Assert.assertEquals("==SELECT DISTINCT ======================", textbox.val());

		click(jq("@button"));
		waitResponse();

		// Check server
		Assert.assertEquals("==SELECT DISTINCT ======================", getZKLog());
	}
}
