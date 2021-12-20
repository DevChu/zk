package org.zkoss.zktest.zats.test2;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.zkoss.zktest.zats.WebDriverTestCase;

/**
 * @author jameschu
 */
public class B30_1773575Test extends WebDriverTestCase {
	@Test public void test() {
		connect();
		click(jq("@button").eq(0));
		waitResponse();
		assertTrue(getWebDriver().getCurrentUrl().indexOf("?") < 0);
		click(jq("@button").eq(1));
		waitResponse();
		assertTrue(getWebDriver().getCurrentUrl().indexOf("?") < 0);
		assertTrue(getWebDriver().getCurrentUrl().endsWith("#12345"));
	}
}