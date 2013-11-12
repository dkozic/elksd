package org.elksd.lk;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.elksd.tlv.BERParser;
import org.elksd.tlv.TLV;
import org.elksd.util.Util;

public class EFDocumentParser {

	private static Logger log = Logger.getLogger(EFDocumentParser.class);

	public String getTagAsHexString(byte[] tag) {
		return Util.bytesToHex(tag);
	}

	private void logUnknownTag(TLV tlv, byte[] bytes) {
		log.warn("Unknown tag: " + tlv.toString() + " bytes: "
				+ Util.bytesToHex(bytes));
	}

	public Map<TagDocument, TLV> parseFile(byte[] bytes)
			throws UnsupportedEncodingException {
		Map<TagDocument, TLV> result = new HashMap<TagDocument, TLV>();

		BERParser bp = new BERParser(bytes, true, true);
		for (int i = 0; i < 10; i++) {
			TLV tlv = bp.parseTLV();
			String t = getTagAsHexString(tlv.getTag());
			if (TagDocument.TAG_0D.codeEquals(t)) {
				result.put(TagDocument.TAG_0D, tlv);
			} else if (TagDocument.TAG_0A.codeEquals(t)) {
				result.put(TagDocument.TAG_0A, tlv);
			} else if (TagDocument.TAG_0B.codeEquals(t)) {
				result.put(TagDocument.TAG_0B, tlv);
			} else if (TagDocument.TAG_0C.codeEquals(t)) {
				result.put(TagDocument.TAG_0C, tlv);
			} else if (TagDocument.TAG_0D.codeEquals(t)) {
				result.put(TagDocument.TAG_0D, tlv);
			} else if (TagDocument.TAG_0E.codeEquals(t)) {
				result.put(TagDocument.TAG_0E, tlv);
			} else if (TagDocument.TAG_0F.codeEquals(t)) {
				result.put(TagDocument.TAG_0F, tlv);
			} else if (TagDocument.TAG_09.codeEquals(t)) {
				result.put(TagDocument.TAG_09, tlv);
			} else if (TagDocument.TAG_10.codeEquals(t)) {
				result.put(TagDocument.TAG_10, tlv);
			} else if (TagDocument.TAG_11.codeEquals(t)) {
				result.put(TagDocument.TAG_11, tlv);
			} else {
				logUnknownTag(tlv, bytes);
			}
		}

		return result;
	}
}
