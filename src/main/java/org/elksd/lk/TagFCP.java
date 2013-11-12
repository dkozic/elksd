package org.elksd.lk;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.elksd.tlv.TagCharset;

public enum TagFCP {

	TAG_62("62"), TAG_80("80"), TAG_81("81"), TAG_82("82"), TAG_83("83"), TAG_84(
			"84"), TAG_85("85"), TAG_86("86"), TAG_87("87"), TAG_88("88"), TAG_8A(
			"8A"), TAG_8B("8B"), TAG_8C("8C"), TAG_8D("8D"), TAG_8E("8E"), TAG_A0(
			"A0"), TAG_A1("A1"), TAG_A2("A2"), TAG_A5("A5"), TAG_AB("AB"), TAG_AC(
			"AC");

	TagFCP(String code, TagCharset tagCharset) {
		this.code = code;
		this.tagCharset = tagCharset;
	}

	TagFCP(String code) {
		this.code = code;
		this.tagCharset = TagCharset.HEX;
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
