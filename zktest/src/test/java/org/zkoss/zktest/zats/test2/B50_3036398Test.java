/* B50_3036398Test.java

	Purpose:
		
	Description:
		
	History:
		Fri Mar 22 16:03:39 CST 2019, Created by rudyhuang

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.zats.test2;

import static org.hamcrest.Matchers.lessThanOrEqualTo;

import org.junit.Assert;
import org.junit.Test;

import org.zkoss.zktest.zats.WebDriverTestCase;

/**
 * @author rudyhuang
 */
public class B50_3036398Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();

		int frozenBottom = jq("@frozen").positionTop() + jq("@frozen").outerHeight();
		int listboxBottom = jq("@listbox").positionTop() + jq("@listbox").outerHeight();
		Assert.assertThat(frozenBottom, lessThanOrEqualTo(listboxBottom));
	}
}
