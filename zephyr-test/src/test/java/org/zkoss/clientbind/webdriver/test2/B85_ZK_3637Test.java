/** B85_ZK_3637Test.java.

 Purpose:

 Description:

 History:
 	Tue June 6 17:14:22 CST 2017, Created by jameschu

 Copyright (C) 2017 Potix Corporation. All Rights Reserved.
 */
package org.zkoss.clientbind.webdriver.test2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import org.zkoss.clientbind.webdriver.ClientBindTestCase;

/**
 * @author jameschu
 *
 */
public class B85_ZK_3637Test extends ClientBindTestCase {
    @Test
    public void test() {
		connect();
		for (int i = 1; i < 9; i++) {
			click(jq("@button:eq(" + i +")"));
			waitResponse();
			String log = "";
			if (i <= 4)
				log = "clicked_local";
			else
				log = "clicked_global";
			assertEquals(log, getZKLog());
			closeZKLog();
			waitResponse();
		}
	}
}