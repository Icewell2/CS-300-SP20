//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P03 Elastic Piggy Bank
// Files: Coin.java ElasticBank.java ElasticTester.java
// Course: CS 300, 20 Spring
//
// Author: Zijian(Joey)Chen
// Email: 
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: Yiran Zhou                
// Partner Email: 
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
 * ElasticBank class description:
 * 
 * This class will deal with different operation of coins including
 * calculate balance, add coin to the bank, empty it or remove some coins.
 * 
 * @author Zijian(Joey)Chen; Yiran Zhou
 *
 */
public class ElasticBank {
  private Coin[] coins; // an array to store the information of each coin
  private int size; // current size of the coins array
  private int expansionsLeft; // how many an coins array can expanded
  private static Random rand = new Random(100); //randomly get a number 

  /**
   * Initialize the coins array with 10 capacity 
   * Sign the initial value of size and expansionsLeft
   */
  public ElasticBank() {
    coins = new Coin[10];
    this.size = 0;
    this.expansionsLeft = 2;
  }

  /**
   * Initialize the value of coins when user give an initialCapacity
   * Sign the initial value of size and expansionsLeft
   * @param initialCapacity
   */
  public ElasticBank(int initialCapacity) {
    coins = new Coin[initialCapacity];
    this.size = 0;
    this.expansionsLeft = 2;
  }

  /**
   * Get the current capacity of the coins array
   * @return the current capacity of the coins 
   */
  public int capacity() {
    return coins.length;
  }

  /**
   * Get the current expansionsLeft 
   * @return the current expansionsLeft
   */
  public int getExpansions() {
    return expansionsLeft;
  }

  /**
   * Get the number of coins actually stored in the coins
   * @return the number of coins stored
   */
  public int getSize() {
    return size;
  }

  /**
   * Calculate current balance of the Bank
   */
  public int getBalance() {
    int totalBalance = 0;
    for (int i = 0; i < size; i++) {
      totalBalance += coins[i].getValue();
    }
    return totalBalance;
  }

  /**
   * get the string representative of the coins
   * for example (name,value)
   * @return the string representative of the coins
   */
  public String getCoins() {
    String coinInfo = "";
    for (int i = 0; i < size; i++) {
      coinInfo = coinInfo.concat("(" + coins[i].getName() + ", " + coins[i].getValue() + ")");
      if (i < size - 1)
        coinInfo = coinInfo.concat(" ");
    }
    return coinInfo;
  }

  /**
   * Remove a coin from the array randomly
   * @return A randomly chosen coin to remove 
   */
  public Coin removeCoin() {
    if (size == 0)
      return null;
    int index = rand.nextInt(size);
    coins[index] = coins[size - 1];
    coins[size - 1] = null;
    size--;
    return coins[size];
  }

  /**
   * Empty the whole coins array 
   */
  public void empty() {
    for (int i = 0; i < size; i++) {
      coins[i] = null;
    }
    size = 0;
  }

  /**
   * Add a coin to the coins array, and will check whether the
   * array is full filled is it is, then expand it or empty it
   * depends on the situation.
   * @param c the coin to be added to coins
   */
  public void addCoin(Coin c) {
    if (size < capacity()) { // is current number of coins is less than capacity, add it
      size++;
      coins[size - 1] = new Coin(c.getName(), c.getValue());
    } else { 
      if (expansionsLeft > 0) { // if expansionsLeft is better than one then expand the coins array
        expansionsLeft--;
        Coin[] copy = new Coin[size + 10];
        for (int i = 0; i < size; i++) {
          copy[i] = coins[i];
        }
        size++;
        copy[size - 1] = c;
        coins = copy;
      } else { // if no expansionsLeft then empty the array
        empty();
        coins[0] = c;
        size = 1;
      }
    }
  }
}
