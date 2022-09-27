//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P08 Badger Coaster
// Files: RideQueue.java
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

import java.util.NoSuchElementException;

/**
 * Class Description: this class implement the interfaces defined in queusADT
 * 
 * @author Zijian Chen
 */
public class RideQueue implements QueueADT<BoardingGroup> {

	private BGNode front;
	private BGNode back;
	private int capacity = 0;
	private int numOfPeople = 0;
	private int numOfGroups = 0;

	/**
	 * constructor for RideQueue when capacity is given
	 * 
	 * @param capacity the capacity of the target
	 */
	public RideQueue(int capacity) {
		this.capacity = capacity;
		this.numOfPeople = 0;
		this.numOfGroups = 0;
	}

	@Override
	/**
	 * This method will print of the information of group status when called
	 * 
	 * @return status the string representative of the group status
	 */
	public String toString() {
		String status = "Number of People in Queue: " + numOfPeople + "\n";
		status += "Number of Groups in Queue: " + numOfGroups + "\n";
		status += "Group Names in Queue: ";
		BGNode current = front;
		while (current != null) {
			String groupName = current.getGroup().getName();
			status += groupName + " ";
			current = current.getNext();
		}
		return status;
	}

	@Override
	/**
	 * check whether the numOfPeople is zero
	 * 
	 * @return true when it is zero, false otherwise
	 */
	public boolean isEmpty() {
		return numOfPeople == 0;
	}

	@Override
	/**
	 * get number of groups
	 * 
	 * @return numOfGroup number of groups
	 */
	public int size() {
		return numOfGroups;
	}

	@Override
	/**
	 * enqueue the list and consider the situation when there is a vip group
	 */
	public void enqueue(BoardingGroup newObject) {
		if (capacity - numOfPeople < newObject.getNumOfPeople()) {
			throw new IllegalStateException();
		}
		BGNode bgNode = new BGNode(newObject);
		if (front == null) {
			// not initialized
			front = bgNode;
			back = bgNode;
		} else {
			if (newObject.isVip()) {
				// put vip to head
				bgNode.setNext(front);
				front = bgNode;
			} else {
				// put non-vip to tail
				back.setNext(bgNode);
				back = bgNode;
			}
		}
		numOfGroups++;
		numOfPeople += newObject.getNumOfPeople();
	}

	@Override
	/**
	 * set the list to empty
	 */
	public void clear() {
		front = null;
		back = null;
		numOfPeople = 0;
		numOfGroups = 0;
	}

	@Override
	/**
	 * get the top (front) of the list but not modify it
	 * 
	 * @return the front of the group list
	 */
	public BoardingGroup peek() {
		if (numOfGroups == 0) {
			throw new NoSuchElementException();
		}
		return front.getGroup();
	}

	@Override
	/**
	 * dequeue the list
	 * 
	 * @return the first in the list
	 */
	public BoardingGroup dequeue() {
		if (numOfGroups == 0) {
			throw new NoSuchElementException();
		}
		BGNode header = front;
		front = front.getNext();
		numOfGroups--;
		numOfPeople -= header.getGroup().getNumOfPeople();
		return header.getGroup();
	}
}
