package org.elksd.util;

import java.util.Locale;
import java.util.prefs.Preferences;

public class PreferencesUtil {

	private final static String PREFS = "elksd";
	private final static String LANGUAGE_KEY = "language";

	public static Locale getLocale() {
		Preferences prefs = Preferences.userRoot().node(PREFS);
		String localeStr = prefs.get(LANGUAGE_KEY, "sr");
		return new Locale(localeStr);
	}

	public static void saveLocale(Locale newLocale) {
		Preferences prefs = Preferences.userRoot().node(PREFS);
		prefs.put(LANGUAGE_KEY, newLocale.toString());
	}

}
