package org.elksd.tlv;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.elksd.util.Util;

public class BerParserException extends RuntimeException {

	private final int next;
	private final int temp;
	private final byte[] bytes;

	public BerParserException(String message, int next, int temp, byte[] bytes) {
		super(message);
		this.next = next;
		this.temp = temp;
		this.bytes = bytes;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append(getMessage()).append("next", next).append("temp", temp)
				.append("length", bytes.length)
				.append("bytes", Util.bytesToHex(bytes)).toString();
	}
}
