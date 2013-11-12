package org.elksd.lk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

import javax.smartcardio.ATR;
import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardException;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;

import org.apache.log4j.Logger;
import org.elksd.tlv.TLV;
import org.elksd.util.Util;

public class ElkReader {

	private static Logger log = Logger.getLogger(ElkReader.class);

	private static final byte[] EF_DOCUMENT = { 0x0F, 0x02 };
	private static final byte[] EF_PERSONAL = { 0x0F, 0x03 };
	private static final byte[] EF_RESIDENCE = { 0x0F, 0x04 };
	private static final byte[] EF_PORTRAIT = { 0x0F, 0x06 };

	private Card card = null;
	private CardChannel channel = null;

	public ElkReader(Card card) {
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

	public ElkData readElk() throws CardException, IOException {

		init();

		byte[] fileDocument = readFile(EF_DOCUMENT);
		EFDocumentParser pDocument = new EFDocumentParser();
		Map<TagDocument, TLV> fieldsDocument = pDocument
				.parseFile(fileDocument);

		byte[] filePersonal = readFile(EF_PERSONAL);
		EFPersonalParser pPersonal = new EFPersonalParser();
		Map<TagPersonal, TLV> fieldsPersonal = pPersonal
				.parseFile(filePersonal);

		byte[] fileResidence = readFile(EF_RESIDENCE);
		EFResidenceParser pResidence = new EFResidenceParser();
		Map<TagResidence, TLV> fieldsResidence = pResidence
				.parseFile(fileResidence);

		byte[] filePortrait = readFile(EF_PORTRAIT);
		byte[] portrait = stripHeader(filePortrait, 10);

		ElkDataFactory factory = new ElkDataFactory(fieldsDocument,
				fieldsPersonal, fieldsResidence, portrait);

		log.debug(factory.toString());
		ElkData evdData = factory.create();

		destroy();

		return evdData;

	}

	private byte[] stripHeader(byte[] file, int offset) {
		// ByteArrayInputStream is = new ByteArrayInputStream(file, 6,
		// file.length);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		os.write(file, offset, file.length - offset);
		return os.toByteArray();
	}

	private void printCommand(String command, CommandAPDU apdu) {
		log.debug(command + " APDU >>>: " + Util.bytesToHex(apdu.getBytes()));
	}

	private void printResponse(ResponseAPDU apdu) {
		log.debug("RESPONSE APDU <<<: " + Util.bytesToHex(apdu.getBytes()));
	}

	public String getTagAsHexString(byte[] tag) {
		return Util.bytesToHex(tag);
	}

	private int parseFileLength(TLV tlv) {
		byte[] v2 = tlv.getValue();
		int l2 = tlv.getLength();
		int length = 0;
		for (int i = 0; i < l2; i++) {
			length = length + ((v2[i] & 0xFF) << (8 * (l2 - 1 - i)));
		}
		return length;
	}

	private byte[] selectFile(byte[] fileId) throws CardException {

		card.beginExclusive();

		CommandAPDU commandAPDU = new CommandAPDU(0x00, 0xA4, 0x02, 0x04,
				fileId);
		printCommand("SELECT FILE", commandAPDU);

		ResponseAPDU responseAPDU = channel.transmit(commandAPDU);
		printResponse(responseAPDU);

		card.endExclusive();

		byte[] fcp = responseAPDU.getData();
		return fcp;
	}

	private byte[] readFile(byte[] fileId) throws CardException, IOException {

		// select
		byte[] fcp = selectFile(fileId);

		FCPParser fcpParser = new FCPParser();
		Map<TagFCP, TLV> fcpTags = fcpParser.parseFCP(fcp);

		TLV t81 = fcpTags.get(TagFCP.TAG_81);

		int fileLength = parseFileLength(t81);

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
