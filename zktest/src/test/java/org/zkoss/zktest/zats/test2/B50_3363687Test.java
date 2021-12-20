/* B50_3363687Test.java

		Purpose:
		
		Description:
		
		History:
				Tue Apr 02 17:12:48 CST 2019, Created by leon

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;
import org.zkoss.zktest.zats.WebDriverTestCase;

public class B50_3363687Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		check(jq(".z-button").eq(0));
		waitResponse();
		check(jq(".z-button").eq(1));
		waitResponse();
		Assert.assertEquals("ONCREATE\nONCREATE", outContent.toString().trim());
	}
}
