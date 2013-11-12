package org.elksd.gui;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

import org.apache.log4j.Logger;

public class Lock {

	private static Logger log = Logger.getLogger(Lock.class);

	private static File f;
	private static FileChannel channel;
	private static FileLock lock;

	public Lock() throws LockException, IOException {
		String homeDir = System.getProperty("user.home");
		File elksdDir = new File(homeDir, ".elksd");
		if (elksdDir.exists()) {
			log.debug("Directory exists: " + elksdDir);
		} else {
			log.debug("Directory does not exists: " + elksdDir
					+ ". Creating directory.");
			elksdDir.mkdirs();
			log.debug("Direcotry created: " + elksdDir);
		}

		f = new File(elksdDir, ".lock");
		// Check if the lock exist
		if (f.exists()) // if exist try to delete it
			f.delete();
		// Try to get the lock
		channel = new RandomAccessFile(f, "rw").getChannel();
		lock = channel.tryLock();
		if (lock == null) {
			// File is lock by other application
			channel.close();
			throw new LockException("Two instance cant run at a time.");
		}
		// Add shutdown hook to release lock when application shutdown
		ShutdownHook shutdownHook = new ShutdownHook();
		Runtime.getRuntime().addShutdownHook(shutdownHook);

	}

	public static void unlockFile() {
		// release and delete file lock
		try {
			if (lock != null) {
				lock.release();
				channel.close();
				f.delete();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static class ShutdownHook extends Thread {
		public void run() {
			unlockFile();
		}
	}

	public static class LockException extends Exception {

		public LockException() {
			super();
		}

		public LockException(String message, Throwable cause) {
			super(message, cause);
		}

		public LockException(String message) {
			super(message);
		}

		public LockException(Throwable cause) {
			super(cause);
		}

	}
}
