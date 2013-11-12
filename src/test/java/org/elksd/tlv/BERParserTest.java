package org.elksd.tlv;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class BERParserTest {

	@Test
	public void test() {

		byte[] bytes1 = new byte[] { (byte) 0x62, (byte) 0x16, (byte) 0x80,
				(byte) 0x02, (byte) 0x0B, (byte) 0xB8, (byte) 0x82,
				(byte) 0x01, (byte) 0x01, (byte) 0x83, (byte) 0x02,
				(byte) 0xD0, (byte) 0x01, (byte) 0x88, (byte) 0x00,
				(byte) 0xA1, (byte) 0x04, (byte) 0x8C, (byte) 0x02,
				(byte) 0x01, (byte) 0x00, (byte) 0x8A, (byte) 0x01, (byte) 0x05 };

		BERParser bp1 = new BERParser(bytes1);
		TLV tlv1 = bp1.parseTLV();
		assertArrayEquals("Tag", new byte[] { 0x62 }, tlv1.getTag());
		assertEquals("Length", 22, tlv1.getLength());

		assertFalse("Next", bp1.hasNext());

		byte[] bytes2 = tlv1.getValue();
		BERParser bp2 = new BERParser(bytes2);
		TLV tlv2 = bp2.parseTLV();
		assertArrayEquals("Tag", new byte[] { (byte) 0x80 }, tlv2.getTag());
		assertEquals("Length", 2, tlv2.getLength());
		assertArrayEquals("Value", new byte[] { (byte) 0x0B, (byte) 0xB8 },
				tlv2.getValue());

		TLV tlv3 = bp2.parseTLV();
		assertArrayEquals("Tag", new byte[] { (byte) 0x82 }, tlv3.getTag());
		assertEquals("Length", 1, tlv3.getLength());
		assertArrayEquals("Value", new byte[] { (byte) 0x01 }, tlv3.getValue());

		TLV tlv4 = bp2.parseTLV();
		assertArrayEquals("Tag", new byte[] { (byte) 0x83 }, tlv4.getTag());
		assertEquals("Length", 2, tlv4.getLength());
		assertArrayEquals("Value", new byte[] { (byte) 0xD0, (byte) 0x01 },
				tlv4.getValue());

		TLV tlv5 = bp2.parseTLV();
		assertArrayEquals("Tag", new byte[] { (byte) 0x88 }, tlv5.getTag());
		assertEquals("Length", 0, tlv5.getLength());
		assertArrayEquals("Value", new byte[] {}, tlv5.getValue());

		TLV tlv6 = bp2.parseTLV();
		assertArrayEquals("Tag", new byte[] { (byte) 0xA1 }, tlv6.getTag());
		assertEquals("Length", 4, tlv6.getLength());
		assertArrayEquals("Value", new byte[] { (byte) 0x8C, (byte) 0x02,
				(byte) 0x01, (byte) 0x00 }, tlv6.getValue());

		TLV tlv7 = bp2.parseTLV();
		assertArrayEquals("Tag", new byte[] { (byte) 0x8A }, tlv7.getTag());
		assertEquals("Length", 1, tlv7.getLength());
		assertArrayEquals("Value", new byte[] { (byte) 0x05 }, tlv7.getValue());

		assertFalse("Next", bp2.hasNext());
	}

}
