/* B50_2945998Test.java

	Purpose:
		
	Description:
		
	History:
		Wed Mar 20 17:40:05 CST 2019, Created by rudyhuang

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;

import org.zkoss.zktest.zats.WebDriverTestCase;

/**
 * @author rudyhuang
 */
public class B50_2945998Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();

		Assert.assertTrue(jq("@window").exists());

		click(jq("@button"));
		waitResponse();

		Assert.assertFalse(jq("@window").exists());
	}
}
