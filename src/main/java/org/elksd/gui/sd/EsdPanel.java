package org.elksd.gui.sd;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.elksd.gui.Messages;
import org.elksd.sd.EsdData;

public class EsdPanel extends JPanel {

	private EsdDocumentPanel esdDocumentPanel;
	private EsdPersonalPanel esdPersonalPanel;
	private EsdVehiclePanel esdVehiclePanel;

	public EsdDocumentPanel getEsdDocumentPanel() {
		return esdDocumentPanel;
	}

	public EsdPersonalPanel getEsdPersonalPanel() {
		return esdPersonalPanel;
	}

	public EsdVehiclePanel getEsdVehiclePanel() {
		return esdVehiclePanel;
	}

	public EsdPanel() {
		setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);

		esdDocumentPanel = new EsdDocumentPanel();
		tabbedPane
				.addTab(Messages.getString("EsdPanel.esdDocumentPanel.title"), null, esdDocumentPanel, null); //$NON-NLS-1$

		esdPersonalPanel = new EsdPersonalPanel();
		tabbedPane
				.addTab(Messages.getString("EsdPanel.esdPersonalPanel.title"), null, esdPersonalPanel, null); //$NON-NLS-1$

		esdVehiclePanel = new EsdVehiclePanel();
		tabbedPane
				.addTab(Messages.getString("EsdPanel.esdVehiclePanel.title"), null, esdVehiclePanel, null); //$NON-NLS-1$

	}

	public void setEsdData(EsdData esdData) {
		// document data
		getEsdDocumentPanel().getTxtStateIssuing().setText(
				esdData.getStateIssuing());
		getEsdDocumentPanel().getTxtAuthorityIssuing().setText(
				esdData.getAuthorityIssuing());
		getEsdDocumentPanel().getTxtCompetentAuthority().setText(
				esdData.getCompetentAuthority());
		getEsdDocumentPanel().getTxtExpiryDate().setText(
				esdData.getExpiryDate());
		getEsdDocumentPanel().getTxtIssuingDate().setText(
				esdData.getIssuingDate());
		getEsdDocumentPanel().getTxtRestrictionToChangeOwner().setText(
				esdData.getRestrictionToChangeOwner());
		getEsdDocumentPanel().getTxtSerialNumber().setText(
				esdData.getSerialNumber());
		getEsdDocumentPanel().getTxtUnambiguousNumber().setText(
				esdData.getUnambiguousNumber());

		// personal data
		getEsdPersonalPanel().getTxtHolderAddress().setText(
				esdData.getHolderAddress());
		getEsdPersonalPanel().getTxtHolderName().setText(
				esdData.getHolderName());
		getEsdPersonalPanel().getTxtHolderSurnameOrBusinessName().setText(
				esdData.getHolderSurnameOrBusinessName());

		getEsdPersonalPanel().getTxtOwnerAddress().setText(
				esdData.getOwnerAddress());
		getEsdPersonalPanel().getTxtOwnerPersonalNo().setText(
				esdData.getOwnerPersonalNo());
		getEsdPersonalPanel().getTxtOwnerName().setText(esdData.getOwnerName());
		getEsdPersonalPanel().getTxtOwnerSurnameOrBusinessName().setText(
				esdData.getOwnerSurnameOrBusinessName());

		getEsdPersonalPanel().getTxtUserAddress().setText(
				esdData.getUserAddress());
		getEsdPersonalPanel().getTxtUserPersonalNo().setText(
				esdData.getUserPersonalNo());
		getEsdPersonalPanel().getTxtUserName().setText(esdData.getUserName());
		getEsdPersonalPanel().getTxtUserSurnameOrBusinessName().setText(
				esdData.getUserSurnameOrBusinessName());

		// vehicle data
		getEsdVehiclePanel().getTxtDateOfFirstRegistration().setText(
				esdData.getDateOfFirstRegistration());
		getEsdVehiclePanel().getTxtYearOfProduction().setText(
				esdData.getYearOfProduction());
		getEsdVehiclePanel().getTxtVehicleMake().setText(
				esdData.getVehicleMake());
		getEsdVehiclePanel().getTxtVehicleType().setText(
				esdData.getVehicleType());
		getEsdVehiclePanel().getTxtCommercialDescription().setText(
				esdData.getCommercialDescription());
		getEsdVehiclePanel().getTxtVehicleIDNumber().setText(
				esdData.getVehicleIDNumber());
		getEsdVehiclePanel().getTxtRegistrationNumberOfVehicle().setText(
				esdData.getRegistrationNumberOfVehicle());
		getEsdVehiclePanel().getTxtMaximumNetPower().setText(
				esdData.getMaximumNetPower());
		getEsdVehiclePanel().getTxtEngineCapacity().setText(
				esdData.getEngineCapacity());
		getEsdVehiclePanel().getTxtTypeOfFuel()
				.setText(esdData.getTypeOfFuel());
		getEsdVehiclePanel().getTxtPowerWeightRatio().setText(
				esdData.getPowerWeightRatio());
		getEsdVehiclePanel().getTxtVehicleMass().setText(
				esdData.getVehicleMass());
		getEsdVehiclePanel().getTxtMaximumPermissibleLadenMass().setText(
				esdData.getMaximumPermissibleLadenMass());
		getEsdVehiclePanel().getTxtTypeApprovalNumber().setText(
				esdData.getTypeApprovalNumber());
		getEsdVehiclePanel().getTxtNumberOfSeats().setText(
				esdData.getNumberOfSeats());
		getEsdVehiclePanel().getTxtNumberOfStandingPlaces().setText(
				esdData.getNumberOfStandingPlaces());
		getEsdVehiclePanel().getTxtEngineIDNumber().setText(
				esdData.getEngineIDNumber());
		getEsdVehiclePanel().getTxtNumberOfAxles().setText(
				esdData.getNumberOfAxles());
		getEsdVehiclePanel().getTxtVehicleCategory().setText(
				esdData.getVehicleCategory());
		getEsdVehiclePanel().getTxtColourOfVehicle().setText(
				esdData.getColourOfVehicle());
		getEsdVehiclePanel().getTxtVehicleLoad().setText(
				esdData.getVehicleLoad());
	}
}
