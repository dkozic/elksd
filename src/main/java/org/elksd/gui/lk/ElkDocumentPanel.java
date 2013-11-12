package org.elksd.gui.lk;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.elksd.gui.Messages;

public class ElkDocumentPanel extends JPanel {
	private JTextField txtDocRegNo;
	private JTextField txtIssuingDate;
	private JTextField txtExpiryDate;
	private JTextField txtIssuingAuthority;

	public JTextField getTxtDocRegNo() {
		return txtDocRegNo;
	}

	public JTextField getTxtExpiryDate() {
		return txtExpiryDate;
	}

	public JTextField getTxtIssuingAuthority() {
		return txtIssuingAuthority;
	}

	public JTextField getTxtIssuingDate() {
		return txtIssuingDate;
	}

	public ElkDocumentPanel() {
		setLayout(null);

		JLabel lblDocRegNo = new JLabel(
				Messages.getString("ElkDocumentPanel.lblDocRegNo.text")); //$NON-NLS-1$
		lblDocRegNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDocRegNo.setBounds(10, 10, 150, 20);
		add(lblDocRegNo);

		txtDocRegNo = new JTextField();
		txtDocRegNo.setEditable(false);
		txtDocRegNo.setBounds(165, 10, 250, 20);
		add(txtDocRegNo);
		txtDocRegNo.setColumns(10);

		JLabel lblIssuingDate = new JLabel(
				Messages.getString("ElkDocumentPanel.lblIssuingDate.text")); //$NON-NLS-1$
		lblIssuingDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIssuingDate.setBounds(10, 40, 150, 20);
		add(lblIssuingDate);

		txtIssuingDate = new JTextField();
		txtIssuingDate.setEditable(false);
		txtIssuingDate.setBounds(165, 40, 250, 20);
		add(txtIssuingDate);
		txtIssuingDate.setColumns(10);

		JLabel lblExpiryDate = new JLabel(
				Messages.getString("ElkDocumentPanel.lblExpiryDate.text")); //$NON-NLS-1$
		lblExpiryDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblExpiryDate.setBounds(10, 70, 150, 20);
		add(lblExpiryDate);

		txtExpiryDate = new JTextField();
		txtExpiryDate.setEditable(false);
		txtExpiryDate.setBounds(165, 70, 250, 20);
		add(txtExpiryDate);
		txtExpiryDate.setColumns(10);

		JLabel lblIssuingAuthority = new JLabel(
				Messages.getString("ElkDocumentPanel.lblIssuingAuthority.text")); //$NON-NLS-1$
		lblIssuingAuthority.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIssuingAuthority.setBounds(10, 100, 150, 20);
		add(lblIssuingAuthority);

		txtIssuingAuthority = new JTextField();
		txtIssuingAuthority.setEditable(false);
		txtIssuingAuthority.setBounds(165, 100, 250, 20);
		add(txtIssuingAuthority);
		txtIssuingAuthority.setColumns(10);

	}
}
