package org.elksd.lk;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.elksd.tlv.BERParser;
import org.elksd.tlv.TLV;
import org.elksd.util.Util;

public class EFPersonalParser {

	private static Logger log = Logger.getLogger(EFPersonalParser.class);

	public String getTagAsHexString(byte[] tag) {
		return Util.bytesToHex(tag);
	}

	private void logUnknownTag(TLV tlv, byte[] bytes) {
		log.warn("Unknown tag: " + tlv.toString() + " bytes: "
				+ Util.bytesToHex(bytes));
	}

	public Map<TagPersonal, TLV> parseFile(byte[] bytes)
			throws UnsupportedEncodingException {
		Map<TagPersonal, TLV> result = new HashMap<TagPersonal, TLV>();

		BERParser bp = new BERParser(bytes, true, true);
		for (int i = 0; i < 10; i++) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagPersonal.TAG_0D.codeEquals(t)) {
				result.put(TagPersonal.TAG_0D, tlv);
			} else if (TagPersonal.TAG_16.codeEquals(t)) {
				result.put(TagPersonal.TAG_16, tlv);
			} else if (TagPersonal.TAG_17.codeEquals(t)) {
				result.put(TagPersonal.TAG_17, tlv);
			} else if (TagPersonal.TAG_18.codeEquals(t)) {
				result.put(TagPersonal.TAG_18, tlv);
			} else if (TagPersonal.TAG_19.codeEquals(t)) {
				result.put(TagPersonal.TAG_19, tlv);
			} else if (TagPersonal.TAG_1A.codeEquals(t)) {
				result.put(TagPersonal.TAG_1A, tlv);
			} else if (TagPersonal.TAG_1B.codeEquals(t)) {
				result.put(TagPersonal.TAG_1B, tlv);
			} else if (TagPersonal.TAG_1D.codeEquals(t)) {
				result.put(TagPersonal.TAG_1D, tlv);
			} else if (TagPersonal.TAG_1E.codeEquals(t)) {
				result.put(TagPersonal.TAG_1E, tlv);
			} else if (TagPersonal.TAG_1F06.codeEquals(t)) {
				result.put(TagPersonal.TAG_1F06, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}

		return result;
	}
}
