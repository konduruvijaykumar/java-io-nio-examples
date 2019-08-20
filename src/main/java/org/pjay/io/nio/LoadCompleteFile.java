/**
 * 
 */
package org.pjay.io.nio;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 * @author Vijay
 * 
 * http://www.baeldung.com/java-read-lines-large-file
 * https://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-using-java
 * https://stackoverflow.com/questions/14037404/java-read-large-text-file-with-70million-line-of-text
 * https://explainjava.com/java-read-file/
 * http://www.novixys.com/blog/java-reading-large-file-efficiently/
 * https://stackoverflow.com/questions/45444989/will-bufferedreader-load-the-entire-file-into-memory
 *
 */
public class LoadCompleteFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//Pause for 20 seconds
			Thread.sleep(20000);
			// File size approximately 1.5 GB 
			//Files.readAllLines((new File("marks.csv")).toPath(), Charset.defaultCharset());//StandardCharsets.UTF_8
			
			// File size approximately 432 MB 
			Files.readAllLines((new File("marks-v1.csv")).toPath(), Charset.defaultCharset());//StandardCharsets.UTF_8
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}

}
