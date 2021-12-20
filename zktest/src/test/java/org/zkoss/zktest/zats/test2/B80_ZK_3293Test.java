/* B80_ZK_3293Test.java

	Purpose:
		
	Description:
		
	History:
		Wed Sep 04 16:07:35 CST 2019, Created by rudyhuang

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;

import org.zkoss.zktest.zats.WebDriverTestCase;
import org.zkoss.zktest.zats.ztl.JQuery;

/**
 * @author rudyhuang
 */
public class B80_ZK_3293Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();

		JQuery sp = jq("@splitter");
		JQuery tb = jq("@tabbox");
		int tbw = tb.width();
		// FIXME: splitter center cannot be dragged
		dragdropTo(sp, 0, 10, 20, 0);
		waitResponse();
		Assert.assertEquals(tbw - 20, tb.width(), 3);
	}
}
