/* F85_ZK_3739Test.java

	Purpose:
		
	Description:
		
	History:
		Wed Jun 19 12:41:37 CST 2019, Created by rudyhuang

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.clientbind.webdriver.test2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.zkoss.clientbind.webdriver.ClientBindTestCase;
import org.zkoss.test.webdriver.ztl.JQuery;

/**
 * @author rudyhuang
 */
@Disabled
public class F85_ZK_3739Test extends ClientBindTestCase {
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
		Assertions.assertEquals("==SELECT DISTINCT ======================", textbox.val());

		click(jq("@button"));
		waitResponse();

		// Check server
		Assertions.assertEquals("==SELECT DISTINCT ======================", getZKLog());
	}
}
