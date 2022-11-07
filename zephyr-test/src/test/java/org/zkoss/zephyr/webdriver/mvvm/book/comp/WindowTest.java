/* WindowTest.java

	Purpose:
		
	Description:
		
	History:
		Wed Apr 28 10:52:22 CST 2021, Created by rudyhuang

Copyright (C) 2021 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zephyr.webdriver.mvvm.book.comp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import org.zkoss.test.webdriver.WebDriverTestCase;
import org.zkoss.test.webdriver.ztl.JQuery;

/**
 * @author rudyhuang
 */
public class WindowTest extends WebDriverTestCase {
	@Test
	public void testMaximize() {
		connect();

		final JQuery maximizeBtn = jq(".z-window-maximize");
		final JQuery maximized = jq("$maximized");

		click(maximizeBtn);
		waitResponse(true);
		assertEquals("true", maximized.text());
		click(maximizeBtn);
		waitResponse(true);
		assertEquals("false", maximized.text());
	}

	@Test
	public void testZIndex() {
		connect();

		click(jq("$window2ZIndexAdd"));
		waitResponse();
		click(jq("$window1ZIndexAdd"));
		waitResponse();
		assertEquals("4", jq("$window2Zindex").text());
		assertEquals("4", jq("$window1Zindex").text());
	}
}
