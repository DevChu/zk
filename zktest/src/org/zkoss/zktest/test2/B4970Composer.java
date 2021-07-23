/* B4970Composer.java

	Purpose:
		
	Description:
		
	History:
		Fri Jul 23 10:39:38 CST 2021, Created by rudyhuang

Copyright (C) 2021 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2;

import java.util.Arrays;
import java.util.Collections;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Composer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.ListitemRenderer;

/**
 * @author rudyhuang
 */
public class B4970Composer implements Composer<Div> {
	private Div div;

	@Override
	public void doAfterCompose(Div comp) throws Exception {

		Button button = new Button("create");
		comp.appendChild(button);

		button.addEventListener("onClick", event -> {
			div = (Div) Executions.createComponentsDirectly(
					"<div apply='${arg.innerComposer}'><listbox/></div>", "zul",
					null,
					Collections.singletonMap("innerComposer", (Composer<Div>) div2 -> {
						div2.addEventListener("onInitModel", event2 -> {
							Listbox listbox = (Listbox) div2.getFirstChild();
							listbox.setModel(new ListModelList<>(Arrays.asList("aaa", "bbb", "ccc")));
							listbox.setItemRenderer((ListitemRenderer<String>) (item, data, index) -> item.setLabel(data));
						});
						Events.postEvent("onInitModel", div2, null);
					}));
		});
	}
}