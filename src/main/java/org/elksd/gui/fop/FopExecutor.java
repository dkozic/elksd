package org.elksd.gui.fop;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.URIResolver;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.avalon.framework.configuration.Configuration;
import org.apache.avalon.framework.configuration.ConfigurationException;
import org.apache.avalon.framework.configuration.DefaultConfigurationBuilder;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.apache.log4j.Logger;
import org.elksd.lk.ElkData;
import org.elksd.sd.EsdData;
import org.xml.sax.SAXException;

public class FopExecutor {

	private static Logger log = Logger.getLogger(FopExecutor.class);

	private static FopExecutor instance = null;

	public static FopExecutor getInstance() throws ConfigurationException, SAXException, IOException {
		if (instance == null) {
			instance = new FopExecutor();
		}
		return instance;
	}

	private FopFactory fopFactory;

	// private FOUserAgent foUserAgent;
	private String copyFonts() throws IOException {
		String homeDir = System.getProperty("user.home");
		File elksdDir = new File(homeDir, ".elksd");
		if (elksdDir.exists()) {
			log.debug("Directory exists: " + elksdDir);
		} else {
			log.debug("Directory does not exists: " + elksdDir + ". Creating directory.");
			elksdDir.mkdirs();
			log.debug("Direcotry created: " + elksdDir);
		}
		File fontsDir = new File(elksdDir, "fonts");
		if (fontsDir.exists()) {
			log.debug("Directory exists: " + fontsDir);
		} else {
			log.debug("Directory does not exists: " + fontsDir + ". Creating directory.");
			fontsDir.mkdirs();
			log.debug("Direcotry created: " + fontsDir);
		}

		File f1 = new File(fontsDir, "arial.ttf");
		if (f1.exists()) {
			log.debug("arial.ttf exists: " + f1);
		} else {
			log.debug("arial.ttf does not exists: " + f1 + ". Creating file.");

			BufferedInputStream bis = null;
			FileOutputStream fos = null;
			try {

				InputStream is = this.getClass().getResourceAsStream("/fonts/arial.ttf");
				bis = new BufferedInputStream(is);
				fos = new FileOutputStream(f1);
				int b;
				while ((b = bis.read()) != -1) {
					fos.write(b);
				}
			} finally {
				if (bis != null) {
					try {
						bis.close();
					} catch (Exception e) {

					}
				}
				if (fos != null) {
					try {
						fos.close();
					} catch (Exception e) {

					}
				}
			}
			log.debug("arial.ttf created: " + fontsDir);
		}
		File f2 = new File(fontsDir, "arialbd.ttf");
		if (f2.exists()) {
			log.debug("arialbd.ttf exists: " + f2);
		} else {
			log.debug("arialbd.ttf does not exists: " + f2 + ". Creating file.");

			BufferedInputStream bis = null;
			FileOutputStream fos = null;
			try {

				InputStream is = this.getClass().getResourceAsStream("/fonts/arialbd.ttf");
				bis = new BufferedInputStream(is);
				fos = new FileOutputStream(f2);
				int b;
				while ((b = bis.read()) != -1) {
					fos.write(b);
				}
			} finally {
				if (bis != null) {
					try {
						bis.close();
					} catch (Exception e) {

					}
				}
				if (fos != null) {
					try {
						fos.close();
					} catch (Exception e) {

					}
				}
			}
			log.debug("arialbd.ttf created: " + fontsDir);
		}
		return fontsDir.getPath();

	}

	private FopExecutor() throws ConfigurationException, SAXException, IOException {
		// Step 1: Construct a FopFactory
		// (reuse if you plan to render multiple documents!)
		fopFactory = FopFactory.newInstance();

		// FOURIResolver uriResolver = (FOURIResolver)
		// fopFactory.getURIResolver();
		// uriResolver.setCustomURIResolver(new CustomPathResolver());

		DefaultConfigurationBuilder cfgBuilder = new DefaultConfigurationBuilder();
		Configuration cfg = cfgBuilder.build(getClass().getResourceAsStream("/fop.xconf"));
		fopFactory.setUserConfig(cfg);

		String fontBase = copyFonts();
		fopFactory.getFontManager().setFontBaseURL(fontBase);
		// foUserAgent = fopFactory.newFOUserAgent();

	}

	public byte[] esdPrint(EsdData esdData) throws Exception {
		log.debug(esdData);

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			// Step 3: Construct fop with desired output format
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);

			// Step 4: Setup JAXP using identity transformer
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(new StreamSource(FopExecutor.class
					.getResourceAsStream("/org/elksd/gui/fop/esd.xsl")));

			// Step 5: Setup input and output for XSLT transformation
			// Setup input stream
			Source src = new StreamSource(new ByteArrayInputStream(esdData.toXMLByteArray()));

			// Resulting SAX events (the generated FO) must be piped through to
			// FOP
			Result res = new SAXResult(fop.getDefaultHandler());

			// Step 6: Start XSLT transformation and FOP processing
			transformer.transform(src, res);

			byte[] pdfBytes = out.toByteArray();
			return pdfBytes;

		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					log.warn("Error closing stream", e);
				}
			}

		}
	}

	private String writeImageFile(byte[] bytes) throws IOException {
		FileOutputStream fos = null;
		try {
			File imageFile = File.createTempFile("elksd", ".jpeg");
			fos = new FileOutputStream(imageFile);
			fos.write(bytes);
			fos.flush();
			return imageFile.getAbsolutePath().replace("\\", "/").replace("C:", "C://");
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e1) {
					log.warn("Error closing stream", e1);
				}
			}
		}
	}

	public byte[] elkPrint(ElkData elkData) throws Exception {
		log.debug(elkData);

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			// Step 3: Construct fop with desired output format
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);

			// Step 4: Setup JAXP using identity transformer
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(new StreamSource(FopExecutor.class
					.getResourceAsStream("/org/elksd/gui/fop/elk.xsl")));

			// Step 5: Setup input and output for XSLT transformation
			// Setup input stream
			Source src = new StreamSource(new ByteArrayInputStream(elkData.toXMLByteArray()));

			// Resulting SAX events (the generated FO) must be piped through to
			// FOP
			Result res = new SAXResult(fop.getDefaultHandler());

			// Step 6: Start XSLT transformation and FOP processing
			if (elkData.getPortrait() != null) {
				String imageFileName = writeImageFile(elkData.getPortrait());
				transformer.setParameter("imagePath", imageFileName);
			}
			transformer.transform(src, res);

			byte[] pdfBytes = out.toByteArray();
			return pdfBytes;

		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					log.warn("Error closing stream", e);
				}
			}

		}
	}

	public static class CustomPathResolver implements URIResolver {

		public Source resolve(String href, String base) throws TransformerException {
			return new StreamSource(getClass().getResourceAsStream(href));
		}

	}
}
