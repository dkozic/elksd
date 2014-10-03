package org.elksd.gui.sd;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.elksd.gui.Messages;
import org.elksd.gui.fop.FopExecutor;
import org.elksd.gui.fop.PdfViewer;
import org.elksd.sd.EsdData;

public class EsdFrame extends JFrame {

	private static Logger log = Logger.getLogger(EsdFrame.class);

	private EsdData esdData;
	private JPanel contentPane;
	private EsdPanel esdPanel;
	private JButton btnPrint;
	private JButton btnSave;

	public EsdFrame() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				EsdFrame.class.getResource("/org/elksd/gui/images/vcard.png")));
		setTitle(Messages.getString("EsdFrame.title"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 520);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel headerPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) headerPanel.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(3);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		headerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(headerPanel, BorderLayout.NORTH);

		//btnPrint = new JButton(Messages.getString("EsdFrame.btnPrint.text")); //$NON-NLS-1$
		btnPrint = new JButton();
		btnPrint.setPreferredSize(new Dimension(50, 50));
		btnPrint.setMinimumSize(new Dimension(50, 50));
		btnPrint.setMaximumSize(new Dimension(50, 50));
		btnPrint.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPrint.setMnemonic('P');
		btnPrint.setToolTipText(Messages
				.getString("EsdFrame.btnPrint.toolTipText")); //$NON-NLS-1$
		btnPrint.setIcon(new ImageIcon(EsdFrame.class
				.getResource("/org/elksd/gui/images/printer.png")));
		btnPrint.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					print();
				} catch (Exception ex) {
					handleException(ex);
				}
			}
		});
		headerPanel.add(btnPrint);

		btnSave = new JButton();
		btnSave.setPreferredSize(new Dimension(50, 50));
		btnSave.setMinimumSize(new Dimension(50, 50));
		btnSave.setMaximumSize(new Dimension(50, 50));
		btnSave.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSave.setMnemonic('S');
		btnSave.setToolTipText(Messages
				.getString("EsdFrame.btnSave.toolTipText")); //$NON-NLS-1$
		btnSave.setIcon(new ImageIcon(EsdFrame.class
				.getResource("/org/elksd/gui/images/disk.png")));
		btnSave.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					save();
				} catch (Exception ex) {
					handleException(ex);
				}
			}
		});
		headerPanel.add(btnSave);

		esdPanel = new EsdPanel();
		contentPane.add(esdPanel, BorderLayout.CENTER);
	}

	public void setEsdData(EsdData esdData) {
		this.esdData = esdData;
		esdPanel.setEsdData(esdData);
	}

	private void print() throws Exception {
		FopExecutor e = FopExecutor.getInstance();
		byte[] pdfBytes = e.esdPrint(esdData);
		PdfViewer pdfViewer = new PdfViewer(pdfBytes);
		pdfViewer.show();

	}

	private void save() throws Exception {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer(new StreamSource(
				EsdFrame.class
						.getResourceAsStream("/org/elksd/gui/xml/esd.xsl")));

		Source src = new StreamSource(new ByteArrayInputStream(getXMLSource(
				esdData).toByteArray()));

		Result res = new StreamResult(System.out);

		transformer.transform(src, res);

	}

	private ByteArrayOutputStream getXMLSource(EsdData data) throws Exception {
		JAXBContext context;

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		context = JAXBContext.newInstance(EsdData.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(data, outStream);
		return outStream;

	}

	private void handleException(Exception e) {
		log.error("Error in EsdFrame", e);
		JOptionPane.showMessageDialog(this, e.getMessage(),
				Messages.getString("EsdFrame.exception.title"),
				JOptionPane.ERROR_MESSAGE);
	}

}
