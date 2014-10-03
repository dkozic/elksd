<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	xmlns:sd="http://www.elksd.org/sd/" exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no"
		indent="yes" />

	<xsl:template match="sd:EsdData">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">

			<fo:layout-master-set>
				<!-- fo:layout-master-set defines in its children the page layout: the 
					pagination and layout specifications - page-masters: have the role of describing 
					the intended subdivisions of a page and the geometry of these subdivisions 
					In this case there is only a simple-page-master which defines the layout 
					for all pages of the text -->
				<!-- layout information -->
				<fo:simple-page-master master-name="simple"
					page-height="29.7cm" page-width="21cm" margin-top="2cm"
					margin-bottom="1.5cm" margin-left="1.5cm" margin-right="1.5cm">
					<fo:region-body />
					<fo:region-after extent="0cm" />
				</fo:simple-page-master>
			</fo:layout-master-set>
			<!-- end: defines page layout -->


			<!-- start page-sequence here comes the text (contained in flow objects) 
				the page-sequence can contain different fo:flows the attribute value of master-name 
				refers to the page layout which is to be used to layout the text contained 
				in this page-sequence -->
			<fo:page-sequence master-reference="simple">

				<!-- footer -->
				<fo:static-content flow-name="xsl-region-after"
					font-family="Arial">
					<fo:block border-top-color="black" border-top-style="solid"
						border-top-width="thick" text-align="center">eLKSD</fo:block>
				</fo:static-content>

				<!-- start fo:flow each flow is targeted at one (and only one) of the 
					following: xsl-region-body (usually: normal text) xsl-region-before (usually: 
					header) xsl-region-after (usually: footer) xsl-region-start (usually: left 
					margin) xsl-region-end (usually: right margin) ['usually' applies here to 
					languages with left-right and top-down writing direction like English] in 
					this case there is only one target: xsl-region-body -->
				<fo:flow flow-name="xsl-region-body">

					<!-- each paragraph is encapsulated in a block element the attributes 
						of the block define font-family and size, line-heigth etc. -->

					<!-- this defines a title -->
					<fo:block font-size="18pt" font-family="Arial"
						line-height="24pt" border-bottom-color="black"
						border-bottom-style="solid" border-bottom-width="thick"
						space-after.optimum="15pt" text-align="left" padding-top="3pt">
						&#x010c;ita&#x010d; saobra&#x0107;ajne dozvole
					</fo:block>
					<!-- this defines a title -->
					<fo:block font-size="14pt" font-family="Arial"
						line-height="24pt" space-after.optimum="15pt" text-align="left"
						padding-top="3pt">
						Registarska oznaka:
						<xsl:value-of select="registrationNumberOfVehicle" />
					</fo:block>


					<!-- this defines normal text -->
					<fo:table text-align="left" table-layout="fixed" width="100%">
						<fo:table-column column-width="10cm" />
						<fo:table-column column-width="6cm" />
						<fo:table-body>
							<fo:table-row>
								<fo:table-cell>
									<fo:block font-size="12pt" font-family="Arial"
										line-height="15pt" space-after.optimum="3pt" text-align="justify">
										Datum izdavanja:
										<xsl:value-of select="issuingDate" />
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block font-size="12pt" font-family="Arial"
										line-height="15pt" space-after.optimum="3pt" text-align="justify">
										Važi do:
										<xsl:value-of select="expiryDate" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-body>
					</fo:table>

					<fo:block font-size="12pt" font-family="Arial"
						line-height="15pt" space-after.optimum="3pt" text-align="justify">
						Saobraćajnu dozvolu izdao:
						<xsl:value-of select="stateIssuing" />
						,
						<xsl:value-of select="authorityIssuing" />
						,
						<xsl:value-of select="competentAuthority" />
					</fo:block>
					<fo:block font-size="12pt" font-family="Arial"
						line-height="15pt" space-after.optimum="3pt" text-align="justify">
						Zabrana
						otuđenja:
						<xsl:value-of select="restrictionToChangeOwner" />
					</fo:block>
					<fo:block font-size="12pt" font-family="Arial"
						line-height="15pt" space-after.optimum="3pt" text-align="justify">
						Broj
						saobraćajne:
						<xsl:value-of select="unambiguousNumber" />
					</fo:block>
					<fo:block font-size="12pt" font-family="Arial"
						line-height="15pt" space-after.optimum="3pt" text-align="justify">
						Serijski
						broj:
						<xsl:value-of select="serialNumber" />
					</fo:block>
					<fo:block font-size="12pt" font-family="Arial"
						line-height="15pt" text-decoration="underline"
						space-after.optimum="3pt" text-align="justify">
						Podaci o vlasniku
					</fo:block>
					<fo:block font-size="12pt" font-family="Arial"
						line-height="15pt" space-after.optimum="3pt" text-align="justify">
						Vlasnik:
						<xsl:value-of select="holderSurnameOrBusinessName" />
					</fo:block>
					<fo:block font-size="12pt" font-family="Arial"
						line-height="15pt" space-after.optimum="3pt" text-align="justify">
						Ime
						vlasnika:
						<xsl:value-of select="holderName" />
					</fo:block>
					<fo:block font-size="12pt" font-family="Arial"
						line-height="15pt" space-after.optimum="3pt" text-align="justify">
						Adresa
						vlasnika:
						<xsl:value-of select="holderAddress" />
					</fo:block>
					<fo:block font-size="12pt" font-family="Arial"
						line-height="15pt" space-after.optimum="3pt" text-align="justify">
						Jmbg
						vlasnika:
						<xsl:value-of select="ownerPersonalNo" />
					</fo:block>
					<fo:block font-size="12pt" font-family="Arial"
						line-height="15pt" space-after.optimum="3pt" text-align="justify">
						Korisnik:
						<xsl:value-of select="userSurnameOrBusinessName" />
					</fo:block>
					<fo:block font-size="12pt" font-family="Arial"
						line-height="15pt" space-after.optimum="3pt" text-align="justify">
						Ime
						korisnika:
						<xsl:value-of select="userName" />
					</fo:block>
					<fo:block font-size="12pt" font-family="Arial"
						line-height="15pt" space-after.optimum="3pt" text-align="justify">
						Adresa
						korisnika:
						<xsl:value-of select="userAddress" />
					</fo:block>
					<fo:block font-size="12pt" font-family="Arial"
						line-height="15pt" space-after.optimum="3pt" text-align="justify">
						Jmbg
						korisnika:
						<xsl:value-of select="userPersonalNo" />
					</fo:block>
					<fo:block font-size="12pt" font-family="Arial"
						line-height="15pt" text-decoration="underline"
						space-after.optimum="3pt" text-align="justify">
						Podaci o vozilu
					</fo:block>
					<fo:table text-align="left" table-layout="fixed" width="100%">
						<fo:table-column column-width="10cm" />
						<fo:table-column column-width="6cm" />
						<fo:table-body>
							<fo:table-row>
								<fo:table-cell>
									<fo:block font-size="12pt" font-family="Arial"
										line-height="15pt" space-after.optimum="3pt" text-align="justify">
										Datum
										prve registracije:
										<xsl:value-of select="dateOfFirstRegistration" />
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block font-size="12pt" font-family="Arial"
										line-height="15pt" space-after.optimum="3pt" text-align="justify">
										Godina
										proizvodnje:
										<xsl:value-of select="yearOfProduction" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell>
									<fo:block>
										Marka:
										<xsl:value-of select="vehicleMake" />
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										Model:
										<xsl:value-of select="commercialDescription" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell>
									<fo:block>
										Tip:
										<xsl:value-of select="vehicleType" />
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										Homologacijska oznaka:
										<xsl:value-of select="typeApprovalNumber" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell>
									<fo:block>
										Boja:
										<xsl:value-of select="colourOfVehicle" />
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										Broj osovina:
										<xsl:value-of select="numberOfAxles" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell>
									<fo:block>
										Broj šasije:
										<xsl:value-of select="vehicleIDNumber" />
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										Zapremina motora:
										<xsl:value-of select="engineCapacity" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell>
									<fo:block>
										Broj motora:
										<xsl:value-of select="engineIDNumber" />
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										Masa:
										<xsl:value-of select="vehicleMass" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell>
									<fo:block>
										Snaga motora:
										<xsl:value-of select="maximumNetPower" />
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										Nosivost:
										<xsl:value-of select="vehicleLoad" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell>
									<fo:block>
										Odnos snaga/masa:
										<xsl:value-of select="powerWeightRatio" />
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										Ukupna masa:
										<xsl:value-of select="maximumPermissibleLadenMass" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell>
									<fo:block>
										Kategorija:
										<xsl:value-of select="vehicleCategory" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell>
									<fo:block>
										Pogonsko gorivo:
										<xsl:value-of select="typeOfFuel" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell>
									<fo:block>
										Broj mesta za sedenje:
										<xsl:value-of select="numberOfSeats" />
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										Broj mesta za stajanje:
										<xsl:value-of select="numberOfStandingPlaces" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>

						</fo:table-body>
					</fo:table>


				</fo:flow> <!-- closes the flow element -->
			</fo:page-sequence> <!-- closes the page-sequence -->
		</fo:root>
	</xsl:template>
</xsl:stylesheet>