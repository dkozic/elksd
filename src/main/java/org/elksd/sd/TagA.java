package org.elksd.sd;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.elksd.tlv.TagCharset;

public enum TagA {

	TAG_78("78", TagCharset.HEX), TAG_4F("4F", TagCharset.HEX), TAG_71("71",
			TagCharset.HEX), TAG_80("80", TagCharset.HEX), TAG_9F33("9F33"), TAG_9F34(
			"9F34"), TAG_9F35("9F35"), TAG_9F36("9F36"), TAG_9F37("9F37",
			TagCharset.HEX), TAG_9F38("9F38"), TAG_81("81"), TAG_82("82"), TAG_A1(
			"A1", TagCharset.HEX), TAG_A2("A2", TagCharset.HEX), TAG_A2_83("83"), TAG_A2_84(
			"84"), TAG_A2_85("85"), TAG_86("86", TagCharset.HEX), TAG_A3("A3",
			TagCharset.HEX), TAG_87("87"), TAG_88("88"), TAG_89("89"), TAG_8A(
			"8A"), TAG_A4("A4", TagCharset.HEX), TAG_8B("8B"), TAG_8C("8C"), TAG_8D(
			"8D"), TAG_8E("8E"), TAG_8F("8F"), TAG_A5("A5", TagCharset.HEX), TAG_90(
			"90"), TAG_91("91"), TAG_92("92"), TAG_93("93"), TAG_A6("A6",
			TagCharset.HEX), TAG_94("94"), TAG_95("95");

	TagA(String code, TagCharset tagCharset) {
		this.code = code;
		this.tagCharset = tagCharset;
	}

	TagA(String code) {
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
