package org.elksd.sd;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.elksd.tlv.TagCharset;

public enum TagC {

	TAG_78("78", TagCharset.HEX), TAG_4F("4F", TagCharset.HEX), TAG_72("72",
			TagCharset.HEX), TAG_80("80", TagCharset.HEX), TAG_C1("C1"), TAG_C2(
			"C2"), TAG_C3("C3"), TAG_C4("C4"), TAG_C5("C5");

	TagC(String code, TagCharset tagCharset) {
		this.code = code;
		this.tagCharset = tagCharset;
	}

	TagC(String code) {
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
