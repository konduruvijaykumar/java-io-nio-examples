/**
 * 
 */
package org.pjay.io.nio;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Vijay
 *
 */
public class Java8StreamsReadingLineByLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			//Pause for 20 seconds
			Thread.sleep(20000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		// Result: Excellent takes max heap as 125 MB and used heap is not more than 35 MB approx. While reading 1.5 GB file
        try (Stream<String> lines = Files.lines(Paths.get("marks.csv"))) {
            lines.forEach(System.out::println);
        }catch(Exception e){
        	e.printStackTrace();
        }
	}

}
