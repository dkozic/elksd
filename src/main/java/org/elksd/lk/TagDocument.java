package org.elksd.lk;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.elksd.tlv.TagCharset;

public enum TagDocument {

	TAG_0D("0D"), TAG_0A("0A"), TAG_0B("0B", TagCharset.HEX), TAG_0C(
			"0C"), TAG_0E("0E"), TAG_0F("0F"), TAG_09("09"), TAG_10("10",
			TagCharset.HEX), TAG_11("11", TagCharset.HEX);

	TagDocument(String code, TagCharset tagCharset) {
		this.code = code;
		this.tagCharset = tagCharset;
	}

	TagDocument(String code) {
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
