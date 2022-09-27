//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P10 Food Delivery
// Files: DeliveryQueue.java
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
// Persons: Adan Vivero, I just watched the attach website for some hint
// (identify each person and describe their help in detail)
// Online Sources: 
// https://stackoverflow.com/questions/56139664/how-to-write-a-bubbledown-method-with-heap
//  -in-java(identify each URL and describe their assistance in detail)
//
///////////////////////////////////////////////////////////////////////////////

import java.util.NoSuchElementException;

/**
 * Description:
 * This class will implement heap-based Priority Queue
 * This heap stores elements of type Delivery in a zero-index based
 * array that represents a min heap (where the shortest distance, which
 * has the highest priority is always stored at the root)
 *
 * @author Zijian Chen
 */
public class DeliveryQueue {

	private static final int INITIAL_CAPACITY = 20;
	private Delivery[] heap;
	private int size;

	/**
	 * constructor of this class which assign the initial value of heap and size
	 */
	public DeliveryQueue() {
		this.heap = new Delivery[INITIAL_CAPACITY];
		this.size = 0;
	}

	/**
	 * This method will add new delivery to the queue
	 * @param delivery the delivery to be added
	 */
	public void offerDelivery(Delivery delivery) {
		if (size == heap.length) {
			Delivery[] tmp = new Delivery[heap.length * 2];
			for (int i = 0; i < heap.length; i++) {
				tmp[i] = heap[i];
			}
			heap = tmp;
		}
		heap[size++] = delivery;
	}

	/**
	 * This method will removes and returns the highest priority delivery object
	 * from this priority queue, and also removes all other delivery objects that
	 * "equals" (with matching studentIds or robotNames) that highest priority one
	 * @return highestPriority the delivery with highest priority
	 */
	public Delivery pollBestDelivery() {
		if (size == 0) {
			throw new NoSuchElementException("Warning: Empty Heap!");
		}
		Delivery highestPriority = peek();
		for (int i = 0; i < size; i++) {
			Delivery delivery = heap[i];
			if (delivery.equals(highestPriority)) {
				heap[i] = null;
			}
		}
		heapify();
		return highestPriority;
	}

	/**
	 * returns (without removing) the highest priority delivery.
	 * @return highestPriority the highest priority delivery
	 */
	public Delivery peek() {
		if (size == 0) {
			throw new NoSuchElementException("Warning: Empty Heap!");
		}
		Delivery highestPriority = null;
		for (int i = 0; i < size; i++) {
			Delivery delivery = heap[i];
			if (highestPriority == null || delivery.compareTo(highestPriority) < 0) {
				highestPriority = delivery;
			}
		}
		return highestPriority;

	}

	/**
	 * returns the number of Delivery objects currently in this priority queue
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * returns true when this priority queue is empty, and false otherwise
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * recursively propagates heap order violations up
	 * @param index position to check
	 */
  private void percolateUp(int index) {
  	
  	int parent = index / 2;
  	if(index == 1 || this.heap[parent].compareTo(this.heap[index]) < 0) {
  		return;
  	}
  	Delivery parentValue = this.heap[parent];
  	this.heap[parent] = this.heap[index];
  	this.heap[index] = parentValue;
  	percolateUp(parent);
  	/*int target;
  	Delivery temp = heap[index];
  	for(target = index; target > 1 && (temp.compareTo(heap[target/2]))<0; target /= 2) {
  		heap[target] = heap[target/2];
  	}*/
  }

  /**
   * recursively propagates heap order violations down
   * @param index position to check
   */
  private void percolateDown(int index) {
  	int child = index;
  	final int leftChild = 2 * index + 1;
  	if(leftChild < size) {
  		if(heap[child].compareTo(heap[leftChild]) > 0) {
  			child = leftChild;
  		}
  		final int rightChild = leftChild + 1;
  		if(rightChild < size) {
  			if(heap[child].compareTo(heap[rightChild]) > 0) {
  				child = rightChild;
  			}
  		}
  		if(child != index) {
  			Delivery a = heap[child];
  			heap[child] = heap[index];
  			heap[index] = a;
  			percolateDown(child);
  		}
  	}
  	/*int target;
  	Delivery temp = heap[index];
  	int put;
  	for(put = index; put * 2 <= size; put = target) {
  		target = put * 2;
  		if(target != size && (heap[target+1].compareTo(heap[target])) < 0) {
  			target ++;
  		}
  		if(target != size && (heap[target].compareTo(temp)) < 0) {
  			heap[put] = heap[target];
  		}
  		else {
  			break;
  		}
  	}
  	heap[put] = temp;*/
  }

  /**
   * eliminates all heap order violations from the heap array
   */
	private void heapify() {
		Delivery[] tmp = new Delivery[heap.length];
		int index = 0;
		for (int i = 0; i < size; i++) {
			if (heap[i] != null) {
				tmp[index++] = heap[i];
			}
		}
		heap = tmp;
		size = index;
	}

	@Override
	public String toString() {
		String string = "This DeliveryQueue contains " + size + " elements";
		if (size == 0) {
			return string;
		}
		string += ": [ ";
		for (int i = 0; i < size; i++)
			string += "\n" + heap[i].toString();
		string += " ]\n";
		return string;
	}
}
