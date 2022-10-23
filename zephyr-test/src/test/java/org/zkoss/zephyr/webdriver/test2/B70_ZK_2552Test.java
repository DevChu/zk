/* B70_ZK_2552Test.java

	Purpose:
		
	Description:
		
	History:
		Wed Apr 03 11:08:26 CST 2019, Created by rudyhuang

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zephyr.webdriver.test2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.zkoss.zephyr.webdriver.ZephyrClientMVVMTestCase;

/**
 * @author rudyhuang
 */
public class B70_ZK_2552Test extends ZephyrClientMVVMTestCase {
	@Test
	public void test() {
		connect();
		click(widget("@tab:eq(2)").$n("cls"));
		waitResponse();

		Assertions.assertEquals("eee", jq("@tab:last").text());
	}
}
