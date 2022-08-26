/* B80_ZK_3046Test.java

	Purpose:
		
	Description:
		
	History:
		5:46 PM 12/24/15, Created by jumperchen

Copyright (C) 2015 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import org.zkoss.test.webdriver.WebDriverTestCase;
import org.zkoss.test.webdriver.ztl.JQuery;

/**
 * @author jumperchen
 */
public class B80_ZK_3046Test extends WebDriverTestCase {
	@Test
	public void testZK3046() {
		connect();
		JQuery groups = jq("@groupbox");
		checkResult(groups, 7);
	}
	private void checkResult(JQuery groups, int groupsLen) {
		assertEquals(groupsLen, groups.length());
		for (JQuery group : groups) {
			JQuery buttons = group.find("button");
			for (JQuery button : buttons) {
				String text = button.text();
				assertTrue(text.startsWith("zh"));
				click(button);
				waitResponse();
				assertEquals(text, getZKLog());
				closeZKLog();
			}
		}
	}
	@Test public void testZK3046_1() {
		connect(getTestURL("B80-ZK-3046-1.zul"));
		JQuery groups = jq("@groupbox");
		checkResult(groups, 1);
	}
	@Test public void testZK3046_2() {
		connect(getTestURL("B80-ZK-3046-2.zul"));
		JQuery groups = jq("@groupbox");
		checkResult(groups, 1);
	}
	@Test public void testZK3046_3() {
		connect(getTestURL("B80-ZK-3046-3.zul"));
		JQuery groups = jq("@groupbox");
		checkResult(groups, 1);
	}
	@Test public void testZK3046_4() {
		connect(getTestURL("B80-ZK-3046-4.zul"));
		JQuery groups = jq("@groupbox");
		checkResult(groups, 1);
	}
	@Test public void testZK3046_5() {
		connect(getTestURL("B80-ZK-3046-5.zul"));
		JQuery groups = jq("@groupbox");
		checkResult(groups, 1);
	}
}
