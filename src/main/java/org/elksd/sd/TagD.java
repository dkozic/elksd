package org.elksd.sd;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.elksd.tlv.TagCharset;

public enum TagD {

	TAG_78("78", TagCharset.HEX), TAG_4F("4F", TagCharset.HEX), TAG_72("72",
			TagCharset.HEX), TAG_80("80", TagCharset.HEX), TAG_C9("C9");

	TagD(String code, TagCharset tagCharset) {
		this.code = code;
		this.tagCharset = tagCharset;
	}

	TagD(String code) {
		this.code = code;
		this.tagCharset = TagCharset.ISO8859P1;
	}

	private final String code;
	private final TagCharset tagCharset;

	public String getCode() {
		return code;
	}

	public TagCharset getTagCharset() {
		return tagCharset;
	}

	public boolean codeEquals(String code) {
		return this.code.equals(code);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name", this.name())
				.append("code", code).appendToString(tagCharset.toString())
				.toString();
	}
}
