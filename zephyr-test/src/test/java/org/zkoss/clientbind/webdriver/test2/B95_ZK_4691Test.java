/* B95_ZK_4691Test.java

	Purpose:
		
	Description:
		
	History:
		The Nov 12 09:50:21 CST 2020, Created by jameschu

Copyright (C) 2020 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.clientbind.webdriver.test2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import org.zkoss.clientbind.webdriver.ClientBindTestCase;

/**
 * @author jameschu
 */
public class B95_ZK_4691Test extends ClientBindTestCase {
	@Test
	public void test() {
		connect();
		waitResponse();
		closeZKLog();
		waitResponse();
		click(jq("$chgURI"));
		waitResponse();
		assertEquals("B.zul", jq("@div").find("@label").html().trim());
		assertEquals(false, isZKLogAvailable());
	}
}
