package org.elksd.gui.lk;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;
import org.elksd.gui.Messages;
import org.elksd.gui.fop.FopExecutor;
import org.elksd.gui.fop.PdfViewer;
import org.elksd.lk.ElkData;

public class ElkFrame extends JFrame {

	private static Logger log = Logger.getLogger(ElkFrame.class);

	private ElkData elkData;
	private JPanel contentPane;
	private ElkPanel elkPanel;
	private JButton btnPrint;

	public ElkFrame() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				ElkFrame.class.getResource("/org/elksd/gui/images/vcard.png")));
		setTitle(Messages.getString("ElkFrame.title"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 410);

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

		btnPrint = new JButton();
		btnPrint.setPreferredSize(new Dimension(50, 50));
		btnPrint.setMinimumSize(new Dimension(50, 50));
		btnPrint.setMaximumSize(new Dimension(50, 50));
		btnPrint.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPrint.setMnemonic('P');
		btnPrint.setToolTipText(Messages
				.getString("ElkFrame.btnPrint.toolTipText")); //$NON-NLS-1$
		btnPrint.setIcon(new ImageIcon(ElkFrame.class
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

		elkPanel = new ElkPanel();
		contentPane.add(elkPanel, BorderLayout.CENTER);
	}

	public void setElkData(ElkData elkData) throws IOException {
		this.elkData = elkData;
		elkPanel.setElkData(elkData);
	}

	private void print() throws Exception {
		FopExecutor e = FopExecutor.getInstance();
		byte[] pdfBytes = e.elkPrint(elkData);
		PdfViewer pdfViewer = new PdfViewer(pdfBytes);
		pdfViewer.show();

	}

	private void handleException(Exception e) {
		log.error("Error in ElkFrame", e);
		JOptionPane.showMessageDialog(this, e.getMessage(),
				Messages.getString("ElkFrame.exception.title"),
				JOptionPane.ERROR_MESSAGE);
	}

}
