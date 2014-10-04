package org.elksd.lk;

import java.io.ByteArrayOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "ElkData", namespace = "http://www.elksd.org/lk/")
public class ElkData {

	public ElkData() {
	}

	public static class Builder {

		// Document data
		private String docRegNo;
		private String issuingDate;
		private String expiryDate;
		private String issuingAuthority;

		// Fixed personal data
		private String personalNumber;
		private String surname;
		private String givenName;
		private String parentGivenName;
		private String sex;
		private String placeOfBirth;
		private String stateOfBirth;
		private String dateOfBirth;
		private String communityOfBirth;

		// Variable personal data
		private String state;
		private String community;
		private String place;
		private String street;
		private String houseNumber;
		private String houseLetter;
		private String entrance;
		private String floor;
		private String apartmentNumber;

		// Portrait
		private byte[] portrait;

		public Builder docRegNo(String docRegNo) {
			this.docRegNo = docRegNo;
			return this;
		}

		public Builder issuingDate(String issuingDate) {
			this.issuingDate = issuingDate;
			return this;
		}

		public Builder expiryDate(String expiryDate) {
			this.expiryDate = expiryDate;
			return this;
		}

		public Builder issuingAuthority(String issuingAuthority) {
			this.issuingAuthority = issuingAuthority;
			return this;
		}

		public Builder personalNumber(String personalNumber) {
			this.personalNumber = personalNumber;
			return this;
		}

		public Builder surname(String surname) {
			this.surname = surname;
			return this;
		}

		public Builder givenName(String givenName) {
			this.givenName = givenName;
			return this;
		}

		public Builder parentGivenName(String parentGivenName) {
			this.parentGivenName = parentGivenName;
			return this;
		}

		public Builder sex(String sex) {
			this.sex = sex;
			return this;
		}

		public Builder placeOfBirth(String placeOfBirth) {
			this.placeOfBirth = placeOfBirth;
			return this;
		}

		public Builder stateOfBirth(String stateOfBirth) {
			this.stateOfBirth = stateOfBirth;
			return this;
		}

		public Builder dateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			return this;
		}

		public Builder communityOfBirth(String communityOfBirth) {
			this.communityOfBirth = communityOfBirth;
			return this;
		}

		public Builder state(String state) {
			this.state = state;
			return this;
		}

		public Builder community(String community) {
			this.community = community;
			return this;
		}

		public Builder place(String place) {
			this.place = place;
			return this;
		}

		public Builder street(String street) {
			this.street = street;
			return this;
		}

		public Builder houseNumber(String houseNumber) {
			this.houseNumber = houseNumber;
			return this;
		}

		public Builder houseLetter(String houseLetter) {
			this.houseLetter = houseLetter;
			return this;
		}

		public Builder entrance(String entrance) {
			this.entrance = entrance;
			return this;
		}

		public Builder floor(String floor) {
			this.floor = floor;
			return this;
		}

		public Builder apartmentNumber(String apartmentNumber) {
			this.apartmentNumber = apartmentNumber;
			return this;
		}

		public Builder portrait(byte[] portrait) {
			this.portrait = portrait;
			return this;
		}

		public ElkData build() {
			return new ElkData(this);
		}

	}

	// Document data
	private String docRegNo;
	private String issuingDate;
	private String expiryDate;
	private String issuingAuthority;

	// Fixed personal data
	private String personalNumber;
	private String surname;
	private String givenName;
	private String parentGivenName;
	private String sex;
	private String placeOfBirth;
	private String stateOfBirth;
	private String dateOfBirth;
	private String communityOfBirth;

	// Variable personal data
	private String state;
	private String community;
	private String place;
	private String street;
	private String houseNumber;
	private String houseLetter;
	private String entrance;
	private String floor;
	private String apartmentNumber;

	// Portrait
	private byte[] portrait;

	public String getDocRegNo() {
		return docRegNo;
	}

	public String getIssuingDate() {
		return issuingDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public String getIssuingAuthority() {
		return issuingAuthority;
	}

	public String getPersonalNumber() {
		return personalNumber;
	}

	public String getSurname() {
		return surname;
	}

	public String getGivenName() {
		return givenName;
	}

	public String getParentGivenName() {
		return parentGivenName;
	}

	public String getSex() {
		return sex;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public String getStateOfBirth() {
		return stateOfBirth;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getCommunityOfBirth() {
		return communityOfBirth;
	}

	public String getState() {
		return state;
	}

	public String getCommunity() {
		return community;
	}

	public String getPlace() {
		return place;
	}

	public String getStreet() {
		return street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public String getHouseLetter() {
		return houseLetter;
	}

	public String getEntrance() {
		return entrance;
	}

	public String getFloor() {
		return floor;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public byte[] getPortrait() {
		return portrait;
	}

	private ElkData(Builder b) {

		// Document data
		this.docRegNo = b.docRegNo;
		this.issuingDate = b.issuingDate;
		this.expiryDate = b.expiryDate;
		this.issuingAuthority = b.issuingAuthority;

		// Fixed personal data
		this.personalNumber = b.personalNumber;
		this.surname = b.surname;
		this.givenName = b.givenName;
		this.parentGivenName = b.parentGivenName;
		this.sex = b.sex;
		this.placeOfBirth = b.placeOfBirth;
		this.stateOfBirth = b.stateOfBirth;
		this.dateOfBirth = b.dateOfBirth;
		this.communityOfBirth = b.communityOfBirth;

		// Variable personal data
		this.state = b.state;
		this.community = b.community;
		this.place = b.place;
		this.street = b.street;
		this.houseNumber = b.houseNumber;
		this.houseLetter = b.houseLetter;
		this.entrance = b.entrance;
		this.floor = b.floor;
		this.apartmentNumber = b.apartmentNumber;

		// Portrait
		this.portrait = b.portrait;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public byte[] toXMLByteArray() throws Exception {
		JAXBContext context;

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		context = JAXBContext.newInstance(this.getClass());
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(this, outStream);
		return outStream.toByteArray();

	}

}
