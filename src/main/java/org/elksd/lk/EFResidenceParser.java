package org.elksd.lk;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.elksd.tlv.BERParser;
import org.elksd.tlv.TLV;
import org.elksd.util.Util;

public class EFResidenceParser {

	private static Logger log = Logger.getLogger(EFResidenceParser.class);

	public String getTagAsHexString(byte[] tag) {
		return Util.bytesToHex(tag);
	}

	private void logUnknownTag(TLV tlv, byte[] bytes) {
		log.warn("Unknown tag: " + tlv.toString() + " bytes: "
				+ Util.bytesToHex(bytes));
	}

	public Map<TagResidence, TLV> parseFile(byte[] bytes)
			throws UnsupportedEncodingException {
		Map<TagResidence, TLV> result = new HashMap<TagResidence, TLV>();

		BERParser bp = new BERParser(bytes, true, true);
		for (int i = 0; i < 7; i++) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagResidence.TAG_0D.codeEquals(t)) {
				result.put(TagResidence.TAG_0D, tlv);
			} else if (TagResidence.TAG_20.codeEquals(t)) {
				result.put(TagResidence.TAG_20, tlv);
			} else if (TagResidence.TAG_21.codeEquals(t)) {
				result.put(TagResidence.TAG_21, tlv);
			} else if (TagResidence.TAG_22.codeEquals(t)) {
				result.put(TagResidence.TAG_22, tlv);
			} else if (TagResidence.TAG_23.codeEquals(t)) {
				result.put(TagResidence.TAG_23, tlv);
			} else if (TagResidence.TAG_24.codeEquals(t)) {
				result.put(TagResidence.TAG_24, tlv);
			} else if (TagResidence.TAG_2A.codeEquals(t)) {
				result.put(TagResidence.TAG_2A, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}

		return result;
	}
}
