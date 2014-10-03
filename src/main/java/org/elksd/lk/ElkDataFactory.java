package org.elksd.lk;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.elksd.tlv.TLV;
import org.elksd.util.Util;

public class ElkDataFactory {

	private Map<TagDocument, TLV> fieldsDocument;
	private Map<TagPersonal, TLV> fieldsPersonal;
	private Map<TagResidence, TLV> fieldsResidence;
	private byte[] portrait;

	public ElkDataFactory(Map<TagDocument, TLV> fieldsDocument,
			Map<TagPersonal, TLV> fieldsPersonal,
			Map<TagResidence, TLV> fieldsResidence, byte[] portrait) {
		this.fieldsDocument = fieldsDocument;
		this.fieldsPersonal = fieldsPersonal;
		this.fieldsResidence = fieldsResidence;
		this.portrait = portrait;
	}

	private String getDocument(TagDocument tag) {
		if (tag == null) {
			return null;
		}
		if (fieldsDocument == null) {
			return null;
		}
		if (fieldsDocument.containsKey(tag)) {
			TLV tlv = fieldsDocument.get(tag);
			return tag.getTagCharset().bytesToCharsetString(tlv.getValue());
		} else {
			return null;
		}
	}

	private String getPersonal(TagPersonal tag) {
		if (tag == null) {
			return null;
		}
		if (fieldsPersonal == null) {
			return null;
		}
		if (fieldsPersonal.containsKey(tag)) {
			TLV tlv = fieldsPersonal.get(tag);
			return tag.getTagCharset().bytesToCharsetString(tlv.getValue());
		} else {
			return null;
		}
	}

	private String getResidence(TagResidence tag) {
		if (tag == null) {
			return null;
		}
		if (fieldsResidence == null) {
			return null;
		}
		if (fieldsResidence.containsKey(tag)) {
			TLV tlv = fieldsResidence.get(tag);
			return tag.getTagCharset().bytesToCharsetString(tlv.getValue());
		} else {
			return null;
		}
	}

	// Document data
	private String getDocRegNo() {
		return getDocument(TagDocument.TAG_0A);
	}

	private String getIssuingDate() {
		return getDocument(TagDocument.TAG_0D);
	}

	private String getExpiryDate() {
		return getDocument(TagDocument.TAG_0E);
	}

	private String getIssuingAuthority() {
		return getDocument(TagDocument.TAG_0F);
	}

	// personal data
	private String getPersonalNumber() {
		return getPersonal(TagPersonal.TAG_16);
	}

	private String getSurname() {
		return getPersonal(TagPersonal.TAG_17);
	}

	private String getGivenName() {
		return getPersonal(TagPersonal.TAG_18);
	}

	private String getParentGivenName() {
		return getPersonal(TagPersonal.TAG_19);
	}

	private String getSex() {
		return getPersonal(TagPersonal.TAG_1A);
	}

	private String getPlaceOfBirth() {
		return getPersonal(TagPersonal.TAG_1B);
	}

	private String getStateOfBirth() {
		return getPersonal(TagPersonal.TAG_1D);
	}

	private String getDateOfBirth() {
		return getPersonal(TagPersonal.TAG_1E);
	}

	// residence data
	private String getState() {
		return getResidence(TagResidence.TAG_20);
	}

	private String getComunity() {
		return getResidence(TagResidence.TAG_21);
	}

	private String getPlace() {
		return getResidence(TagResidence.TAG_22);
	}

	private String getStreet() {
		return getResidence(TagResidence.TAG_23);
	}

	private String getHouseNumber() {
		return getResidence(TagResidence.TAG_24);
	}

	private String getApartmentNumber() {
		return getResidence(TagResidence.TAG_2A);
	}

	@Override
	public String toString() {
		ToStringBuilder tsb = new ToStringBuilder(this,
				ToStringStyle.MULTI_LINE_STYLE);
		tsb.append("EF_Document");
		for (Map.Entry<TagDocument, TLV> field : fieldsDocument.entrySet()) {
			TagDocument tag = field.getKey();
			TLV tlv = field.getValue();
			tsb.append(String.format("%s: %s", tag.toString(), tag
					.getTagCharset().bytesToCharsetString(tlv.getValue())));
		}
		tsb.append("EF_Personal");
		for (Map.Entry<TagPersonal, TLV> field : fieldsPersonal.entrySet()) {
			TagPersonal tag = field.getKey();
			TLV tlv = field.getValue();
			tsb.append(String.format("%s: %s", tag.toString(), tag
					.getTagCharset().bytesToCharsetString(tlv.getValue())));
		}
		tsb.append("EF_Residence");
		for (Map.Entry<TagResidence, TLV> field : fieldsResidence.entrySet()) {
			TagResidence tag = field.getKey();
			TLV tlv = field.getValue();
			tsb.append(String.format("%s: %s", tag.toString(), tag
					.getTagCharset().bytesToCharsetString(tlv.getValue())));
		}

		tsb.append("EF_Portrait");
		tsb.append(Util.bytesToHex(portrait));

		return tsb.toString();

	}

	public ElkData create() {
		return new ElkData.Builder().docRegNo(getDocRegNo())
				.issuingDate(getIssuingDate()).expiryDate(getExpiryDate())
				.issuingAuthority(getIssuingAuthority())
				.personalNumber(getPersonalNumber()).surname(getSurname())
				.givenName(getGivenName())
				.parentGivenName(getParentGivenName()).sex(getSex())
				.placeOfBirth(getPlaceOfBirth())
				.stateOfBirth(getStateOfBirth()).dateOfBirth(getDateOfBirth())
				.state(getState()).community(getComunity()).place(getPlace())
				.street(getStreet()).houseNumber(getHouseNumber())
				.apartmentNumber(getApartmentNumber()).portrait(portrait)
				.build();
	}

}
