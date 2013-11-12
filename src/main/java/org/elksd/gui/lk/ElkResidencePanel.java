package org.elksd.gui.lk;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.elksd.gui.Messages;

public class ElkResidencePanel extends JPanel {

	private JTextField txtState;
	private JTextField txtCommunity;
	private JTextField txtPlace;
	private JTextField txtStreet;
	private JTextField txtHouseNumber;
	private JTextField txtHouseLetter;
	private JTextField txtEntrance;
	private JTextField txtFloor;
	private JTextField txtApartmentNumber;

	public JTextField getTxtState() {
		return txtState;
	}

	public JTextField getTxtCommunity() {
		return txtCommunity;
	}

	public JTextField getTxtPlace() {
		return txtPlace;
	}

	public JTextField getTxtStreet() {
		return txtStreet;
	}

	public JTextField getTxtHouseNumber() {
		return txtHouseNumber;
	}

	public JTextField getTxtHouseLetter() {
		return txtHouseLetter;
	}

	public JTextField getTxtEntrance() {
		return txtEntrance;
	}

	public JTextField getTxtFloor() {
		return txtFloor;
	}

	public JTextField getTxtApartmentNumber() {
		return txtApartmentNumber;
	}

	public ElkResidencePanel() {
		setLayout(null);

		JLabel lblState = new JLabel(
				Messages.getString("ElkResidencePanel.lblState.text")); //$NON-NLS-1$
		lblState.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblState.setBounds(10, 10, 150, 20);
		add(lblState);

		txtState = new JTextField();
		txtState.setEditable(false);
		txtState.setBounds(165, 10, 250, 20);
		add(txtState);
		txtState.setColumns(10);

		JLabel lblCommunity = new JLabel(
				Messages.getString("ElkResidencePanel.lblCommunity.text")); //$NON-NLS-1$
		lblCommunity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommunity.setBounds(10, 40, 150, 20);
		add(lblCommunity);

		txtCommunity = new JTextField();
		txtCommunity.setEditable(false);
		txtCommunity.setBounds(165, 40, 250, 20);
		add(txtCommunity);
		txtCommunity.setColumns(10);

		JLabel lblPlace = new JLabel(
				Messages.getString("ElkResidencePanel.lblPlace.text")); //$NON-NLS-1$
		lblPlace.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlace.setBounds(10, 70, 150, 20);
		add(lblPlace);

		txtPlace = new JTextField();
		txtPlace.setEditable(false);
		txtPlace.setBounds(165, 70, 250, 20);
		add(txtPlace);
		txtPlace.setColumns(10);

		JLabel lblStreet = new JLabel(
				Messages.getString("ElkResidencePanel.lblStreet.text")); //$NON-NLS-1$
		lblStreet.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStreet.setBounds(10, 100, 150, 20);
		add(lblStreet);

		txtStreet = new JTextField();
		txtStreet.setEditable(false);
		txtStreet.setBounds(165, 100, 250, 20);
		add(txtStreet);
		txtStreet.setColumns(10);

		JLabel lblHouseNumber = new JLabel(
				Messages.getString("ElkResidencePanel.lblHouseNumber.text")); //$NON-NLS-1$
		lblHouseNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHouseNumber.setBounds(10, 130, 150, 20);
		add(lblHouseNumber);

		txtHouseNumber = new JTextField();
		txtHouseNumber.setEditable(false);
		txtHouseNumber.setBounds(165, 130, 250, 20);
		add(txtHouseNumber);
		txtHouseNumber.setColumns(10);

		JLabel lblHouseLetter = new JLabel(
				Messages.getString("ElkResidencePanel.lblHouseLetter.text")); //$NON-NLS-1$
		lblHouseLetter.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHouseLetter.setBounds(10, 160, 150, 20);
		add(lblHouseLetter);

		txtHouseLetter = new JTextField();
		txtHouseLetter.setEditable(false);
		txtHouseLetter.setBounds(165, 160, 250, 20);
		add(txtHouseLetter);
		txtHouseLetter.setColumns(10);

		JLabel lblEntrance = new JLabel(
				Messages.getString("ElkResidencePanel.lblEntrance.text")); //$NON-NLS-1$
		lblEntrance.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEntrance.setBounds(10, 190, 150, 20);
		add(lblEntrance);

		txtEntrance = new JTextField();
		txtEntrance.setEditable(false);
		txtEntrance.setBounds(165, 190, 250, 20);
		add(txtEntrance);
		txtEntrance.setColumns(10);

		JLabel lblFloor = new JLabel(
				Messages.getString("ElkResidencePanel.lblFloor.text")); //$NON-NLS-1$
		lblFloor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFloor.setBounds(10, 220, 150, 20);
		add(lblFloor);

		txtFloor = new JTextField();
		txtFloor.setEditable(false);
		txtFloor.setBounds(165, 220, 250, 20);
		add(txtFloor);
		txtFloor.setColumns(10);

		JLabel lblApartmentNumber = new JLabel(
				Messages.getString("ElkResidencePanel.lblApartmentNumber.text")); //$NON-NLS-1$
		lblApartmentNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApartmentNumber.setBounds(10, 250, 150, 20);
		add(lblApartmentNumber);

		txtApartmentNumber = new JTextField();
		txtApartmentNumber.setEditable(false);
		txtApartmentNumber.setBounds(165, 250, 250, 20);
		add(txtApartmentNumber);
		txtApartmentNumber.setColumns(10);

	}

}
