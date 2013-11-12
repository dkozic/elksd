package org.elksd.sd;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.smartcardio.ATR;
import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardException;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;

import org.apache.log4j.Logger;
import org.elksd.tlv.BERParser;
import org.elksd.tlv.TLV;
import org.elksd.util.Util;

public class EsdReader {

	private static Logger log = Logger.getLogger(EsdReader.class);

	private static final byte[] EF_REGISTRATON_A = { (byte) 0xD0, (byte) 0x01 };
	private static final byte[] EF_REGISTRATON_B = { (byte) 0xD0, (byte) 0x11 };
	private static final byte[] EF_REGISTRATON_C = { (byte) 0xD0, (byte) 0x21 };
	private static final byte[] EF_REGISTRATON_D = { (byte) 0xD0, (byte) 0x31 };

	private static final byte[] APPLICATION = { (byte) 0xA0, 0x00, 0x00, 0x00,
			0x77, 0x01, 0x08, 0x00, 0x07, 0x00, 0x00, (byte) 0xFE, 0x00, 0x00,
			(byte) 0xAD, (byte) 0xF2 };

	private Card card = null;
	private CardChannel channel = null;

	public EsdReader(Card card) {
		this.card = card;
	}

	private void init() throws CardException {

		// card
		log.info("Card: " + card);

		// atr
		ATR atr = card.getATR();
		byte[] baATR = atr.getBytes();
		log.info("ATR: " + Util.bytesToHex(baATR));

		// channel
		channel = card.getBasicChannel();
		log.info("Channel: " + channel.toString());
	}

	private void destroy() throws CardException {
		card.disconnect(true);
	}

	public EsdData readEsd() throws CardException, IOException {

		init();

		selectApplication();

		byte[] fileA = readFile(EF_REGISTRATON_A);
		EFRegistrationAParser pA = new EFRegistrationAParser();
		Map<TagA, TLV> fieldsA = pA.parseFile(fileA);

		byte[] fileB = readFile(EF_REGISTRATON_B);
		EFRegistrationBParser pB = new EFRegistrationBParser();
		Map<TagB, TLV> fieldsB = pB.parseFile(fileB);

		byte[] fileC = readFile(EF_REGISTRATON_C);
		EFRegistrationCParser pC = new EFRegistrationCParser();
		Map<TagC, TLV> fieldsC = pC.parseFile(fileC);

		byte[] fileD = readFile(EF_REGISTRATON_D);
		EFRegistrationDParser pD = new EFRegistrationDParser();
		Map<TagD, TLV> fieldsD = pD.parseFile(fileD);

		EsdDataFactory factory = new EsdDataFactory(fieldsA, fieldsB, fieldsC,
				fieldsD);

		log.debug(factory.toString());
		EsdData evdData = factory.create();

		destroy();

		return evdData;

	}

	private void selectApplication() throws CardException {
		CommandAPDU command = new CommandAPDU(0x00, 0xA4, 0x04, 0x0C,
				APPLICATION);
		printCommand("SELECT APPLICATION", command);
		ResponseAPDU response = channel.transmit(command);
		printResponse(response);
	}

	private void printCommand(String command, CommandAPDU apdu) {
		log.debug(command + " APDU >>>: " + Util.bytesToHex(apdu.getBytes()));
	}

	private void printResponse(ResponseAPDU apdu) {
		log.debug("RESPONSE APDU <<<: " + Util.bytesToHex(apdu.getBytes()));
	}

	private int parseFileLength(byte[] fcp) {
		BERParser bp1 = new BERParser(fcp);
		TLV tlv1 = bp1.parseTLV();

		byte[] bytes2 = tlv1.getValue();
		BERParser bp2 = new BERParser(bytes2);
		TLV tlv2 = bp2.parseTLV();
		if (Arrays.equals(tlv2.getTag(), new byte[] { (byte) 0x80 })) {
			byte[] v2 = tlv2.getValue();
			int l2 = tlv2.getLength();
			int length = 0;
			for (int i = 0; i < l2; i++) {
				length = length + ((v2[i] & 0xFF) << (8 * (l2 - 1 - i)));
			}
			return length;
		} else {
			throw new IllegalStateException("First tag is not 0x80");
		}
	}

	private int selectFile(byte[] fileId) throws CardException {

		card.beginExclusive();

		CommandAPDU commandAPDU = new CommandAPDU(0x00, 0xA4, 0x02, 0x04,
				fileId);
		printCommand("SELECT FILE", commandAPDU);

		ResponseAPDU responseAPDU = channel.transmit(commandAPDU);
		printResponse(responseAPDU);

		card.endExclusive();

		byte[] fcp = responseAPDU.getData();
		int length = parseFileLength(fcp);
		return length;
	}

	private byte[] readFile(byte[] fileId) throws CardException, IOException {

		// select
		int fileLength = selectFile(fileId);
		card.beginExclusive();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// read binary
		int offset = 0;
		while (true) {
			int P1 = (offset >> 8);
			int P2 = (offset & 0x00FF);
			CommandAPDU commandADU = new CommandAPDU(0x00, 0xB0, P1, P2, 0);
			printCommand("READ BYNARY", commandADU);

			ResponseAPDU responseAPDU = channel.transmit(commandADU);
			printResponse(responseAPDU);

			byte[] r = responseAPDU.getData();
			baos.write(r);
			offset = offset + r.length;
			if (offset >= fileLength) {
				break;
			}
		}

		card.endExclusive();
		return baos.toByteArray();
	}

}
