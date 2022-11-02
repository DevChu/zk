/* F80_ZK_3041Test.java

	Purpose:
		
	Description:
		
	History:
		Mon Jan 25 16:53:28 CST 2015, Created by Jameschu

Copyright (C) 2015 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zephyr.webdriver.test2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import org.zkoss.zephyr.webdriver.ClientBindTestCase;
import org.zkoss.test.webdriver.ztl.JQuery;

/**
 * @author jameschu
 */
public class F80_ZK_2668Test extends ClientBindTestCase {

	@Test
	public void test() throws IOException {
		connect();
		sleep(2000);
		JQuery $timebox = jq("@timebox input");
		JQuery $datebox = jq("@datebox input");
		JQuery $textbox = jq("@textbox");
		String oldDate = $datebox.val().substring(0, $datebox.val().indexOf(" "));
		focus($textbox);
		waitResponse(true);
		click(jq(".ui-timepicker-list li:first"));
		waitResponse(true);
		String newTime = $textbox.val();
		int newTimeSpaceIndex = newTime.indexOf(" ");
		assertEquals((newTime.substring(newTimeSpaceIndex, newTime.length()) + " " + newTime.substring(0, newTimeSpaceIndex) + ":00").trim(), $timebox.val());
		assertEquals((oldDate + " " + $timebox.val()).trim(), $datebox.val());
	}
}
