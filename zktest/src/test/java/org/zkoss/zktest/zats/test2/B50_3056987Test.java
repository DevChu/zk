/* B50_3056987Test.java

	Purpose:
		
	Description:
		
	History:
		Tue Mar 26 17:40:28 CST 2019, Created by rudyhuang

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import static org.hamcrest.Matchers.greaterThan;

import org.junit.Assert;
import org.junit.Test;

import org.zkoss.zktest.zats.WebDriverTestCase;
import org.zkoss.zktest.zats.ztl.JQuery;

/**
 * @author rudyhuang
 */
public class B50_3056987Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();

		click(widget("@combobox:eq(0)").$n("btn"));
		waitResponse(true);
		JQuery popup = jq(".z-combobox-popup:visible");
		Assert.assertThat(popup.scrollHeight(), greaterThan(popup.innerHeight()));

		click(widget("@combobox:eq(1)").$n("btn"));
		waitResponse(true);
		Assert.assertThat(popup.scrollHeight(), greaterThan(popup.innerHeight()));

		click(widget("@bandbox:eq(0)").$n("btn"));
		waitResponse(true);
		popup = jq(".z-bandbox-popup:visible");
		Assert.assertThat(popup.scrollHeight(), greaterThan(popup.innerHeight()));

		click(widget("@bandbox:eq(1)").$n("btn"));
		waitResponse(true);
		Assert.assertThat(popup.scrollHeight(), greaterThan(popup.innerHeight()));
	}
}
