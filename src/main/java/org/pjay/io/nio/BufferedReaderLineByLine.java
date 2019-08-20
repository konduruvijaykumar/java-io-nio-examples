/**
 * 
 */
package org.pjay.io.nio;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Vijay
 *
 */
public class BufferedReaderLineByLine {

	public static void main(String[] args) {
		// File size approximately 432 MB -- marks-v1.csv
		// File size approximately 1.5 GB -- marks.csv
		// Result: Excellent takes max heap as 125 MB and used heap is not more than 35 MB approx. While reading 1.5 GB file
		try (BufferedReader br = new BufferedReader(new FileReader("marks.csv"))) {
			//Pause for 20 seconds
			Thread.sleep(20000);
			for (String line; (line = br.readLine()) != null;) {
				System.out.println(line);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
