/* F90_ZK_4380Test.java

	Purpose:
		
	Description:
		
	History:
		Fri Sep 20 15:40:44 CST 2019, Created by rudyhuang

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zephyr.webdriver.test2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import org.zkoss.test.webdriver.WebDriverTestCase;

/**
 * @author rudyhuang
 */
public class F90_ZK_4380_bindTest extends WebDriverTestCase {
	@Test
	public void testSingleSelection() {
		connect();

		click(jq("@searchbox:eq(0)"));
		waitResponse(true);
		getActions().sendKeys("A").perform();
		waitResponse();
		click(jq(".z-searchbox-item:contains(Asia)"));
		waitResponse();

		click(jq("@searchbox:eq(1)"));
		waitResponse(true);
		getActions().sendKeys("J").perform();
		waitResponse();
		click(jq(".z-searchbox-item:contains(Java)"));
		click(jq(".z-searchbox-item:contains(Julia)"));
		waitResponse();

		click(jq("@button"));
		waitResponse();

		Assertions.assertEquals("Asia / Java, Julia", getZKLog());
	}

	@Test
	public void testSubModelSelection() {
		connect();

		click(jq("@searchbox:eq(0)"));
		waitResponse(true);
		getActions().sendKeys("A").perform();
		waitResponse();
		click(jq(".z-searchbox-item:contains(Asia)"));
		waitResponse();

		click(jq("@searchbox:eq(0)"));
		waitResponse(true);
		getActions().sendKeys(Keys.BACK_SPACE, "B").perform();
		waitResponse();
		getActions().sendKeys(Keys.BACK_SPACE, "A").perform();
		waitResponse();

		Assertions.assertEquals("Asia", jq(".z-searchbox-selected").text());
	}
}
