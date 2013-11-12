package org.elksd.gui.sd;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.elksd.gui.Messages;

public class EsdVehiclePanel extends JPanel {

	private JTextField txtRegistrationNumberOfVehicle;
	private JTextField txtYearOfProduction;
	private JTextField txtDateOfFirstRegistration;
	private JTextField txtVehicleMake;
	private JTextField txtVehicleType;
	private JTextField txtCommercialDescription;
	private JTextField txtVehicleIDNumber;
	private JTextField txtMaximumNetPower;
	private JTextField txtEngineCapacity;
	private JTextField txtTypeOfFuel;
	private JTextField txtPowerWeightRatio;
	private JTextField txtVehicleMass;
	private JTextField txtMaximumPermissibleLadenMass;
	private JTextField txtTypeApprovalNumber;
	private JTextField txtNumberOfSeats;
	private JTextField txtNumberOfStandingPlaces;
	private JTextField txtEngineIDNumber;
	private JTextField txtNumberOfAxles;
	private JTextField txtVehicleCategory;
	private JTextField txtColourOfVehicle;
	private JTextField txtVehicleLoad;

	public JTextField getTxtDateOfFirstRegistration() {
		return txtDateOfFirstRegistration;
	}

	public JTextField getTxtRegistrationNumberOfVehicle() {
		return txtRegistrationNumberOfVehicle;
	}

	public JTextField getTxtYearOfProduction() {
		return txtYearOfProduction;
	}

	public JTextField getTxtVehicleMake() {
		return txtVehicleMake;
	}

	public JTextField getTxtVehicleType() {
		return txtVehicleType;
	}

	public JTextField getTxtCommercialDescription() {
		return txtCommercialDescription;
	}

	public JTextField getTxtVehicleIDNumber() {
		return txtVehicleIDNumber;
	}

	public JTextField getTxtMaximumNetPower() {
		return txtMaximumNetPower;
	}

	public JTextField getTxtEngineCapacity() {
		return txtEngineCapacity;
	}

	public JTextField getTxtTypeOfFuel() {
		return txtTypeOfFuel;
	}

	public JTextField getTxtPowerWeightRatio() {
		return txtPowerWeightRatio;
	}

	public JTextField getTxtVehicleMass() {
		return txtVehicleMass;
	}

	public JTextField getTxtMaximumPermissibleLadenMass() {
		return txtMaximumPermissibleLadenMass;
	}

	public JTextField getTxtTypeApprovalNumber() {
		return txtTypeApprovalNumber;
	}

	public JTextField getTxtNumberOfSeats() {
		return txtNumberOfSeats;
	}

	public JTextField getTxtNumberOfStandingPlaces() {
		return txtNumberOfStandingPlaces;
	}

	public JTextField getTxtEngineIDNumber() {
		return txtEngineIDNumber;
	}

	public JTextField getTxtNumberOfAxles() {
		return txtNumberOfAxles;
	}

	public JTextField getTxtVehicleCategory() {
		return txtVehicleCategory;
	}

	public JTextField getTxtColourOfVehicle() {
		return txtColourOfVehicle;
	}

	public JTextField getTxtVehicleLoad() {
		return txtVehicleLoad;
	}

	public EsdVehiclePanel() {
		setLayout(null);

		JLabel lblDateOfFirstRegistration = new JLabel(
				Messages.getString("EsdVehiclePanel.lblDateOfFirstRegistration.text")); //$NON-NLS-1$
		lblDateOfFirstRegistration.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDateOfFirstRegistration.setBounds(10, 35, 150, 20);
		add(lblDateOfFirstRegistration);

		txtDateOfFirstRegistration = new JTextField();
		txtDateOfFirstRegistration.setEditable(false);
		txtDateOfFirstRegistration.setBounds(165, 35, 250, 20);
		txtDateOfFirstRegistration.setColumns(10);
		add(txtDateOfFirstRegistration);

		JLabel lblYearOfProduction = new JLabel(
				Messages.getString("EsdVehiclePanel.lblYearOfProduction.text")); //$NON-NLS-1$
		lblYearOfProduction.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblYearOfProduction.setBounds(10, 85, 150, 20);
		add(lblYearOfProduction);

		txtYearOfProduction = new JTextField();
		txtYearOfProduction.setEditable(false);
		txtYearOfProduction.setBounds(165, 85, 60, 20);
		txtYearOfProduction.setColumns(10);
		add(txtYearOfProduction);

		JLabel lblRegistrationNumberOfVehicle = new JLabel(
				Messages.getString("EsdVehiclePanel.lblRegistrationNumberOfVehicle.text")); //$NON-NLS-1$
		lblRegistrationNumberOfVehicle
				.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegistrationNumberOfVehicle.setBounds(10, 10, 150, 20);
		add(lblRegistrationNumberOfVehicle);

		txtRegistrationNumberOfVehicle = new JTextField();
		txtRegistrationNumberOfVehicle.setEditable(false);
		txtRegistrationNumberOfVehicle.setBounds(165, 10, 250, 20);
		txtRegistrationNumberOfVehicle.setColumns(10);
		add(txtRegistrationNumberOfVehicle);

		JLabel lblVehicleMake = new JLabel(
				Messages.getString("EsdVehiclePanel.lblVehicleMake.text")); //$NON-NLS-1$
		lblVehicleMake.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVehicleMake.setBounds(10, 60, 150, 20);
		add(lblVehicleMake);

		txtVehicleMake = new JTextField();
		txtVehicleMake.setEditable(false);
		txtVehicleMake.setBounds(165, 60, 105, 20);
		txtVehicleMake.setColumns(10);
		add(txtVehicleMake);

		JLabel lblVehicleType = new JLabel(
				Messages.getString("EsdVehiclePanel.lblVehicleType.text")); //$NON-NLS-1$
		lblVehicleType.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVehicleType.setBounds(230, 85, 40, 20);
		add(lblVehicleType);

		txtVehicleType = new JTextField();
		txtVehicleType.setEditable(false);
		txtVehicleType.setBounds(275, 85, 140, 20);
		txtVehicleType.setColumns(10);
		add(txtVehicleType);

		txtCommercialDescription = new JTextField();
		txtCommercialDescription.setEditable(false);
		txtCommercialDescription.setBounds(275, 60, 140, 20);
		txtCommercialDescription.setColumns(10);
		add(txtCommercialDescription);

		JLabel lblVehicleIDNumber = new JLabel(
				Messages.getString("EsdVehiclePanel.lblVehicleIDNumber.text")); //$NON-NLS-1$
		lblVehicleIDNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVehicleIDNumber.setBounds(10, 135, 150, 20);
		add(lblVehicleIDNumber);

		txtVehicleIDNumber = new JTextField();
		txtVehicleIDNumber.setEditable(false);
		txtVehicleIDNumber.setBounds(165, 135, 250, 20);
		txtVehicleIDNumber.setColumns(10);
		add(txtVehicleIDNumber);

		JLabel lblMaximumNetPower = new JLabel(
				Messages.getString("EsdVehiclePanel.lblMaximumNetPower.text")); //$NON-NLS-1$
		lblMaximumNetPower.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMaximumNetPower.setBounds(10, 185, 150, 20);
		add(lblMaximumNetPower);

		txtMaximumNetPower = new JTextField();
		txtMaximumNetPower.setEditable(false);
		txtMaximumNetPower.setBounds(165, 185, 80, 20);
		txtMaximumNetPower.setColumns(10);
		add(txtMaximumNetPower);

		JLabel lblEngineCapacity = new JLabel(
				Messages.getString("EsdVehiclePanel.lblEngineCapacity.text")); //$NON-NLS-1$
		lblEngineCapacity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEngineCapacity.setBounds(10, 210, 150, 20);
		add(lblEngineCapacity);

		txtEngineCapacity = new JTextField();
		txtEngineCapacity.setEditable(false);
		txtEngineCapacity.setBounds(165, 210, 80, 20);
		txtEngineCapacity.setColumns(10);
		add(txtEngineCapacity);

		JLabel lblTypeOfFuel = new JLabel(
				Messages.getString("EsdVehiclePanel.lblTypeOfFuel.text")); //$NON-NLS-1$
		lblTypeOfFuel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTypeOfFuel.setBounds(10, 360, 150, 20);
		add(lblTypeOfFuel);

		txtTypeOfFuel = new JTextField();
		txtTypeOfFuel.setEditable(false);
		txtTypeOfFuel.setBounds(165, 360, 250, 20);
		txtTypeOfFuel.setColumns(10);
		add(txtTypeOfFuel);

		JLabel lblPowerWeightRatio = new JLabel(
				Messages.getString("EsdVehiclePanel.lblPowerWeightRatio.text")); //$NON-NLS-1$
		lblPowerWeightRatio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPowerWeightRatio.setBounds(10, 235, 150, 20);
		add(lblPowerWeightRatio);

		txtPowerWeightRatio = new JTextField();
		txtPowerWeightRatio.setEditable(false);
		txtPowerWeightRatio.setBounds(165, 235, 80, 20);
		txtPowerWeightRatio.setColumns(10);
		add(txtPowerWeightRatio);

		JLabel lblVehicleMass = new JLabel(
				Messages.getString("EsdVehiclePanel.lblVehicleMass.text")); //$NON-NLS-1$
		lblVehicleMass.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVehicleMass.setBounds(250, 185, 80, 20);
		add(lblVehicleMass);

		txtVehicleMass = new JTextField();
		txtVehicleMass.setEditable(false);
		txtVehicleMass.setBounds(335, 185, 80, 20);
		txtVehicleMass.setColumns(10);
		add(txtVehicleMass);

		JLabel lblMaximumPermissibleLadenMass = new JLabel(
				Messages.getString("EsdVehiclePanel.lblMaximumPermissibleLadenMass.text")); //$NON-NLS-1$
		lblMaximumPermissibleLadenMass
				.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMaximumPermissibleLadenMass.setBounds(10, 260, 150, 20);
		add(lblMaximumPermissibleLadenMass);

		txtMaximumPermissibleLadenMass = new JTextField();
		txtMaximumPermissibleLadenMass.setEditable(false);
		txtMaximumPermissibleLadenMass.setBounds(165, 260, 80, 20);
		txtMaximumPermissibleLadenMass.setColumns(10);
		add(txtMaximumPermissibleLadenMass);

		JLabel lblTypeApprovalNumber = new JLabel(
				Messages.getString("EsdVehiclePanel.lblTypeApprovalNumber.text")); //$NON-NLS-1$
		lblTypeApprovalNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTypeApprovalNumber.setBounds(10, 310, 150, 20);
		add(lblTypeApprovalNumber);

		txtTypeApprovalNumber = new JTextField();
		txtTypeApprovalNumber.setEditable(false);
		txtTypeApprovalNumber.setBounds(165, 310, 250, 20);
		txtTypeApprovalNumber.setColumns(10);
		add(txtTypeApprovalNumber);

		JLabel lblNumberOfSeats = new JLabel(
				Messages.getString("EsdVehiclePanel.lblNumberOfSeats.text")); //$NON-NLS-1$
		lblNumberOfSeats.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumberOfSeats.setBounds(10, 285, 150, 20);
		add(lblNumberOfSeats);

		txtNumberOfSeats = new JTextField();
		txtNumberOfSeats.setEditable(false);
		txtNumberOfSeats.setBounds(165, 285, 50, 20);
		txtNumberOfSeats.setColumns(10);
		add(txtNumberOfSeats);

		JLabel lblNumberOfStandingPlaces = new JLabel(
				Messages.getString("EsdVehiclePanel.lblNumberOfStandingPlaces.text")); //$NON-NLS-1$
		lblNumberOfStandingPlaces.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumberOfStandingPlaces.setBounds(220, 285, 140, 20);
		add(lblNumberOfStandingPlaces);

		txtNumberOfStandingPlaces = new JTextField();
		txtNumberOfStandingPlaces.setEditable(false);
		txtNumberOfStandingPlaces.setBounds(365, 285, 50, 20);
		txtNumberOfStandingPlaces.setColumns(10);
		add(txtNumberOfStandingPlaces);

		JLabel lblEngineIDNumber = new JLabel(
				Messages.getString("EsdVehiclePanel.lblEngineIDNumber.text")); //$NON-NLS-1$
		lblEngineIDNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEngineIDNumber.setBounds(10, 160, 150, 20);
		add(lblEngineIDNumber);

		txtEngineIDNumber = new JTextField();
		txtEngineIDNumber.setEditable(false);
		txtEngineIDNumber.setBounds(165, 160, 250, 20);
		txtEngineIDNumber.setColumns(10);
		add(txtEngineIDNumber);

		JLabel lblNumberOfAxles = new JLabel(
				Messages.getString("EsdVehiclePanel.lblNumberOfAxles.text")); //$NON-NLS-1$
		lblNumberOfAxles.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumberOfAxles.setBounds(250, 235, 80, 20);
		add(lblNumberOfAxles);

		txtNumberOfAxles = new JTextField();
		txtNumberOfAxles.setEditable(false);
		txtNumberOfAxles.setBounds(335, 235, 80, 20);
		txtNumberOfAxles.setColumns(10);
		add(txtNumberOfAxles);

		JLabel lblVehicleCategory = new JLabel(
				Messages.getString("EsdVehiclePanel.lblVehicleCategory.text")); //$NON-NLS-1$
		lblVehicleCategory.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVehicleCategory.setBounds(10, 335, 150, 20);
		add(lblVehicleCategory);

		txtVehicleCategory = new JTextField();
		txtVehicleCategory.setEditable(false);
		txtVehicleCategory.setBounds(165, 335, 250, 20);
		txtVehicleCategory.setColumns(10);
		add(txtVehicleCategory);

		JLabel lblColourOfVehicle = new JLabel(
				Messages.getString("EsdVehiclePanel.lblColourOfVehicle.text")); //$NON-NLS-1$
		lblColourOfVehicle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblColourOfVehicle.setBounds(10, 110, 150, 20);
		add(lblColourOfVehicle);

		txtColourOfVehicle = new JTextField();
		txtColourOfVehicle.setEditable(false);
		txtColourOfVehicle.setBounds(165, 110, 250, 20);
		txtColourOfVehicle.setColumns(10);
		add(txtColourOfVehicle);

		JLabel lblVehicleLoad = new JLabel(
				Messages.getString("EsdVehiclePanel.lblVehicleLoad.text")); //$NON-NLS-1$
		lblVehicleLoad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVehicleLoad.setBounds(250, 210, 80, 20);
		add(lblVehicleLoad);

		txtVehicleLoad = new JTextField();
		txtVehicleLoad.setEditable(false);
		txtVehicleLoad.setBounds(335, 210, 80, 20);
		txtVehicleLoad.setColumns(10);
		add(txtVehicleLoad);

	}
}
