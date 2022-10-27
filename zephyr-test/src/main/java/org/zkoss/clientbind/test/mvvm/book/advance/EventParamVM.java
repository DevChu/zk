/* EventParamVM.java

		Purpose:
		
		Description:
		
		History:
				Tue May 04 17:33:35 CST 2021, Created by leon

Copyright (C) 2021 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.clientbind.test.mvvm.book.advance;

import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.event.InputEvent;

public class EventParamVM {
	String message;

	String message2;

	public String getMessage() {
		return message;
	}

	public String getMessage2() {
		return message2;
	}

	@Command
	@NotifyChange({"message", "message2"})
	public void showTyping(@BindingParam("v") String value, @ContextParam(ContextType.TRIGGER_EVENT) InputEvent event) {
		message = value;
		message2 = event.getValue();
	}
}
