/* B50_ZK_812Test.java

		Purpose:
		
		Description:
		
		History:
				Thu May 23 14:59:43 CST 2019, Created by leon

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Test;
import org.zkoss.zats.mimic.DesktopAgent;
import org.zkoss.zktest.zats.ZATSTestCase;

import static org.junit.Assert.fail;

public class B50_ZK_812Test extends ZATSTestCase {
	@Test
	public void test() {
		try {
			DesktopAgent desktop = connect();
		} catch (Exception e) {
			fail("No exception here");
		}
	}
}
