/* F90_ZK_4377_3Test.java

		Purpose:
		
		Description:
		
		History:
				Fri Nov 01 11:22:49 CST 2019, Created by leon

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;
import org.zkoss.zktest.zats.WebDriverTestCase;

public class F90_ZK_4377_3Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();
		waitResponse();
		checkThreeParts(4);
		click(jq("@button:contains(add item)"));
		waitResponse();
		checkThreeParts(5);
		click(jq("@button:contains(remove item)"));
		waitResponse();
		checkThreeParts(4);
		click(jq("@button:contains(change item)"));
		waitResponse();
		Assert.assertEquals("data changed!", jq(".z-lineitem > @button").eq(0).text());
		Assert.assertEquals("data changed!", jq(".z-lineitem > @label").eq(0).text());
		click(jq("@button:contains(clear)"));
		waitResponse();
		checkThreeParts(0);
	}
	
	private void checkThreeParts(int expect) {
		Assert.assertEquals(expect, jq(".z-lineitem-point").length());
		Assert.assertEquals(expect, jq(".z-lineitem > @button").length());
		Assert.assertEquals(expect, jq(".z-lineitem > @label").length());
	}
}
