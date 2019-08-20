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
public class TopStudentsFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		String[] splitStr = null;
		BoundedTreeSet<Student> treeSet = new BoundedTreeSet<>(10);
		boolean isFirstLine = true;
		try (BufferedReader br = new BufferedReader(new FileReader("marks.csv"))) {
			for (String line; (line = br.readLine()) != null;) {
				//System.out.println(line);
				if(!isFirstLine){
					splitStr = line.split(",");
					Student student = new Student(splitStr);
					treeSet.add(student);
				}else{
					isFirstLine = false;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Student student : treeSet) {
			System.out.println(student.toString());
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("Total time taken >>> " + (endTime - startTime)/1000 + " secs");
		// This was the output with no cold startup of JVM or if the code is run after 1 or 2 times
		// Output: Total time taken >>> 19 secs
		// Excellent: time taken to process top 10 students from 1.5 GB file is 17 seconds approximately
	}

}
