/* B50_ZK_842Test.java

		Purpose:
		
		Description:
		
		History:
				Thu May 23 15:17:53 CST 2019, Created by leon

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import org.zkoss.zktest.zats.WebDriverTestCase;

public class B50_ZK_842Test extends WebDriverTestCase {
	@Test
	public void test() {
		Actions act = new Actions(connect());
		waitResponse();
		click(jq("@intbox"));
		waitResponse();
		act.sendKeys("-1").perform();
		waitResponse();
		click(jq(".z-div"));
		waitResponse();
		Assert.assertTrue(hasError());
	}
}
