/**
 * 
 */
package org.pjay.io.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Vijay
 *
 */
public class NIOApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			RandomAccessFile aFile = new RandomAccessFile("data-nio.txt", "rw");
			FileChannel inChannel = aFile.getChannel();

			// create buffer with capacity of 48 bytes
			ByteBuffer buf = ByteBuffer.allocate(48);

			int bytesRead = inChannel.read(buf); // read into buffer.
			while (bytesRead != -1) {

				buf.flip(); // make buffer ready for read

				while (buf.hasRemaining()) {
					System.out.print((char) buf.get()); // read 1 byte at a time
					// System.out.print("-");
				}

				buf.clear(); // make buffer ready for writing
				System.out.print("<==>");
				bytesRead = inChannel.read(buf);
			}
			aFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
