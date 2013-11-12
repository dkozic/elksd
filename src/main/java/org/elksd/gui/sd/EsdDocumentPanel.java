package org.elksd.gui.sd;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import org.elksd.gui.Messages;

public class EsdDocumentPanel extends JPanel {
	private JTextField txtStateIssuing;
	private JTextField txtCompetentAuthority;
	private JTextField txtAuthorityIssuing;
	private JTextField txtIssuingDate;
	private JTextField txtExpiryDate;
	private JTextField txtUnambiguousNumber;
	private JTextField txtSerialNumber;
	private JTextField txtRestrictionToChangeOwner;

	public JTextField getTxtCompetentAuthority() {
		return txtCompetentAuthority;
	}

	public JTextField getTxtStateIssuing() {
		return txtStateIssuing;
	}

	public JTextField getTxtAuthorityIssuing() {
		return txtAuthorityIssuing;
	}

	public JTextField getTxtIssuingDate() {
		return txtIssuingDate;
	}

	public JTextField getTxtExpiryDate() {
		return txtExpiryDate;
	}

	public JTextField getTxtUnambiguousNumber() {
		return txtUnambiguousNumber;
	}

	public JTextField getTxtSerialNumber() {
		return txtSerialNumber;
	}

	public JTextField getTxtRestrictionToChangeOwner() {
		return txtRestrictionToChangeOwner;
	}

	public EsdDocumentPanel() {
		setLayout(null);

		JLabel lblStateIssuing = new JLabel(
				Messages.getString("EsdDocumentPanel.lblStateIssuing.text")); //$NON-NLS-1$
		lblStateIssuing.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStateIssuing.setBounds(10, 10, 150, 20);
		add(lblStateIssuing);

		txtStateIssuing = new JTextField();
		txtStateIssuing.setEditable(false);
		txtStateIssuing.setBounds(165, 10, 250, 20);
		add(txtStateIssuing);
		txtStateIssuing.setColumns(10);

		JLabel lblCompetentAuthority = new JLabel(
				Messages.getString("EsdDocumentPanel.lblCompetentAuthority.text")); //$NON-NLS-1$
		lblCompetentAuthority.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCompetentAuthority.setBounds(10, 60, 150, 20);
		add(lblCompetentAuthority);

		txtCompetentAuthority = new JTextField();
		txtCompetentAuthority.setEditable(false);
		txtCompetentAuthority.setBounds(165, 60, 250, 20);
		add(txtCompetentAuthority);
		txtCompetentAuthority.setColumns(10);

		JLabel lblAuthorityIssuing = new JLabel(
				Messages.getString("EsdDocumentPanel.lblAuthorityIssuing.text")); //$NON-NLS-1$
		lblAuthorityIssuing.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAuthorityIssuing.setBounds(10, 35, 150, 20);
		add(lblAuthorityIssuing);

		txtAuthorityIssuing = new JTextField();
		txtAuthorityIssuing.setEditable(false);
		txtAuthorityIssuing.setBounds(165, 35, 250, 20);
		add(txtAuthorityIssuing);
		txtAuthorityIssuing.setColumns(10);

		JLabel lblIssuingDate = new JLabel(
				Messages.getString("EsdDocumentPanel.lblIssuingDate.text")); //$NON-NLS-1$
		lblIssuingDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIssuingDate.setBounds(10, 85, 150, 20);
		add(lblIssuingDate);

		txtIssuingDate = new JTextField();
		txtIssuingDate.setEditable(false);
		txtIssuingDate.setBounds(165, 85, 100, 20);
		add(txtIssuingDate);
		txtIssuingDate.setColumns(10);

		JLabel lblExpiryDate = new JLabel(
				Messages.getString("EsdDocumentPanel.lblExpiryDate.text"));
		lblExpiryDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblExpiryDate.setBounds(270, 85, 55, 20);
		add(lblExpiryDate);

		txtExpiryDate = new JTextField();
		txtExpiryDate.setEditable(false);
		txtExpiryDate.setBounds(330, 85, 85, 20);
		add(txtExpiryDate);
		txtExpiryDate.setColumns(10);

		JLabel lblUnambiguousNumber = new JLabel(
				Messages.getString("EsdDocumentPanel.lblUnambiguousNumber.text"));
		lblUnambiguousNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUnambiguousNumber.setBounds(10, 135, 150, 20);
		add(lblUnambiguousNumber);

		txtUnambiguousNumber = new JTextField();
		txtUnambiguousNumber.setEditable(false);
		txtUnambiguousNumber.setBounds(165, 135, 250, 20);
		add(txtUnambiguousNumber);
		txtUnambiguousNumber.setColumns(10);

		JLabel lblSerialNumber = new JLabel(
				Messages.getString("EsdDocumentPanel.lblSerialNumber.text"));
		lblSerialNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSerialNumber.setBounds(10, 160, 150, 20);
		add(lblSerialNumber);

		txtSerialNumber = new JTextField();
		txtSerialNumber.setEditable(false);
		txtSerialNumber.setBounds(165, 160, 250, 20);
		add(txtSerialNumber);
		txtSerialNumber.setColumns(10);

		JLabel lblRestrictionToChangeOwner = new JLabel(
				Messages.getString("EsdDocumentPanel.lblRestrictionToChangeOwner.text"));
		lblRestrictionToChangeOwner.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRestrictionToChangeOwner.setBounds(10, 110, 150, 20);
		add(lblRestrictionToChangeOwner);

		txtRestrictionToChangeOwner = new JTextField();
		txtRestrictionToChangeOwner.setEditable(false);
		txtRestrictionToChangeOwner.setBounds(165, 110, 250, 20);
		add(txtRestrictionToChangeOwner);
		txtRestrictionToChangeOwner.setColumns(10);

	}
}
