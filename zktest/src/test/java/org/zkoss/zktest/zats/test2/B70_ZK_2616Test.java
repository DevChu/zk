package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriverException;

import org.zkoss.zktest.zats.WebDriverTestCase;
import org.zkoss.zktest.zats.ztl.JQuery;

public class B70_ZK_2616Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();
		click(jq("@button"));
		try {
			for (int i = 0; i <= 5; i++) {
				click(jq("@button").eq(1));
			}
		} catch (WebDriverException ignored) {
			// expected if a redirection is performing
		}
		sleep(2000);
		waitResponse();
		JQuery window = jq(".z-window-header");
		Assert.assertTrue(!window.exists() || window.text().equals("Session Timeout"));
	}
}
