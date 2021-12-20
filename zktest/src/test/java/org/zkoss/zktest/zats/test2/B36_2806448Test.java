/* B36_2806448Test.java

	Purpose:
		
	Description:
		
	History:
		Fri Jun 14 12:40:28 CST 2019, Created by rudyhuang

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
public class B36_2806448Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();

		JQuery cell = jq("@listcell[label=\"female\"]");
		rightClick(cell);
		waitResponse();
		Assert.assertTrue(jq("@menupopup").exists());

		click(jq("@listcell[label=\"Mary\"]"));
		waitResponse();
		Assert.assertFalse(jq("@menupopup").exists());
	}
}
