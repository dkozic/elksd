package org.elksd;

import java.util.List;
import java.util.Scanner;

import javax.smartcardio.Card;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.TerminalFactory;

import org.elksd.sd.EsdData;
import org.elksd.sd.EsdReader;

public class EsdDemo {

	public static CardTerminal pickTerminal(List<CardTerminal> terminals) {
		if (terminals.size() > 1) {
			System.out.println("Available readers:\n");
			int c = 1;
			for (CardTerminal terminal : terminals) {
				System.out.format("%d) %s\n", c++, terminal);
			}

			Scanner in = new Scanner(System.in);
			while (true) {
				System.out.print("Select number: ");
				System.out.flush();

				c = in.nextInt();
				if (c > 0 && c < terminals.size()) {
					return terminals.get(c);
				}
			}
		} else {
			return terminals.get(0);
		}
	}

	public static void main(String[] args) {

		try {
			TerminalFactory factory = TerminalFactory.getDefault();
			CardTerminal terminal = pickTerminal(factory.terminals().list());
			
			Card card = terminal.connect("*");
			System.out.println("Terminal: " + terminal);
			
			EsdReader reader = new EsdReader(card);

			EsdData esdData = reader.readEsd();

			System.out.println(esdData.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
