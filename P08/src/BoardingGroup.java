//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P08 Badger Coaster
// Files: BoardingGroup.java
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
 * Class Description: This is an instantiable class that will be used to
 * represent groups entering the ride line. Each boarding group object will have
 * a name and a number of people in the group
 * 
 * @author Zijian Chen
 */

public class BoardingGroup {

	private String name;
	private int numOfPeople;
	private boolean vip;

	/**
	 * The constructor for BoardingGroup set name and number of people
	 * 
	 * @param name        name of group
	 * @param numOfPeople number of people in group
	 */
	public BoardingGroup(String name, int numOfPeople) {
		this.name = name;
		this.numOfPeople = numOfPeople;
	}

	/**
	 * use it when need to get name of group
	 * 
	 * @return name the name of group
	 */
	public String getName() {
		return name;
	}

	/**
	 * set the name of group
	 * 
	 * @param name name of group
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get number of people in the group
	 * 
	 * @return numOfPeople number of people in that group
	 */
	public int getNumOfPeople() {
		return numOfPeople;
	}

	/**
	 * get number of people in the group
	 * 
	 * @param numOfPeople number of epople in that group
	 */
	public void setNumOfPeople(int numOfPeople) {
		this.numOfPeople = numOfPeople;
	}

	/**
	 * check whether the group is vip or not
	 * 
	 * @return true when it is vip, false otherwise
	 */
	public boolean isVip() {
		return vip;
	}

	/**
	 * set the group to vip if it is vip
	 * 
	 * @param vip the boolean representative that whether it is vip or not
	 */
	public void setVip(boolean vip) {
		this.vip = vip;
	}
}

