/* B86_ZK_4162Test.java

	Purpose:
		
	Description:
		
	History:
		Fri Dec 28 17:25:30 CST 2018, Created by rudyhuang

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;

import org.zkoss.zktest.zats.WebDriverTestCase;

/**
 * @author rudyhuang
 */
public class B86_ZK_4162Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();

		click(jq(".z-listheader-checkable:eq(0)"));
		waitResponse();
		String selectedItems = getZKLog();
		click(jq(".z-listheader-checkable:eq(0)"));
		waitResponse();
		closeZKLog();

		click(jq(".z-listheader-checkable:eq(1)"));
		waitResponse();
		Assert.assertEquals(selectedItems, getZKLog());
	}
}
