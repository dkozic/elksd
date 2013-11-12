package org.elksd.sd;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.elksd.tlv.TagCharset;

public enum TagB {

	TAG_78("78", TagCharset.HEX), TAG_4F("4F", TagCharset.HEX), TAG_72("72",
			TagCharset.HEX), TAG_80("80", TagCharset.HEX), TAG_A1("A1",
			TagCharset.HEX), TAG_A7("A7", TagCharset.HEX), TAG_A7_83("83"), TAG_A7_84(
			"84"), TAG_A7_85("85"), TAG_A8("A8", TagCharset.HEX), TAG_A8_83(
			"83"), TAG_A8_84("84"), TAG_A8_85("85"), TAG_A9("A9",
			TagCharset.HEX), TAG_A9_83("83"), TAG_A9_84("84"), TAG_A9_85("85"), TAG_A4(
			"A4", TagCharset.HEX), TAG_96("96"), TAG_97("97"), TAG_98("98"), TAG_99(
			"99"), TAG_9A("9A"), TAG_AD("AD", TagCharset.HEX), TAG_9F1F("9F1F"), TAG_9F20(
			"9F20"), TAG_9F21("9F21"), TAG_9F22("9F22"), TAG_9F23("9F23"), TAG_AE(
			"AE", TagCharset.HEX), TAG_9B("9B"), TAG_9C("9C"), TAG_A5("A5",
			TagCharset.HEX), TAG_9D("9D"), TAG_9E("9E"), TAG_9F24("9F24"), TAG_9F25(
			"9F25"), TAG_AF("AF", TagCharset.HEX), TAG_9F26("9F26"), TAG_9F27(
			"9F27"), TAG_9F28("9F28"), TAG_B0("B0", TagCharset.HEX), TAG_9F29(
			"9F29"), TAG_9F2A("9F2A"), TAG_9F2B("9F2B"), TAG_9F2C("9F2C"), TAG_9F2D(
			"9F2D"), TAG_9F2E("9F2E"), TAG_9F2F("9F2F"), TAG_9F30("9F30"), TAG_9F31(
			"9F31"), TAG_9F32("9F32");

	TagB(String code, TagCharset tagCharset) {
		this.code = code;
		this.tagCharset = tagCharset;
	}

	TagB(String code) {
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
