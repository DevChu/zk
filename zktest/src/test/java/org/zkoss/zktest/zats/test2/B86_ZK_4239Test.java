/* B86_ZK_4239Test.java

	Purpose:
		
	Description:
		
	History:
		Wed May 08 16:53:58 CST 2019, Created by rudyhuang

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;

import org.zkoss.zktest.zats.WebDriverTestCase;
import org.zkoss.zktest.zats.ztl.Widget;

/**
 * @author rudyhuang
 */
public class B86_ZK_4239Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();

		Widget cal = widget("@calendar");
		int contentHeight = jq(cal.$n("mid")).outerHeight();

		click(cal.$n("right"));
		sleep(100);

		int animatingContentHeight = jq(".z-calendar-anima .z-calendar-body").outerHeight();
		Assert.assertEquals(contentHeight, animatingContentHeight, 2);
	}
}
