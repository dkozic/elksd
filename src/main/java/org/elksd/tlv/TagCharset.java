package org.elksd.tlv;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.elksd.util.Util;

public enum TagCharset {

	HEX("HEX"), ISO8859P1("ISO8859-1"), ISO8859P2("ISO8859-2"), ISO8859P5(
			"ISO8859-5"), ISO8859P7("ISO8859-7"), UTF8("UTF-8");

	TagCharset(String charset) {
		this.charset = charset;
	}

	private final String charset;

	public String getCharset() {
		return charset;
	}

	public String bytesToCharsetString(byte[] bytes) {
		if (charset.equals("HEX")) {
			return Util.bytesToHex(bytes);
		} else {
			try {
				return new String(bytes, charset);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				throw new RuntimeException(
						"Error in TagCharset#asCharsetString", e);
			}
		}
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("charset", charset).toString();
	}
}
