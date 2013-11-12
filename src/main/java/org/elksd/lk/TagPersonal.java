package org.elksd.lk;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.elksd.tlv.TagCharset;

public enum TagPersonal {

	TAG_0D("0D", TagCharset.HEX), TAG_16("16"), TAG_17("17", TagCharset.UTF8), TAG_18(
			"18"), TAG_19("19"), TAG_1A("1A"), TAG_1B("1B"), TAG_1D("1D"), TAG_1E(
			"1E"), TAG_1F06("1F06");

	TagPersonal(String code, TagCharset tagCharset) {
		this.code = code;
		this.tagCharset = tagCharset;
	}

	TagPersonal(String code) {
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
