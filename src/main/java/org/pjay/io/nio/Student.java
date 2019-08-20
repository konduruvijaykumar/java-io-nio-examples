/**
 * 
 */
package org.pjay.io.nio;

/**
 * @author Vijay
 *
 */
public class Student implements Comparable<Student>{

	private String name;
	private int score;
	
	public Student(String... details) {
		if (null != details && details.length == 10) {
			this.setName(details[0]);
			this.setScore(Integer.parseInt(details[1]) + Integer.parseInt(details[2]) + Integer.parseInt(details[3])
					+ Integer.parseInt(details[4]) + Integer.parseInt(details[5]) + Integer.parseInt(details[6])
					+ Integer.parseInt(details[7]) + Integer.parseInt(details[8]) + Integer.parseInt(details[9]));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Student o) {
		return (o.getScore() - this.getScore());
	}
	
}
