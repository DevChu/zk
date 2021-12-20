/* ValidationMessages.java

	Purpose:
		
	Description:
		
	History:
		2011/12/26 Created by Dennis Chen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.bind.sys;

import org.zkoss.zk.ui.Component;

/**
 * To provide the message binding between validator and binder. 
 * @author dennis
 * @since 6.0.0
 */
public interface ValidationMessages {

	/**
	 * clear validation message of component
	 */
	void clearMessages(Component comp, String attr);

	/**
	 * clear validation message of component
	 */
	void clearMessages(Component comp);

	/**
	 * clear validation message of component and a special message key
	 * @since 6.5.2
	 */
	void clearKeyMessages(Component comp, String key);

	/**
	 * clear validation message of a special message key
	 * @since 6.5.2
	 */
	void clearKeyMessages(String key);

	/**
	 * clear all validation message
	 * @since 6.5.2
	 */
	void clearAllMessages();

	/**
	 * get validation messages of a component and special attribute
	 * @return messages. Always not null. Empty if no message in component and attribute
	 */
	String[] getMessages(Component comp, String attr);

	/**
	 * get validation messages of a component
	 * @return messages. Always not null. Empty if no message of component
	 */
	String[] getMessages(Component comp);

	/**
	 * get all validation messages
	 * @return messages. Always not null. Empty if no messages
	 * @since 6.0.1
	 */
	String[] getMessages();

	/**
	 * get validation message of component and a special key
	 * @return messages. Always not null. Empty if no message of key
	 */
	String[] getKeyMessages(Component comp, String key);

	/**
	 * get validation message of a special key
	 * @return messages. Always not null. Empty if no message of key
	 */
	String[] getKeyMessages(String key);

	/**
	 * set validation messages to component, it will replace previous messages
	 * @param comp the component refers to the messages
	 * @param attr the attr refers to the messages
	 * @param key the custom key refers to this messages, nullable
	 * @param messages the messages
	 */
	void setMessages(Component comp, String attr, String key, String[] messages);
	
	/**
	 * set validation messages to component, it will replace previous messages
	 * @param comp the component refers to the messages
	 * @param attr the attr refers to the messages
	 * @param key the custom key refers to this messages, nullable
	 * @param messages the messages
	 * @param value the rejected value
	 * @since 8.0.1
	 */
	void setMessages(Component comp, String attr, String key, String[] messages, Object value);

	/**
	 * add validation messages to component
	 * @param comp the component refers to the messages
	 * @param attr the attr refers to the messages
	 * @param key the custom key refers to this messages, nullable
	 * @param messages the messages
	 */
	void addMessages(Component comp, String attr, String key, String[] messages);

	/**
	 * add validation messages to component
	 * @param comp the component refers to the messages
	 * @param attr the attr refers to the messages
	 * @param key the custom key refers to this messages, nullable
	 * @param messages the messages
	 * @param value the rejected value
	 * @since 8.0.1
	 */
	void addMessages(Component comp, String attr, String key, String[] messages, Object value);

	/**
	 * Returns the first field value from the given key, if any.
	 * @param key the custom key refers to this messages, nullable
	 * @return value. Nullable.
	 * @since 8.0.1
	 */
	Object getFieldValue(String key);

	/**
	 * Returns the first field value from the given key and component, if any.
	 * @param comp the component refers to the value
	 * @param key the custom key refers to this value, nullable
	 * @return value. Nullable.
	 * @since 8.0.1
	 */
	Object getFieldValue(Component comp, String key);

	/**
	 * Returns all field values from the given key, if any.
	 * @param key the custom key refers to this messages, nullable
	 * @return values. Always not null.
	 * @since 8.0.1
	 */
	Object[] getFieldValues(String key);

	/**
	 * Returns all field values from the given key and component, if any.
	 * @param comp the component refers to the value
	 * @param key the custom key refers to this value, nullable
	 * @return values. Always not null.
	 * @since 8.0.1
	 */
	Object[] getFieldValues(Component comp, String key);

	/**
	 * Returns the first associated component from the given key, if any.
	 * @param key the custom key refers to this messages, nullable
	 * @return component. Nullable.
	 * @since 8.0.1
	 */
	Component getAssociate(String key);

	/**
	 * Returns all associated components from the given key, if any.
	 * @param key the custom key refers to this messages, nullable
	 * @return components. Always not null.
	 * @since 8.0.1
	 */
	Component[] getAssociates(String key);

}
