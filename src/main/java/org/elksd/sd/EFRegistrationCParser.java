package org.elksd.sd;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.elksd.tlv.BERParser;
import org.elksd.tlv.TLV;
import org.elksd.util.Util;

public class EFRegistrationCParser {

	private static Logger log = Logger.getLogger(EFRegistrationCParser.class);

	public String getTagAsHexString(byte[] tag) {
		return Util.bytesToHex(tag);
	}

	private void logUnknownTag(TLV tlv, byte[] bytes) {
		log.warn("Unknown tag: " + tlv.toString() + " bytes: "
				+ Util.bytesToHex(bytes));
	}

	private Map<TagC, TLV> parse78(byte[] bytes) {
		Map<TagC, TLV> result = new HashMap<TagC, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagC.TAG_4F.codeEquals(t)) {
				result.put(TagC.TAG_4F, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	private Map<TagC, TLV> parse72(byte[] bytes) {
		Map<TagC, TLV> result = new HashMap<TagC, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagC.TAG_80.codeEquals(t)) {
				result.put(TagC.TAG_80, tlv);
			} else if (TagC.TAG_C1.codeEquals(t)) {
				result.put(TagC.TAG_C1, tlv);
			} else if (TagC.TAG_C2.codeEquals(t)) {
				result.put(TagC.TAG_C2, tlv);
			} else if (TagC.TAG_C3.codeEquals(t)) {
				result.put(TagC.TAG_C3, tlv);
			} else if (TagC.TAG_C4.codeEquals(t)) {
				result.put(TagC.TAG_C4, tlv);
			} else if (TagC.TAG_C5.codeEquals(t)) {
				result.put(TagC.TAG_C5, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	public Map<TagC, TLV> parseFile(byte[] bytes)
			throws UnsupportedEncodingException {
		Map<TagC, TLV> result = new HashMap<TagC, TLV>();

		BERParser bp = new BERParser(bytes);
		for (int i = 0; i < 2; i++) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagC.TAG_78.codeEquals(t)) {
				Map<TagC, TLV> r78 = parse78(tlv.getValue());
				result.putAll(r78);
			} else if (TagC.TAG_72.codeEquals(t)) {
				Map<TagC, TLV> r72 = parse72(tlv.getValue());
				result.putAll(r72);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}

		return result;
	}

}
