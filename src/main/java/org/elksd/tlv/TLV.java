package org.elksd.tlv;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.elksd.util.Util;

public class TLV {

	private final byte[] tag;
	private final int length;
	private final byte[] value;

	public TLV(byte[] tagBytes, int length, byte[] valueBytes) {
		this.tag = tagBytes;
		this.length = length;
		this.value = valueBytes;
	}

	public byte[] getTag() {
		return tag;
	}

	public int getLength() {
		return length;
	}

	public byte[] getValue() {
		return value;
	}

	public String toString() {
		return new ToStringBuilder(this).append("tag", Util.bytesToHex(tag))
				.append("length", length)
				.append("value", Util.bytesToHex(value)).toString();
	}
}
