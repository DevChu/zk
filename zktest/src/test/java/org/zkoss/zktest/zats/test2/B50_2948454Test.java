/* B50_2948454Test.java

	Purpose:
		
	Description:
		
	History:
		Thu Mar 21 12:02:21 CST 2019, Created by rudyhuang

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;

import org.zkoss.zktest.zats.WebDriverTestCase;

/**
 * @author rudyhuang
 */
public class B50_2948454Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();

		click(jq("@button:eq(0)"));
		waitResponse();
		click(jq("@button:eq(1)"));
		waitResponse();
		Assert.assertTrue(jq(".z-messagebox-window").exists());
		Assert.assertEquals("success:target", jq(".z-messagebox @label").text());
	}
}
