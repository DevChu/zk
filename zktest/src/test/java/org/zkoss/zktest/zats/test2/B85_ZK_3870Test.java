/* B85_ZK_3870Test.java

	Purpose:
		
	Description:
		
	History:
		Fri Jun 08 15:22:10 CST 2018, Created by rudyhuang

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;

import org.zkoss.zktest.zats.WebDriverTestCase;

/**
 * @author rudyhuang
 */
public class B85_ZK_3870Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();
		Assert.assertNotEquals("", jq("$themeName").text());
	}
}
