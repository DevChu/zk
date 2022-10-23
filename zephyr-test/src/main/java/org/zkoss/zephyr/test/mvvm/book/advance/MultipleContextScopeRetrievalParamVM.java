/* MultipleContextScopeRetrievalParamVM.java

		Purpose:
		
		Description:
		
		History:
				Tue May 04 15:40:02 CST 2021, Created by leon

Copyright (C) 2021 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zephyr.test.mvvm.book.advance;

import org.zkoss.bind.annotation.*;

public class MultipleContextScopeRetrievalParamVM {
	String message;

	@Init
	public void init(@CookieParam("nosuch") @HeaderParam String host) {
		message = host;
	}

	@NotifyChange("message")
	@Command
	public void cmd(@HeaderParam("nosuch") @CookieParam String jsessionid) {
		message = jsessionid;
	}

	@NotifyChange("message")
	@Command
	public void cmd2(@HeaderParam @CookieParam String host) {
		message = host;
	}

	@NotifyChange("message")
	@Command
	public void cmd3(@HeaderParam @CookieParam String jsessionid) {
		message = jsessionid;
	}

	public String getMessage() {
		return message;
	}
}
