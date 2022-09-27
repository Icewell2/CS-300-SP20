//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P10 Food Delivery
// Files: Delivery.java
// Course: CS 300, 2020 Spring
//
// Author: Zijian(Joey) Chen
// Email: zchen697@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: 
// Partner Email: 
// Partner Lecturer's Name: 
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understood the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Description:
 * a class keep track of a FoodRobot + Student pair that could be matched to 
 * fulfill a delivery
 * 
 * @author Zijian Chen
 *
 */
public class Delivery implements Comparable<Delivery> {

	private int studentId;
	private String robotName;
	private int distance;

	/**
	 * constructor for Delivery which set initial value for information mentioned
	 * in student and FoodRobot class
	 * @param student student information
	 * @param foodRobot information for foodRobot
	 */
	public Delivery(Student student, FoodRobot foodRobot) {
		this.studentId = student.getId();
		this.robotName = foodRobot.getName();
		this.distance = Math.abs(student.getX() - foodRobot.getX()) +
				Math.abs(student.getY() - foodRobot.getY());
	}

	/**
	 * implement the Comparable interface so that it is comparable to other Delivery objects.
	 */
	@Override
	public int compareTo(Delivery o) {
		int ret = Integer.compare(this.distance, o.getDistance());
		if (ret != 0) {
			return ret;
		}
		ret = Integer.compare(this.studentId, o.getStudentId());
		if (ret != 0) {
			return ret;
		}
		return robotName.compareTo(o.getRobotName());
	}

	/**
	 * implementation of this method will be designed to work differently depending 
	 * on whether the runtime type of the object passed as an argument to this method
	 * has type Delivery, Student, or FoodRobot
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o instanceof Delivery) {
			Delivery tmp = (Delivery) o;
			return studentId == tmp.getStudentId() || robotName.equals(tmp.getRobotName());
		} else if (o instanceof Student) {
			Student tmp = (Student) o;
			return studentId == tmp.getId();
		} else if (o instanceof FoodRobot) {
			FoodRobot tmp = (FoodRobot) o;
			return robotName.equals(tmp.getName());
		}
		return false;
	}

	@Override
	public String toString() {
		return "The distance between " + studentId + " and " + robotName + " is " + distance;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getRobotName() {
		return robotName;
	}

	public int getDistance() {
		return distance;
	}
}
