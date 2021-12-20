/* B70_ZK_2534.java

	Purpose:
		
	Description:
		
	History:
		10:07 AM 8/4/15, Created by jumperchen

Copyright (C) 2015 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.AbstractListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

/**
 * @author jumperchen
 */
public class B70_ZK_2534 extends SelectorComposer<Listbox> {
	@Override public void doAfterCompose(final Listbox comp) throws Exception {
		super.doAfterCompose(comp);
		List names = new ArrayList();
		for (int i = 0; i < 10; i++) {
			names.add("Jasmin" + i);
			names.add("David" + i);
			names.add("Richard" + i);
			names.add("Jean" + i);
			names.add("Norman" + i);
			names.add("Thomas" + i);
			names.add("Leonard" + i);
			names.add("Janine" + i);
			names.add("Daniel" + i);
			names.add("Michael" + i);
			names.add("Julia" + i);
			names.add("Vitali" + i);
			names.add("Katharina" + i);
			names.add("Marie" + i);
			names.add("Jenny" + i);
			names.add("Reinhard" + i);
			names.add("Christoph" + i);
			names.add("Heiko" + i);
			names.add("Ludwig" + i);
			names.add("Nico" + i);
			names.add("Rolf" + i);
		}
		final ListModelList model = new ListModelList(names);
		model.setMultiple(true);
		model.setSelectionControl(new AbstractListModel.DefaultSelectionControl(model) {
			public boolean isSelectable(Object e) {
				int i = model.indexOf(e);
				return i % 2 == 0;
			}
		});
		comp.setModel(model);
	}
}
