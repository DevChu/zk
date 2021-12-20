package org.zkoss.zktest.zats.bind.issue;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.zkoss.zats.mimic.ComponentAgent;
import org.zkoss.zats.mimic.DesktopAgent;
import org.zkoss.zats.mimic.Zats;
import org.zkoss.zktest.zats.ZATSTestCase;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

public class B01189FormNotifyChangeTest extends ZATSTestCase {
	@Test
	public void test() {
		DesktopAgent desktop = connect();

		ComponentAgent tb1 = desktop.query("#tb1");
		ComponentAgent tb2 = desktop.query("#tb2");
		ComponentAgent tb3 = desktop.query("#tb3");
		ComponentAgent tb4 = desktop.query("#tb4");
		ComponentAgent save1 = desktop.query("#save1");
		ComponentAgent lb1 = desktop.query("#lb1");
		
		assertEquals("", tb1.as(Textbox.class).getValue());
		assertEquals("", tb2.as(Textbox.class).getValue());
		assertEquals("", tb3.as(Textbox.class).getValue());
		assertEquals("", tb4.as(Textbox.class).getValue());
		assertEquals("", lb1.as(Label.class).getValue());
		
		tb1.type("A");
		assertEquals("A", tb2.as(Textbox.class).getValue());
		assertEquals("A", tb3.as(Textbox.class).getValue());
		assertEquals("A", tb4.as(Textbox.class).getValue());
		save1.click();
		assertEquals("A", lb1.as(Label.class).getValue());
		
		tb2.type("B");
		assertEquals("B", tb1.as(Textbox.class).getValue());
		assertEquals("B", tb3.as(Textbox.class).getValue());
		assertEquals("B", tb4.as(Textbox.class).getValue());
		save1.click();
		assertEquals("B", lb1.as(Label.class).getValue());
		
		tb3.type("C");
		assertEquals("C", tb1.as(Textbox.class).getValue());
		assertEquals("C", tb2.as(Textbox.class).getValue());
		assertEquals("C", tb4.as(Textbox.class).getValue());
		save1.click();
		assertEquals("C", lb1.as(Label.class).getValue());
		
		tb4.type("D");
		assertEquals("D", tb1.as(Textbox.class).getValue());
		assertEquals("D", tb2.as(Textbox.class).getValue());
		assertEquals("D", tb3.as(Textbox.class).getValue());
		save1.click();
		assertEquals("D", lb1.as(Label.class).getValue());
		
		tb1.type("E");
		assertEquals("E", tb2.as(Textbox.class).getValue());
		assertEquals("E", tb3.as(Textbox.class).getValue());
		assertEquals("E", tb4.as(Textbox.class).getValue());
		save1.click();
		assertEquals("E", lb1.as(Label.class).getValue());
		
		tb2.type("F");
		assertEquals("F", tb1.as(Textbox.class).getValue());
		assertEquals("F", tb3.as(Textbox.class).getValue());
		assertEquals("F", tb4.as(Textbox.class).getValue());
		save1.click();
		assertEquals("F", lb1.as(Label.class).getValue());
		
		tb3.type("G");
		assertEquals("G", tb1.as(Textbox.class).getValue());
		assertEquals("G", tb2.as(Textbox.class).getValue());
		assertEquals("G", tb4.as(Textbox.class).getValue());
		save1.click();
		assertEquals("G", lb1.as(Label.class).getValue());
		
		tb4.type("H");
		assertEquals("H", tb1.as(Textbox.class).getValue());
		assertEquals("H", tb2.as(Textbox.class).getValue());
		assertEquals("H", tb3.as(Textbox.class).getValue());
		save1.click();
		assertEquals("H", lb1.as(Label.class).getValue());

		ComponentAgent tb5 = desktop.query("#tb5");
		ComponentAgent tb6 = desktop.query("#tb6");
		ComponentAgent tb7 = desktop.query("#tb7");
		ComponentAgent tb8 = desktop.query("#tb8");
		ComponentAgent save2 = desktop.query("#save2");
		ComponentAgent lb2 = desktop.query("#lb2");
		ComponentAgent lb3 = desktop.query("#lb3");
		
		assertEquals("", tb5.as(Textbox.class).getValue());
		assertEquals("", tb6.as(Textbox.class).getValue());
		assertEquals("", tb7.as(Textbox.class).getValue());
		assertEquals("", tb8.as(Textbox.class).getValue());
		assertEquals("", lb2.as(Label.class).getValue());
		assertEquals("", lb3.as(Label.class).getValue());
		
		tb5.type("A");
		assertEquals("A", tb6.as(Textbox.class).getValue());
		assertEquals("", tb7.as(Textbox.class).getValue());
		assertEquals("", tb8.as(Textbox.class).getValue());
		
		tb6.type("B");
		assertEquals("B", tb5.as(Textbox.class).getValue());
		assertEquals("", tb7.as(Textbox.class).getValue());
		assertEquals("", tb8.as(Textbox.class).getValue());
		
		tb7.type("C");
		assertEquals("B", tb5.as(Textbox.class).getValue());
		assertEquals("B", tb6.as(Textbox.class).getValue());
		assertEquals("C", tb8.as(Textbox.class).getValue());
		
		tb8.type("D");
		assertEquals("B", tb5.as(Textbox.class).getValue());
		assertEquals("B", tb6.as(Textbox.class).getValue());
		assertEquals("D", tb7.as(Textbox.class).getValue());
		
		save2.click();
		assertEquals("B", lb2.as(Label.class).getValue());
		assertEquals("D", lb3.as(Label.class).getValue());
	}
}
