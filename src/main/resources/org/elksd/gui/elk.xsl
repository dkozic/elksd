<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	xmlns:lk="http://www.elksd.org/lk/" exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no"
		indent="yes" />
	<xsl:param name="imagePath" />
	<xsl:template match="lk:ElkData">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format"
			xmlns:svg="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">

			<fo:layout-master-set>
				<!-- fo:layout-master-set defines in its children the page layout: the 
					pagination and layout specifications - page-masters: have the role of describing 
					the intended subdivisions of a page and the geometry of these subdivisions 
					In this case there is only a simple-page-master which defines the layout 
					for all pages of the text -->
				<!-- layout information -->
				<fo:simple-page-master master-name="simple"
					page-height="29.7cm" page-width="21cm" margin-top="2.5cm"
					margin-bottom="1.5cm" margin-left="2.5cm" margin-right="2.5cm">
					<fo:region-body />
					<fo:region-after extent="1cm" />
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
				<fo:flow flow-name="xsl-region-body" font-family="Arial"
					font-size="12pt">

					<!-- each paragraph is encapsulated in a block element the attributes 
						of the block define font-family and size, line-heigth etc. -->

					<fo:block font-size="14pt" font-family="Arial"
						line-height="24pt" border-top-color="black" border-top-style="solid"
						border-top-width="thick" border-bottom-color="black"
						border-bottom-style="solid" border-bottom-width="thick"
						space-after.optimum="15pt" text-align="left" padding-top="3pt">
						ČITAČ
						ELEKTRONSKE LIČNE KARTE: ŠTAMPA PODATAKA
					</fo:block>
					<fo:block>
						<fo:external-graphic src="url('file:{$imagePath}')" height="5.5cm" width="4cm" content-height="scale-to-fit" />
					</fo:block>
					<fo:block font-size="12pt" font-family="Arial"
						line-height="24pt" border-top-color="black" border-top-style="solid"
						border-top-width="thick" border-bottom-color="black"
						border-bottom-style="solid" border-bottom-width="thick"
						space-after.optimum="15pt" space-before.optimum="15pt" text-align="left"
						padding-top="3pt">
						Podaci o
						građaninu
					</fo:block>
					<fo:table text-align="left" table-layout="fixed" width="100%">
						<fo:table-column column-width="4cm" />
						<fo:table-column column-width="12cm" />
						<fo:table-body>
							<fo:table-row height="24pt">
								<fo:table-cell>
									<fo:block>Prezime:</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										<xsl:value-of select="surname" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row height="24pt">
								<fo:table-cell>
									<fo:block>Ime:</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										<xsl:value-of select="givenName" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row height="24pt">
								<fo:table-cell>
									<fo:block>Ime jednog roditelja:</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										<xsl:value-of select="parentGivenName" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row height="24pt">
								<fo:table-cell>
									<fo:block>Datum rođenja:</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										<xsl:value-of select="dateOfBirth" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row height="24pt">
								<fo:table-cell>
									<fo:block>Mesto rođenja, opština i država:</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										<xsl:value-of select="placeOfBirth" />
										,
										<xsl:value-of select="communityOfBirth" />
										,
										<xsl:value-of select="stateOfBirth" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row height="24pt">
								<fo:table-cell>
									<fo:block>Prebivalište i adresa stana:</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										<xsl:value-of select="place" />
										,
										<xsl:value-of select="community" />
										,
										<xsl:value-of select="street" />
										,
										<xsl:value-of select="houseNumber" />
										/
										<xsl:value-of select="apartmentNumber" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row height="24pt">
								<fo:table-cell>
									<fo:block>JMBG:</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										<xsl:value-of select="personalNumber" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row height="24pt">
								<fo:table-cell>
									<fo:block>Pol:</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										<xsl:value-of select="sex" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>

						</fo:table-body>
					</fo:table>

					<fo:block font-size="12pt" font-family="Arial"
						line-height="24pt" border-top-color="black" border-top-style="solid"
						border-top-width="thick" border-bottom-color="black"
						border-bottom-style="solid" border-bottom-width="thick"
						space-after.optimum="15pt" text-align="left" padding-top="3pt">
						Podaci o
						dokumentu
					</fo:block>

					<fo:table text-align="left" table-layout="fixed" width="100%">
						<fo:table-column column-width="4cm" />
						<fo:table-column column-width="12cm" />
						<fo:table-body>
							<fo:table-row height="24pt">
								<fo:table-cell>
									<fo:block>Dokument izdaje:</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										<xsl:value-of select="issuingAuthority" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row height="24pt">
								<fo:table-cell>
									<fo:block>Broj dokumenta:</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										<xsl:value-of select="docRegNo" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row height="24pt">
								<fo:table-cell>
									<fo:block>Datum izdavanja:</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										<xsl:value-of select="issuingDate" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row height="24pt">
								<fo:table-cell>
									<fo:block>Važi do:</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block>
										<xsl:value-of select="expiryDate" />
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
	