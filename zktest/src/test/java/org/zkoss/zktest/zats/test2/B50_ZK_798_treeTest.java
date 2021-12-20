/* B50_ZK_798_treeTest.java

		Purpose:
		
		Description:
		
		History:
				Fri Apr 26 12:51:44 CST 2019, Created by leon

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;
import org.zkoss.zktest.zats.WebDriverTestCase;

public class B50_ZK_798_treeTest extends WebDriverTestCase {
	@Test
	public void test() {
		connect();
		jq(".z-iframe").scrollTop(10000);
		waitResponse();
		click(jq("@treeitem:last"));
		waitResponse();
		int currentScroll = jq(".z-iframe").scrollTop();
		click(jq("@button"));
		waitResponse();
		Assert.assertEquals(currentScroll, jq(".z-iframe").scrollTop());
	}
}
