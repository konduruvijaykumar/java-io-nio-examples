/**
 * 
 */
package org.pjay.io.nio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Vijay
 * 
 * https://stackoverflow.com/questions/19207845/java-multiple-threads-writing-to-same-file
 * https://stackoverflow.com/questions/15900387/how-to-stop-all-runnable-thread-in-java-executor-class
 *
 */
public class ThreadWritingToFile {

	static final Object OBJ = new Object();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			File file = new File("marks.csv");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Name" + "," + "Subject1" + "," + "Subject2" + "," + "Subject3" + "," + "Subject4" + ","
					+ "Subject5" + "," + "Subject6" + "," + "Subject7" + "," + "Subject8" + "," + "Subject9" + "\n");
			// Thread call
			ExecutorService executor = Executors.newFixedThreadPool(10);
			int i = 0;
			while(i<10){
				executor.execute(new TheadWriter(bw));
				i = i+1;
			}
			// Note: If the below code is not terminating this executor service, please try to terminate this application.
			// As this service can write file approximately close to size of 1 GB to 1.5 GB in a 1 minute
			// Threads termination logic
			try {
				if (executor.awaitTermination(20, TimeUnit.SECONDS)) {
					System.out.println("Closing ExecutorService thread pool gracefully");
				} else {
					System.out.println("Forcing ExecutorService shutdown");
					executor.shutdownNow();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Threads termination logic
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
