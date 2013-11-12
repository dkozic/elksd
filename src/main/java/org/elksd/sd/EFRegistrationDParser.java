package org.elksd.sd;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.elksd.tlv.BERParser;
import org.elksd.tlv.TLV;
import org.elksd.util.Util;

public class EFRegistrationDParser {

	private static Logger log = Logger.getLogger(EFRegistrationDParser.class);
	
	public String getTagAsHexString(byte[] tag) {
		return Util.bytesToHex(tag);
	}

	private void logUnknownTag(TLV tlv, byte[] bytes) {
		log.warn("Unknown tag: " + tlv.toString() + " bytes: "
				+ Util.bytesToHex(bytes));
	}

	private Map<TagD, TLV> parse78(byte[] bytes) {
		Map<TagD, TLV> result = new HashMap<TagD, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagD.TAG_4F.codeEquals(t)) {
				result.put(TagD.TAG_4F, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	private Map<TagD, TLV> parse72(byte[] bytes) {
		Map<TagD, TLV> result = new HashMap<TagD, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagD.TAG_80.codeEquals(t)) {
				result.put(TagD.TAG_80, tlv);
			} else if (TagD.TAG_C9.codeEquals(t)) {
				result.put(TagD.TAG_C9, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	public Map<TagD, TLV> parseFile(byte[] bytes)
			throws UnsupportedEncodingException {
		Map<TagD, TLV> result = new HashMap<TagD, TLV>();

		BERParser bp = new BERParser(bytes);
		for (int i = 0; i < 2; i++) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagD.TAG_78.codeEquals(t)) {
				Map<TagD, TLV> r78 = parse78(tlv.getValue());
				result.putAll(r78);
			} else if (TagD.TAG_72.codeEquals(t)) {
				Map<TagD, TLV> r72 = parse72(tlv.getValue());
				result.putAll(r72);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}

		return result;
	}
}
