package org.elksd.sd;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.elksd.tlv.TLV;

public class EsdDataFactory {
	private Map<TagA, TLV> fieldsA;
	private Map<TagB, TLV> fieldsB;
	private Map<TagC, TLV> fieldsC;
	private Map<TagD, TLV> fieldsD;

	public EsdDataFactory(Map<TagA, TLV> fieldsA, Map<TagB, TLV> fieldsB,
			Map<TagC, TLV> fieldsC, Map<TagD, TLV> fieldsD) {
		this.fieldsA = fieldsA;
		this.fieldsB = fieldsB;
		this.fieldsC = fieldsC;
		this.fieldsD = fieldsD;
	}

	private String getA(TagA tag) {
		if (tag == null || fieldsA == null) {
			return null;
		}
		if (fieldsA.containsKey(tag)) {
			TLV tlv = fieldsA.get(tag);
			return tag.getTagCharset().bytesToCharsetString(tlv.getValue());
		} else {
			return null;
		}
	}

	private String getB(TagB tag) {
		if (tag == null || fieldsB == null) {
			return null;
		}
		if (fieldsB.containsKey(tag)) {
			TLV tlv = fieldsB.get(tag);
			return tag.getTagCharset().bytesToCharsetString(tlv.getValue());
		} else {
			return null;
		}
	}

	private String getC(TagC tag) {
		if (tag == null || fieldsC == null) {
			return null;
		}
		if (fieldsC.containsKey(tag)) {
			TLV tlv = fieldsC.get(tag);
			return tag.getTagCharset().bytesToCharsetString(tlv.getValue());
		} else {
			return null;
		}
	}

	private String getD(TagD tag) {
		if (tag == null || fieldsD == null) {
			return null;
		}
		if (fieldsD.containsKey(tag)) {
			TLV tlv = fieldsD.get(tag);
			return tag.getTagCharset().bytesToCharsetString(tlv.getValue());
		} else {
			return null;
		}
	}

	// SD_DOCUMENT_DATA
	private String getStateIssuing() {
		return getA(TagA.TAG_9F33);
	}

	private String getCompetentAuthority() {
		return getA(TagA.TAG_9F35);
	}

	private String getAuthorityIssuing() {
		return getA(TagA.TAG_9F36);
	}

	private String getUnambiguousNumber() {
		return getA(TagA.TAG_9F38);
	}

	private String getIssuingDate() {
		return getA(TagA.TAG_8E);
	}

	private String getExpiryDate() {
		return getA(TagA.TAG_8D);
	}

	private String getSerialNumber() {
		return getD(TagD.TAG_C9);
	}

	// SD_VEHICLE_DATA
	private String getDateOfFirstRegistration() {
		return getA(TagA.TAG_82);
	}

	private String getYearOfProduction() {
		return getC(TagC.TAG_C5);
	}

	private String getVehicleMake() {
		return getA(TagA.TAG_87);
	}

	private String getVehicleType() {
		return getA(TagA.TAG_88);
	}

	private String getCommercialDescription() {
		return getA(TagA.TAG_89);
	}

	private String getVehicleIDNumber() {
		return getA(TagA.TAG_8A);
	}

	private String getRegistrationNumberOfVehicle() {
		return getA(TagA.TAG_81);
	}

	private String getMaximumNetPower() {
		return getA(TagA.TAG_91);
	}

	private String getEngineCapacity() {
		return getA(TagA.TAG_90);
	}

	private String getTypeOfFuel() {
		return getA(TagA.TAG_92);
	}

	private String getPowerWeightRatio() {
		return getA(TagA.TAG_93);
	}

	private String getVehicleMass() {
		return getA(TagA.TAG_8C);
	}

	private String getMaximumPermissibleLadenMass() {
		return getA(TagA.TAG_8B);
	}

	private String getTypeApprovalNumber() {
		return getA(TagA.TAG_8F);
	}

	private String getNumberOfSeats() {
		return getA(TagA.TAG_94);
	}

	private String getNumberOfStandingPlaces() {
		return getA(TagA.TAG_95);
	}

	private String getEngineIDNumber() {
		return getB(TagB.TAG_9E);
	}

	private String getNumberOfAxles() {
		return getB(TagB.TAG_99);
	}

	private String getVehicleCategory() {
		return getB(TagB.TAG_98);
	}

	private String getColourOfVehicle() {
		return getB(TagB.TAG_9F24);
	}

	private String getRestrictionToChangeOwner() {
		return getC(TagC.TAG_C1);
	}

	private String getVehicleLoad() {
		return getC(TagC.TAG_C4);
	}

	// SD_PERSONAL_DATA
	private String getHolderSurnameOrBusinessName() {
		return getA(TagA.TAG_A2_83);
	}

	private String getHolderName() {
		return getA(TagA.TAG_A2_84);
	}

	private String getHolderAddress() {
		return getA(TagA.TAG_A2_85);
	}

	private String getOwnerPersonalNo() {
		return getC(TagC.TAG_C2);
	}

	private String getOwnerSurnameOrBusinessName() {
		return getB(TagB.TAG_A7_83);
	}

	private String getOwnerName() {
		return getB(TagB.TAG_A7_84);
	}

	private String getOwnerAddress() {
		return getB(TagB.TAG_A7_85);
	}

	private String getUserPersonalNo() {
		return getC(TagC.TAG_C3);
	}

	private String getUserSurnameOrBusinessName() {
		return getB(TagB.TAG_A9_83);
	}

	private String getUserName() {
		return getB(TagB.TAG_A9_84);
	}

	private String getUserAddress() {
		return getB(TagB.TAG_A9_85);
	}

	@Override
	public String toString() {
		ToStringBuilder tsb = new ToStringBuilder(this,
				ToStringStyle.MULTI_LINE_STYLE);
		tsb.append("EF.Registration_A");
		for (Map.Entry<TagA, TLV> field : fieldsA.entrySet()) {
			TagA tag = field.getKey();
			TLV tlv = field.getValue();
			tsb.append(String.format("%s: %s", tag.toString(), tag
					.getTagCharset().bytesToCharsetString(tlv.getValue())));
		}

		tsb.append("EF.Registration_B");
		for (Map.Entry<TagB, TLV> field : fieldsB.entrySet()) {
			TagB tag = field.getKey();
			TLV tlv = field.getValue();
			tsb.append(String.format("%s: %s", tag.toString(), tag
					.getTagCharset().bytesToCharsetString(tlv.getValue())));
		}

		tsb.append("EF.Registration_C");
		for (Map.Entry<TagC, TLV> field : fieldsC.entrySet()) {
			TagC tag = field.getKey();
			TLV tlv = field.getValue();
			tsb.append(String.format("%s: %s", tag.toString(), tag
					.getTagCharset().bytesToCharsetString(tlv.getValue())));
		}

		tsb.append("EF.Registration_D");
		for (Map.Entry<TagD, TLV> field : fieldsD.entrySet()) {
			TagD tag = field.getKey();
			TLV tlv = field.getValue();
			tsb.append(String.format("%s: %s", tag.toString(), tag
					.getTagCharset().bytesToCharsetString(tlv.getValue())));
		}

		return tsb.toString();

	}

	public EsdData create() {
		return new EsdData.Builder().stateIssuing(getStateIssuing())
				.competentAuthority(getCompetentAuthority())
				.authorityIssuing(getAuthorityIssuing())
				.unambiguousNumber(getUnambiguousNumber())
				.issuingDate(getIssuingDate()).expiryDate(getExpiryDate())
				.serialNumber(getSerialNumber())
				.dateOfFirstRegistration(getDateOfFirstRegistration())
				.yearOfProduction(getYearOfProduction())
				.vehicleMake(getVehicleMake()).vehicleType(getVehicleType())
				.commercialDescription(getCommercialDescription())
				.vehicleIDNumber(getVehicleIDNumber())
				.registrationNumberOfVehicle(getRegistrationNumberOfVehicle())
				.maximumNetPower(getMaximumNetPower())
				.engineCapacity(getEngineCapacity())
				.typeOfFuel(getTypeOfFuel())
				.powerWeightRatio(getPowerWeightRatio())
				.vehicleMass(getVehicleMass())
				.maximumPermissibleLadenMass(getMaximumPermissibleLadenMass())
				.typeApprovalNumber(getTypeApprovalNumber())
				.numberOfSeats(getNumberOfSeats())
				.numberOfStandingPlaces(getNumberOfStandingPlaces())
				.engineIDNumber(getEngineIDNumber())
				.numberOfAxles(getNumberOfAxles())
				.vehicleCategory(getVehicleCategory())
				.colourOfVehicle(getColourOfVehicle())
				.restrictionToChangeOwner(getRestrictionToChangeOwner())
				.vehicleLoad(getVehicleLoad())
				.holderSurnameOrBusinessName(getHolderSurnameOrBusinessName())
				.holderName(getHolderName()).holderAddress(getHolderAddress())
				.ownerPersonalNo(getOwnerPersonalNo())
				.ownerSurnameOrBusinessName(getOwnerSurnameOrBusinessName())
				.ownerName(getOwnerName()).ownerAddress(getOwnerAddress())
				.userPersonalNo(getUserPersonalNo())
				.userSurnameOrBusinessName(getUserSurnameOrBusinessName())
				.userName(getUserName()).userAddress(getUserAddress()).build();
	}

}
