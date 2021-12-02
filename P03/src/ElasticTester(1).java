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

import java.util.Random;

/**
 * ElasticTester class description:
 * 
 * This class will check whether the ElasticBank class and Coin class
 * works fine or not
 * 
 * @author Zijian(Joey)Chen; Yiran Zhou
 */
public class ElasticTester {
  /**
   * check whether the Coin class functions well or not
   * @return true when the class works well, false otherwise
   */
  public static boolean testCoinInstantiableClass() {
    Coin quarter = new Coin("QUARTER", 25);
    Coin penny = new Coin("PENNY", 1);
    if (!penny.getName().equals("PENNY"))
      return false;
    if (penny.getValue() != 1)
      return false;
    if (!quarter.getName().equals("QUARTER"))
      return false;
    if (quarter.getValue() != 25)
      return false;
    return true;
  }

  /**
   * check whether the getBalance functions well or not
   * @return true when the getBalance works well, false otherwise
   */
  public static boolean testBalanceAccessors() {
    ElasticBank one = new ElasticBank(5);
    ElasticBank two = new ElasticBank(7);
    one.addCoin(new Coin("PENNY", 1));
    two.addCoin(new Coin("NICKEL", 5));
    if (one.getBalance() != 1)
      return false;
    if (two.getBalance() != 5)
      return false;
    return true;
  }

  /**
   * check whether the getCoins functions well or not
   * @return true when the getCoins works well, false otherwise
   */
  public static boolean testGetCoins() {
    ElasticBank one = new ElasticBank(5);
    ElasticBank two = new ElasticBank(7);
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("DIME", 10));
    one.addCoin(new Coin("NICKEL", 5));
    two.addCoin(new Coin("NICKEL", 5));
    if (!one.getCoins().equals("(PENNY, 1) (QUARTER, 25) (PENNY, 1) (DIME, 10) (NICKEL, 5)"))
      return false;
    if (!two.getCoins().equals("(NICKEL, 5)"))
      return false;
    return true;
  }

  /**
   * check whether the RemoveCoin functions well or not
   * @return true when the ReomoveCoin works well, false otherwise
   */
  public static boolean testRemoveCoin() {
    ElasticBank one = new ElasticBank(5);
    ElasticBank two = new ElasticBank(7);
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("DIME", 10));
    one.addCoin(new Coin("NICKEL", 5));
    two.addCoin(new Coin("NICKEL", 5));
    one.removeCoin();
    if (one.getSize() != 4)
      return false;
    two.removeCoin();
    if (two.getSize() != 0)
      return false;
    return true;
  }

  /**
   * check whether the Empty functions well or not
   * @return true when the Empty works well, false otherwise
   */
  public static boolean testEmpty() {
    ElasticBank one = new ElasticBank(5);
    ElasticBank two = new ElasticBank(7);
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("DIME", 10));
    one.addCoin(new Coin("NICKEL", 5));
    two.addCoin(new Coin("NICKEL", 5));
    one.empty();
    if (one.getSize() != 0)
      return false;
    two.empty();
    if (two.getSize() != 0)
      return false;
    return true;
  }

  /**
   * check whether the addCoin functions well or not
   * @return true when the addCoin works well, false otherwise
   */
  public static boolean testAddCoin() {
    ElasticBank one = new ElasticBank(5);
    ElasticBank two = new ElasticBank(7);
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("DIME", 10));
    one.addCoin(new Coin("NICKEL", 5));

    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("DIME", 10));
    one.addCoin(new Coin("NICKEL", 5));

    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("DIME", 10));
    one.addCoin(new Coin("NICKEL", 5));


    if (!one.getCoins().equals(
        "(PENNY, 1) (QUARTER, 25) (PENNY, 1) (DIME, 10) (NICKEL, 5) (PENNY, 1) (QUARTER, 25) (PENNY, 1) (DIME, 10) (NICKEL, 5) (PENNY, 1) (QUARTER, 25) (PENNY, 1) (DIME, 10) (NICKEL, 5)"))
      return false;

    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("DIME", 10));
    one.addCoin(new Coin("NICKEL", 5));

    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("DIME", 10));
    one.addCoin(new Coin("NICKEL", 5));
    one.addCoin(new Coin("NICKEL", 5));

    if (!one.getCoins().equals("(NICKEL, 5)"))
      return false;
    return true;
  }

  /**
   * Calls the test methods implemented in this class and 
   * displays their output
   * @param args not used
   */
  public static void main(String[] args) {
    System.out.println("testCoinInstantiableClass:" + testCoinInstantiableClass());
    System.out.println("testBalanceAccessors:" + testBalanceAccessors());
    System.out.println("testGetCoins:" + testGetCoins());
    System.out.println("testRemoveCoin:" + testRemoveCoin());
    System.out.println("testEmpty:" + testEmpty());
    System.out.println("testAddCoin:" + testAddCoin());
  }

}
