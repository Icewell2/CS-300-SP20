//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P10 Food Delivery
// Files: DeliveryQueueTester.java
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
 * This class will finding and fixing any bugs that may be in your DeliveryQueue.
 * 
 * @author Zijian Chen
 *
 */
public class DeliveryQueueTester {

	public static void main(String[] args) {
		System.out.println("testOfferDelivery(): " + testOfferDelivery());
	}

	public static boolean testOfferDelivery() {
		// create a new DeliveryQueue
		DeliveryQueue minHeap = new DeliveryQueue();
		// create some Student and FoodRobot objects
		Student one = new Student(1, 1, 1);
		Student two = new Student(3, 2, 2);
		FoodRobot a = new FoodRobot(2, 3, "A");
		FoodRobot b = new FoodRobot(5, 4, "B");
		// create some Delivery objects and add them to the DeliveryQueue
		minHeap.offerDelivery(new Delivery(one, a));
		minHeap.offerDelivery(new Delivery(one, b));
		minHeap.offerDelivery(new Delivery(two, a));
		minHeap.offerDelivery(new Delivery(two, b));
		// check if the size is correct (2 students * 2 foodRobots = 4 deliveries)
		if (minHeap.getSize() != 4)
			return false;
		// check first (highest priority delivery to be returned)
		String bestDelivery = minHeap.pollBestDelivery().toString();
		if (!bestDelivery.equals("The distance between 2 and A is 2"))
			return false;
		// check if the size is correct (only delivery w/student 1 + robot B left)
		if (minHeap.getSize() != 1)
			return false;
		// check last (lowest priority delivery to be returned)
		String worstDelivery = minHeap.peek().toString();
		if (!worstDelivery.equals("The distance between 1 and B is 7"))
			return false;
		// true when past all test
		return true;
	}

}
