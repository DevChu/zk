/* F50_3028270Test.java

	Purpose:
		
	Description:
		
	History:
		Tue May 28 16:12:13 CST 2019, Created by jameschu

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;

import org.zkoss.zktest.zats.WebDriverTestCase;
import org.zkoss.zktest.zats.ztl.JQuery;

/**
 * @author jameschu
 */
public class B86_ZK_4258Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();
		JQuery slider = jq("@slider:eq(0)");
		JQuery btn = slider.find(".z-slider-button");
		int pos = btn.positionLeft() + btn.width() / 2;
		System.out.println(pos);
		getActions().moveToElement(toElement(slider))
				.moveByOffset(80, 0)
				.click()
				.perform();
		waitResponse();
		System.out.println((btn.positionLeft() + btn.width() / 2));
		Assert.assertTrue((btn.positionLeft() + btn.width() / 2) > pos);
	}
}
