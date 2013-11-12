package org.elksd.tlv;

import java.io.ByteArrayOutputStream;

import org.apache.log4j.Logger;

public class BERParser {

	private static Logger log = Logger.getLogger(BERParser.class);

	private int next = 0;
	private byte[] bytes;

	private boolean skip00 = false;
	private boolean skip06 = false;

	public BERParser(byte[] bytes) {
		this(bytes, false, false);
	}

	public BERParser(byte[] bytes, boolean skip00, boolean skip06) {
		this.skip00 = skip00;
		this.skip06 = skip06;
		if (bytes == null || bytes.length == 0) {
			throw new IllegalArgumentException("Bytes are empty!");
		}
		this.bytes = bytes;
		next = 0;
	}

	public boolean hasNext() {
		return next < bytes.length;
	}

	public int getPosition() {
		return next;
	}

	private byte[] parseTag() {
		int temp = next;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		while (bytes[temp] == 0x00) {
			temp++;
		}
		byte byte1 = bytes[temp++];
		if ((byte1 & 0x1F) != 0x1F) {
			baos.write(byte1 & 0xFF);

		} else {

			baos.write(byte1 & 0xFF);
			while (true) {
				byte b = bytes[temp++];
				baos.write(b & 0xFF);
				if ((b & 0x80) != 0x80) {
					break;
				}
			}

		}

		next = temp;
		return baos.toByteArray();
	}

	private long parseLength() {
		int temp = next;
		if (next >= bytes.length) {
			throw new BerParserException(
					"You are at the end of byte array at position!", next,
					temp, bytes);
		}

		if (skip06 && bytes[temp] == 0x06) {
			temp++;
		}

		long length = 0;
		byte byte1 = bytes[temp++];
		if ((byte1 & 0x80) != 0x80) {
			length = byte1 & 0xFF;
		} else {
			int l = byte1 & 0x7F;
			for (int i = 0; i < l; i++) {
				length = length
						+ ((bytes[temp + i] & 0xFF) << (8 * (l - 1 - i)));
			}
			temp = temp + l;
		}
		next = temp;
		return length;
	}

	private byte[] parseValue(int length) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		while (skip00 && bytes[next] == 0x00) {
			next++;
		}
		baos.write(bytes, next, length);
		byte[] result = baos.toByteArray();
		next = next + length;
		return result;

	}

	public TLV parseTLV() {
		byte[] tag = parseTag();
		// ovo nije bas najsretnije
		int length = (int) parseLength();
		byte[] value = parseValue(length);
		return new TLV(tag, length, value);

	}
}
