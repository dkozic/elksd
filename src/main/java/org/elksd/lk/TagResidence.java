package org.elksd.lk;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.elksd.tlv.TagCharset;

public enum TagResidence {

	TAG_0D("0D", TagCharset.HEX), TAG_20("20"), TAG_21("21"), TAG_22("22"), TAG_23(
			"23"), TAG_24("24"), TAG_2A("2A");

	TagResidence(String code, TagCharset tagCharset) {
		this.code = code;
		this.tagCharset = tagCharset;
	}

	TagResidence(String code) {
		this.code = code;
		this.tagCharset = TagCharset.UTF8;
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
