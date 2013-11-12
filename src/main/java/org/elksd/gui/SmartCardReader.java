package org.elksd.gui;

import java.util.concurrent.CopyOnWriteArrayList;

import javax.smartcardio.Card;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;

import org.apache.log4j.Logger;

public class SmartCardReader {

	private static Logger log = Logger.getLogger(SmartCardReader.class);

	private CardTerminal terminal;
	private volatile Card card;
	private CopyOnWriteArrayList<ReaderListener> listeners;
	private Thread listenerThread;

	public interface ReaderListener {
		public void inserted(Card card);

		public void removed();
	}

	public SmartCardReader(final CardTerminal terminal) {
		this.terminal = terminal;
		listeners = new CopyOnWriteArrayList<ReaderListener>();

		listenerThread = new Thread(new Runnable() {
			public void run() {
				try {
					int timeoutMs = 0;

					while (true) {

						boolean statusChanged = true;

						try {
							// wait for a status change
							if (card == null) {
								log.info("Card is null, wait for insertion");
								terminal.waitForCardPresent(timeoutMs);
							} else {
								log.info("Card not null, wait for removal");
								terminal.waitForCardAbsent(timeoutMs);
							}

							// change the status
							if (card == null && terminal.isCardPresent()) {
								connect();
							} else if (card != null
									&& !terminal.isCardPresent()) {
								disconnect();
							} else {
								// this looks like a bug in PC/SC with
								// waitForCard*(0) not blocking!
								timeoutMs = 3000;
								statusChanged = false;
							}

						} catch (CardException e1) {
							// force "disconnect"
							card = null;

							// try to reconnect if card is present and continue
							// the loop
							if (terminal.isCardPresent()) {
								log.info("RE-CONNECT");
								// will step out on repeated exception
								connect();
							}
						}

						if (statusChanged) {
							notifyListeners();
						}
					}
				} catch (CardException e2) {
					// Break the loop, exit thread
					// TODO: Should we notify our listeners that there is no
					// Reader thread?
				}
			}

			private void notifyListeners() {
				for (ReaderListener listener : listeners) {
					notifyCardListener(listener, false);
				}
			}
		});
		listenerThread.start();
	}

	public void addCardListener(ReaderListener listener) {
		listeners.add(listener);
		notifyCardListener(listener, true);
	}

	public boolean removeCardListener(ReaderListener listener) {
		return listeners.remove(listener);
	}

	private void notifyCardListener(ReaderListener listener,
			boolean inserted_only) {
		if (card != null) {
			listener.inserted(card);
		} else if (!inserted_only) {
			listener.removed();
		}
	}

	public void connect() throws CardException {
		log.info("CONNECT");
		card = terminal.connect("*");
	}

	public void disconnect() throws CardException {
		log.info("DISCONNECT");
		card.disconnect(false);
		card = null;
	}
}
