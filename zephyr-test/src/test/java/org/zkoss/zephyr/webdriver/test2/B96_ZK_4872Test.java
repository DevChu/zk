/* B96_ZK_4872Test.java

	Purpose:
		
	Description:
		
	History:
		Tue May 11 11:28:07 CST 2021, Created by rudyhuang

Copyright (C) 2021 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zephyr.webdriver.test2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Select;

import org.zkoss.test.webdriver.WebDriverTestCase;

/**
 * @author rudyhuang
 */
public class B96_ZK_4872Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();
		waitResponse();
		Assertions.assertEquals("item 1-1", jq(":selected").text());

		new Select(toElement(jq("@select"))).selectByVisibleText("item 2-2");
		waitResponse();
		Assertions.assertEquals("item 2-2", jq(":selected").text());
	}
}
