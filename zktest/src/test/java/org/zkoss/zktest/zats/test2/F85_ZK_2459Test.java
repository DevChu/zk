/* F85_ZK_2459Test.java

		Purpose:
		
		Description:
		
		History:
				Thu May 31 10:26:22 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;

import org.zkoss.zats.mimic.DesktopAgent;
import org.zkoss.zktest.zats.ZATSTestCase;
import org.zkoss.zul.Label;

public class F85_ZK_2459Test extends ZATSTestCase {
	@Test
	public void test() {
		DesktopAgent desktop = connect();
		desktop.query("#btn").click();
		Assert.assertEquals("one", desktop.query("#lb1").as(Label.class).getValue());
		Assert.assertEquals("two", desktop.query("#lb2").as(Label.class).getValue());
		Assert.assertEquals("three", desktop.query("#lb3").as(Label.class).getValue());
	}
}