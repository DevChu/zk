package org.zkoss.zephyr.webdriver.mvvm.book.databinding.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import org.zkoss.test.webdriver.WebDriverTestCase;
import org.zkoss.test.webdriver.ztl.JQuery;

public class ValidationmessagesTest extends WebDriverTestCase {
	@Test
	public void test() {
		connect();
		JQuery l11 = jq("$l11");
		JQuery l12 = jq("$l12");
		JQuery t21 = jq("$t21");
		JQuery t22 = jq("$t22");
		JQuery t31 = jq("$t31");
		JQuery t32 = jq("$t32");
		JQuery m31 = jq("$m31");
		JQuery m32 = jq("$m32");
		JQuery btn1 = jq("$btn1");
		JQuery t41 = jq("$t41");
		JQuery t42 = jq("$t42");
		JQuery m41 = jq("$m41");
		JQuery m42 = jq("$m42");
		JQuery m43 = jq("$m43");
		JQuery m44 = jq("$m44");
		JQuery m45 = jq("$m45");
		JQuery m46 = jq("$m46");
		JQuery btn2 = jq("$btn2");
		JQuery btn3 = jq("$btn3");
		assertEquals("ABC", l11.toWidget().get("value"));
		assertEquals("10", l12.toWidget().get("value"));
		assertEquals("ABC", t21.toWidget().get("value"));
		assertEquals("10", t22.toWidget().get("value"));
		assertEquals("ABC", t31.toWidget().get("value"));
		assertEquals("10", t32.toWidget().get("value"));
		assertEquals("", m31.toWidget().get("value"));
		assertEquals("", m32.toWidget().get("value"));
		assertEquals("ABC", t41.toWidget().get("value"));
		assertEquals("10", t42.toWidget().get("value"));
		assertEquals("", m41.toWidget().get("value"));
		assertEquals("", m42.toWidget().get("value"));
		assertEquals("", m43.toWidget().get("value"));
		assertEquals("", m44.toWidget().get("value"));
		type(t21.toWidget(), "ABCD");
		waitResponse(true);
		type(t22.toWidget(), "6");
		waitResponse(true);
		sleep(500);
		assertEquals("ABC", l11.toWidget().get("value"));
		assertEquals("10", l12.toWidget().get("value"));
		assertEquals("ABCD", t21.toWidget().get("value"));
		assertEquals("6", t22.toWidget().get("value"));
		assertEquals("ABC", t31.toWidget().get("value"));
		assertEquals("10", t32.toWidget().get("value"));
		assertEquals("", m31.toWidget().get("value"));
		assertEquals("", m32.toWidget().get("value"));
		assertEquals("ABC", t41.toWidget().get("value"));
		assertEquals("10", t42.toWidget().get("value"));
		assertEquals("", m41.toWidget().get("value"));
		assertEquals("", m42.toWidget().get("value"));
		assertEquals("", m43.toWidget().get("value"));
		assertEquals("", m44.toWidget().get("value"));
		type(t21.toWidget(), "Abc");
		waitResponse(true);
		type(t22.toWidget(), "33");
		waitResponse(true);
		assertEquals("Abc", l11.toWidget().get("value"));
		assertEquals("33", l12.toWidget().get("value"));
		assertEquals("Abc", t21.toWidget().get("value"));
		assertEquals("33", t22.toWidget().get("value"));
		assertEquals("Abc", t31.toWidget().get("value"));
		assertEquals("33", t32.toWidget().get("value"));
		assertEquals("", m31.toWidget().get("value"));
		assertEquals("", m32.toWidget().get("value"));
		assertEquals("ABC", t41.toWidget().get("value"));
		assertEquals("10", t42.toWidget().get("value"));
		assertEquals("", m41.toWidget().get("value"));
		assertEquals("", m42.toWidget().get("value"));
		assertEquals("", m43.toWidget().get("value"));
		assertEquals("", m44.toWidget().get("value"));
		type(t31.toWidget(), "XXX");
		waitResponse(true);
		type(t32.toWidget(), "1"); // intbox has reset issue...too bad
		waitResponse(true);
		assertEquals("Abc", l11.toWidget().get("value"));
		assertEquals("33", l12.toWidget().get("value"));
		assertEquals("Abc", t21.toWidget().get("value"));
		assertEquals("33", t22.toWidget().get("value"));
		assertEquals("XXX", t31.toWidget().get("value"));
		assertEquals("1", t32.toWidget().get("value"));
		assertEquals("", m31.toWidget().get("value"));
		assertEquals("", m32.toWidget().get("value"));
		assertEquals("ABC", t41.toWidget().get("value"));
		assertEquals("10", t42.toWidget().get("value"));
		assertEquals("", m41.toWidget().get("value"));
		assertEquals("", m42.toWidget().get("value"));
		assertEquals("", m43.toWidget().get("value"));
		assertEquals("", m44.toWidget().get("value"));
		click(btn1.toWidget());
		waitResponse(true);
		assertEquals("Abc", l11.toWidget().get("value"));
		assertEquals("33", l12.toWidget().get("value"));
		assertEquals("Abc", t21.toWidget().get("value"));
		assertEquals("33", t22.toWidget().get("value"));
		assertEquals("XXX", t31.toWidget().get("value"));
		assertEquals("1", t32.toWidget().get("value"));
		assertEquals("value must equals ignore case 'abc', but is XXX", m31.toWidget().get("value"));
		assertEquals("value must not < 10 or > 100, but is 1", m32.toWidget().get("value"));
		assertEquals("ABC", t41.toWidget().get("value"));
		assertEquals("10", t42.toWidget().get("value"));
		assertEquals("", m41.toWidget().get("value"));
		assertEquals("", m42.toWidget().get("value"));
		assertEquals("", m43.toWidget().get("value"));
		assertEquals("", m44.toWidget().get("value"));
		type(t32.toWidget(), "55"); // intbox has reset issue...too bad
		waitResponse(true);
		assertEquals("Abc", l11.toWidget().get("value"));
		assertEquals("33", l12.toWidget().get("value"));
		assertEquals("Abc", t21.toWidget().get("value"));
		assertEquals("33", t22.toWidget().get("value"));
		assertEquals("XXX", t31.toWidget().get("value"));
		assertEquals("55", t32.toWidget().get("value"));
		assertEquals("value must equals ignore case 'abc', but is XXX", m31.toWidget().get("value"));
		assertEquals("value must not < 10 or > 100, but is 1", m32.toWidget().get("value"));
		assertEquals("ABC", t41.toWidget().get("value"));
		assertEquals("10", t42.toWidget().get("value"));
		assertEquals("", m41.toWidget().get("value"));
		assertEquals("", m42.toWidget().get("value"));
		assertEquals("", m43.toWidget().get("value"));
		assertEquals("", m44.toWidget().get("value"));
		click(btn1.toWidget());
		waitResponse(true);
		assertEquals("Abc", l11.toWidget().get("value"));
		assertEquals("33", l12.toWidget().get("value"));
		assertEquals("Abc", t21.toWidget().get("value"));
		assertEquals("33", t22.toWidget().get("value"));
		assertEquals("XXX", t31.toWidget().get("value"));
		assertEquals("55", t32.toWidget().get("value"));
		assertEquals("value must equals ignore case 'abc', but is XXX", m31.toWidget().get("value"));
		assertEquals("", m32.toWidget().get("value"));
		assertEquals("ABC", t41.toWidget().get("value"));
		assertEquals("10", t42.toWidget().get("value"));
		assertEquals("", m41.toWidget().get("value"));
		assertEquals("", m42.toWidget().get("value"));
		assertEquals("", m43.toWidget().get("value"));
		assertEquals("", m44.toWidget().get("value"));
		type(t31.toWidget(), "aBC"); // intbox has reset issue...too bad
		waitResponse(true);
		assertEquals("Abc", l11.toWidget().get("value"));
		assertEquals("33", l12.toWidget().get("value"));
		assertEquals("Abc", t21.toWidget().get("value"));
		assertEquals("33", t22.toWidget().get("value"));
		assertEquals("aBC", t31.toWidget().get("value"));
		assertEquals("55", t32.toWidget().get("value"));
		assertEquals("value must equals ignore case 'abc', but is XXX", m31.toWidget().get("value"));
		assertEquals("", m32.toWidget().get("value"));
		assertEquals("ABC", t41.toWidget().get("value"));
		assertEquals("10", t42.toWidget().get("value"));
		assertEquals("", m41.toWidget().get("value"));
		assertEquals("", m42.toWidget().get("value"));
		assertEquals("", m43.toWidget().get("value"));
		assertEquals("", m44.toWidget().get("value"));
		click(btn1.toWidget());
		waitResponse(true);
		assertEquals("aBC", l11.toWidget().get("value"));
		assertEquals("55", l12.toWidget().get("value"));
		assertEquals("aBC", t21.toWidget().get("value"));
		assertEquals("55", t22.toWidget().get("value"));
		assertEquals("aBC", t31.toWidget().get("value"));
		assertEquals("55", t32.toWidget().get("value"));
		assertEquals("", m31.toWidget().get("value"));
		assertEquals("", m32.toWidget().get("value"));
		assertEquals("ABC", t41.toWidget().get("value"));
		assertEquals("10", t42.toWidget().get("value"));
		assertEquals("", m41.toWidget().get("value"));
		assertEquals("", m42.toWidget().get("value"));
		assertEquals("", m43.toWidget().get("value"));
		assertEquals("", m44.toWidget().get("value"));
		// ///////
		type(t41.toWidget(), "YYY");
		waitResponse(true);
		type(t42.toWidget(), "1999"); // intbox has reset issue...too bad
		waitResponse(true);
		assertEquals("aBC", l11.toWidget().get("value"));
		assertEquals("55", l12.toWidget().get("value"));
		assertEquals("aBC", t21.toWidget().get("value"));
		assertEquals("55", t22.toWidget().get("value"));
		assertEquals("aBC", t31.toWidget().get("value"));
		assertEquals("55", t32.toWidget().get("value"));
		assertEquals("", m31.toWidget().get("value"));
		assertEquals("", m32.toWidget().get("value"));
		assertEquals("YYY", t41.toWidget().get("value"));
		assertEquals("1999", t42.toWidget().get("value"));
		assertEquals("value must equals ignore case 'abc', but is YYY", m41.toWidget().get("value"));
		assertEquals("value must not < 10 or > 100, but is 1999", m42.toWidget().get("value"));
		assertEquals("", m43.toWidget().get("value"));
		assertEquals("", m44.toWidget().get("value"));
		click(btn2.toWidget());
		waitResponse(true);
		assertEquals("aBC", l11.toWidget().get("value"));
		assertEquals("55", l12.toWidget().get("value"));
		assertEquals("aBC", t21.toWidget().get("value"));
		assertEquals("55", t22.toWidget().get("value"));
		assertEquals("aBC", t31.toWidget().get("value"));
		assertEquals("55", t32.toWidget().get("value"));
		assertEquals("", m31.toWidget().get("value"));
		assertEquals("", m32.toWidget().get("value"));
		assertEquals("YYY", t41.toWidget().get("value"));
		assertEquals("1999", t42.toWidget().get("value"));
		assertEquals("value must equals ignore case 'abc', but is YYY", m41.toWidget().get("value"));
		assertEquals("value must not < 10 or > 100, but is 1999", m42.toWidget().get("value"));
		assertEquals("value must equals 'AbC', but is ABC", m43.toWidget().get("value"));
		assertEquals("value must equals 'AbC', but is ABC", m44.toWidget().get("value"));
		assertEquals("value must equals 'AbC', but is ABC", m45.toWidget().get("value"));
		assertEquals("extra validation info ABC", m46.toWidget().get("value"));
		type(t41.toWidget(), "abc");
		waitResponse(true);
		type(t42.toWidget(), "77"); // intbox has reset issue...too bad
		waitResponse(true);
		assertEquals("aBC", l11.toWidget().get("value"));
		assertEquals("55", l12.toWidget().get("value"));
		assertEquals("aBC", t21.toWidget().get("value"));
		assertEquals("55", t22.toWidget().get("value"));
		assertEquals("aBC", t31.toWidget().get("value"));
		assertEquals("55", t32.toWidget().get("value"));
		assertEquals("", m31.toWidget().get("value"));
		assertEquals("", m32.toWidget().get("value"));
		assertEquals("abc", t41.toWidget().get("value"));
		assertEquals("77", t42.toWidget().get("value"));
		assertEquals("", m41.toWidget().get("value"));
		assertEquals("", m42.toWidget().get("value"));
		assertEquals("value must equals 'AbC', but is ABC", m43.toWidget().get("value"));
		assertEquals("value must equals 'AbC', but is ABC", m44.toWidget().get("value"));
		assertEquals("value must equals 'AbC', but is ABC", m45.toWidget().get("value"));
		assertEquals("extra validation info ABC", m46.toWidget().get("value"));
		click(btn2.toWidget());
		waitResponse(true);
		assertEquals("aBC", l11.toWidget().get("value"));
		assertEquals("55", l12.toWidget().get("value"));
		assertEquals("aBC", t21.toWidget().get("value"));
		assertEquals("55", t22.toWidget().get("value"));
		assertEquals("aBC", t31.toWidget().get("value"));
		assertEquals("55", t32.toWidget().get("value"));
		assertEquals("", m31.toWidget().get("value"));
		assertEquals("", m32.toWidget().get("value"));
		assertEquals("abc", t41.toWidget().get("value"));
		assertEquals("77", t42.toWidget().get("value"));
		assertEquals("", m41.toWidget().get("value"));
		assertEquals("", m42.toWidget().get("value"));
		assertEquals("value must equals 'AbC', but is abc", m43.toWidget().get("value"));
		assertEquals("value must equals 'AbC', but is abc", m44.toWidget().get("value"));
		assertEquals("value must equals 'AbC', but is abc", m45.toWidget().get("value"));
		assertEquals("extra validation info abc", m46.toWidget().get("value"));
		type(t41.toWidget(), "AbC");
		waitResponse(true);
		click(btn2.toWidget());
		waitResponse(true);
		assertEquals("AbC", l11.toWidget().get("value"));
		assertEquals("77", l12.toWidget().get("value"));
		assertEquals("AbC", t21.toWidget().get("value"));
		assertEquals("77", t22.toWidget().get("value"));
		assertEquals("AbC", t31.toWidget().get("value"));
		assertEquals("77", t32.toWidget().get("value"));
		assertEquals("", m31.toWidget().get("value"));
		assertEquals("", m32.toWidget().get("value"));
		assertEquals("AbC", t41.toWidget().get("value"));
		assertEquals("77", t42.toWidget().get("value"));
		assertEquals("", m41.toWidget().get("value"));
		assertEquals("", m42.toWidget().get("value"));
		assertEquals("", m43.toWidget().get("value"));
		assertEquals("", m44.toWidget().get("value"));
		type(t31.toWidget(), "YYY");
		waitResponse(true);
		type(t32.toWidget(), "2"); // intbox has reset issue...too bad
		waitResponse(true);
		click(btn1.toWidget());
		waitResponse(true);
		assertEquals("YYY", t31.toWidget().get("value"));
		assertEquals("2", t32.toWidget().get("value"));
		assertEquals("value must equals ignore case 'abc', but is YYY", m31.toWidget().get("value"));
		assertEquals("value must not < 10 or > 100, but is 2", m32.toWidget().get("value"));
		click(btn3.toWidget());
		waitResponse(true);
		assertEquals("AbC", t31.toWidget().get("value"));
		assertEquals("2", t32.toWidget().get("value"));
		assertEquals("", m31.toWidget().get("value"));
		assertEquals("value must not < 10 or > 100, but is 2", m32.toWidget().get("value"));
	}
}