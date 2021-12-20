/* F90_ZK_4352Test.java

	Purpose:
		
	Description:
		
	History:
		Mon Aug 19 14:27:36 CST 2019, Created by rudyhuang

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;

import org.zkoss.zktest.zats.WebDriverTestCase;
import org.zkoss.zktest.zats.ztl.ClientWidget;

/**
 * @author rudyhuang
 */
public class F90_ZK_4352Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();

		Assert.assertEquals("2000/01/01 PM 02:23:55", jq("@textbox:eq(0)").val());
		Assert.assertEquals("2000/01/01", jq("@textbox:eq(1)").val());
		Assert.assertEquals("14:23:55", jq("@textbox:eq(2)").val());

		clickAndType(jq("@textbox:eq(0)"), "2019/08/19 AM 09:30:59");
		clickAndType(jq("@textbox:eq(1)"), "2012/12/31");
		clickAndType(jq("@textbox:eq(2)"), "23:59:59");

		click(jq("@button:eq(0)"));
		waitResponse();
		Assert.assertEquals("2019-08-19T09:30:59", getZKLog());
		closeZKLog();

		click(jq("@button:eq(1)"));
		waitResponse();
		Assert.assertEquals("2012-12-31", getZKLog());
		closeZKLog();

		click(jq("@button:eq(2)"));
		waitResponse();
		Assert.assertEquals("23:59:59", getZKLog());
		closeZKLog();
	}

	private void clickAndType(ClientWidget locator, String text) {
		click(locator);
		selectAll();
		sendKeys(locator, text);
		click(jq("body"));
		waitResponse();
	}
}
