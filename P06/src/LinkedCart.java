//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P06 Alphabet Train
// Files: LinkedCart.java
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
 * This class models and implements a doubly linked cart.
 * @author Yiran Zhou, Zijian Chen
 *
 */
public class LinkedCart {
  private final Cart CART; // data field of this linked Cart
  private LinkedCart previous; // reference to the previous linked cart in
  // a list of carts
  private LinkedCart next; // reference to the next linked cart in a list of carts

  public LinkedCart(Cart cart) {
    CART = cart;
    previous = null;
    next = null;
  }

  public LinkedCart(Cart cart, LinkedCart previous, LinkedCart next) {
    CART = cart;
    this.previous = previous;
    this.next = next;
  }

  /**
   * Returns a reference to the data cart of this linked cart
   * 
   * @return the data cart of this LinkedCart
   */
  public Cart getCart() {
    return CART;
  }

  /**
   * Returns a reference to the previous LinkedCart attached to this linked cart
   * 
   * @return the previous LinkedCart
   */
  public LinkedCart getPrevious() {
    return previous;
  }

  /**
   * Sets the previous LinkedCart attached to this LinkedCart
   * 
   * @param previous - the previous to set
   */
  public void setPrevious​(LinkedCart previous) {
    this.previous = previous;
  }

  /**
   * Returns a reference to the next LinkedCart attached to this LinkedCart
   * 
   * @return the next LinkedCart
   */
  public LinkedCart getNext() {
    return next;
  }

  /**
   * Sets the next LinkedCart attached to this LinkedCart
   * 
   * @param next - the next to set
   */
  public void setNext​(LinkedCart next) {
    this.next = next;
  }
}
