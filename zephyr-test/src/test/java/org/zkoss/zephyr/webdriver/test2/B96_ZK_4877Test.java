/* B96_ZK_4877Test.java

	Purpose:
		
	Description:
		
	History:
		Mon May 17 17:23:10 CST 2021, Created by rudyhuang

Copyright (C) 2021 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zephyr.webdriver.test2;

import org.junit.jupiter.api.Test;

import org.zkoss.test.webdriver.WebDriverTestCase;

/**
 * @author rudyhuang
 */
public class B96_ZK_4877Test extends WebDriverTestCase {
	@Test
	public void test() throws Exception {
		connect();
		sleep(2000);
		click(jq("@button"));
		waitResponse();
		assertNoAnyError();
	}
}
