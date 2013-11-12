package org.elksd.gui.lk;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ElkPhotoPanel extends JPanel {

	private Image image = null;

	public ElkPhotoPanel() {
		setPreferredSize(new Dimension(200, 250));
	}
	
	public void setImage(Image image) {
		this.image = image;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			g.drawImage(image, (this.getWidth() - image.getWidth(null)) / 2,
					(this.getHeight() - image.getHeight(null)) / 2, this);
		}
	}

}
