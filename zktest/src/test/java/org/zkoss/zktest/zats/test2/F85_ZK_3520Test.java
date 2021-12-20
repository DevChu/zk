/* F85_ZK_3520Test.java

	Purpose:
		
	Description:
		
	History:
		Wed Jun 19 11:22:36 CST 2019, Created by rudyhuang

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
public class F85_ZK_3520Test extends WebDriverTestCase {
	private JQuery pp = jq("@popup");
	private JQuery yellow = jq(".z-div[style*=yellow]");
	private JQuery pink = jq(".z-div[style*=pink]");
	private JQuery cyan = jq(".z-div[style*=cyan]");

	@Test
	public void testBeforeChange() {
		connect();

		rightClick(yellow);
		waitResponse();
		// should see tooltip showed on 50px left of mouse pointer
		Assert.assertEquals(yellow.offsetTop() + 100, pp.offsetTop(), 1);
		Assert.assertEquals(yellow.offsetLeft() + 50, pp.offsetLeft(), 1);
		getActions().moveToElement(toElement(yellow), 50, 50).contextClick().perform();
		waitResponse();
		// should see tooltip showed
		Assert.assertTrue("yellowPopup should be visible", pp.isVisible());

		click(pink);
		waitResponse();
		// should see tooltip showed on 20px down of mouse pointer
		Assert.assertEquals(pink.offsetTop() + 120, pp.offsetTop(), 3);
		Assert.assertEquals(pink.offsetLeft() + 100, pp.offsetLeft(), 3);

		mouseOver(cyan);
		sleep(500);
		// should see tooltip showed at position "before_start"
		Assert.assertEquals(cyan.offsetTop() + 200, pp.offsetTop(), 1);
		Assert.assertEquals(cyan.offsetLeft(), pp.offsetLeft(), 1);
	}

	@Test
	public void testAfterChange() {
		connect();

		//after change
		click(jq("@button"));
		waitResponse();

		rightClick(yellow);
		waitResponse();
		getActions().moveToElement(toElement(yellow), 50, 50).contextClick().perform();
		waitResponse();
		// should not see tooltip showed
		Assert.assertFalse("yellowPopup should be hidden", pp.isVisible());

		click(pink);
		waitResponse();
		// should see tooltip showed at the "after_center" position
		Assert.assertEquals(pink.offsetTop() + 200, pp.offsetTop(), 3);
		Assert.assertEquals(pink.offsetLeft() + 100 - pp.width() / 2, pp.offsetLeft(), 3);

		mouseOver(cyan);
		sleep(500);
		// should see tooltip showed at 40px right of the cursor
		Assert.assertEquals(cyan.offsetTop() + 100, pp.offsetTop(), 1);
		Assert.assertEquals(cyan.offsetLeft() + 140, pp.offsetLeft(), 1);
	}
}
