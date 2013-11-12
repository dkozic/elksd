package org.elksd.gui.sd;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.elksd.gui.Messages;

public class EsdPersonalPanel extends JPanel {

	private JTextField txtHolderSurnameOrBusinessName;
	private JTextField txtHolderName;
	private JTextField txtHolderAddress;

	private JTextField txtOwnerPersonalNo;
	private JTextField txtOwnerSurnameOrBusinessName;
	private JTextField txtOwnerName;
	private JTextField txtOwnerAddress;

	private JTextField txtUserPersonalNo;
	private JTextField txtUserSurnameOrBusinessName;
	private JTextField txtUserName;
	private JTextField txtUserAddress;

	public JTextField getTxtHolderSurnameOrBusinessName() {
		return txtHolderSurnameOrBusinessName;
	}

	public JTextField getTxtHolderName() {
		return txtHolderName;
	}

	public JTextField getTxtHolderAddress() {
		return txtHolderAddress;
	}

	public JTextField getTxtOwnerPersonalNo() {
		return txtOwnerPersonalNo;
	}

	public JTextField getTxtOwnerSurnameOrBusinessName() {
		return txtOwnerSurnameOrBusinessName;
	}

	public JTextField getTxtOwnerName() {
		return txtOwnerName;
	}

	public JTextField getTxtOwnerAddress() {
		return txtOwnerAddress;
	}

	public JTextField getTxtUserPersonalNo() {
		return txtUserPersonalNo;
	}

	public JTextField getTxtUserSurnameOrBusinessName() {
		return txtUserSurnameOrBusinessName;
	}

	public JTextField getTxtUserName() {
		return txtUserName;
	}

	public JTextField getTxtUserAddress() {
		return txtUserAddress;
	}

	public EsdPersonalPanel() {
		setLayout(null);

		JLabel lblHolderSurnameOrBusinessName = new JLabel(
				Messages.getString("EsdPersonalPanel.lblHolderSurnameOrBusinessName.text")); //$NON-NLS-1$
		lblHolderSurnameOrBusinessName
				.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHolderSurnameOrBusinessName.setBounds(10, 10, 150, 20);
		add(lblHolderSurnameOrBusinessName);

		txtHolderSurnameOrBusinessName = new JTextField();
		txtHolderSurnameOrBusinessName.setEditable(false);
		txtHolderSurnameOrBusinessName.setBounds(165, 10, 250, 20);
		txtHolderSurnameOrBusinessName.setColumns(10);
		add(txtHolderSurnameOrBusinessName);

		JLabel lblHolderName = new JLabel(
				Messages.getString("EsdPersonalPanel.lblHolderName.text")); //$NON-NLS-1$
		lblHolderName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHolderName.setBounds(10, 35, 150, 20);
		add(lblHolderName);

		txtHolderName = new JTextField();
		txtHolderName.setEditable(false);
		txtHolderName.setBounds(165, 35, 250, 20);
		txtHolderName.setColumns(10);
		add(txtHolderName);

		JLabel lblHolderAddress = new JLabel(
				Messages.getString("EsdPersonalPanel.lblHolderAddress.text")); //$NON-NLS-1$
		lblHolderAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHolderAddress.setBounds(10, 60, 150, 20);
		add(lblHolderAddress);

		txtHolderAddress = new JTextField();
		txtHolderAddress.setEditable(false);
		txtHolderAddress.setBounds(165, 60, 250, 20);
		txtHolderAddress.setColumns(10);
		add(txtHolderAddress);

		JLabel lblOwnerPersonalNo = new JLabel(
				Messages.getString("EsdPersonalPanel.lblOwnerPersonalNo.text")); //$NON-NLS-1$
		lblOwnerPersonalNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOwnerPersonalNo.setBounds(10, 135, 150, 20);
		add(lblOwnerPersonalNo);

		txtOwnerPersonalNo = new JTextField();
		txtOwnerPersonalNo.setEditable(false);
		txtOwnerPersonalNo.setBounds(165, 135, 250, 20);
		txtOwnerPersonalNo.setColumns(10);
		add(txtOwnerPersonalNo);

		JLabel lblOwnerSurnameOrBusinessName = new JLabel(
				Messages.getString("EsdPersonalPanel.lblOwnerSurnameOrBusinessName.text")); //$NON-NLS-1$
		lblOwnerSurnameOrBusinessName
				.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOwnerSurnameOrBusinessName.setBounds(10, 85, 150, 20);
		add(lblOwnerSurnameOrBusinessName);

		txtOwnerSurnameOrBusinessName = new JTextField();
		txtOwnerSurnameOrBusinessName.setEditable(false);
		txtOwnerSurnameOrBusinessName.setBounds(165, 85, 250, 20);
		txtOwnerSurnameOrBusinessName.setColumns(10);
		add(txtOwnerSurnameOrBusinessName);

		JLabel lblOwnerName = new JLabel(
				Messages.getString("EsdPersonalPanel.lblOwnerName.text")); //$NON-NLS-1$
		lblOwnerName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOwnerName.setBounds(10, 110, 150, 20);
		add(lblOwnerName);

		txtOwnerName = new JTextField();
		txtOwnerName.setEditable(false);
		txtOwnerName.setBounds(165, 110, 250, 20);
		txtOwnerName.setColumns(10);
		add(txtOwnerName);

		JLabel lblOwnerAddress = new JLabel(
				Messages.getString("EsdPersonalPanel.lblOwnerAddress.text")); //$NON-NLS-1$
		lblOwnerAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOwnerAddress.setBounds(10, 160, 150, 20);
		add(lblOwnerAddress);

		txtOwnerAddress = new JTextField();
		txtOwnerAddress.setEditable(false);
		txtOwnerAddress.setBounds(165, 160, 250, 20);
		txtOwnerAddress.setColumns(10);
		add(txtOwnerAddress);

		JLabel lblUserPersonalNo = new JLabel(
				Messages.getString("EsdPersonalPanel.lblUserPersonalNo.text")); //$NON-NLS-1$
		lblUserPersonalNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUserPersonalNo.setBounds(10, 235, 150, 20);
		add(lblUserPersonalNo);

		txtUserPersonalNo = new JTextField();
		txtUserPersonalNo.setEditable(false);
		txtUserPersonalNo.setBounds(165, 235, 250, 20);
		txtUserPersonalNo.setColumns(10);
		add(txtUserPersonalNo);

		JLabel lblUserSurnameOrBusinessName = new JLabel(
				Messages.getString("EsdPersonalPanel.lblUserSurnameOrBusinessName.text")); //$NON-NLS-1$
		lblUserSurnameOrBusinessName
				.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUserSurnameOrBusinessName.setBounds(10, 185, 150, 20);
		add(lblUserSurnameOrBusinessName);

		txtUserSurnameOrBusinessName = new JTextField();
		txtUserSurnameOrBusinessName.setEditable(false);
		txtUserSurnameOrBusinessName.setBounds(165, 185, 250, 20);
		txtUserSurnameOrBusinessName.setColumns(10);
		add(txtUserSurnameOrBusinessName);

		JLabel lblUserName = new JLabel(
				Messages.getString("EsdPersonalPanel.lblUserName.text")); //$NON-NLS-1$
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUserName.setBounds(10, 210, 150, 20);
		add(lblUserName);

		txtUserName = new JTextField();
		txtUserName.setEditable(false);
		txtUserName.setBounds(165, 210, 250, 20);
		txtUserName.setColumns(10);
		add(txtUserName);

		JLabel lblUserAddress = new JLabel(
				Messages.getString("EsdPersonalPanel.lblUserAddress.text")); //$NON-NLS-1$
		lblUserAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUserAddress.setBounds(10, 260, 150, 20);
		add(lblUserAddress);

		txtUserAddress = new JTextField();
		txtUserAddress.setEditable(false);
		txtUserAddress.setBounds(165, 260, 250, 20);
		txtUserAddress.setColumns(10);
		add(txtUserAddress);

	}

}
