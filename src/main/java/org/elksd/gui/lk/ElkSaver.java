package org.elksd.gui.lk;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.elksd.lk.ElkData;

public class ElkSaver {

	public ElkSaver() {
	}

	public void saveToFile(ElkData elkData, File file) throws JAXBException, TransformerException, IOException {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer(new StreamSource(ElkFrame.class
				.getResourceAsStream("/org/elksd/gui/xml/elk.xsl")));

		Source src = new StreamSource(new ByteArrayInputStream(elkData.toXMLByteArray()));

		FileOutputStream fos = new FileOutputStream(file);
		Result res = new StreamResult(fos);
		transformer.transform(src, res);
		fos.close();
	}
	
	public void saveToFile(ElkData elkData) throws JAXBException, TransformerException, IOException {
		File userHome = new File(System.getProperty("user.home"));
		File file = new File(userHome, elkData.getPersonalNumber() + ".xml");
		saveToFile(elkData, file);
		
	}

}
