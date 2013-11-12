package org.elksd.gui.lk;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.elksd.gui.Messages;

public class ElkPersonalPanel extends JPanel {

	private JTextField txtPersonalNumber;
	private JTextField txtSurname;
	private JTextField txtGivenName;
	private JTextField txtParentGivenName;
	private JTextField txtSex;
	private JTextField txtPlaceOfBirth;
	private JTextField txtStateOfBirth;
	private JTextField txtDateOfBirth;
	private JTextField txtCommunityOfBirth;

	public JTextField getTxtPersonalNumber() {
		return txtPersonalNumber;
	}

	public JTextField getTxtSurname() {
		return txtSurname;
	}

	public JTextField getTxtGivenName() {
		return txtGivenName;
	}

	public JTextField getTxtParentGivenName() {
		return txtParentGivenName;
	}

	public JTextField getTxtSex() {
		return txtSex;
	}

	public JTextField getTxtPlaceOfBirth() {
		return txtPlaceOfBirth;
	}

	public JTextField getTxtStateOfBirth() {
		return txtStateOfBirth;
	}

	public JTextField getTxtDateOfBirth() {
		return txtDateOfBirth;
	}

	public JTextField getTxtCommunityOfBirth() {
		return txtCommunityOfBirth;
	}

	public ElkPersonalPanel() {
		setLayout(null);

		setPreferredSize(new Dimension(430, 250));

		JLabel lblSurname = new JLabel(
				Messages.getString("ElkPersonalPanel.lblSurname.text")); //$NON-NLS-1$
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSurname.setBounds(10, 10, 150, 20);
		add(lblSurname);

		txtSurname = new JTextField();
		txtSurname.setEditable(false);
		txtSurname.setBounds(165, 10, 250, 20);
		add(txtSurname);
		txtSurname.setColumns(10);

		JLabel lblGivenName = new JLabel(
				Messages.getString("ElkPersonalPanel.lblGivenName.text")); //$NON-NLS-1$
		lblGivenName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGivenName.setBounds(10, 40, 150, 20);
		add(lblGivenName);

		txtGivenName = new JTextField();
		txtGivenName.setEditable(false);
		txtGivenName.setBounds(165, 40, 250, 20);
		add(txtGivenName);
		txtGivenName.setColumns(10);

		JLabel lblParentGivenName = new JLabel(
				Messages.getString("ElkPersonalPanel.lblParentGivenName.text")); //$NON-NLS-1$
		lblParentGivenName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblParentGivenName.setBounds(10, 70, 150, 20);
		add(lblParentGivenName);

		txtParentGivenName = new JTextField();
		txtParentGivenName.setEditable(false);
		txtParentGivenName.setBounds(165, 70, 250, 20);
		add(txtParentGivenName);
		txtParentGivenName.setColumns(10);

		JLabel lblDateOfBirth = new JLabel(
				Messages.getString("ElkPersonalPanel.lblDateOfBirth.text")); //$NON-NLS-1$
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDateOfBirth.setBounds(10, 100, 150, 20);
		add(lblDateOfBirth);

		txtDateOfBirth = new JTextField();
		txtDateOfBirth.setEditable(false);
		txtDateOfBirth.setBounds(165, 100, 250, 20);
		add(txtDateOfBirth);
		txtDateOfBirth.setColumns(10);

		JLabel lblPlaceOfBirth = new JLabel(
				Messages.getString("ElkPersonalPanel.lblPlaceOfBirth.text")); //$NON-NLS-1$
		lblPlaceOfBirth.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlaceOfBirth.setBounds(10, 130, 150, 20);
		add(lblPlaceOfBirth);

		txtPlaceOfBirth = new JTextField();
		txtPlaceOfBirth.setEditable(false);
		txtPlaceOfBirth.setBounds(165, 130, 250, 20);
		add(txtPlaceOfBirth);
		txtPlaceOfBirth.setColumns(10);

		JLabel lblCommunityOfBirth = new JLabel(
				Messages.getString("ElkPersonalPanel.lblCommunityOfBirth.text")); //$NON-NLS-1$
		lblCommunityOfBirth.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommunityOfBirth.setBounds(10, 160, 150, 20);
		add(lblCommunityOfBirth);

		txtCommunityOfBirth = new JTextField();
		txtCommunityOfBirth.setEditable(false);
		txtCommunityOfBirth.setBounds(165, 160, 250, 20);
		add(txtCommunityOfBirth);
		txtCommunityOfBirth.setColumns(10);

		JLabel lblStateOfBirth = new JLabel(
				Messages.getString("ElkPersonalPanel.lblStateOfBirth.text")); //$NON-NLS-1$
		lblStateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStateOfBirth.setBounds(10, 190, 150, 20);
		add(lblStateOfBirth);

		txtStateOfBirth = new JTextField();
		txtStateOfBirth.setEditable(false);
		txtStateOfBirth.setBounds(165, 190, 250, 20);
		add(txtStateOfBirth);
		txtStateOfBirth.setColumns(10);

		JLabel lblSex = new JLabel(
				Messages.getString("ElkPersonalPanel.lblSex.text")); //$NON-NLS-1$
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSex.setBounds(10, 220, 150, 20);
		add(lblSex);

		txtSex = new JTextField();
		txtSex.setEditable(false);
		txtSex.setBounds(165, 220, 250, 20);
		add(txtSex);
		txtSex.setColumns(10);

		JLabel lblPersonalNumber = new JLabel(
				Messages.getString("ElkPersonalPanel.lblPersonalNumber.text")); //$NON-NLS-1$
		lblPersonalNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPersonalNumber.setBounds(10, 250, 150, 20);
		add(lblPersonalNumber);

		txtPersonalNumber = new JTextField();
		txtPersonalNumber.setEditable(false);
		txtPersonalNumber.setBounds(165, 250, 250, 20);
		add(txtPersonalNumber);
		txtPersonalNumber.setColumns(10);

	}

}
