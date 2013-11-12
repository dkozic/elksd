package org.elksd.sd;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.elksd.tlv.BERParser;
import org.elksd.tlv.TLV;
import org.elksd.util.Util;

public class EFRegistrationBParser {

	private static Logger log = Logger.getLogger(EFRegistrationBParser.class);

	public String getTagAsHexString(byte[] tag) {
		return Util.bytesToHex(tag);
	}
	
	private void logUnknownTag(TLV tlv, byte[] bytes) {
		log.warn("Unknown tag: " + tlv.toString() + " bytes: "
				+ Util.bytesToHex(bytes));
	}

	private Map<TagB, TLV> parseA7(byte[] bytes) {
		Map<TagB, TLV> result = new HashMap<TagB, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagB.TAG_A7_83.codeEquals(t)) {
				result.put(TagB.TAG_A7_83, tlv);
			} else if (TagB.TAG_A7_84.codeEquals(t)) {
				result.put(TagB.TAG_A7_84, tlv);
			} else if (TagB.TAG_A7_85.codeEquals(t)) {
				result.put(TagB.TAG_A7_85, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	private Map<TagB, TLV> parseA8(byte[] bytes) {
		Map<TagB, TLV> result = new HashMap<TagB, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagB.TAG_A8_83.codeEquals(t)) {
				result.put(TagB.TAG_A8_83, tlv);
			} else if (TagB.TAG_A8_84.codeEquals(t)) {
				result.put(TagB.TAG_A8_84, tlv);
			} else if (TagB.TAG_A8_85.codeEquals(t)) {
				result.put(TagB.TAG_A8_85, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	private Map<TagB, TLV> parseA9(byte[] bytes) {
		Map<TagB, TLV> result = new HashMap<TagB, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagB.TAG_A9_83.codeEquals(t)) {
				result.put(TagB.TAG_A9_83, tlv);
			} else if (TagB.TAG_A9_84.codeEquals(t)) {
				result.put(TagB.TAG_A9_84, tlv);
			} else if (TagB.TAG_A9_85.codeEquals(t)) {
				result.put(TagB.TAG_A9_85, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	private Map<TagB, TLV> parseA1(byte[] bytes) {
		Map<TagB, TLV> result = new HashMap<TagB, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagB.TAG_A7.codeEquals(t)) {
				Map<TagB, TLV> a7 = parseA7(tlv.getValue());
				result.putAll(a7);
			} else if (TagB.TAG_A8.codeEquals(t)) {
				Map<TagB, TLV> a8 = parseA8(tlv.getValue());
				result.putAll(a8);
			} else if (TagB.TAG_A9.codeEquals(t)) {
				Map<TagB, TLV> a9 = parseA9(tlv.getValue());
				result.putAll(a9);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	private Map<TagB, TLV> parseA4(byte[] bytes) {
		Map<TagB, TLV> result = new HashMap<TagB, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagB.TAG_96.codeEquals(t)) {
				result.put(TagB.TAG_96, tlv);
			} else if (TagB.TAG_97.codeEquals(t)) {
				result.put(TagB.TAG_97, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	private Map<TagB, TLV> parseAD(byte[] bytes) {
		Map<TagB, TLV> result = new HashMap<TagB, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagB.TAG_9F1F.codeEquals(t)) {
				result.put(TagB.TAG_9F1F, tlv);
			} else if (TagB.TAG_9F20.codeEquals(t)) {
				result.put(TagB.TAG_9F20, tlv);
			} else if (TagB.TAG_9F21.codeEquals(t)) {
				result.put(TagB.TAG_9F21, tlv);
			} else if (TagB.TAG_9F22.codeEquals(t)) {
				result.put(TagB.TAG_9F22, tlv);
			} else if (TagB.TAG_9F23.codeEquals(t)) {
				result.put(TagB.TAG_9F23, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	private Map<TagB, TLV> parseAE(byte[] bytes) {
		Map<TagB, TLV> result = new HashMap<TagB, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagB.TAG_9B.codeEquals(t)) {
				result.put(TagB.TAG_9B, tlv);
			} else if (TagB.TAG_9C.codeEquals(t)) {
				result.put(TagB.TAG_9C, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	private Map<TagB, TLV> parseA5(byte[] bytes) {
		Map<TagB, TLV> result = new HashMap<TagB, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagB.TAG_9D.codeEquals(t)) {
				result.put(TagB.TAG_9D, tlv);
			} else if (TagB.TAG_9E.codeEquals(t)) {
				result.put(TagB.TAG_9E, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	private Map<TagB, TLV> parseAF(byte[] bytes) {
		Map<TagB, TLV> result = new HashMap<TagB, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagB.TAG_9F26.codeEquals(t)) {
				result.put(TagB.TAG_9F26, tlv);
			} else if (TagB.TAG_9F27.codeEquals(t)) {
				result.put(TagB.TAG_9F27, tlv);
			} else if (TagB.TAG_9F28.codeEquals(t)) {
				result.put(TagB.TAG_9F28, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	private Map<TagB, TLV> parseB0(byte[] bytes) {
		Map<TagB, TLV> result = new HashMap<TagB, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagB.TAG_9F29.codeEquals(t)) {
				result.put(TagB.TAG_9F29, tlv);
			} else if (TagB.TAG_9F2A.codeEquals(t)) {
				result.put(TagB.TAG_9F2A, tlv);
			} else if (TagB.TAG_9F2B.codeEquals(t)) {
				result.put(TagB.TAG_9F2B, tlv);
			} else if (TagB.TAG_9F2C.codeEquals(t)) {
				result.put(TagB.TAG_9F2C, tlv);
			} else if (TagB.TAG_9F2D.codeEquals(t)) {
				result.put(TagB.TAG_9F2D, tlv);
			} else if (TagB.TAG_9F2E.codeEquals(t)) {
				result.put(TagB.TAG_9F2E, tlv);
			} else if (TagB.TAG_9F2F.codeEquals(t)) {
				result.put(TagB.TAG_9F2F, tlv);
			} else if (TagB.TAG_9F30.codeEquals(t)) {
				result.put(TagB.TAG_9F30, tlv);
			} else if (TagB.TAG_9F31.codeEquals(t)) {
				result.put(TagB.TAG_9F31, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	private Map<TagB, TLV> parse78(byte[] bytes) {
		Map<TagB, TLV> result = new HashMap<TagB, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagB.TAG_4F.codeEquals(t)) {
				result.put(TagB.TAG_4F, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	private Map<TagB, TLV> parse72(byte[] bytes) {
		Map<TagB, TLV> result = new HashMap<TagB, TLV>();
		BERParser bp = new BERParser(bytes);
		while (bp.hasNext()) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagB.TAG_80.codeEquals(t)) {
				result.put(TagB.TAG_80, tlv);
			} else if (t.equals(TagB.TAG_A1)) {
				Map<TagB, TLV> a1 = parseA1(tlv.getValue());
				result.putAll(a1);
			} else if (TagB.TAG_A4.codeEquals(t)) {
				Map<TagB, TLV> a4 = parseA4(tlv.getValue());
				result.putAll(a4);
			} else if (TagB.TAG_98.codeEquals(t)) {
				result.put(TagB.TAG_98, tlv);
			} else if (TagB.TAG_99.codeEquals(t)) {
				result.put(TagB.TAG_99, tlv);
			} else if (TagB.TAG_9A.codeEquals(t)) {
				result.put(TagB.TAG_9A, tlv);
			} else if (TagB.TAG_AD.codeEquals(t)) {
				Map<TagB, TLV> ad = parseAD(tlv.getValue());
				result.putAll(ad);
			} else if (TagB.TAG_AE.codeEquals(t)) {
				Map<TagB, TLV> ae = parseAE(tlv.getValue());
				result.putAll(ae);
			} else if (TagB.TAG_A5.codeEquals(t)) {
				Map<TagB, TLV> a5 = parseA5(tlv.getValue());
				result.putAll(a5);
			} else if (TagB.TAG_9F24.codeEquals(t)) {
				result.put(TagB.TAG_9F24, tlv);
			} else if (TagB.TAG_9F25.codeEquals(t)) {
				result.put(TagB.TAG_9F25, tlv);
			} else if (TagB.TAG_AF.codeEquals(t)) {
				Map<TagB, TLV> af = parseAF(tlv.getValue());
				result.putAll(af);
			} else if (TagB.TAG_B0.codeEquals(t)) {
				Map<TagB, TLV> b0 = parseB0(tlv.getValue());
				result.putAll(b0);
			} else if (TagB.TAG_9F32.codeEquals(t)) {
				result.put(TagB.TAG_9F32, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}
		return result;
	}

	public Map<TagB, TLV> parseFile(byte[] bytes)
			throws UnsupportedEncodingException {
		Map<TagB, TLV> result = new HashMap<TagB, TLV>();

		BERParser bp = new BERParser(bytes);
		for (int i = 0; i < 2; i++) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagB.TAG_78.codeEquals(t)) {
				Map<TagB, TLV> r78 = parse78(tlv.getValue());
				result.putAll(r78);
			} else if (TagB.TAG_72.codeEquals(t)) {
				Map<TagB, TLV> r72 = parse72(tlv.getValue());
				result.putAll(r72);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}

		return result;
	}
}
