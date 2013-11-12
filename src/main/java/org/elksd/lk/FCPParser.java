package org.elksd.lk;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.elksd.tlv.BERParser;
import org.elksd.tlv.TLV;
import org.elksd.util.Util;

public class FCPParser {

	private static Logger log = Logger.getLogger(FCPParser.class);

	public String getTagAsHexString(byte[] tag) {
		return Util.bytesToHex(tag);
	}

	private void logUnknownTag(TLV tlv, byte[] bytes) {
		log.warn("Unknown tag: " + tlv.toString() + " bytes: "
				+ Util.bytesToHex(bytes));
	}

	private Map<TagFCP, TLV> parse62(byte[] bytes) {
		Map<TagFCP, TLV> result = new HashMap<TagFCP, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagFCP.TAG_80.codeEquals(t)) {
				result.put(TagFCP.TAG_80, tlv);
			} else if (TagFCP.TAG_81.codeEquals(t)) {
				result.put(TagFCP.TAG_81, tlv);
			} else if (TagFCP.TAG_82.codeEquals(t)) {
				result.put(TagFCP.TAG_82, tlv);
			} else if (TagFCP.TAG_83.codeEquals(t)) {
				result.put(TagFCP.TAG_83, tlv);
			} else if (TagFCP.TAG_84.codeEquals(t)) {
				result.put(TagFCP.TAG_84, tlv);
			} else if (TagFCP.TAG_85.codeEquals(t)) {
				result.put(TagFCP.TAG_85, tlv);
			} else if (TagFCP.TAG_86.codeEquals(t)) {
				result.put(TagFCP.TAG_86, tlv);
			} else if (TagFCP.TAG_87.codeEquals(t)) {
				result.put(TagFCP.TAG_87, tlv);
			} else if (TagFCP.TAG_88.codeEquals(t)) {
				result.put(TagFCP.TAG_88, tlv);
			} else if (TagFCP.TAG_8A.codeEquals(t)) {
				result.put(TagFCP.TAG_8A, tlv);
			} else if (TagFCP.TAG_8B.codeEquals(t)) {
				result.put(TagFCP.TAG_8B, tlv);
			} else if (TagFCP.TAG_8C.codeEquals(t)) {
				result.put(TagFCP.TAG_8C, tlv);
			} else if (TagFCP.TAG_8D.codeEquals(t)) {
				result.put(TagFCP.TAG_8D, tlv);
			} else if (TagFCP.TAG_8E.codeEquals(t)) {
				result.put(TagFCP.TAG_8E, tlv);
			} else if (TagFCP.TAG_A0.codeEquals(t)) {
				result.put(TagFCP.TAG_A0, tlv);
			} else if (TagFCP.TAG_A1.codeEquals(t)) {
				result.put(TagFCP.TAG_A1, tlv);
			} else if (TagFCP.TAG_A2.codeEquals(t)) {
				result.put(TagFCP.TAG_A2, tlv);
			} else if (TagFCP.TAG_A5.codeEquals(t)) {
				result.put(TagFCP.TAG_A5, tlv);
			} else if (TagFCP.TAG_AB.codeEquals(t)) {
				result.put(TagFCP.TAG_AB, tlv);
			} else if (TagFCP.TAG_AC.codeEquals(t)) {
				result.put(TagFCP.TAG_AC, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	public Map<TagFCP, TLV> parseFCP(byte[] bytes)
			throws UnsupportedEncodingException {
		Map<TagFCP, TLV> result = new HashMap<TagFCP, TLV>();

		BERParser bp = new BERParser(bytes);
		TLV tlv = bp.parseTLV();
		String t = getTagAsHexString(tlv.getTag());
		if (TagFCP.TAG_62.codeEquals(t)) {
			Map<TagFCP, TLV> r62 = parse62(tlv.getValue());
			result.putAll(r62);
		} else {
			logUnknownTag(tlv, bytes);
		}

		return result;
	}
}
