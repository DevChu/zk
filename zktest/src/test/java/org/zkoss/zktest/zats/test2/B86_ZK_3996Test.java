/* B86_ZK_3996Test.java

	Purpose:
		
	Description:
		
	History:
		Thu Jul 26 15:19:23 CST 2018, Created by rudyhuang

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import org.junit.Assert;
import org.junit.Test;

import org.zkoss.zktest.zats.WebDriverTestCase;

/**
 * @author rudyhuang
 */
public class B86_ZK_3996Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();

		String errorMessage = jq("#zk_err .messagecontent").text();
		boolean hasFragmentLexicalError = errorMessage.contains("Failed to parse the content: Lexical error");
		Assert.assertFalse("Fragment has a lexical error", hasFragmentLexicalError);
	}
}
