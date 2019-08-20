/**
 * 
 */
package org.pjay.io.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Vijay
 *
 */
public class ScannerReadingLineByLine {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		try {
			//Pause for 20 seconds
			Thread.sleep(20000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		// Try 1
		// Result: Good takes max heap as 340 MB and used heap is not more than 110 MB approx. While reading 1.5 GB file
		/**
		try(Scanner scanner = new Scanner(new File("marks.csv"))) {
		    while ( scanner.hasNextLine() ) {
		        //String line = scanner.nextLine();
		        System.out.println(scanner.nextLine());
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
		*/
		
		// Try 2
		// This is not using Scanner, but just tried this process also
		// Result: Excellent takes max heap as 125 MB and used heap is not more than 35 MB approx. While reading 1.5 GB file
		/**
        try (Stream<String> lines = Files.lines(Paths.get("marks.csv"))) {
            lines.forEach(System.out::println);
        }catch(Exception e){
        	e.printStackTrace();
        }
        */
		
		// Try 3
		// Result: Good takes max heap as 340 MB and used heap is not more than 230 MB approx. While reading 1.5 GB file
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
		    inputStream = new FileInputStream("marks.csv");
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        //String line = sc.nextLine();
		        //System.out.println(line);
		    	System.out.println(sc.nextLine());
		    }
		    // note that Scanner suppresses exceptions
		    if (sc.ioException() != null) {
		        throw sc.ioException();
		    }
		} finally {
		    if (inputStream != null) {
		        inputStream.close();
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}
	}

}
