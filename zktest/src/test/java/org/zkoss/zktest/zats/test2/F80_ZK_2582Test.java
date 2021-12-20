package org.zkoss.zktest.zats.test2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import org.zkoss.zktest.zats.WebDriverTestCase;
import org.zkoss.zktest.zats.ztl.JQuery;

/**
 * Created by wenning on 5/5/16.
 */
public class F80_ZK_2582Test extends WebDriverTestCase {

    @Test
    public void test() {
        connect();
        JQuery $textbox = jq("@textbox");
        click($textbox);
        waitResponse();
        sendKeys($textbox, "222");
        waitResponse();
        click(jq(".z-page"));
        waitResponse();
        assertEquals("100\n99\n0\n-100", getZKLog());
    }

}
