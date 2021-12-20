/* B86_ZK_4346Test.java

		Purpose:
		
		Description:
		
		History:
				Thu Aug 22 15:05:29 CST 2019, Created by leon

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Test;
import org.zkoss.zk.ui.UiException;
import org.zkoss.zul.SimpleDateConstraint;

public class B86_ZK_4346Test {
	@Test
	public void testGoodConstraintStringConstructor() {
		new SimpleDateConstraint("before 20190609");
	}
	
	@Test(expected = UiException.class)
	public void testBadConstraintStringConstructor() {
		new SimpleDateConstraint("before 120190609");
	}
	
	@Test(expected = UiException.class)
	public void testBadComplexConstraintStringConstructor() {
		new SimpleDateConstraint("between 20071012 and 20081223, before 200810103");
	}
}
