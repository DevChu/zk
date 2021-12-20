/* Z60_Listbox_GroupsModelArrayTest.java

	Purpose:
		
	Description:
		
	History:
		Tue Apr 23 09:45:33 CST 2019, Created by rudyhuang

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;

import org.zkoss.zktest.zats.WebDriverTestCase;

/**
 * @author rudyhuang
 */
public class Z60_Listbox_GroupsModelArrayTest extends WebDriverTestCase {
	@Test
	public void test() {
		connect();

		click(widget("@listbox:eq(0) @listgroup:first").$n("img"));
		waitResponse();
		Assert.assertFalse(jq("@listbox:eq(0) @listgroup:first").hasClass("z-listgroup-open"));
		Assert.assertFalse(jq("@listbox:eq(1) @listgroup:first").hasClass("z-listgroup-open"));

		click(widget("@listbox:eq(1) @listgroup:first").$n("img"));
		waitResponse();
		Assert.assertTrue(jq("@listbox:eq(0) @listgroup:first").hasClass("z-listgroup-open"));
		Assert.assertTrue(jq("@listbox:eq(1) @listgroup:first").hasClass("z-listgroup-open"));

		click(jq("@listbox:eq(0) @listheader:eq(1)"));
		waitResponse();
		Assert.assertEquals("Cod", jq("@listbox:eq(1) @listitem:eq(0) @listcell:eq(1)").text());
		Assert.assertEquals("Scallops", jq("@listbox:eq(1) @listitem:eq(1) @listcell:eq(1)").text());

		click(widget("@listbox:eq(2) @listgroup:first").$n("img"));
		waitResponse();
		click(jq("@button:eq(0)"));
		waitResponse();
		click(jq("@button:eq(1)"));
		waitResponse();
		Assert.assertFalse(jq("$cloneThreeArea @listbox:eq(0) @listgroup:first").hasClass("z-listgroup-open"));
		Assert.assertFalse(jq("$cloneThreeArea @listbox:eq(1) @listgroup:first").hasClass("z-listgroup-open"));

		click(widget("@listbox:eq(2) @listgroup:first").$n("img"));
		waitResponse();
		Assert.assertFalse(jq("$cloneThreeArea @listbox:eq(0) @listgroup:first").hasClass("z-listgroup-open"));
		Assert.assertFalse(jq("$cloneThreeArea @listbox:eq(1) @listgroup:first").hasClass("z-listgroup-open"));
	}

	@Test
	public void testClone() {
		connect();

		click(widget("@listbox:eq(2) @listgroup:first").$n("img"));
		waitResponse();
		click(widget("@listbox:eq(2) @listgroup:last").$n("img"));
		waitResponse();
		click(jq("@button:eq(0)"));
		waitResponse();
		click(jq("@button:eq(1)"));
		waitResponse();

		click(widget(jq("$cloneThreeArea @listbox:eq(0) @listgroup:last")).$n("img"));
		waitResponse();
		click(widget(jq("$cloneThreeArea @listbox:eq(1) @listgroup:last")).$n("img"));
		waitResponse();
		Assert.assertTrue(jq("$cloneThreeArea @listbox:eq(0) @listgroup:last").hasClass("z-listgroup-open"));
		Assert.assertTrue(jq("$cloneThreeArea @listbox:eq(1) @listgroup:last").hasClass("z-listgroup-open"));
	}
}
