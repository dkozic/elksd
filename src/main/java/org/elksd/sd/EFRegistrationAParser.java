package org.elksd.sd;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.elksd.tlv.BERParser;
import org.elksd.tlv.TLV;
import org.elksd.util.Util;

public class EFRegistrationAParser {

	private static Logger log = Logger.getLogger(EFRegistrationAParser.class);

	public String getTagAsHexString(byte[] tag) {
		return Util.bytesToHex(tag);
	}

	private void logUnknownTag(TLV tlv, byte[] bytes) {
		log.warn("Unknown tag: " + tlv.toString() + " bytes: "
				+ Util.bytesToHex(bytes));
	}

	private Map<TagA, TLV> parseA2(byte[] bytes) {
		Map<TagA, TLV> result = new HashMap<TagA, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagA.TAG_A2_83.codeEquals(t)) {
				result.put(TagA.TAG_A2_83, tlv);
			} else if (TagA.TAG_A2_84.codeEquals(t)) {
				result.put(TagA.TAG_A2_84, tlv);
			} else if (TagA.TAG_A2_85.codeEquals(t)) {
				result.put(TagA.TAG_A2_85, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	private Map<TagA, TLV> parseA1(byte[] bytes) {
		Map<TagA, TLV> result = new HashMap<TagA, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagA.TAG_A2.codeEquals(t)) {
				Map<TagA, TLV> a2 = parseA2(tlv.getValue());
				result.putAll(a2);
			} else if (TagA.TAG_86.codeEquals(t)) {
				result.put(TagA.TAG_86, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	private Map<TagA, TLV> parseA3(byte[] bytes) {
		Map<TagA, TLV> result = new HashMap<TagA, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagA.TAG_87.codeEquals(t)) {
				result.put(TagA.TAG_87, tlv);
			} else if (TagA.TAG_88.codeEquals(t)) {
				result.put(TagA.TAG_88, tlv);
			} else if (TagA.TAG_89.codeEquals(t)) {
				result.put(TagA.TAG_89, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	private Map<TagA, TLV> parseA4(byte[] bytes) {
		Map<TagA, TLV> result = new HashMap<TagA, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagA.TAG_8B.codeEquals(t)) {
				result.put(TagA.TAG_8B, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	private Map<TagA, TLV> parseA5(byte[] bytes) {
		Map<TagA, TLV> result = new HashMap<TagA, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagA.TAG_90.codeEquals(t)) {
				result.put(TagA.TAG_90, tlv);
			} else if (TagA.TAG_91.codeEquals(t)) {
				result.put(TagA.TAG_91, tlv);
			} else if (TagA.TAG_92.codeEquals(t)) {
				result.put(TagA.TAG_92, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	private Map<TagA, TLV> parseA6(byte[] bytes) {
		Map<TagA, TLV> result = new HashMap<TagA, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagA.TAG_94.codeEquals(t)) {
				result.put(TagA.TAG_94, tlv);
			} else if (TagA.TAG_95.codeEquals(t)) {
				result.put(TagA.TAG_95, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	private Map<TagA, TLV> parse78(byte[] bytes) {
		Map<TagA, TLV> result = new HashMap<TagA, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagA.TAG_4F.codeEquals(t)) {
				result.put(TagA.TAG_4F, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	private Map<TagA, TLV> parse71(byte[] bytes) {
		Map<TagA, TLV> result = new HashMap<TagA, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagA.TAG_80.codeEquals(t)) {
				result.put(TagA.TAG_80, tlv);
			} else if (TagA.TAG_9F33.codeEquals(t)) {
				result.put(TagA.TAG_9F33, tlv);
			} else if (TagA.TAG_9F34.codeEquals(t)) {
				result.put(TagA.TAG_9F34, tlv);
			} else if (TagA.TAG_9F35.codeEquals(t)) {
				result.put(TagA.TAG_9F35, tlv);
			} else if (TagA.TAG_9F36.codeEquals(t)) {
				result.put(TagA.TAG_9F36, tlv);
			} else if (TagA.TAG_9F37.codeEquals(t)) {
				result.put(TagA.TAG_9F37, tlv);
			} else if (TagA.TAG_9F38.codeEquals(t)) {
				result.put(TagA.TAG_9F38, tlv);
			} else if (TagA.TAG_81.codeEquals(t)) {
				result.put(TagA.TAG_81, tlv);
			} else if (TagA.TAG_82.codeEquals(t)) {
				result.put(TagA.TAG_82, tlv);
			} else if (TagA.TAG_A1.codeEquals(t)) {
				Map<TagA, TLV> a1 = parseA1(tlv.getValue());
				result.putAll(a1);
			} else if (TagA.TAG_A3.codeEquals(t)) {
				Map<TagA, TLV> a3 = parseA3(tlv.getValue());
				result.putAll(a3);
			} else if (TagA.TAG_8A.codeEquals(t)) {
				result.put(TagA.TAG_8A, tlv);
			} else if (TagA.TAG_A4.codeEquals(t)) {
				Map<TagA, TLV> a4 = parseA4(tlv.getValue());
				result.putAll(a4);
			} else if (TagA.TAG_8C.codeEquals(t)) {
				result.put(TagA.TAG_8C, tlv);
			} else if (TagA.TAG_8D.codeEquals(t)) {
				result.put(TagA.TAG_8D, tlv);
			} else if (TagA.TAG_8E.codeEquals(t)) {
				result.put(TagA.TAG_8E, tlv);
			} else if (TagA.TAG_8F.codeEquals(t)) {
				result.put(TagA.TAG_8F, tlv);
			} else if (TagA.TAG_A5.codeEquals(t)) {
				Map<TagA, TLV> a5 = parseA5(tlv.getValue());
				result.putAll(a5);
			} else if (TagA.TAG_93.codeEquals(t)) {
				result.put(TagA.TAG_93, tlv);
			} else if (TagA.TAG_A6.codeEquals(t)) {
				Map<TagA, TLV> a6 = parseA6(tlv.getValue());
				result.putAll(a6);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	public Map<TagA, TLV> parseFile(byte[] bytes)
			throws UnsupportedEncodingException {
		Map<TagA, TLV> result = new HashMap<TagA, TLV>();

		BERParser bp = new BERParser(bytes);
		for (int i = 0; i < 2; i++) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagA.TAG_78.codeEquals(t)) {
				Map<TagA, TLV> r78 = parse78(tlv.getValue());
				result.putAll(r78);
			} else if (TagA.TAG_71.codeEquals(t)) {
				Map<TagA, TLV> r71 = parse71(tlv.getValue());
				result.putAll(r71);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}

		return result;
	}
}
