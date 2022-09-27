//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P06 Alphabet Train
// Files: Cart.java
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
 * This class models and implements a cart which carries goods of type String
 *
 */
public class Cart implements Comparable<Cart> {
  private String cargo; // a String representation of the goods carried
                        // by this cart

  /**
   * Creates a new Cart carrying a given data
   * 
   * @param cargo string representation of the good which are going to be carried by this cart
   */
  public Cart(String cargo) {
    this.cargo = cargo;
  }

  /**
   * Returns String representation of the goods carried by this cart
   * 
   * @return a String representation of the cargo carried by this cart
   */
  @Override
  public String toString() {
    return cargo;
  }

  /**
   * Returns the cargo carried by this cart
   * 
   * @return a the cargo carried by this cart
   */
  public String getCargo() {
    return cargo;
  }

  /**
   * Compares this cart with the specified object for order.
   * 
   * @return a negative integer, zero, or a positive integer as this cart has a cargo which is less
   *         than, equal to, or greater than the specified other cart's cargo.
   */
  @Override
  public int compareTo(Cart other) {
    return cargo.compareTo(other.cargo);
  }

}
