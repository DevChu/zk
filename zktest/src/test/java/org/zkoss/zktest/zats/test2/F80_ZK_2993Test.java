/* F80_ZK_2993Test.java

	Purpose:
		
	Description:
		
	History:
		Thu Apr 18 10:03:35 CST 2019, Created by rudyhuang

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;

import org.zkoss.zktest.zats.WebDriverTestCase;

/**
 * @author rudyhuang
 */
public class F80_ZK_2993Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();

		type(jq("@textbox:eq(0)"), "test1m");
		waitResponse();
		Assert.assertEquals("test1m", jq("$l1").text());

		type(jq("@textbox:eq(1)"), "test2m");
		waitResponse();
		Assert.assertEquals("test2", jq("$l2").text());

		click(jq("@button"));
		waitResponse();
		Assert.assertEquals("test2m", jq("$l2").text());
	}
}
