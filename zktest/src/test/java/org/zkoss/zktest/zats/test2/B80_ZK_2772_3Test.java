package org.zkoss.zktest.zats.test2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import org.zkoss.test.webdriver.WebDriverTestCase;
import org.zkoss.test.webdriver.ztl.JQuery;

public class B80_ZK_2772_3Test extends WebDriverTestCase {
	@Test
	public void test() {
		connect();
		//save the original column width
		eval("recordColsWidth()");
		//sort column 6
		clickAt(jq(".z-column").eq(5), 2, 2);
		waitResponse();
		//check the new column width
		var cols = jq(".z-column");
		for (int i = 0; i <= 9; i++) {
			assertEquals(parseInt(getEval("getRecordedColWidth(" + i + ")")), cols.eq(i).outerWidth(), 1);
		}
		//scroll to right
		jq(jq(jq(".z-grid")).find(".z-frozen").toWidget().$n("scrollX")).toElement().set("scrollLeft", "" + 400);
		waitResponse();
		//sort the last column
		clickAt(jq(".z-column").last(), 2, 2);
		waitResponse();
		//check the new column width remains the same
		//skip index 5~8
		cols = jq(".z-column");
		for (int i = 0; i <= 9; i++) {
			if (i < 5 || i > 8) {
				assertEquals(parseInt(getEval("getRecordedColWidth(" + i + ")")), cols.eq(i).outerWidth(), 1);
			}
		}
		//scroll to left
		jq(jq(jq(".z-grid")).find(".z-frozen").toWidget().$n("scrollX")).toElement().set("scrollLeft", "" + -400);
		waitResponse();
		//resize column 7
		JQuery column7 = jq(".z-column").eq(6);
		int colWidth = column7.outerWidth();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(column7)).moveByOffset(colWidth / 2 - 2, 0).clickAndHold().moveByOffset(-50, 0).release().perform();
		waitResponse();
		int colWidthAfter = column7.outerWidth();
		assertThat("resize failed", colWidthAfter, lessThan(colWidth));
		waitResponse();
		//save column width
		eval("recordColsWidth()");
		//sort column 7
		clickAt(column7, 2, 2);
		waitResponse();
		//check width should be the same
		cols = jq(".z-column");
		for (int i = 0; i <= 9; i++) {
			assertEquals(parseInt(getEval("getRecordedColWidth(" + i + ")")), cols.eq(i).outerWidth(), 1);
		}
	}
}
