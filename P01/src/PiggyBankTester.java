//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P01 Piggy Bank
// Files: PiggyBank.java, PiggyBankTester.java
// Course: CS 300 , SPRING 2020
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
// Persons: NONE(identify each person and describe their help in detail)
// Online Sources: NONE(identify each URL and describe their assistance in detail)
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Random;

public class PiggyBankTester {

  /**
   * Checks whether PiggyBank.getCoinName() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean getCoinNameTestMethod() {
    // consider all coin values as input arguments
    for (int i = 0; i < PiggyBank.COINS_VALUES.length; i++)
      if (!PiggyBank.getCoinName(PiggyBank.COINS_VALUES[i]).equals(PiggyBank.COINS_NAMES[i])) {
        System.out.println("1");
        return false;
      }
    // consider input argument which does not correspond to a coin value
    if (!PiggyBank.getCoinName(7).equals(PiggyBank.NO_SUCH_COIN)) {
      System.out.println("2");
      return false;
    }
    if (!PiggyBank.getCoinName(-10).equals(PiggyBank.NO_SUCH_COIN)) {
      System.out.println("3");
      return false;
    }
    return true;
  }

  /**
   * Checks whether PiggyBank.getBalance() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean getBalanceTestMethod() {
    // scenario 1 - empty piggy bank
    int[] coins = new int[10]; // array storing the coins held in a piggy bank
    int size = 0; // number of coins held in coins array
    if (PiggyBank.getBalance(coins, size) != 0) {
      System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
          + "return the expected output when passed an empty piggy bank.");
      return false;
    }
    // scenario 2 - non empty piggy bank
    coins = new int[] {10, 1, 5, 25, 1, 0, 0};
    size = 5;
    if (PiggyBank.getBalance(coins, size) != 42) {
      System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
          + "return the expected output when passed an piggy bank that holds "
          + "two pennies, a nickel, a dime, and a quarter.");
      return false;
    }
    // scenario 3 - another non empty piggy bank
    coins = new int[] {10, 1, 5, 25, 1, 0};
    size = 3;
    if (PiggyBank.getBalance(coins, size) != 16) {
      System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
          + "return the expected output when passed an piggy bank that holds "
          + "a penny, a nickel, and a dime, only.");
      return false;
    }
    return true;
  }

  /**
   * Checks whether PiggyBank.getSpecificCoinCount() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean getSpecificCoinCountTestMethod() {
    // scenario 1 - non empty piggy bank
    int[] coins = new int[] {10, 1, 5, 25, 1, 0, 0};
    int size = 5;
    int coinValue = 5;
    if (PiggyBank.getSpecificCoinCount(coinValue, coins, size) != 1) {
      System.out.println("Problem detected. Your PiggyBank.getSpecificCoinCount() "
          + "did not return the expected output when passed an piggy "
          + "bank that holds two pennies, a nickel, a dime, and a quarter.");
      return false;
    }
    // scenario 2 - Extreme Example when 0 appear
    coins = new int[] {0, 0, 0, 0, 0, 0, 0};
    size = 0;
    coinValue = 5;
    if (PiggyBank.getSpecificCoinCount(coinValue, coins, size) != 0) {
      System.out.println("Problem detected. Your PiggyBank.getSpecificCoinCount() "
          + "did not return the expected output when passed an piggy bank "
          + "that holds zero pennies, zero nickel, zero dime, and zero quarter.");
      return false;
    }
    // scenario 3 - Extreme Example with 25 each
    coins = new int[] {25, 25, 25, 25, 25, 25, 25};
    size = 7;
    coinValue = 25;
    if (PiggyBank.getSpecificCoinCount(coinValue, coins, size) != 7) {
      System.out.println("Problem detected. Your PiggyBank.getSpecificCoinCount() "
          + "did not return the expected output when passed an piggy bank "
          + "that holds zero pennies, zero nickel, zero dime, and Seven quarter.");
      return false;
    }
    return true;
  }

  /**
   * Checks whether PiggyBank.addCoin() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean addCoinTestMethod() {
    // scenario 1 - check with weird coin value
    int[] coins = new int[] {10, 1, 5, 25, 1, 0};
    int size = 5;
    int coinValue = 7;
    if (PiggyBank.addCoin(coinValue, coins, size) != size) {
      System.out.println("Problem detected. Your PiggyBank.addCoin() "
          + "did not return the expected output when passed an piggy bank "
          + "that holds coinValue of seven which is invalid");
      return false;
    }
    // scenario 2 - With size excess 100
    coins = new int[] {10, 1, 5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1,
        5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1,
        5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1,
        5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1};
    size = 100;
    coinValue = 5;
    if (PiggyBank.addCoin(coinValue, coins, size) != size) {
      System.out.println("Problem detected. Your PiggyBank.addCoin() "
          + "did not return the expected output when passed an piggy bank "
          + "that holds size ont-hundred which is invalid");
      return false;
    }
    // scenario 3 - Check standard example
    coins = new int[] {10, 1, 5, 25, 1, 10, 0};
    size = 6;
    coinValue = 5;
    if (PiggyBank.addCoin(coinValue, coins, size) != 7) {
      System.out.println("Problem detected. Your PiggyBank.addCoin() "
          + "did not return the expected output when passed an piggy bank "
          + "that holds coinValue of seven which is invalid");
      return false;
    }
    return true;
  }

  /**
   * Checks whether PiggyBank.removeCoin() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean removeCoinTestMethod() {
    // scenario 1 - check empty piggy bank account
    int[] coins = new int[] {0, 0, 0, 0, 0, 0};
    int size = 0;
    if (PiggyBank.removeCoin(coins, size) != 0) {
      System.out.println("Problem detected. Your PiggyBank.removeCoin() "
          + "did not return the expected output when passed an piggy bank "
          + "that holds empty account which is invalid");
      return false;
    }
    // scenario 2 - normal check with normal number
    coins = new int[] {1, 5, 5, 10, 10, 0};
    size = 5;
    if (PiggyBank.removeCoin(coins, size) != 4) {
      System.out.println("Problem detected. Your PiggyBank.removeCoin() "
          + "did not return the expected output when passed an piggy bank "
          + "that holds size not declined by one which is invalid");
      return false;
    }
    // scenario 3 - extreme example to check the boundary
    coins = new int[] {10, 1, 5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1,
        5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1,
        5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1,
        5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1};
    size = 100;
    if (PiggyBank.removeCoin(coins, size) != 99) {
      System.out.println("Problem detected. Your PiggyBank.removeCoin() "
          + "did not return the expected output when passed an piggy bank "
          + "that holds size not declined by one which is invalid");
      return false;
    }
    return true;
  }

  /**
   * Checks whether PiggyBank.emptyPiggyBank() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean emptyPiggyBankTestMethod() {
    // scenario 1 - empty piggy bank account check
    int[] coins = null;
    int size = 0;
    if (PiggyBank.emptyPiggyBank(coins, size) != 0) {
      System.out.println("Problem detected. Your PiggyBank.emptyPiggyBankTestMethod() "
          + "did not return the expected output when passed an piggy bank that holds "
          + "empty account which is impossible to empty again");
      return false;
    }
    // scenario 2 - normal piggy bank account check
    coins = new int[] {10, 1, 5, 25, 0, 0};
    size = 4;
    if (PiggyBank.emptyPiggyBank(coins, size) != 0) {
      System.out.println("Problem detected. Your PiggyBank.emptyPiggyBankTestMethod()"
          + "did not return the expected output when passed an piggy bank that holds "
          + "should be empty account");
      return false;
    }
    // scenario 3 - extreme data piggy bank account check
    coins = new int[] {10, 1, 5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1,
        5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1,
        5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1,
        5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1, 5, 25, 1, 0, 0, 10, 1};
    size = 100;
    if (PiggyBank.emptyPiggyBank(coins, size) != 0) {
      System.out.println("Problem detected. Your PiggyBank.emptyPiggyBankTestMethod()"
          + "did not return the expected output when passed an piggy bank that" + " is invalid");
      return false;
    }
    return true;
  }

  /**
   * Checks whether PiggyBank.withdraw() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean withdrawTestMethod() {
    // scenario 1 - amount more than piggy bank account check
    int[] coins = new int[] {1, 0, 0, 0, 0, 0};
    int size = 1;
    int amount = 5;
    int[] resultCoins = new int[] {0, 0, 0, 0, 0};
    resultCoins = PiggyBank.withdraw(amount, coins, size);
    if (resultCoins[0] != 1) {
      System.out.println("Problem detected. Your PiggyBank.withdraw() "
          + "did not return the expected output when the amount more than "
          + "piggy bank account check");
      return false;
    }
    // scenario 2 - exact change can be made
    coins = new int[] {1, 1, 1, 5, 10, 25};
    size = 6;
    amount = 18;
    resultCoins = PiggyBank.withdraw(amount, coins, size);
    if (resultCoins[0] != 1 || resultCoins[1] != 0 || resultCoins[2] != 1 || resultCoins[3] != 1
        || resultCoins[4] != 3) {
      System.out.println("Problem detected. Your PiggyBank.withdraw() "
          + "did not return the expected output when exact change can be made");
      for (int i = 0; i <= 4; i++)
        System.out.println(resultCoins[i]);
      return false;
    }
    // scenario 3 - exact change cannot be made
    coins = new int[] {5, 5, 10, 10, 25};
    size = 5;
    amount = 38;
    resultCoins = PiggyBank.withdraw(amount, coins, size);
    if (resultCoins[0] != 2 || resultCoins[1] != 1 || resultCoins[2] != 1 || resultCoins[3] != 1
        || resultCoins[4] != 0) {
      System.out.println("Problem detected. Your PiggyBank.removeCoin() "
          + "did not return the expected output when exact change cannot be made");
      return false;
    }
    return true;
  }

  /**
   * Calls the test methods implemented in this class and displays their output
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("getCoinNameTest(): " + getCoinNameTestMethod());
    System.out.println("getBalanceTest(): " + getBalanceTestMethod());
    System.out.println("getSpecificCoinCountTest(): " + getSpecificCoinCountTestMethod());
    System.out.println("addCoinTestMethod(): " + addCoinTestMethod());
    System.out.println("removeCoinTestMethod(): " + removeCoinTestMethod());
    System.out.println("emptyPiggyBankTestMethod(): " + emptyPiggyBankTestMethod());
    System.out.println("withdrawTestMethod(): " + withdrawTestMethod());
  }

}

