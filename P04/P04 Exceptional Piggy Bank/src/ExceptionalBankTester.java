//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   P04 Exceptional Bank	
// Files:   Coin.java ExceptionalBank.java ExceptionalBankTester
// Course:  CS 300 SP20 2020
//
// Author:  Zijian (Joey) Chen
// Email:   zchen697@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understood the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course 
// staff must fully acknowledge and credit those sources here.  If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons:         None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException; 
import java.util.zip.DataFormatException;

/**
 * ExceptionalBankTester Description:
 * Check the ExceptionalBank's method functional well or not
 * 
 * @author Mouna, Zijian (Joey) Chen
 */
public class ExceptionalBankTester {

	/**
	 * This method checks whether the ExceptionalBank constructor throws an
	 * IllegalArgumentException with appropriate error message, when it is passed a
	 * zero or a negative capacity. This test must fail if another kind of exception
	 * is thrown for such test scenario.
	 *
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testExceptionalBankConstructor() {
		try {
			// create an exceptional bank with a negative capacity
			ExceptionalBank bank = new ExceptionalBank(-10);
			System.out.println("Problem detected. The constructor call of the ExceptionalBank class did not "
					+ "throw an IllegalArgumentException when it is passed a negative capacity.");
			return false; // return false if no exception has been thrown
		} catch (IllegalArgumentException e1) {
			// check that the caught IllegalArgumentException includes
			// an appropriate error message
			if (e1.getMessage() == null // your test method should not throw
					// a NullPointerException,but must return false if e1.getMessage is null
					|| !e1.getMessage().toLowerCase().contains("must be a non-zero positive integer")) {
				System.out.println("Problem detected. The IllegalArgumentException thrown by the constructor "
						+ "call of the ExceptionalBank class when it is passed a negative capacity "
						+ "does not contain an appropriate error message.");
				return false;
			}
		} catch (Exception e2) {
			// an exception other than IllegalArgumentException has been thrown
			System.out.println("Problem detected. An unexpected exception has been thrown when calling the "
					+ "constructor of the ExceptionBank class with a negative argument. "
					+ "An IllegalArgumentException was expected to be thrown. " + "But, it was NOT the case.");
			e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank
			// constructor code.
			return false;
		}
		return true; // test passed
	}
	
/**
 * This method checks whether the ExceptionalBank constructor creates 
 * without errors an empty exceptional bank with capacity 20 when it is 
 * passed 20 as input parameter. This test must fail if any exception is 
 * thrown for such test scenario.
 * @return true when this test verifies a correct functionality, and false otherwise
 */
	public static boolean testGoodExceptionalBankConstructor() {
		try {
			ExceptionalBank bank = new ExceptionalBank(10);
			return true; // return true if the method works fine
		} catch (Exception e1) {
			System.out.println("Problem detected. No exception should be throw");
			e1.printStackTrace(); 
			return false;
		}
	}
	
	/**
	 * This method checks whether the ExceptionalBank.addCoin() method 
	 * throws an IllegalArgumentException with an appropriate error message,
	 * when it is passed a null reference.
	 * @return true when this test verifies a correct functionality, and false otherwise
	 */
	public static boolean testAddCoin() {
		try {
		// create a Coin with null
			ExceptionalBank one = new ExceptionalBank(5);
			Coin c = null;
			one.addCoin(c);
			System.out.println("Problem detected. The call of AddCoin method did not "
					+ "throw an IllegalArgumentException when it is passed a null.");
			return false;// return false if no exception has been thrown
		}
		catch(IllegalArgumentException e1) {
		// check that the caught IllegalArgumentException includes
		// an appropriate error message
			if(e1.getMessage() == null// your test method should not throw
						// a NullPointerException,but must return false if e1.getMessage is null
						|| !e1.getMessage().contains("WARNING! You cannot add a null reference"
								+ " to this bank.")) {
					System.out.println("Problem detected. The IllegalArgumentException "
							+ "thrown by the constructor call of the addCoin method "
							+ "when it is passed a null Coin c does not contain an "
							+ "appropriate error message.");
					return false;
				}
			} catch (Exception e2) {
				// an exception other than IllegalArgumentException has been thrown
				System.out.println("Problem detected. An unexpected exception has been thrown when calling the "
						+ "addCoin method with a null Coin c An IllegalArgumentException was expected"
						+ " to be thrown. " + "But, it was NOT the case.");
				e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank
				// constructor code.
				return false;
			}
		return true;
	}
	
	/**
	 * This method checks whether the ExceptionalBank.removeCoin() method 
	 * throws a NoSuchElementException with an appropriate error message,
	 * when it is called on an empty bank.
	 * @return true when this test verifies a correct functionality, and false otherwise
	 */
	public static boolean testRemoveCoinEmptyBank() {
		try {
		// create a Coin one to check
			ExceptionalBank one = new ExceptionalBank(5);
			one.removeCoin();
			System.out.println("Problem detected. The call of AddCoin method did not "
					+ "throw an IllegalArgumentException when it is passed a null.");
			return false;// return false if no exception has been thrown
		}
		catch(NoSuchElementException e1) {
		// check that the caught NoSuchElementException includes
		// an appropriate error message
			if(e1.getMessage() == null
						|| !e1.getMessage().contains("WARNING! This bank is empty. "
		    				+ "Unable to remove a coin.")) {
					System.out.println("Problem detected. The NoSuchElementException "
							+ "thrown by the call of the removeCoin method "
							+ "when it is passed a empty coin set does not contain an "
							+ "appropriate error message.");
					return false;
				}
			} catch (Exception e2) {
				System.out.println("Problem detected. An unexpected exception has been thrown when calling the "
						+ "removeCoin method with a empty coin set An NoSuchElementException was expected"
						+ " to be thrown. " + "But, it was NOT the case.");
				e2.printStackTrace(); // to help locate the error within the bad removeCoin()
				return false;
			}
		return true;
	}
	
	/**
	 * This method checks whether ExceptionalBank.addCoins() method throws 
	 * an IllegalArgumentException with an appropriate error message when 
	 * it is passed a null reference as input argument.
	 * @return true when this test verifies a correct functionality, and false otherwise.
	 */
	public static boolean testAddCoinsIllegalArgument() {
		try {
			// call addCoins with null
				ExceptionalBank one = new ExceptionalBank(5);
				one.addCoins(null);
				System.out.println("Problem detected. The call of AddCoins method did not "
						+ "throw an IllegalArgumentException when it is passed a null.");
				return false;// return false if no exception has been thrown
			}
			catch(IllegalArgumentException e1) {
			// check that the caught IllegalArgumentException includes
			// an appropriate error message
				if(e1.getMessage() == null// your test method should not throw
							// a IllegalArgumentException ,but must return false if e1.getMessage is null
							|| !e1.getMessage().contains("WARNING! The addCoins() method"
									+ " does not accept a null reference as input.")) {
						System.out.println("Problem detected. The IllegalArgumentException "
								+ "thrown by the call of the removeCoin method "
								+ "when it is passed a empty coin set does not contain an "
								+ "appropriate error message.");
						return false;
					}
				} catch (Exception e2) {
					// an exception other than NoSuchElementException has been thrown
					System.out.println("Problem detected. An unexpected exception has been thrown when calling the "
							+ "addCoins method with a null An IllegalArgumentException was expected"
							+ " to be thrown. " + "But, it was NOT the case.");
					e2.printStackTrace(); // to help locate the error within the bad addCoins()
					return false;
				}
			return true;
	}
	
	/**
	 * This method checks whether ExceptionalBank.addCoins() method throws a 
	 * NoSuchElementException with an appropriate error message when it 
	 * is passed a String object with a correct format (meaning "string:positive_number"),
	 *  but with a coin name not defined in the enum Coin's constants. For instance, 
	 *  when it is passed "blabla:10".
	 * @return true when this test verifies a correct functionality, and false otherwise.
	 */
	
	public static boolean testAddCoinsNoSuchElement() {
		try {
			// call addCoins with a coin not in enum
				ExceptionalBank one = new ExceptionalBank(5);
				one.addCoins("blalala:10");
				System.out.println("Problem detected. The call of AddCoins method did not "
						+ "throw an NoSuchElementException when it is passed a not allowed one.");
				return false;// return false if no exception has been thrown
			}
			catch(NoSuchElementException e1) {
			// check that the caught NoSuchElementException includes
			// an appropriate error message
				if(e1.getMessage() == null
							|| !e1.getMessage().contains("The coin name provided in the command line " + 
									"blalala:10 is invalid.")) {
						System.out.println("Problem detected. The NoSuchElementException "
								+ "thrown by the call of the addCoins method "
								+ "when it is passed a not allowed set does not contain an "
								+ "appropriate error message.");
						return false;
					}
				} catch (Exception e2) {
					// an exception other than NoSuchElementException has been thrown
					System.out.println("Problem detected. An unexpected exception has been thrown "
							+ "when calling the addCoins method with a null An NoSuchElementException "
							+ "was expected to be thrown. " + "But, it was NOT the case.");
					e2.printStackTrace(); // to help locate the error within the bad addCoins()
					return false;
				}
			return true;
	}
	
	/**
	 * This method checks whether ExceptionalBank.addCoins() method throws a
	 * DataFormatException with an appropriate error message when it is passed
	 * an incorrectly formatted string object, for instance "quarter: five", 
	 * or ": 6", or "DIME:-5"
	 * @return true when this test verifies a correct functionality, and false otherwise.
	 */
	public static boolean testAddCoinsInvalidDataFormat() {
		try {
			// call addCoins with invalid format
				ExceptionalBank one = new ExceptionalBank(5);
				one.addCoins("blalala: s10");
				System.out.println("Problem detected. The call of AddCoins method did not "
						+ "throw an DataFormatException when it is passed a not allowed one.");
				return false;// return false if no exception has been thrown
			}
			catch(DataFormatException e1) {
			// check that the caught DataFormatException includes
			// an appropriate error message
				if(e1.getMessage() == null
							|| !e1.getMessage().contains("The format of the command line " + 
									"blalala: s10" + " is incorrect.")) {
						System.out.println("Problem detected. The DataFormatException "
								+ "thrown by the call of the addCoins method "
								+ "when it is passed a not allowed set does not contain an "
								+ "appropriate error message.");
						return false;
					}
				} catch (Exception e2) {
					// an exception other than DataFormatException has been thrown
					System.out.println("Problem detected. An unexpected exception has been thrown "
							+ "when calling the addCoins method with a null An DataFormatException "
							+ "was expected to be thrown. " + "But, it was NOT the case.");
					e2.printStackTrace(); // to help locate the error within the bad addCoins()
					return false;
				}
			return true;
	}
	
	/**
	 * This method checks whether the ExceptionalBank.addCoins() works appropriately 
	 * when it is passed a String with a valid format. You can consider the following 
	 * test scenarios, for instance. First, Create a new ExceptionalBank with initial 
	 * capacity 20. Then, call .addCoins("QUARTER:2"). Then, verify that 2 quarters have
	 * been added to the bank without errors. Then, call .addCoins(" Penny : 3 "); Then,
	 * verify that 3 pennies have been added to the bank without errors. You can consider
	 * further scenarios. No exceptions must be thrown by the call of .addCoins() method
	 * with valid input arguments.
	 * @return true when this test verifies a correct functionality, and false otherwise.
	 */
	public static boolean testAddCoinsValidFormat() {
		try {
			// call addCoins with valid input
				ExceptionalBank one = new ExceptionalBank(5);
				one.addCoins(" penNY : 10 ");
				return true;// return true if no exception has been thrown
			}
		  catch (Exception e1) {
					// an exception has been thrown
					System.out.println("Problem detected. No exception should be throw");
					e1.printStackTrace(); // to help locate the error within the bad addCoins()
					return false;
				}
	}
	
	/**
	 * This method checks whether ExceptionalBank.loadCoins() method throws
	 * a NullPointerException when it is passed a null reference.
	 * @return true when this test verifies a correct functionality, and false otherwise.
	 */
	public static boolean testLoadCoinsNullReference() {
		try {
			File file = null;
			ExceptionalBank one = new ExceptionalBank(5);
			one.loadCoins(file);
		}catch(NullPointerException e1) {
			return true;
		}catch(FileNotFoundException e2) {
			System.out.println("Should throw NullPointerException, but actually"  
					+ "throw the FileNotFoundException");
			return false;
		}
		return false;
	}
	
	/**
	 * This method checks whether ExceptionalBank.loadCoins() 
	 * method throws a FileNotFoundException when it is passed a non found file.
	 * @return true when this test verifies a correct functionality, and false otherwise.
	 */
	public static boolean testLoadCoinsFileNotFound() {
		try {
			File file = new File("good/xswl.txt");
			ExceptionalBank one = new ExceptionalBank(5);
			one.loadCoins(file);
		}catch(FileNotFoundException e2) {
			return true;
		}catch(Exception e1) {
			System.out.println("Should catch FileNotFoundException, but catched others");
		}
		return false;
	}
	
	/**
	 * This method checks whether ExceptionalBank.loadCoins() method 
	 * loads appropriately without throwing any exception when it is 
	 * passed a found file.
	 * @return true when this test verifies a correct functionality, and false otherwise.
	 */
	public static boolean testLoadCoinsFileFound() {
		try {
			File file = new File("D://study/CS 300/P04/1.txt");
			ExceptionalBank one = new ExceptionalBank(5);
			one.loadCoins(file);
		}catch(Exception e1) {
			System.out.println("Should catch nothing");
			return false;
		}
		return true;
	}
	
	/**
	 * Calls unit tests implemented in this class
	 * @param args input arguments if any
	 */
	public static void main(String args[]) {
		System.out.println("testExceptionalBankConstructor: " + testExceptionalBankConstructor());
		System.out.println("testAddCoin: " + testAddCoin());
		System.out.println("testRemoveCoinEmptyBank: " + testRemoveCoinEmptyBank());
		System.out.println("testAddCoinsIllegalArgument: " + testAddCoinsIllegalArgument());
		System.out.println("testAddCoinsNoSuchElement: " + testAddCoinsNoSuchElement());
		System.out.println("testAddCoinsInvalidDataFormat: " + testAddCoinsInvalidDataFormat());
		System.out.println("testAddCoinsValidFormat: " + testAddCoinsValidFormat());
		System.out.println("testGoodExceptionalBankConstructor: " + testGoodExceptionalBankConstructor());
		System.out.println("testLoadCoinsNullReference: " + testLoadCoinsNullReference());
		System.out.println("testLoadCoinsFileNotFound: " + testLoadCoinsFileNotFound());
		System.out.println("testLoadCoinsFileFound: " + testLoadCoinsFileFound());
	}
}
