/* B85_ZK_3228Test.java

	Purpose:
		
	Description:
		
	History:
		Thu Dec 21 16:55:08 CST 2017, Created by rudyhuang

Copyright (C) 2017 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;

import org.zkoss.zktest.zats.WebDriverTestCase;

/**
 * @author rudyhuang
 */
public class B85_ZK_3228Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();

		click(jq("@button:eq(0)"));
		waitResponse();

		click(jq("@button:eq(1)"));
		waitResponse();

		Assert.assertEquals("CK1=true,CK2=true", getZKLog());
	}
}
