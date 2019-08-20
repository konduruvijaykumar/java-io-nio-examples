/**
 * 
 */
package org.pjay.io.nio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

/**
 * @author Vijay
 * 
 * https://stackoverflow.com/questions/19207845/java-multiple-threads-writing-to-same-file
 * 
 */
public class TheadWriter implements Runnable {

	BufferedWriter bw;
	Random random = new Random();

	public TheadWriter(BufferedWriter bw) {
		this.bw = bw;
	}

	private String getName() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	private int getRandomMarks() {
		return random.nextInt(65)+35;
	}

	public void run() {
		while (true) {
			try {
				synchronized (ThreadWritingToFile.OBJ) {
					bw.write(getName() + "," + getRandomMarks() + "," + getRandomMarks() + "," + getRandomMarks() + ","
							+ getRandomMarks() + "," + getRandomMarks() + "," + getRandomMarks() + ","
							+ getRandomMarks() + "," + getRandomMarks() + "," + getRandomMarks() + "\n");
				}
				// Threads termination logic
				if(Thread.interrupted()) {
					System.out.println("Thread with name " + Thread.currentThread().getName() + " terminated");
					break;
				}
				// Threads termination logic
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
