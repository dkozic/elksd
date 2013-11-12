package org.elksd.sd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "EsdData", namespace = "http://www.elksd.org/sd/")
public class EsdData {

	public EsdData() {
	}
	
	public static class Builder {
		// SD_DOCUMENT_DATA
		private String stateIssuing;
		private String competentAuthority;
		private String authorityIssuing;
		private String unambiguousNumber;
		private String issuingDate;
		private String expiryDate;
		private String serialNumber;

		// SD_VEHICLE_DATA
		private String dateOfFirstRegistration;
		private String yearOfProduction;
		private String vehicleMake;
		private String vehicleType;
		private String commercialDescription;
		private String vehicleIDNumber;
		private String registrationNumberOfVehicle;
		private String maximumNetPower;
		private String engineCapacity;
		private String typeOfFuel;
		private String powerWeightRatio;
		private String vehicleMass;
		private String maximumPermissibleLadenMass;
		private String typeApprovalNumber;
		private String numberOfSeats;
		private String numberOfStandingPlaces;
		private String engineIDNumber;
		private String numberOfAxles;
		private String vehicleCategory;
		private String colourOfVehicle;
		private String restrictionToChangeOwner;
		private String vehicleLoad;

		// SD_PERSONAL_DATA
		private String holderSurnameOrBusinessName;
		private String holderName;
		private String holderAddress;
		private String ownerPersonalNo;
		private String ownerSurnameOrBusinessName;
		private String ownerName;
		private String ownerAddress;
		private String userPersonalNo;
		private String userSurnameOrBusinessName;
		private String userName;
		private String userAddress;

		public Builder stateIssuing(String stateIssuing) {
			this.stateIssuing = stateIssuing;
			return this;
		}

		public Builder competentAuthority(String competentAuthority) {
			this.competentAuthority = competentAuthority;
			return this;
		}

		public Builder authorityIssuing(String authorityIssuing) {
			this.authorityIssuing = authorityIssuing;
			return this;
		}

		public Builder unambiguousNumber(String unambiguousNumber) {
			this.unambiguousNumber = unambiguousNumber;
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

		public Builder serialNumber(String serialNumber) {
			this.serialNumber = serialNumber;
			return this;
		}

		public Builder dateOfFirstRegistration(String dateOfFirstRegistration) {
			this.dateOfFirstRegistration = dateOfFirstRegistration;
			return this;
		}

		public Builder yearOfProduction(String yearOfProduction) {
			this.yearOfProduction = yearOfProduction;
			return this;
		}

		public Builder vehicleMake(String vehicleMake) {
			this.vehicleMake = vehicleMake;
			return this;
		}

		public Builder vehicleType(String vehicleType) {
			this.vehicleType = vehicleType;
			return this;
		}

		public Builder commercialDescription(String commercialDescription) {
			this.commercialDescription = commercialDescription;
			return this;
		}

		public Builder vehicleIDNumber(String vehicleIDNumber) {
			this.vehicleIDNumber = vehicleIDNumber;
			return this;
		}

		public Builder registrationNumberOfVehicle(
				String registrationNumberOfVehicle) {
			this.registrationNumberOfVehicle = registrationNumberOfVehicle;
			return this;
		}

		public Builder maximumNetPower(String maximumNetPower) {
			this.maximumNetPower = maximumNetPower;
			return this;
		}

		public Builder engineCapacity(String engineCapacity) {
			this.engineCapacity = engineCapacity;
			return this;
		}

		public Builder typeOfFuel(String typeOfFuel) {
			this.typeOfFuel = typeOfFuel;
			return this;
		}

		public Builder powerWeightRatio(String powerWeightRatio) {
			this.powerWeightRatio = powerWeightRatio;
			return this;
		}

		public Builder vehicleMass(String vehicleMass) {
			this.vehicleMass = vehicleMass;
			return this;
		}

		public Builder maximumPermissibleLadenMass(
				String maximumPermissibleLadenMass) {
			this.maximumPermissibleLadenMass = maximumPermissibleLadenMass;
			return this;
		}

		public Builder typeApprovalNumber(String typeApprovalNumber) {
			this.typeApprovalNumber = typeApprovalNumber;
			return this;
		}

		public Builder numberOfSeats(String numberOfSeats) {
			this.numberOfSeats = numberOfSeats;
			return this;
		}

		public Builder numberOfStandingPlaces(String numberOfStandingPlaces) {
			this.numberOfStandingPlaces = numberOfStandingPlaces;
			return this;
		}

		public Builder engineIDNumber(String engineIDNumber) {
			this.engineIDNumber = engineIDNumber;
			return this;
		}

		public Builder numberOfAxles(String numberOfAxles) {
			this.numberOfAxles = numberOfAxles;
			return this;
		}

		public Builder vehicleCategory(String vehicleCategory) {
			this.vehicleCategory = vehicleCategory;
			return this;
		}

		public Builder colourOfVehicle(String colourOfVehicle) {
			this.colourOfVehicle = colourOfVehicle;
			return this;
		}

		public Builder restrictionToChangeOwner(String restrictionToChangeOwner) {
			this.restrictionToChangeOwner = restrictionToChangeOwner;
			return this;
		}

		public Builder vehicleLoad(String vehicleLoad) {
			this.vehicleLoad = vehicleLoad;
			return this;
		}

		public Builder holderSurnameOrBusinessName(
				String holderSurnameOrBusinessName) {
			this.holderSurnameOrBusinessName = holderSurnameOrBusinessName;
			return this;
		}

		public Builder holderName(String holderName) {
			this.holderName = holderName;
			return this;
		}

		public Builder holderAddress(String holderAddress) {
			this.holderAddress = holderAddress;
			return this;
		}

		public Builder ownerPersonalNo(String ownerPersonalNo) {
			this.ownerPersonalNo = ownerPersonalNo;
			return this;
		}

		public Builder ownerSurnameOrBusinessName(
				String ownerSurnameOrBusinessName) {
			this.ownerSurnameOrBusinessName = ownerSurnameOrBusinessName;
			return this;
		}

		public Builder ownerName(String ownerName) {
			this.ownerName = ownerName;
			return this;
		}

		public Builder ownerAddress(String ownerAddress) {
			this.ownerAddress = ownerAddress;
			return this;
		}

		public Builder userPersonalNo(String userPersonalNo) {
			this.userPersonalNo = userPersonalNo;
			return this;
		}

		public Builder userSurnameOrBusinessName(
				String userSurnameOrBusinessName) {
			this.userSurnameOrBusinessName = userSurnameOrBusinessName;
			return this;
		}

		public Builder userName(String userName) {
			this.userName = userName;
			return this;
		}

		public Builder userAddress(String userAddress) {
			this.userAddress = userAddress;
			return this;
		}

		public EsdData build() {
			return new EsdData(this);
		}

	}

	// SD_DOCUMENT_DATA
	private String stateIssuing;
	private String competentAuthority;
	private String authorityIssuing;
	private String unambiguousNumber;
	private String issuingDate;
	private String expiryDate;
	private String serialNumber;

	// SD_VEHICLE_DATA
	private String dateOfFirstRegistration;
	private String yearOfProduction;
	private String vehicleMake;
	private String vehicleType;
	private String commercialDescription;
	private String vehicleIDNumber;
	private String registrationNumberOfVehicle;
	private String maximumNetPower;
	private String engineCapacity;
	private String typeOfFuel;
	private String powerWeightRatio;
	private String vehicleMass;
	private String maximumPermissibleLadenMass;
	private String typeApprovalNumber;
	private String numberOfSeats;
	private String numberOfStandingPlaces;
	private String engineIDNumber;
	private String numberOfAxles;
	private String vehicleCategory;
	private String colourOfVehicle;
	private String restrictionToChangeOwner;
	private String vehicleLoad;

	// SD_PERSONAL_DATA
	private String holderSurnameOrBusinessName;
	private String holderName;
	private String holderAddress;
	private String ownerPersonalNo;
	private String ownerSurnameOrBusinessName;
	private String ownerName;
	private String ownerAddress;
	private String userPersonalNo;
	private String userSurnameOrBusinessName;
	private String userName;
	private String userAddress;

	public String getStateIssuing() {
		return stateIssuing;
	}

	public String getCompetentAuthority() {
		return competentAuthority;
	}

	public String getAuthorityIssuing() {
		return authorityIssuing;
	}

	public String getUnambiguousNumber() {
		return unambiguousNumber;
	}

	public String getIssuingDate() {
		return issuingDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public String getDateOfFirstRegistration() {
		return dateOfFirstRegistration;
	}

	public String getYearOfProduction() {
		return yearOfProduction;
	}

	public String getVehicleMake() {
		return vehicleMake;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public String getCommercialDescription() {
		return commercialDescription;
	}

	public String getVehicleIDNumber() {
		return vehicleIDNumber;
	}

	public String getRegistrationNumberOfVehicle() {
		return registrationNumberOfVehicle;
	}

	public String getMaximumNetPower() {
		return maximumNetPower;
	}

	public String getEngineCapacity() {
		return engineCapacity;
	}

	public String getTypeOfFuel() {
		return typeOfFuel;
	}

	public String getPowerWeightRatio() {
		return powerWeightRatio;
	}

	public String getVehicleMass() {
		return vehicleMass;
	}

	public String getMaximumPermissibleLadenMass() {
		return maximumPermissibleLadenMass;
	}

	public String getTypeApprovalNumber() {
		return typeApprovalNumber;
	}

	public String getNumberOfSeats() {
		return numberOfSeats;
	}

	public String getNumberOfStandingPlaces() {
		return numberOfStandingPlaces;
	}

	public String getEngineIDNumber() {
		return engineIDNumber;
	}

	public String getNumberOfAxles() {
		return numberOfAxles;
	}

	public String getVehicleCategory() {
		return vehicleCategory;
	}

	public String getColourOfVehicle() {
		return colourOfVehicle;
	}

	public String getRestrictionToChangeOwner() {
		return restrictionToChangeOwner;
	}

	public String getVehicleLoad() {
		return vehicleLoad;
	}

	public String getHolderSurnameOrBusinessName() {
		return holderSurnameOrBusinessName;
	}

	public String getHolderName() {
		return holderName;
	}

	public String getHolderAddress() {
		return holderAddress;
	}

	public String getOwnerPersonalNo() {
		return ownerPersonalNo;
	}

	public String getOwnerSurnameOrBusinessName() {
		return ownerSurnameOrBusinessName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public String getOwnerAddress() {
		return ownerAddress;
	}

	public String getUserPersonalNo() {
		return userPersonalNo;
	}

	public String getUserSurnameOrBusinessName() {
		return userSurnameOrBusinessName;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	private EsdData(Builder b) {
		// SD_DOCUMENT_DATA
		this.stateIssuing = b.stateIssuing;
		this.competentAuthority = b.competentAuthority;
		this.authorityIssuing = b.authorityIssuing;
		this.unambiguousNumber = b.unambiguousNumber;
		this.issuingDate = b.issuingDate;
		this.expiryDate = b.expiryDate;
		this.serialNumber = b.serialNumber;

		// SD_VEHICLE_DATA
		this.dateOfFirstRegistration = b.dateOfFirstRegistration;
		this.yearOfProduction = b.yearOfProduction;
		this.vehicleMake = b.vehicleMake;
		this.vehicleType = b.vehicleType;
		this.commercialDescription = b.commercialDescription;
		this.vehicleIDNumber = b.vehicleIDNumber;
		this.registrationNumberOfVehicle = b.registrationNumberOfVehicle;
		this.maximumNetPower = b.maximumNetPower;
		this.engineCapacity = b.engineCapacity;
		this.typeOfFuel = b.typeOfFuel;
		this.powerWeightRatio = b.powerWeightRatio;
		this.vehicleMass = b.vehicleMass;
		this.maximumPermissibleLadenMass = b.maximumPermissibleLadenMass;
		this.typeApprovalNumber = b.typeApprovalNumber;
		this.numberOfSeats = b.numberOfSeats;
		this.numberOfStandingPlaces = b.numberOfStandingPlaces;
		this.engineIDNumber = b.engineIDNumber;
		this.numberOfAxles = b.numberOfAxles;
		this.vehicleCategory = b.vehicleCategory;
		this.colourOfVehicle = b.colourOfVehicle;
		this.restrictionToChangeOwner = b.restrictionToChangeOwner;
		this.vehicleLoad = b.vehicleLoad;

		// SD_PERSONAL_DATA
		this.holderSurnameOrBusinessName = b.holderSurnameOrBusinessName;
		this.holderName = b.holderName;
		this.holderAddress = b.holderAddress;
		this.ownerPersonalNo = b.ownerPersonalNo;
		this.ownerSurnameOrBusinessName = b.ownerSurnameOrBusinessName;
		this.ownerName = b.ownerName;
		this.ownerAddress = b.ownerAddress;
		this.userPersonalNo = b.userPersonalNo;
		this.userSurnameOrBusinessName = b.userSurnameOrBusinessName;
		this.userName = b.userName;
		this.userAddress = b.userAddress;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
