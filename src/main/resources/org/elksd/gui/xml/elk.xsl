<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:lk="http://www.elksd.org/lk/" exclude-result-prefixes="lk">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no"
		indent="yes" />
	<xsl:template match="lk:ElkData">
		<LicnaKarta>
			<Ime>
				<xsl:value-of select="givenName" />
			</Ime>
			<Prezime>
				<xsl:value-of select="surname" />
			</Prezime>
			<OcevoIme>
				<xsl:value-of select="parentGivenName" />
			</OcevoIme>
			<DatumRodjenja>
				<xsl:value-of select="dateOfBirth" />
			</DatumRodjenja>
			<MestoRodjenja>
				<xsl:value-of select="placeOfBirth" />
			</MestoRodjenja>
			<MestoIOpstina>
				<xsl:value-of select="communityOfBirth" />
			</MestoIOpstina>
			<DrzavaRodjenja>
				<xsl:value-of select="stateOfBirth" />
			</DrzavaRodjenja>
			<LicniBroj>
				<xsl:value-of select="personalNumber" />
			</LicniBroj>
			<Pol>
				<xsl:value-of select="sex" />
			</Pol>
			<DokumentIzdaje>
				<xsl:value-of select="issuingAuthority" />
			</DokumentIzdaje>
			<RegistracionBroj>
				<xsl:value-of select="docRegNo" />
			</RegistracionBroj>
			<DatumVadjenja>
				<xsl:value-of select="issuingDate" />
			</DatumVadjenja>
			<DatumIsticanja>
				<xsl:value-of select="expiryDate" />
			</DatumIsticanja>
			<Drzava>
				<xsl:value-of select="state" />
			</Drzava>
			<Mesto>
				<xsl:value-of select="place" />
			</Mesto>
			<Opstina>
				<xsl:value-of select="community" />
			</Opstina>
			<Ulica>
				<xsl:value-of select="street" />
			</Ulica>
			<KucniBroj>
				<xsl:value-of select="houseNumber" />
			</KucniBroj>
			<SlovoKuce>
				<xsl:value-of select="houseLetter" />
			</SlovoKuce>
			<Ulaz>
				<xsl:value-of select="entrance" />
			</Ulaz>
			<Sprat>
				<xsl:value-of select="floor" />
			</Sprat>
			<BrojStana>
				<xsl:value-of select="apartmentNumber" />
			</BrojStana>

		</LicnaKarta>
	</xsl:template>
</xsl:stylesheet>
	