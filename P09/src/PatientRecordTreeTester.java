//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P09 Patient Record System
// Files: PatientRecordTreeTester.java
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
 * This class checks the correctness of the implementation of the methods defined in the class
 * PatientRecordTree.
 *
 */

public class PatientRecordTreeTester {

  /**
   * Checks the correctness of the implementation of both addPatientRecord() and toString() methods
   * implemented in the PatientRecordTree class. This unit test considers at least the following
   * scenarios. (1) Create a new empty PatientRecordTree, and check that its size is 0, it is empty,
   * and that its string representation is an empty string "". (2) try adding one patient record and
   * then check that the addPatientRecord() method call returns true, the tree is not empty, its
   * size is 1, and the .toString() called on the tree returns the expected output. (3) Try adding
   * another patientRecord which is older that the one at the root, (4) Try adding a third patient
   * Record which is younger than the one at the root, (5) Try adding at least two further patient
   * records such that one must be added at the left subtree, and the other at the right subtree.
   * For all the above scenarios, and more, double check each time that size() method returns the
   * expected value, the add method call returns true, and that the .toString() method returns the
   * expected string representation of the contents of the binary search tree in an ascendant order
   * from the oldest patient to the youngest one. (6) Try adding a patient whose date of birth was
   * used as a key for a patient record already stored in the tree. Make sure that the
   * addPatientRecord() method call returned false, and that the size of the tree did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddPatientRecordToStringSize() {
    return false;
  }

  /**
   * This method checks mainly for the correctness of the PatientRecordTree.lookup() method. It must
   * consider at least the following test scenarios. (1) Create a new PatientRecordTree. Then, check
   * that calling the lookup() method with any valid date must throw a NoSuchElementException. (2)
   * Consider a PatientRecordTree of height 3 which consists of at least 5 PatientRecordNodes. Then,
   * try to call lookup() method to search for the patient record at the root of the tree, then a
   * patient records at the right and left subtrees at different levels. Make sure that the lookup()
   * method returns the expected output for every method call. (3) Consider calling .lookup() method
   * on a non-empty PatientRecordTree with a date of birth not stored in the tree, and ensure that
   * the method call throws a NoSuchElementException.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddPatientRecordAndLookup() {
    return false;
  }

  /**
   * Checks for the correctness of PatientRecordTree.height() method. This test must consider
   * several scenarios such as, (1) ensures that the height of an empty patient record tree is zero.
   * (2) ensures that the height of a tree which consists of only one node is 1. (3) ensures that
   * the height of a PatientRecordTree with the following structure for instance, is 4.
   *       (*)
   *     /    \
   *  (*)      (*)
   *    \     /  \
   *    (*) (*)  (*)
   *             /
   *           (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    return false;
  }

  /**
   * Checks for the correctness of PatientRecordTree.getRecordOfYoungestPatient() method.
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetRecordOfYoungestPatient() {
    return false;
  }

  /**
   * Checks for the correctness of PatientRecordTree.getRecordOfOldestPatient() method.
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetRecordOfOldestPatient() {
    return false;
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
  	System.out.println("test testAddPatientRecordToStringSize: " + testAddPatientRecordToStringSize());
  	System.out.println("test testAddPatientRecordAndLookup: " + testAddPatientRecordAndLookup());
  	System.out.println("test testHeight: " + testHeight());
  	System.out.println("test testGetRecordOfYoungestPatient: " + testGetRecordOfYoungestPatient());
  	System.out.println("test testGetRecordOfOldestPatient: " + testGetRecordOfOldestPatient());
  }

}
