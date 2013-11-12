package org.elksd.gui.lk;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ElkPersonalPhotoPanel extends JPanel {

	private ElkPersonalPanel personalPanel;
	private ElkPhotoPanel photoPanel;

	public ElkPersonalPanel getPersonalPanel() {
		return personalPanel;
	}

	public ElkPhotoPanel getPhotoPanel() {
		return photoPanel;
	}

	public ElkPersonalPhotoPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		personalPanel = new ElkPersonalPanel();
		photoPanel = new ElkPhotoPanel();
		add(photoPanel);
		add(Box.createRigidArea(new Dimension(10,0)));
		add(personalPanel);

		setPreferredSize(new Dimension(640, 250));
	}

}
