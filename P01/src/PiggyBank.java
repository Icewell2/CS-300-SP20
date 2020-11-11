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
public class PiggyBank {
  public final static int[] COINS_VALUES = {1, 5, 10, 25}; // coins values in cents
  // coins names
  public final static String[] COINS_NAMES = {"PENNY", "NICKEL", "DIME", "QUARTER"};
  public final static String NO_SUCH_COIN = "N/A"; // N/A string
  private final static Random RAND_GEN = new Random(100); // generator of random integers

  public static boolean findExactAmount(int amount, int[]coins, int size,int stat[],int ans[])
  {
    

    // calculate the least number of coins needed to find an exact amount
    int removesum=0;
    if (amount / COINS_VALUES[3] <= stat[1]) {
      ans[1] = ans[1] + amount / COINS_VALUES[3];
      ans[0] = ans[0] - amount / COINS_VALUES[3];
      removesum = removesum + (amount / COINS_VALUES[3]) * COINS_VALUES[3];
      amount = amount - (amount / COINS_VALUES[3]) * COINS_VALUES[3];

    } else {
      ans[1] = ans[1] + stat[1];
      ans[0] = ans[0] - stat[1];
      removesum = removesum + stat[1] * COINS_VALUES[3];
      amount = amount - stat[1] * COINS_VALUES[3];

    }

    if (amount / COINS_VALUES[2] <= stat[2]) {
      ans[2] = ans[2] + amount / COINS_VALUES[2];
      ans[0] = ans[0] - amount / COINS_VALUES[2];
      removesum = removesum + (amount / COINS_VALUES[2]) * COINS_VALUES[2];
      amount = amount - (amount / COINS_VALUES[2]) * COINS_VALUES[2];

    } else {
      ans[2] = ans[2] + stat[2];
      ans[0] = ans[0] - stat[2];
      removesum = removesum + stat[2] * COINS_VALUES[2];
      amount = amount - stat[2] * COINS_VALUES[2];

    }

    if (amount / COINS_VALUES[1] <= stat[3]) {
      ans[3] = ans[3] + amount / COINS_VALUES[1];
      ans[0] = ans[0] - amount / COINS_VALUES[1];
      removesum = removesum + (amount / COINS_VALUES[1]) * COINS_VALUES[1];
      amount = amount - (amount / COINS_VALUES[1]) * COINS_VALUES[1];

    } else {
      ans[3] = ans[3] + stat[3];
      ans[0] = ans[0] - stat[3];
      removesum = removesum + stat[3] * COINS_VALUES[1];
      amount = amount - stat[3] * COINS_VALUES[1];

    }

    if (amount / COINS_VALUES[0] <= stat[4]) {
      ans[4] = ans[4] + amount / COINS_VALUES[0];
      ans[0] = ans[0] - amount / COINS_VALUES[0];
      removesum = removesum + (amount / COINS_VALUES[0]) * COINS_VALUES[0];
      amount = amount - (amount / COINS_VALUES[0]) * COINS_VALUES[0];

    } else {
      ans[4] = ans[4] + stat[4];
      ans[0] = ans[0] - stat[4];
      removesum = removesum + stat[4] * COINS_VALUES[0];
      amount = amount - stat[4] * COINS_VALUES[0];

    }
    if(amount ==0)
      return true;
    else
    return false;
  }
  /**
   * Returns the name of a specified coin value
   * 
   * @param coin represents a coin value in cents.
   * @return the String name of a specified coin value if it is valid and N/A if the coin value is
   *         not valid
   */
  public static String getCoinName(int coin) {
    String coinName = "";
    // check the value of the coin and sign the name
    if (coin == COINS_VALUES[0]) {

      coinName = COINS_NAMES[0];
      return coinName;
    }
    if (coin == COINS_VALUES[1]) {
      coinName = COINS_NAMES[1];
      return coinName;
    }
    if (coin == COINS_VALUES[2]) {
      coinName = COINS_NAMES[2];
      return coinName;
    }
    if (coin == COINS_VALUES[3]) {
      coinName = COINS_NAMES[3];
      return coinName;
    }
    return NO_SUCH_COIN; // return an empty string
  }

  /**
   * Returns the balance of a piggy bank in cents
   * 
   * @param coins an oversize array which contains all the coins held in a piggy bank
   * @param size  the total number of coins stored in coins array
   * @return the total value of the coins held in a piggy bank in cents
   */
  public static int getBalance(int[] coins, int size) {
    // declare variables to store the count of different coin
    int numPenny = 0;
    int numNickel = 0;
    int numDime = 0;
    int numQuarter = 0;
    int sum = 0;
    // check each coin in array coins and count the time different coin appears
    for (int i = 0; i < size; i++) {
      if (coins[i] == COINS_VALUES[0]) {
        numPenny++;
      } else if (coins[i] == COINS_VALUES[1]) {
        numNickel++;
      } else if (coins[i] == COINS_VALUES[2]) {
        numDime++;
      } else if (coins[i] == COINS_VALUES[3]) {
        numQuarter++;
      }
    }
    // calculate the total balance
    sum = numPenny + numNickel * 5 + numDime * 10 + numQuarter * 25;
    return sum; // the balance
  }

  /**
   * Returns the total number of coins of a specific coin value held in a piggy bank
   * 
   * @param coinValue the value of a specific coin
   * @param coins     an oversize array which contains all the coins held in a piggy bank
   * @param size      the total number of coins stored in coins array
   * @return the number of coins of value coinValue stored in the array coins
   */
  public static int getSpecificCoinCount(int coinValue, int[] coins, int size) {
    int num =0;
    // use for-loop to check how many times a specific coin appears
    for (int i = 0; i < size; i++) {
      if (coins[i] == coinValue)
        num++;
    }
    return num; // the num of time the coin appears
  }

  /**
   * Displays information about the content of a piggy bank
   * 
   * @param coins an oversize array storing the coins held in a piggy bank
   * @param size  number of coin held array coins
   */
  public static void printPiggyBank(int[] coins, int size) {
    // print out all the coins in the piggy bank
    System.out.println("QUARTERS: " + getSpecificCoinCount(25, coins, size));
    System.out.println("DIMES: " + getSpecificCoinCount(10, coins, size));
    System.out.println("NICKELS: " + getSpecificCoinCount(5, coins, size));
    System.out.println("PENNIES: " + getSpecificCoinCount(1, coins, size));
    System.out.println("Balance: $" + getBalance(coins, size) * 0.01);
  }

  /**
   * Adds a given coin to a piggy bank. This operation can terminate successfully or unsuccessfully.
   * For either cases, this method displays a descriptive message for either cases.
   *
   * @param coin  the coin value in cents to be added to the array coins
   * @param coins an oversize array storing the coins held in a piggy bank
   * @param size  the total number of coins contained in the array coins before this addCoin method
   *              is called.
   * @return the new size of the coins array after trying to add coin.
   */
  public static int addCoin(int coin, int[] coins, int size) {
    // check whether the piggy bank is full or not
    if (coins.length <= size) {
      System.out.println("Tried to add a " + getCoinName(coin)
          + ", but could not because the piggy bank is full.");
      return size;
    }
    // check whether the input value of coin by user is valid or not
    if (getCoinName(coin).equals(NO_SUCH_COIN)) {
      System.out.println(coin + " cents is not a valid US currency coin.");
      return size;
    }
    // if the piggy bank is not full and the coin value is valid then
    // add the value to the coins array
    coins[size] = coin;
    System.out.println("Added a " + getCoinName(coin) + ".");
    return size + 1; // return the new size
  }

  /**
   * Removes an arbitrary coin from a piggy bank. This method may terminate successfully or
   * unsuccessfully. In either cases, a descriptive message is displayed.
   *
   * @param coins an oversize array which contains the coins held in a piggy bank
   * @param size  the number of coins held in the coins array before this method is called
   * @return the size of coins array after this method returns successfully
   */
  public static int removeCoin(int[] coins, int size) {
    // check whether the piggy bank is empty if it is we cannot remove anything
    if (size == 0) {
      System.out
          .println("Tried to remove a coin, but could not because " + "the piggy bank is empty.");
      return 0;
    }
    // generate size number of random number and remove the one in the coins array
    int index = RAND_GEN.nextInt(size);
    System.out.println("Removed a " + getCoinName(coins[index]) + ".");
    coins[index] = coins[size - 1];
    coins[size - 1] = 0;
    return size - 1; // return the new size when after we remove one coin
  }

  /**
   * Removes all the coins in a piggy bank. It also displays the total value of the removed coins
   *
   * @param coins an oversize array storing the coins held in a piggy bank application
   * @param size  number of coins held in coins array before this method is called
   * @return the new size of the piggy bank after removing all its coins.
   */
  public static int emptyPiggyBank(int[] coins, int size) {
    // check whether piggy bank is empty if so we cannot empty it
    if (coins == null || size == 0) {
      System.out.println("Zero coin removed. The piggy bank is already empty.");
      return 0;
    }
    // if piggy bank is not empty, then we need to empty all element
    // by signing value zero to them
    int sum = 0;
    for (int i = 0; i < size; i++) {
      sum = sum + coins[i];
      coins[i] = 0;
    }
    System.out.println("All done. " + sum + " cents removed.");
    return 0; // return the new size of piggy bank after empty
  }

  /**
   * Removes the least number of coins needed to fulfill a withdrawal request
   *
   * @param amount amount to withdraw given in cents
   * @param coins  an oversize array storing the coins held in a piggy bank
   * @param size   number of coins stored in coins array before this method is called
   * @return perfect size array of 5 elements, index 0 stores the new size of the piggy bank after
   *         this method returns. Indexes 1, 2, 3, and 4 store respectively the number of removed
   *         quarters, dimes, nickels, and pennies.
   */
  public static int[] withdraw(int amount, int[] coins, int size) {
    int[] stat = new int[5];
    int[] ans = new int[5];
    int sum = 0;
    // calculate numbers of different amount of money in piggy bank
    for (int i = 0; i < size; i++) {
      sum = sum + coins[i];
      if (coins[i] == COINS_VALUES[3])
        stat[1]++;
      if (coins[i] == COINS_VALUES[2])
        stat[2]++;
      if (coins[i] == COINS_VALUES[1])
        stat[3]++;
      if (coins[i] == COINS_VALUES[0])
        stat[4]++;
    }
    stat[0] = size;
    ans[0] = size;
    if (sum < amount) {
      System.out.println(
          "Unable to withdraw " + amount + " cents. NOT" + " enough money in the piggy bank.");
      return stat;
    }
    if (sum == amount) {
      System.out.println("All done. " + amount + " cents removed.");
    }

while(!findExactAmount(amount,coins, size,stat,ans))
{
  ans[0]=size;
  ans[1]=0;
  ans[2]=0;
  ans[3]=0;
  ans[4]=0;
  amount++;
}
    System.out.println("All done. " + amount + " cents removed.");
    int[] temp = new int[5];
    temp[1] = ans[1];
    temp[2] = ans[2];
    temp[3] = ans[3];
    temp[4] = ans[4];
    while (temp[1] > 0) {
      for (int i = size - 1; i >= 0; i--) {
        if (coins[i] == COINS_VALUES[3]) {
          temp[1]--;
          coins[i] = coins[size - 1];
          coins[size - 1] = 0;
          size--;
          break;
        }
      }
    }
    while (temp[2] > 0) {
      for (int i = size - 1; i >= 0; i--) {
        if (coins[i] == COINS_VALUES[2]) {
          temp[2]--;
          coins[i] = coins[size - 1];
          coins[size - 1] = 0;
          size--;
          break;
        }
      }
    }
    while (temp[3] > 0) {
      for (int i = size - 1; i >= 0; i--) {
        if (coins[i] == COINS_VALUES[1]) {
          temp[3]--;
          coins[i] = coins[size - 1];
          coins[size - 1] = 0;
          size--;
          break;
        }
      }
    }
    while (temp[4] > 0) {
      for (int i = size - 1; i >= 0; i--) {
        if (coins[i] == COINS_VALUES[0]) {
          temp[4]--;
          coins[i] = coins[size - 1];
          coins[size - 1] = 0;
          size--;
          break;
        }
      }
    }
    return ans;
  }
}

