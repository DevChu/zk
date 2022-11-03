/* BasicAutoVM.java

	Purpose:
		
	Description:
		
	History:
		Tue May 04 18:13:42 CST 2021, Created by rudyhuang

Copyright (C) 2021 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.clientbind.test.book.viewmodel.notification;

import java.security.SecureRandom;

import org.zkoss.bind.annotation.AutoNotifyChange;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;


/**
 * @author rudyhuang
 */
@AutoNotifyChange
public class BasicAutoVM {
	private int id;
	private String name;
	private String city;

	@Init
	public void init() {
		randomize();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Command
	public void randomize() {
		setId(new SecureRandom().nextInt());
		setName(generateRandomString());
		setCity(generateRandomString());
	}

	@Command
	public void reset() {
		setName("");
		setCity("");
	}

	private String generateRandomString() {
		return new SecureRandom().ints(10, 'A', 'z' + 1)
				.filter(Character::isAlphabetic)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
	}
}
