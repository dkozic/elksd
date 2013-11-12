package org.elksd;

import java.util.List;
import java.util.Scanner;

import javax.smartcardio.Card;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.TerminalFactory;

import org.elksd.lk.ElkData;
import org.elksd.lk.ElkReader;

public class ElkDemo {

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
			
			ElkReader reader = new ElkReader(card);

			ElkData elkData = reader.readElk();

			System.out.println(elkData.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
