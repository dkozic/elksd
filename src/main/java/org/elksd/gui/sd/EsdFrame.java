package org.elksd.gui.sd;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import org.elksd.sd.EsdData;

public class EsdFrame extends JFrame {

	private static Logger log = Logger.getLogger(EsdFrame.class);

	private EsdData esdData;
	private JPanel contentPane;
	private EsdPanel esdPanel;
	private JButton btnPrint;

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

	private void handleException(Exception e) {
		log.error("Error in EsdFrame", e);
		JOptionPane.showMessageDialog(this, e.getMessage(),
				Messages.getString("EsdFrame.exception.title"),
				JOptionPane.ERROR_MESSAGE);
	}

}
