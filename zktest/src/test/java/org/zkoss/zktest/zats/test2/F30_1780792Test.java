/* F30_1780792Test.java

		Purpose:
		
		Description:
		
		History:
				Wed Jun 19 12:12:06 CST 2019, Created by leon

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.zkoss.zktest.zats.WebDriverTestCase;

public class F30_1780792Test extends WebDriverTestCase {
	@Test
	public void test() {
		Actions act = new Actions(connect());
		waitResponse();
		click(jq("@treerow:contains(Item 1)"));
		waitResponse();
		act.sendKeys(Keys.ARROW_DOWN).perform();
		waitResponse();
		Assert.assertFalse(jq("@treerow:contains(Item 2)").is(".z-treerow-selected"));
		Assert.assertTrue(jq("@treerow:contains(Item 3)").eq(0).is(".z-treerow-selected"));
		click(jq("@listitem:contains(option3)"));
		waitResponse();
		act.sendKeys(Keys.ARROW_UP).perform();
		waitResponse();
		Assert.assertFalse(jq("@listitem:contains(option2)").is(".z-listitem-selected"));
	}
}
