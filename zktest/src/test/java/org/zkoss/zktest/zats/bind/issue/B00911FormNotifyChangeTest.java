package org.zkoss.zktest.zats.bind.issue;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import org.zkoss.zats.mimic.ComponentAgent;
import org.zkoss.zats.mimic.DesktopAgent;
import org.zkoss.zktest.zats.ZATSTestCase;
import org.zkoss.zul.Label;

public class B00911FormNotifyChangeTest extends ZATSTestCase {
	@Test
	public void test() {
		DesktopAgent desktop = connect();
		
		ComponentAgent l1 = desktop.query("#l1");
		ComponentAgent l2 = desktop.query("#l2");
		ComponentAgent l3 = desktop.query("#l3");
		ComponentAgent l4 = desktop.query("#l4");
		ComponentAgent l5 = desktop.query("#l5");
		ComponentAgent l6 = desktop.query("#l6");
		ComponentAgent btn = desktop.query("#btn");
		
		assertEquals("Dennis", l1.as(Label.class).getValue());
		assertEquals("Dennis", l2.as(Label.class).getValue());
		assertEquals("Dennis", l3.as(Label.class).getValue());
		assertEquals("A", l4.as(Label.class).getValue());
		assertEquals("A", l5.as(Label.class).getValue());
		assertEquals("A", l6.as(Label.class).getValue());
		
		btn.click();
		assertEquals("Alex", l1.as(Label.class).getValue());
		assertEquals("Alex", l2.as(Label.class).getValue());
		assertEquals("Alex", l3.as(Label.class).getValue());
		assertEquals("B", l4.as(Label.class).getValue());
		assertEquals("B", l5.as(Label.class).getValue());
		assertEquals("B", l6.as(Label.class).getValue());
	}
}
