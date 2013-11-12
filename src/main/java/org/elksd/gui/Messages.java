package org.elksd.gui;

import java.beans.Beans;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	// //////////////////////////////////////////////////////////////////////////
	//
	// Constructor
	//
	// //////////////////////////////////////////////////////////////////////////
	private Messages() {
		// do not instantiate
	}

	// //////////////////////////////////////////////////////////////////////////
	//
	// Bundle access
	//
	// //////////////////////////////////////////////////////////////////////////
	private static final String BUNDLE_NAME = "org.elksd.gui.messages"; //$NON-NLS-1$
	private static final ResourceBundle RESOURCE_BUNDLE = loadBundle();

	private static ResourceBundle loadBundle() {
		return ResourceBundle.getBundle(BUNDLE_NAME);
	}

	// //////////////////////////////////////////////////////////////////////////
	//
	// Strings access
	//
	// //////////////////////////////////////////////////////////////////////////
	public static String getString(String key) {
		try {
//			ResourceBundle bundle = Beans.isDesignTime() ? loadBundle()
//					: RESOURCE_BUNDLE;
			ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
			return bundle.getString(key);
		} catch (MissingResourceException e) {
			return "!" + key + "!";
		}
	}

	public static String getString(String key, Object... args) {
		try {
			ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
			String msg = bundle.getString(key);
			String result = MessageFormat.format(msg, args);
			return result;
		} catch (MissingResourceException e) {
			return "!" + key + "!";
		}
	}
}
