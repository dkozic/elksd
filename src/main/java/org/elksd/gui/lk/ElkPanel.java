package org.elksd.gui.lk;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.elksd.gui.Messages;
import org.elksd.lk.ElkData;

public class ElkPanel extends JPanel {

	private ElkDocumentPanel elkDocumentPanel;
	private ElkPersonalPhotoPanel elkPersonalPhotoPanel;
	private ElkResidencePanel elkResidencePanel;

	public ElkDocumentPanel getElkDocumentPanel() {
		return elkDocumentPanel;
	}

	public ElkPersonalPhotoPanel getElkPersonalPhotoPanel() {
		return elkPersonalPhotoPanel;
	}

	public ElkResidencePanel getElkResidencePanel() {
		return elkResidencePanel;
	}

	private ElkPersonalPanel getElkPersonalPanel() {
		return getElkPersonalPhotoPanel().getPersonalPanel();
	}

	private ElkPhotoPanel getElkPhotoPanel() {
		return getElkPersonalPhotoPanel().getPhotoPanel();
	}

	public ElkPanel() {
		setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);

		elkPersonalPhotoPanel = new ElkPersonalPhotoPanel();
		tabbedPane
				.addTab(Messages.getString("ElkPanel.elkPersonalPanel.title"), null, elkPersonalPhotoPanel, null); //$NON-NLS-1$

		elkResidencePanel = new ElkResidencePanel();
		tabbedPane
				.addTab(Messages.getString("ElkPanel.elkResidencePanel.title"), null, elkResidencePanel, null); //$NON-NLS-1$

		elkDocumentPanel = new ElkDocumentPanel();
		tabbedPane
				.addTab(Messages.getString("ElkPanel.elkDocumentPanel.title"), null, elkDocumentPanel, null); //$NON-NLS-1$

	}

	public void setElkData(ElkData elkData) throws IOException {
		// document data
		getElkDocumentPanel().getTxtDocRegNo().setText(elkData.getDocRegNo());
		getElkDocumentPanel().getTxtIssuingDate().setText(
				elkData.getIssuingDate());
		getElkDocumentPanel().getTxtExpiryDate().setText(
				elkData.getExpiryDate());
		getElkDocumentPanel().getTxtIssuingAuthority().setText(
				elkData.getIssuingAuthority());

		// personal data
		getElkPersonalPanel().getTxtPersonalNumber().setText(
				elkData.getPersonalNumber());
		getElkPersonalPanel().getTxtSurname().setText(elkData.getSurname());
		getElkPersonalPanel().getTxtGivenName().setText(elkData.getGivenName());
		getElkPersonalPanel().getTxtParentGivenName().setText(
				elkData.getParentGivenName());
		getElkPersonalPanel().getTxtSex().setText(elkData.getSex());
		getElkPersonalPanel().getTxtPlaceOfBirth().setText(
				elkData.getPlaceOfBirth());
		getElkPersonalPanel().getTxtStateOfBirth().setText(
				elkData.getStateOfBirth());
		getElkPersonalPanel().getTxtDateOfBirth().setText(
				elkData.getDateOfBirth());

		// residence data
		getElkResidencePanel().getTxtState().setText(elkData.getState());
		getElkResidencePanel().getTxtCommunity()
				.setText(elkData.getCommunity());
		getElkResidencePanel().getTxtPlace().setText(elkData.getPlace());
		getElkResidencePanel().getTxtStreet().setText(elkData.getStreet());
		getElkResidencePanel().getTxtHouseNumber().setText(
				elkData.getHouseNumber());
		getElkResidencePanel().getTxtApartmentNumber().setText(
				elkData.getApartmentNumber());

		// photo data
		Image image = ImageIO.read(new ByteArrayInputStream(elkData
				.getPortrait()));
		getElkPhotoPanel().setImage(image);

	}

}
