package org.elksd.gui;

import java.awt.AWTException;
import java.awt.SystemTray;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.TerminalFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;
import org.elksd.util.PreferencesUtil;

public class ElksdApp {

	private static Logger log = Logger.getLogger(ElksdApp.class);

	public static void main(String[] args) {
		/* Use an appropriate Look and Feel */
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			// UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		/* Turn off metal's use of bold fonts */
		UIManager.put("swing.boldMetal", Boolean.FALSE);

		// Reading Locale from preferences and setting default locale
		PreferencesUtil preferences = new PreferencesUtil();
		Locale locale = preferences.getLocale();
		Locale.setDefault(locale);

		try {
			Lock lock = new Lock();
		} catch (Lock.LockException e) {
			JOptionPane.showMessageDialog(null,
					"This program is already running.");
			System.exit(0);

		} catch (IOException e1) {
			log.error("Error trying to make process lock.", e1);
			System.exit(1);

		}

		// Schedule a job for the event-dispatching thread:
		// adding TrayIcon.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		// Check the SystemTray support
		if (SystemTray.isSupported()) {
			SystemTray tray = SystemTray.getSystemTray();
			ElksdTrayIcon trayIcon = new ElksdTrayIcon();
			try {
				tray.add(trayIcon);
			} catch (AWTException e) {
				log.error("TrayIcon could not be added.", e);
				System.exit(1);
				;
			}

		} else {
			log.error("SystemTray is not supported");
			System.exit(1);
		}

		try {
			CardTerminal terminal = null;
			TerminalFactory factory = TerminalFactory.getDefault();
			List<CardTerminal> terminalList = factory.terminals().list();
			terminal = terminalList.get(0);

			SmartCardReader reader = new SmartCardReader(terminal);
			SmartCardListener listener = new SmartCardListener();
			reader.addCardListener(listener);

		} catch (CardException ce) {
			log.error("Error setting up terminal and listener", ce);
			System.exit(1);
		}

	}

}
