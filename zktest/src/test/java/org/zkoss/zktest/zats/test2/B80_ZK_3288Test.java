/* B80_ZK_3288Test.java

		Purpose:
                
		Description:
                
		History:
				Mon Mar 25 16:04:48 CST 2019, Created by charlesqiu

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;

import org.zkoss.zktest.zats.WebDriverTestCase;
import org.zkoss.zktest.zats.ztl.JQuery;

public class B80_ZK_3288Test extends WebDriverTestCase {

	@Test
	public void test() {
		connect();

		JQuery buttons = jq(".z-button");
		JQuery centerBody = jq(".z-center-body");
		JQuery div = jq("$container");

		click(buttons.eq(0));
		waitResponse();
		click(buttons.eq(1));
		waitResponse();
		Assert.assertTrue(centerBody.width() > div.width());
		click(buttons.eq(2));
		waitResponse();
		Assert.assertEquals(centerBody.width(), div.width(), 1);
	}
}
