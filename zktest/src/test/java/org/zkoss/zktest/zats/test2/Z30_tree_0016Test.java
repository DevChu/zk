/* Z30_tree_0016Test.java

		Purpose:
		
		Description:
		
		History:
				Wed Jun 19 15:02:04 CST 2019, Created by leon

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;
import org.zkoss.zktest.zats.WebDriverTestCase;

public class Z30_tree_0016Test extends WebDriverTestCase {
	@Test
	public void test() {
		try {
			connect();
			waitResponse();
			click(jq("@button"));
			waitResponse();
			Assert.assertFalse(hasError());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
