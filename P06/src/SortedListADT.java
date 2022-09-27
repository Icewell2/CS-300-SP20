//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P06 Alphabet Train
// Files: SortedListADT.java
// Course: CS 300, 2020 Spring
//
// Author: Zijian(Joey) Chen
// Email: zchen697@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: Yiran Zhou
// Partner Email: zhou433@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X__ Write-up states that pair programming is allowed for this assignment.
// _X__ We have both read and understood the course Pair Programming Policy.
// _X__ We have registered our team prior to the team registration deadline.
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
 * Models a sorted list abstract data type. All elements stored in this list MUST be sorted in the
 * ascendant order. Any method that may make change to the contents of this list MUST maintain the
 * order of this list.
 *
 * @param <T> type of elements that may be stored in this sorted list
 */
public interface SortedListADT<T extends Comparable<T>> {

  /**
   * isEmpty() Checks whether this list is empty.
   * 
   * @return true if the list is empty, false otherwise
   */
  public boolean isEmpty();

  /**
   * Adds a newObject of type T to this sorted list.
   * 
   * @param newObject to add
   */
  public void add(T newObject);

  /**
   * Returns the size of this sorted list
   * 
   * @return the number of elements stored in this sorted list
   */
  public int size();


  /**
   * Removes all the elements stored in this list. This list must be empty after this method returns
   */
  public void clear();

  /**
   * Returns the element at position index of this list without removing it
   * 
   * @param index of the element to return
   * @return the element of this sorted list at the given index
   * @throws IndexOutOfBoundsException if index is less than 0 or index is greater or equal to
   *                                   size()
   */
  public T get(int index);

  /**
   * Returns the index of findObject in this list, or -1 if this list does not contain that element.
   * 
   * 
   * @param findObject element to find in this list
   * @return the index of the first occurrence of findObject in this list, or -1 if this list does
   *         not contain that element.
   */
  public int indexOf(T findObject);

  /**
   * Returns and removes the element from this sorted list at the given index position
   * 
   * @param index of the element to be removed
   * @return the removed element
   * @throws IndexOutOfBoundsException if index is less than 0 or index is greater or equal to
   *                                   size()
   */
  public T remove(int index);


}
