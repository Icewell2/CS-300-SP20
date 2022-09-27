//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P08 Badger Coaster
// Files: BGNode.java
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
 * Class Description: linked list nodes of the queue.
 * 
 * @author Zijian Chen
 *
 */
public class BGNode {

	private BoardingGroup group;
	private BGNode next;

	/**
	 * constructor to initialize the group information
	 * 
	 * @param group the information of the group
	 */
	public BGNode(BoardingGroup group) {
		this.group = group;
		this.next = null;
	}

	/**
	 * construtor for initialization when there is a next element
	 * 
	 * @param group group information of the group
	 * @param next  point to the next one
	 */
	public BGNode(BoardingGroup group, BGNode next) {
		this.group = group;
		this.next = next;
	}

	/**
	 * get the group information of the one we want
	 * 
	 * @return group the group information
	 */
	public BoardingGroup getGroup() {
		return group;
	}

	/**
	 * point to the next element
	 * 
	 * @return next the next element
	 */
	public BGNode getNext() {
		return next;
	}

	/**
	 * set next element
	 * 
	 * @param next next element
	 */
	public void setNext(BGNode next) {
		this.next = next;
	}
}
