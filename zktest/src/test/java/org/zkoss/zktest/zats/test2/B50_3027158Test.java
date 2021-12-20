/* B50_3027158Test.java

	Purpose:
		
	Description:
		
	History:
		Fri Mar 22 15:58:45 CST 2019, Created by rudyhuang

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;

import org.zkoss.zktest.zats.WebDriverTestCase;

/**
 * @author rudyhuang
 */
public class B50_3027158Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();

		click(jq("@button"));
		waitResponse();

		Assert.assertTrue(jq("@checkbox input").is(":focus"));
	}
}
