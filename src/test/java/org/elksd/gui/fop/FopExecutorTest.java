package org.elksd.gui.fop;

import java.io.IOException;

import org.apache.avalon.framework.configuration.ConfigurationException;
import org.elksd.lk.ElkData;
import org.elksd.sd.EsdData;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

public class FopExecutorTest {

	FopExecutor e;

	@Before
	public void setUp() throws ConfigurationException, SAXException,
			IOException {
		e = FopExecutor.getInstance();

	}

	@Test
	public void testElkPrint() throws Exception {

		ElkData.Builder builder = new ElkData.Builder().surname("KOZIC")
				.givenName("DRAZEN").parentGivenName("ANDJELKO")
				.dateOfBirth("19.02.1970").placeOfBirth("SARAJEVO")
				.communityOfBirth("CENTAR").stateOfBirth("BIH")
				.place("BEOGRAD").community("NOVI BEOGRAD")
				.street("DR IVANA RIBARA").houseNumber("156/30")
				.personalNumber("1902970171301").sex("M")
				.issuingAuthority("PU ZA GRAD BEOGRAD").docRegNo("00759555")
				.issuingDate("23.06.2009").expiryDate("23.06.2014");
		ElkData elkData = builder.build();
		byte[] pdfBytes = e.elkPrint(elkData);
		PdfViewer pdfViewer = new PdfViewer(pdfBytes);
		pdfViewer.show();

	}

	@Test
	public void testEsdPrint() throws Exception {

		EsdData.Builder builder = new EsdData.Builder()
				.registrationNumberOfVehicle("BG268-UK")
				.issuingDate("201110718")
				.expiryDate("20180718")
				.authorityIssuing("PS NOVI BEOGRAD")
				.competentAuthority(
						"MINISTARSTVO UNUTRASNJIH POSLOVA REPUBLIKE SRBIJE")
				.stateIssuing("REPUBLIKA SRBIJA").unambiguousNumber("2301520")
				.serialNumber("67810014428cc")
				.holderSurnameOrBusinessName("KOZIC").holderName("DRAZEN")
				.holderAddress("BEOGRAD, NOVI BEOGRAD, DR IVANA RIBARA, 156,,")
				.ownerPersonalNo("1902970171301")
				.dateOfFirstRegistration("20090718").yearOfProduction("2003")
				.vehicleMake("RENAULT").commercialDescription("LAGUNA 1.9 DCI")
				.colourOfVehicle("6D ZELENA TAMNA METALIZIRANA")
				.numberOfAxles("2").vehicleIDNumber("VF1KG0E0528234031")
				.vehicleMass("1385").engineCapacity("1870")
				.engineIDNumber("F9QN75C024229")
				.maximumPermissibleLadenMass("1915").powerWeightRatio("0")
				.vehicleCategory("PUTNICKO VOZILO").typeOfFuel("EVRO DIZEL")
				.numberOfSeats("5").numberOfStandingPlaces("0");
		EsdData esdData = builder.build();
		byte[] pdfBytes = e.esdPrint(esdData);
		PdfViewer pdfViewer = new PdfViewer(pdfBytes);
		pdfViewer.show();

	}

}
