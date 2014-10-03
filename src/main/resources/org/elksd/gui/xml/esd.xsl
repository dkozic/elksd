<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:sd="http://www.elksd.org/sd/"
	exclude-result-prefixes="sd">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no"
		indent="yes" />

	<xsl:template match="sd:EsdData">
		<SaobracajnaDozola>
			<stateIssuing>
				<xsl:value-of select="stateIssuing" />
			</stateIssuing>
			<authorityIssuing>
				<xsl:value-of select="authorityIssuing" />
			</authorityIssuing>
			<competentAuthority>
				<xsl:value-of select="competentAuthority" />
			</competentAuthority>
			<issuingDate>
				<xsl:value-of select="issuingDate" />
			</issuingDate>
			<expiryDate>
				<xsl:value-of select="expiryDate" />
			</expiryDate>
			<unambiguousNumber>
				<xsl:value-of select="unambiguousNumber" />
			</unambiguousNumber>
			<serialNumber>
				<xsl:value-of select="serialNumber" />
			</serialNumber>
			<ownersSurnameOrBusinessName>
				<xsl:value-of select="ownersSurnameOrBusinessName" />
			</ownersSurnameOrBusinessName>
			<ownerName>
				<xsl:value-of select="ownerName" />
			</ownerName>
			<ownersPersonalNo>
				<xsl:value-of select="ownersPersonalNo" />
			</ownersPersonalNo>
			<ownerAddress>
				<xsl:value-of select="ownerAddress" />
			</ownerAddress>
			<usersSurnameOrBusinessName>
				<xsl:value-of select="usersSurnameOrBusinessName" />
			</usersSurnameOrBusinessName>
			<usersName>
				<xsl:value-of select="usersName" />
			</usersName>
			<usersPersonalNo>
				<xsl:value-of select="usersPersonalNo" />
			</usersPersonalNo>
			<serialNumber>
				<xsl:value-of select="serialNumber" />
			</serialNumber>
			<registrationNumberOfVehicle>
				<xsl:value-of select="registrationNumberOfVehicle" />
			</registrationNumberOfVehicle>
			<dateOfFirstRegistration>
				<xsl:value-of select="dateOfFirstRegistration" />
			</dateOfFirstRegistration>
			<vehicleMake>
				<xsl:value-of select="vehicleMake" />
			</vehicleMake>
			<commercialDescription>
				<xsl:value-of select="commercialDescription" />
			</commercialDescription>
			<yearOfProduction>
				<xsl:value-of select="yearOfProduction" />
			</yearOfProduction>
			<vehicleType>
				<xsl:value-of select="vehicleType" />
			</vehicleType>
			<colourOfVehicle>
				<xsl:value-of select="colourOfVehicle" />
			</colourOfVehicle>
			<vehicleIDNumber>
				<xsl:value-of select="vehicleIDNumber" />
			</vehicleIDNumber>
			<engineIDNumber>
				<xsl:value-of select="engineIDNumber" />
			</engineIDNumber>
			<maximumNetPower>
				<xsl:value-of select="maximumNetPower" />
			</maximumNetPower>
			<vehicleMass>
				<xsl:value-of select="vehicleMass" />
			</vehicleMass>
			<engineCapacity>
				<xsl:value-of select="engineCapacity" />
			</engineCapacity>
			<vehicleLoad>
				<xsl:value-of select="vehicleLoad" />
			</vehicleLoad>
			<powerWeightRatio>
				<xsl:value-of select="powerWeightRatio" />
			</powerWeightRatio>
			<numberOfAxles>
				<xsl:value-of select="numberOfAxles" />
			</numberOfAxles>
			<maximumPermissibleLadenMass>
				<xsl:value-of select="maximumPermissibleLadenMass" />
			</maximumPermissibleLadenMass>
			<numberOfSeats>
				<xsl:value-of select="numberOfSeats" />
			</numberOfSeats>
			<numberOfStandingPlaces>
				<xsl:value-of select="numberOfStandingPlaces" />
			</numberOfStandingPlaces>
			<typeApprovalNumber>
				<xsl:value-of select="typeApprovalNumber" />
			</typeApprovalNumber>
			<vehicleCategory>
				<xsl:value-of select="vehicleCategory" />
			</vehicleCategory>
			<typeOfFuel>
				<xsl:value-of select="typeOfFuel" />
			</typeOfFuel>
			<restrictionToChangeOwner>
				<xsl:value-of select="restrictionToChangeOwner" />
			</restrictionToChangeOwner>
		</SaobracajnaDozola>
	</xsl:template>
</xsl:stylesheet>