//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P03 Elastic Piggy Bank
// Files: Coin.java ElasticBank.java ElasticTester.java
// Course: CS 300, 20 Spring
//
// Author: Zijian(Joey)Chen
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
// Persons: None
// Online Sources: None
//
///////////////////////////////////////////////////////////////////////////////


/**
 * Coin class description:
 * 
 * An instantiable class to check the coin's name and value
 * No bug is known right know
 * 
 * @author Zijian(Joey)Chen; Yiran Zhou
 *
 */
public class Coin {
  private String name;
  private int value;

  /**
   * This class will sign name and value from the input to the
   * private variable
   * @param name The name of the coin
   * @param value The value of the coin
   */
  public Coin(String name, int value) {
    this.name = name;
    this.value = value;
  }

  /**
   * An accessors which will return the name of coin 
   * @return The name of the coin
   */
  public String getName() {
    return name;
  }

  /**
   * An accessors which will return the value of coin
   * @return The value of the coin
   */
  public int getValue() {
    return value;
  }
}
