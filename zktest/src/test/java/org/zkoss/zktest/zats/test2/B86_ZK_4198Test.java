/* B86_ZK_4198Test.java

	Purpose:
		
	Description:
		
	History:
		Fri Jan 18 17:04:29 CST 2019, Created by rudyhuang

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
public class B86_ZK_4198Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();

		testFormat(jq("@decimalbox:eq(0)"), "123456.789", "123.456.789");
		testFormat(jq("@decimalbox:eq(1)"), "123456.789", "123,456.789");
		testFormat(jq("@decimalbox:eq(2)"), "123456.789", "123.456.789");
		testFormat(jq("@decimalbox:eq(3)"), "123456.789", "123,456.789");
	}

	private void testFormat(JQuery box, String typed, String formatted) {
		type(box, typed);
		waitResponse();
		Assert.assertEquals(formatted, box.val());
	}
}
