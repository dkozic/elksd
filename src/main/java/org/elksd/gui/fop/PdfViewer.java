package org.elksd.gui.fop;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

public class PdfViewer {

	private static Logger log = Logger.getLogger(PdfViewer.class);

	private byte[] pdfBytes;

	public PdfViewer(byte[] pdfBytes) {
		this.pdfBytes = pdfBytes;
	}

	public void show() throws IOException {

		File pdfFile = File.createTempFile("esd", ".pdf");
		FileOutputStream fos = null;
		try {

			fos = new FileOutputStream(pdfFile);
			fos.write(pdfBytes);

		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					log.warn("Error closing stream", e);
				}
			}
		}
		if (pdfFile.exists()) {

			if (Desktop.isDesktopSupported()) {
				Desktop.getDesktop().open(pdfFile);
			} else {
				throw new RuntimeException("Awt Desktop is not supported!");
			}

		} else {
			throw new RuntimeException("File is not exists!");
		}
	}

}
