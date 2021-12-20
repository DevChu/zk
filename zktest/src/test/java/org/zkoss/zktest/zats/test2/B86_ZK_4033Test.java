/* B86_ZK_3996Test.java

	Purpose:
		
	Description:
		
	History:
		Thu Jul 26 15:19:23 CST 2018, Created by rudyhuang

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;

import org.junit.Assert;
import org.junit.Test;

import org.zkoss.zktest.zats.WebDriverTestCase;

/**
 * @author rudyhuang
 */
public class B86_ZK_4033Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();

		click(jq("@button:contains(refresh tree)"));
		waitResponse();
		click(jq("@button:contains(refresh tree)"));
		waitResponse();
		click(jq("@button:contains(rerender radio group)"));
		waitResponse();

		String errorMessage = jq("#zk_err .messagecontent").text();
		Assert.assertThat(errorMessage, not(containsString("Failed to mount: group.getName is not a function")));
	}
}
