package org.elksd.gui;

import java.util.Arrays;

import javax.smartcardio.ATR;
import javax.smartcardio.Card;

import org.apache.log4j.Logger;
import org.elksd.gui.SmartCardReader.ReaderListener;
import org.elksd.gui.lk.ElkFrame;
import org.elksd.gui.sd.EsdFrame;
import org.elksd.lk.ElkData;
import org.elksd.lk.ElkReader;
import org.elksd.sd.EsdData;
import org.elksd.sd.EsdReader;
import org.elksd.util.Util;

public class SmartCardListener implements ReaderListener {

	private static Logger log = Logger.getLogger(SmartCardListener.class);

	static final byte[] ELK_ATR = { (byte) 0x3B, (byte) 0xB9, (byte) 0x18,
			(byte) 0x00, (byte) 0x81, (byte) 0x31, (byte) 0xFE, (byte) 0x9E,
			(byte) 0x80, (byte) 0x73, (byte) 0xFF, (byte) 0x61, (byte) 0x40,
			(byte) 0x83, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0xDF };

	static final byte[] ESD_ATR = { (byte) 0x3B, (byte) 0xDB, (byte) 0x96,
			(byte) 0x00, (byte) 0x80, (byte) 0xB1, (byte) 0xFE, (byte) 0x45,
			(byte) 0x1F, (byte) 0x83, (byte) 0x00, (byte) 0x31, (byte) 0xC0,
			(byte) 0x64, (byte) 0x1A, (byte) 0x18, (byte) 0x01, (byte) 0x00,
			(byte) 0x0F, (byte) 0x90, (byte) 0x00, (byte) 0x52 };

	public void inserted(Card card) {

		try {
			ATR atr = card.getATR();
			byte[] baATR = atr.getBytes();
			log.info("ATR: " + Util.bytesToHex(baATR));

			if (Arrays.equals(baATR, ELK_ATR)) {
				ElkReader elkReader = new ElkReader(card);
				ElkData elkData = elkReader.readElk();
				ElkFrame elkFrame = new ElkFrame();
				elkFrame.setElkData(elkData);
				elkFrame.setVisible(true);
			} else if (Arrays.equals(baATR, ESD_ATR)) {
				EsdReader esdReader = new EsdReader(card);
				EsdData esdData = esdReader.readEsd();
				EsdFrame esdFrame = new EsdFrame();
				esdFrame.setEsdData(esdData);
				esdFrame.setVisible(true);
			} else {
				throw new IllegalArgumentException("ATR is not supported"
						+ Util.bytesToHex(baATR));
			}

		} catch (Exception e) {
			log.error("Error in SmartCardListener#inserted()", e);
		}
	};

	public void removed() {
		log.info("Card is removed.");
	}

}
