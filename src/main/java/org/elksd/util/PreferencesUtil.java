package org.elksd.util;

import java.io.File;
import java.util.Locale;
import java.util.prefs.Preferences;

import org.apache.commons.lang3.Validate;

public class PreferencesUtil {

	private final static String PREFS = "elksd";
	private final static String LANGUAGE_KEY = "language";
	private final static String LKFOLDER_KEY = "lkfolder";
	private final static String SDFOLDER_KEY = "sdfolder";

	private Preferences prefs;

	public PreferencesUtil() {
		prefs = Preferences.userRoot().node(PREFS);
	}

	public Locale getLocale() {
		String localeStr = prefs.get(LANGUAGE_KEY, "sr");
		return new Locale(localeStr);
	}

	public void saveLocale(Locale newLocale) {
		prefs.put(LANGUAGE_KEY, newLocale.toString());
	}

	public String getLkFolderName() {
		String lkFolderStr = prefs.get(LKFOLDER_KEY, System.getProperty("user.home"));
		return lkFolderStr;
	}

	public File getLkFolder() {
		return new File(getLkFolderName());
	}

	public void saveLkFolder(File lkFolder) {
		Validate.isTrue(lkFolder.exists() && lkFolder.isDirectory(), "Folder must exist and must be directory: %s",
				lkFolder);
		prefs.put(LKFOLDER_KEY, lkFolder.getAbsolutePath());
	}

	public void saveLkFolder(String lkFolderStr) {
		File lkFolder = new File(lkFolderStr);
		saveLkFolder(lkFolder);
	}

	public String getSdFolderName() {
		String sdFolderStr = prefs.get(SDFOLDER_KEY, System.getProperty("user.home"));
		return sdFolderStr;
	}

	public File getSdFolder() {
		return new File(getSdFolderName());
	}

	public void saveSdFolder(File sdFolder) {
		Validate.isTrue(sdFolder.exists() && sdFolder.isDirectory(), "Folder must exist and must be directory: %s",
				sdFolder);
		prefs.put(SDFOLDER_KEY, sdFolder.getAbsolutePath());
	}

	public void saveSdFolder(String sdFolderStr) {
		File sdFolder = new File(sdFolderStr);
		saveSdFolder(sdFolder);
	}

}
