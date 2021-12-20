/* B50_ZK_798_listboxTest.java

		Purpose:
		
		Description:
		
		History:
				Fri Apr 26 12:46:53 CST 2019, Created by leon

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;
import org.zkoss.zktest.zats.WebDriverTestCase;

public class B50_ZK_798_listboxTest extends WebDriverTestCase {
	@Test
	public void test() {
		connect();
		connect();
		jq("html").scrollTop(10000);
		waitResponse();
		int currentScroll = jq("html").scrollTop();
		click(jq("@listcell:last"));
		waitResponse();
		click(jq("@button"));
		waitResponse();
		Assert.assertEquals(currentScroll, jq("html").scrollTop());
	}
}
