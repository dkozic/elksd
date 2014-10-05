package org.elksd.gui;

import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.elksd.gui.sd.EsdFrame;
import org.elksd.util.PreferencesUtil;

public class ElksdTrayIcon extends TrayIcon {

	private static Logger log = Logger.getLogger(ElksdTrayIcon.class);

	private SystemTray tray = null;
	private PreferencesUtil preferences = new PreferencesUtil();

	private static final String ELKSD_LOGGER = "org.elksd";
	public ElksdTrayIcon() {
		super(createImage("images/vcard.png", "tray icon"));

		tray = SystemTray.getSystemTray();

		PopupMenu popup = new PopupMenu();

		// Create a popup menu components
		MenuItem aboutItem = new MenuItem(
				Messages.getString("ElksdTrayIcon.about"));
		Menu debugMenu = new Menu("Debug");
		MenuItem errorItem = new MenuItem("Error");
		MenuItem warningItem = new MenuItem("Warning");
		MenuItem infoItem = new MenuItem("Info");
		MenuItem debugItem = new MenuItem("Debug");
		MenuItem noneItem = new MenuItem("None");
		MenuItem optionsItem = new MenuItem(
				Messages.getString("ElksdTrayIcon.options"));
		MenuItem exitItem = new MenuItem(
				Messages.getString("ElksdTrayIcon.exit"));
		Menu languageMenu = new Menu(
				Messages.getString("ElksdTrayIcon.language"));
		MenuItem language_srItem = new MenuItem(
				"\u0441\u0440\u043F\u0441\u043A\u0438");
		language_srItem.setActionCommand("sr");
		MenuItem language_sr_RS_LatItem = new MenuItem("srpski");
		language_sr_RS_LatItem.setActionCommand("sr_RS_Lat");
		MenuItem language_enItem = new MenuItem("English");
		language_enItem.setActionCommand("en");

		// Add components to popup menu
		popup.add(aboutItem);
		popup.addSeparator();
		popup.add(debugMenu);
		debugMenu.add(errorItem);
		debugMenu.add(warningItem);
		debugMenu.add(infoItem);
		debugMenu.add(debugItem);
		debugMenu.add(noneItem);
		popup.add(languageMenu);
		languageMenu.add(language_srItem);
		languageMenu.add(language_sr_RS_LatItem);
		languageMenu.add(language_enItem);
		popup.add(optionsItem);
		popup.add(exitItem);

		setPopupMenu(popup);
		setToolTip(StringEscapeUtils.unescapeJava(Messages
				.getString("ElksdTrayIcon.tooltip")));

		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EsdFrame esdFrame = new EsdFrame();
				esdFrame.setVisible(true);
			}
		});

		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(
								null,
								"eLKSD\nElectronic identity cards and registration certificates reader\nAuthor: Drazen Kozic (kozic.drazen@gmail.com)",
								"About", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuItem item = (MenuItem) e.getSource();
				if ("Error".equals(item.getLabel())) {
					Logger.getLogger(ELKSD_LOGGER).setLevel(Level.ERROR);
					String message = "The log level is now ERROR";
					displayMessage("eLKSD", message, MessageType.INFO);
					log.info(message);
				} else if ("Warning".equals(item.getLabel())) {
					Logger.getLogger(ELKSD_LOGGER).setLevel(Level.WARN);
					String message = "The log level is now WARN";
					displayMessage("eLKSD", message, MessageType.INFO);
					log.info(message);
				} else if ("Info".equals(item.getLabel())) {
					Logger.getLogger(ELKSD_LOGGER).setLevel(Level.INFO);
					String message = "The log level is now INFO";
					displayMessage("eLKSD", message, MessageType.INFO);
					log.info(message);
				} else if ("Debug".equals(item.getLabel())) {
					Logger.getLogger(ELKSD_LOGGER).setLevel(Level.DEBUG);
					String message = "The log level is now DEBUG";
					displayMessage("eLKSD", message, MessageType.INFO);
					log.info(message);
				} else if ("None".equals(item.getLabel())) {
					String message = "The log level is now OFF";
					Logger.getLogger(ELKSD_LOGGER).setLevel(Level.OFF);
					displayMessage("eLKSD", message, MessageType.NONE);
					log.info(message);
				}
			}
		};

		errorItem.addActionListener(listener);
		warningItem.addActionListener(listener);
		infoItem.addActionListener(listener);
		debugItem.addActionListener(listener);
		noneItem.addActionListener(listener);

		ActionListener languageListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuItem item = (MenuItem) e.getSource();
				if ("sr".equals(item.getActionCommand())) {
					Locale newLocale = new Locale("sr");
					Locale.setDefault(newLocale);
					preferences.saveLocale(newLocale);
					String message = Messages
							.getString("language_change", "sr");
					displayMessage("eLKSD", message, MessageType.INFO);
					log.info(message);
				} else if ("sr_RS_Lat".equals(item.getActionCommand())) {
					Locale newLocale = new Locale("sr_RS_Lat");
					Locale.setDefault(newLocale);
					preferences.saveLocale(newLocale);
					String message = Messages.getString("language_change",
							"sr_RS_Lat");
					displayMessage("eLKSD", message, MessageType.INFO);
					log.info(message);
				} else if ("en".equals(item.getActionCommand())) {
					Locale newLocale = Locale.ENGLISH;
					Locale.setDefault(newLocale);
					preferences.saveLocale(newLocale);
					String message = Messages
							.getString("language_change", "en");
					displayMessage("eLKSD", message, MessageType.INFO);
					log.info(message);
				}
			}
		};

		language_enItem.addActionListener(languageListener);
		language_srItem.addActionListener(languageListener);
		language_sr_RS_LatItem.addActionListener(languageListener);

		optionsItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OptionsDialog optionsDialog = new OptionsDialog();
				optionsDialog.setVisible(true);
			}
		});

		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tray.remove(ElksdTrayIcon.this);
				System.exit(0);
			}
		});

	}

	private static Image createImage(String path, String description) {
		URL imageURL = ElksdApp.class.getResource(path);

		if (imageURL == null) {
			log.error("Resource not found: " + path);
			return null;
		} else {
			return (new ImageIcon(imageURL, description)).getImage();
		}
	}

}
