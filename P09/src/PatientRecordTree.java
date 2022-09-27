//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P09 Patient Record System
// Files: PatientRecordTree.java
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
 * This class implements a binary search tree (BST) which stores a set of patient records.
 * The left subtree contains the patient records of all the patients who are older than the
 * patient who's PatientRecord is stored at a parent node.
 * The right subtree contains the patient records of all the patients who are younger than the 
 * patient who's PatientRecord is stored at a parent node.
 * @author Zijian(Joey)Chen
 */
public class PatientRecordTree {
  private PatientRecordNode root; // root of this binary search tree
  private int size; // total number of patient records stored in this tree.

  /**
   * Checks whether this binary search tree (BST) is empty
   * 
   * @return true if this PatientRecordTree is empty, false otherwise
   */
  public boolean isEmpty() {
    if(root == null) {
    	return true;
    }
    return false;  
  }

  /**
   * Returns the number of patient records stored in this BST.
   * 
   * @return the size of this PatientRecordTree
   */
  public int size() {
  	return size;
  }

  /**
   * Recursive helper method to add a new PatientRecord to a PatientRecordTree rooted at current.
   * 
   * @param current The "root" of the subtree we are inserting newRecord into.
   * @param newRecord The PatientRecord to be added to a BST rooted at current.
   * @return true if the newRecord was successfully added to this 
   * 				 PatientRecordTree, false otherwise
   */
  public static boolean addPatientRecordHelper(PatientRecord newRecord, PatientRecordNode current) {
  	PatientRecordNode target = new PatientRecordNode(newRecord);
    if(newRecord.compareTo(current.getPatientRecord()) < 0) {
    	if(current.getLeftChild() == null) {
    		current.setLeftChild(target);
    		return true;
    	}
    	else {
    		addPatientRecordHelper(newRecord,current.getLeftChild());
    	}
    }
    if(newRecord.compareTo(current.getPatientRecord()) > 0) {
    	if(current.getRightChild() == null) {
    		current.setRightChild(target);
    		return true;
    	}
    	else {
    		addPatientRecordHelper(newRecord,current.getRightChild());
    	}
    }
  	return false;
  }

  /**
   * Adds a new PatientRecord to this PatientRecordTree
   * 
   * @param newRecord a new PatientRecord to add to this BST.
   * @return true if the newRecord was successfully added to this BST, and returns false if there is
   *         a match with this PatientRecord already already stored in this BST.
   */
  public boolean addPatientRecord(PatientRecord newRecord) {
    if (isEmpty()) { // Add newRecord to an empty PatientRecordTree
      root = new PatientRecordNode(newRecord);
      return true;
    } else { // Add newRecord to an non-empty PatientRecordTree
      addPatientRecordHelper(newRecord, root); 
      return true;
    }
  }

  /**
   * Recursive helper method which returns a String representation of the BST rooted at current. An
   * example of the String representation of the contents of a PatientRecordTree is provided in the
   * description of the above toString() method.
   * 
   * @param current reference to the current PatientRecordNode within this BST.
   * @return a String representation of all the PatientRecords stored in the sub-tree
   *         PatientRecordTree rooted at current in increasing order with respect to the patients
   *         dates of birth. Returns an empty String "" if current is null.
   */
  public static String toStringHelper(PatientRecordNode current) {
  	if(current == null) {
    	return "";
    }
  	if(current.getLeftChild() != null) {
  		final String i = current.getLeftChild().getPatientRecord().toString() + "\n";
  		toStringHelper(current.getLeftChild());
  	}
  	if(current.getRightChild() != null) {
  		toStringHelper(current.getLeftChild());
  	}
  	if(current.getLeftChild() == null && current.getRightChild() == null) {
  		return "";
  	}
    return "";
  }

  /**
   * Returns a String representation of all the PatientRecords stored within this BST in the
   * increasing order, separated by a newline "\n". For instance: 
   * "Sarah(1/2/1935)" + "\n" +
   * "George(5/27/1943)" + "\n" + 
   * "Adam(8/12/1972)" + "\n" + 
   * "Norah(11/23/1985)" + "\n" +
   * "William(6/4/1998)" + "\n" + 
   * "Nancy(9/12/2003)" + "\n" + 
   * "Sam(4/20/2019)" + "\n"
   * 
   * @return a String representation of all the PatientRecords stored within this BST sorted in an
   *         increasing order with respect to the dates of birth of the patients (i.e. from the
   *         oldest patient to the youngest patient). Returns an empty string "" if this BST is empty.
   */
  public String toString() {
    if(isEmpty()) {
    	return "";
    }
    else {
    	return toStringHelper(root);
    }
  }

  /**
   * Search for a patient record (PatientRecord) given the date of birth as lookup key.
   * 
   * @param date a String representation of the date of birth of a patient in the format mm/dd/yyyy
   * @return the PatientRecord of the patient born on date.
   * @throws a NoSuchElementException with a descriptive error message if there is no PatientRecord
   *         found in this BST having the provided date of birth
   */
  public PatientRecord lookup(String date) {
    PatientRecord findRecord = new PatientRecord("", date);
    return this.lookupHelper(findRecord, root);
  }
  
  /**
   * Recursive helper method to lookup a PatientRecord given a reference PatientRecord with the same
   * date of birth in the subtree rooted at current
   * 
   * @param findRecord a reference to a PatientRecord target we are lookup for a match in the BST
   *        rooted at current.
   * @param current "root" of the subtree we are looking for a match to findRecord within it.
   * @return reference to the PatientRecord stored stored in this BST which matches findRecord.
   * @throws NoSuchElementException with a descriptive error message if there is no patient record
   *         whose date of birth matches date, stored in this BST.
   */
  private PatientRecord lookupHelper(PatientRecord findRecord, PatientRecordNode current) {
    //PatientRecordNode target = new PatientRecordNode(findRecord);
  	
  	if (findRecord == null) {
  		return null;
  	}
  	if(current.getPatientRecord().compareTo(findRecord) < 0) {
  		String s = current.getPatientRecord().toString(); 
  		lookupHelper(findRecord, current.getRightChild());
  		
  	}
  	if(current.getPatientRecord().compareTo(findRecord) > 0) {
  		return lookupHelper(findRecord, current.getLeftChild());
  	}
  	if(current.getPatientRecord() == findRecord) {
  		return current.getPatientRecord();
  	}
  	else {
  		throw new NoSuchElementException("No match");
  	}
  	/*if(current.getPatientRecord() == findRecord) {
    	return current.getPatientRecord();
    }
  	else if((current.getLeftChild()).getPatientRecord() == findRecord) {
  		return (current.getLeftChild()).getPatientRecord();
  	}
  	else if((current.getRightChild()).getPatientRecord() == findRecord) {
  		return (current.getRightChild()).getPatientRecord();
  	}
  	else if((current.getLeftChild()).getPatientRecord().compareTo(findRecord) < 0) {
  		return lookupHelper(findRecord, current.getLeftChild());
  	}
  	else if((current.getRightChild()).getPatientRecord().compareTo(findRecord) > 0) {
  		return lookupHelper(findRecord, current.getRightChild());
  	}
  	else {
  		throw new NoSuchElementException("No match");
  	}*/
  }
  
  /**
   * Computes and returns the height of this BST, counting the number of nodes (PatientRecordNodes)
   * from root to the deepest leaf.
   * 
   * @return the height of this Binary Search Tree
   */
  public int height() {
    return heightHelper(root);
  }

  /**
   * Recursive helper method that computes the height of the subtree rooted at current
   * 
   * @param current pointer to the current PatientRecordNode within a PatientRecordTree
   * @return height of the subtree rooted at current, counting the number of PatientRecordNodes
   */
  public static int heightHelper(PatientRecordNode current) {
    if(current ==  null) {
    	return 0;
    }
    int leftHeight = heightHelper(current.getLeftChild());
    int rightHeight = heightHelper(current.getRightChild());
    return Math.max(leftHeight, rightHeight) + 1;
  }

  /**
   * 
   * @param current
   * @return
   */
  private PatientRecord getRecordOfYoungestPatientHelper(PatientRecordNode current) {
  	if(isEmpty()) {
  		return null;
  	}
  	else if(current.getRightChild() != null) {
  		return getRecordOfYoungestPatientHelper(current.getRightChild());
  	}
  	else if((current.getRightChild() == null && current.getLeftChild() != null) ||
  			(current.getLeftChild() == null && current.getRightChild() == null)) {
  		return current.getPatientRecord();
  	}
  	else {
  		return null;
  	}
  }
  /**
   * Returns the PatientRecord of the youngest patient in this BST.
   * 
   * @return the PatientRecord of the youngest patient in this BST and null if this tree is empty.
   */
  public PatientRecord getRecordOfYoungestPatient() {
    return getRecordOfYoungestPatientHelper(root);
  }

  /**
   * 
   * @param current
   * @return
   */
  private PatientRecord getRecordOfOldestPatientHelper(PatientRecordNode current) {
  	if(isEmpty()) {
  		return null;
  	}
  	else if(current.getLeftChild() != null) {
  		return getRecordOfOldestPatientHelper(current.getLeftChild());
  	}
  	else if((current.getLeftChild() == null && current.getRightChild() != null) ||
  			(current.getLeftChild() == null && current.getRightChild() == null)) {
  		return current.getPatientRecord();
  	}
  	else {
  		return null;
  	}
  }
  
  /**
   * Returns the PatientRecord of the oldest patient in this BST.
   * 
   * @return the PatientRecord of the oldest patient in this BST, and null if this tree is empty.
   */
  public PatientRecord getRecordOfOldestPatient() {
  	return getRecordOfOldestPatientHelper(root);
  }

}
