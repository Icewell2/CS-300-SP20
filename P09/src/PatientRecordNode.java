//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P09 Patient Record System
// Files: PatientRecordNode.java
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
 * This class models a patient record node in a binary search tree.
 *
 */
public class PatientRecordNode {
  private PatientRecord data; // data field which represents a patient within this PatientNode.
  private PatientRecordNode rightChild; // reference to the right child of this PatientNode.
  private PatientRecordNode leftChild; // reference to the left child of this PatientNode.
  
  /**
   * Creates a new PatientNode with given data and null for both left and right children
   * @param data reference to the data of this PatientNode
   */
  public PatientRecordNode(PatientRecord data) {
    this.data = data;
  }

  /**
   * Gets the right child of this PatientNode
   * @return the rightChild of this PatientNode
   */
  public PatientRecordNode getRightChild() {
    return rightChild;
  }

  /**
   * Sets the right child of this PatientNode
   * @param rightChild the rightChild to set
   */
  public void setRightChild(PatientRecordNode rightChild) {
    this.rightChild = rightChild;
  }

  /**
   * Gets the left child of this PatientNode
   * @return the leftChild of this PatientNode
   */
  public PatientRecordNode getLeftChild() {
    return leftChild;
  }

  /**
   * Sets the left child of this PatientNode
   * @param leftChild the leftChild to set
   */
  public void setLeftChild(PatientRecordNode leftChild) {
    this.leftChild = leftChild;
  }

  /**
   * Returns the patient record of this PatientNode
   * @return the data of this binary node.
   */
  public PatientRecord getPatientRecord() {
    return data;
  }
}