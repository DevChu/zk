/* B90_ZK_4441Test.java

		Purpose:
		
		Description:
		
		History:
				Wed Dec 04 15:53:06 CST 2019, Created by jameschu

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;

import org.zkoss.zktest.zats.WebDriverTestCase;
import org.zkoss.zktest.zats.ztl.JQuery;

/**
 * @author jameschu
 */
public class B90_ZK_4443Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();
		JQuery auxheads = jq("$a").children();
		JQuery cols = jq("$c").children();
		int[] wds = new int[] {0, 0, 0};

		for (int i = 0; i < 3; i++ ) {
			int colWd = cols.eq(i).width();
			Assert.assertEquals(auxheads.eq(i).width(), colWd, 2);
			wds[i] = colWd;
		}

		click(jq("$rmBtn"));
		waitResponse();

		for (int i = 0; i < 3; i++ )
			Assert.assertEquals(wds[i], cols.eq(i).width(), 2);

		click(jq("$movBtn"));
		waitResponse();

		auxheads = jq("$b").children();
		for (int i = 0; i < 3; i++ )
			Assert.assertEquals(auxheads.eq(i).width(), cols.eq(i).width(), 2);
	}
}
