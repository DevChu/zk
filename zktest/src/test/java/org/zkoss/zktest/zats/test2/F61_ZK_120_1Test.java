/* F61_ZK_120Test.java

	Purpose:
		
	Description:
		
	History:
		Tue Apr 16 16:15:38 CST 2019, Created by rudyhuang

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
public class F61_ZK_120_1Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();

		openColumnMenu(jq("@listheader:eq(1)"));
		click(jq("@menuitem:contains(Sort Ascending)"));
		waitResponse();
		Assert.assertEquals("Cod", jq("@listitem:first @listcell:eq(1)").text());

		openColumnMenu(jq("@listheader:eq(1)"));
		click(jq("@menuitem:contains(Sort Descending)"));
		waitResponse();
		Assert.assertEquals("Shrimp",jq("@listitem:first @listcell:eq(1)").text());

		openColumnMenu(jq("@listheader:eq(1)"));
		click(jq("@menuitem:contains(Group)"));
		waitResponse();
		Assert.assertEquals(13, jq("@listgroup").length());

		openColumnMenu(jq("@listheader:eq(1)"));
		click(jq("@menuitem:contains(Category)"));
		waitResponse();
		Assert.assertEquals(0, jq("@listheader:contains(Category)").width());
	}

	private void openColumnMenu(JQuery column) {
		getActions().moveToElement(toElement(column))
				.moveByOffset(column.width() / 2 - 10, 0)
				.click()
				.perform();
		waitResponse();
	}
}
