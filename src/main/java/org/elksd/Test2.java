package org.elksd;

import javax.smartcardio.ATR;
import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;
import javax.smartcardio.TerminalFactory;

import org.elksd.util.Util;

public class Test2 {

	private static void printCommand(String command, CommandAPDU apdu) {
		System.out.println(command + " APDU >>>: "
				+ Util.bytesToHex(apdu.getBytes()));
	}

	private static void printResponse(ResponseAPDU apdu) {
		System.out.println("RESPONSE APDU <<<: "
				+ Util.bytesToHex(apdu.getBytes()));
	}

	public static void main(String[] args) {
		try {
			TerminalFactory factory = TerminalFactory.getDefault();

			// terminal
			CardTerminal terminal = factory.terminals().list().get(0);
			System.out.println("Terminal: " + terminal);

			// card
			Card card = terminal.connect("*");
			System.out.println("Card: " + card);

			// atr
			ATR atr = card.getATR();
			byte[] baATR = atr.getBytes();
			System.out.println("ATR: " + Util.bytesToHex(baATR));

			// channel
			CardChannel channel = card.getBasicChannel();
			System.out.println("Channel: " + channel.toString());

			// select document file
			CommandAPDU commandAPDU = new CommandAPDU(0x00, 0xA4, 0x02, 0x04,
					new byte[] { 0x0F, 0x02 });
			printCommand("SELECT FILE", commandAPDU);

			ResponseAPDU responseAPDU = channel.transmit(commandAPDU);
			printResponse(responseAPDU);

			// read binary
			CommandAPDU commandAPDU4 = new CommandAPDU(0x00, 0xB0, 0x00, 0x00,
					0);
			printCommand("READ BYNARY", commandAPDU4);

			ResponseAPDU responseAPDU4 = channel.transmit(commandAPDU4);
			printResponse(responseAPDU4);
			System.out.println(new String(responseAPDU4.getBytes()));

			// select personal file
			CommandAPDU commandAPDU1 = new CommandAPDU(0x00, 0xA4, 0x02, 0x04,
					new byte[] { 0x0F, 0x03 });
			printCommand("SELECT FILE", commandAPDU1);

			ResponseAPDU responseAPDU1 = channel.transmit(commandAPDU1);
			printResponse(responseAPDU1);

			// read binary
			CommandAPDU commandAPDU6 = new CommandAPDU(0x00, 0xB0, 0x00, 0x00,
					0);
			printCommand("READ BYNARY", commandAPDU6);

			ResponseAPDU responseAPDU6 = channel.transmit(commandAPDU6);
			printResponse(responseAPDU6);
			System.out.println(new String(responseAPDU6.getBytes()));

			CommandAPDU commandAPDU7 = new CommandAPDU(0x00, 0xB0, 0x01, 0x00,
					0);
			printCommand("READ BYNARY", commandAPDU7);

			ResponseAPDU responseAPDU7 = channel.transmit(commandAPDU7);
			printResponse(responseAPDU7);
			System.out.println(new String(responseAPDU7.getBytes()));

			// select residence file
			CommandAPDU commandAPDU2 = new CommandAPDU(0x00, 0xA4, 0x02, 0x04,
					new byte[] { 0x0F, 0x04 });
			printCommand("SELECT FILE", commandAPDU2);

			ResponseAPDU responseAPDU2 = channel.transmit(commandAPDU2);
			printResponse(responseAPDU2);

			// read binary
			CommandAPDU commandAPDU5 = new CommandAPDU(0x00, 0xB0, 0x00, 0x00,
					0);
			printCommand("READ BYNARY", commandAPDU5);

			ResponseAPDU responseAPDU5 = channel.transmit(commandAPDU5);
			printResponse(responseAPDU5);
			System.out.println(new String(responseAPDU5.getBytes()));

			// select photo file
			CommandAPDU commandAPDU3 = new CommandAPDU(0x00, 0xA4, 0x02, 0x04,
					new byte[] { 0x0F, 0x06 });
			printCommand("SELECT FILE", commandAPDU3);

			ResponseAPDU responseAPDU3 = channel.transmit(commandAPDU3);
			printResponse(responseAPDU3);

			// read binary
			CommandAPDU commandAPDU8 = new CommandAPDU(0x00, 0xB0, 0x00, 0x00,
					0);
			printCommand("READ BYNARY", commandAPDU8);

			ResponseAPDU responseAPDU8 = channel.transmit(commandAPDU8);
			printResponse(responseAPDU8);
			System.out.println(new String(responseAPDU8.getBytes()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
