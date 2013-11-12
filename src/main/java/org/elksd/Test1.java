package org.elksd;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CardTerminals;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;
import javax.smartcardio.TerminalFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Test1 {

	public static void main(String[] args) {
		try {
			TerminalFactory terminalFactory = TerminalFactory.getDefault();
			CardTerminals cardTerminals = terminalFactory.terminals();
			CardTerminal cardTerminal = cardTerminals.list().get(0);
			Card card = cardTerminal.connect("*");
			CardChannel cardChannel = card.getBasicChannel();
			// select file
			cardChannel.transmit(new CommandAPDU(0x00, 0xA4, 0x02, 0x04,
					new byte[] { 0x0F, 0x06 }));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int offset = 0;
			ResponseAPDU responseApdu;
			do {
				// read binary
				responseApdu = cardChannel.transmit(new CommandAPDU(0x00, 0xB0,
						offset >> 8, offset & 0xFF, 0xff));
				baos.write(responseApdu.getData());
				offset += responseApdu.getData().length;
			} while (responseApdu.getData().length == 0xff);
			BufferedImage photo = ImageIO.read(new ByteArrayInputStream(baos
					.toByteArray()));
			JOptionPane.showMessageDialog(null, new ImageIcon(photo));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

}
