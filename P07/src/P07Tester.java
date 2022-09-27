//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P07 File Finder
// Files: P07Tester.java
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

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Description:
 * This class will define a main method that calls each of the other methods
 * in this file, and prints out whether each test returns true or false.
 * (test ShallowFileIterator/DeepFileIterator/FilteredFileIterator) 
 * @author Zijian Chen 
 */
public class P07Tester {
	
	/**
	 * Check ShallowFileIterator
	 * @param file target file to check
	 * @return true when the method works as expected and false otherwise
	 */
	public static boolean testShallowFileIterator(File file)
	{	
		String a = "";
		String expectedResults = "assignments, exam preparation, lecture notes, "
				 + "reading notes, todo.txt, ";
		try {
			ShallowFileIterator it = new ShallowFileIterator(file);
			while(it.hasNext()) {
				a = a +it.next().getName() + ", ";
			}
			if(a.equals(expectedResults)) {
				return true;
			}
		}catch(FileNotFoundException e1){
			System.out.println("Unexpected Result");
			return false;
		}
		return false;
	}
	
	/**
	 * Check DeepFileIterator
	 * @param file target file to check
	 * @return true when the method works as expected and false otherwise
	 */
	public static boolean testDeepFileIterator(File file)
	{	
		file = new File(file.getPath() + File.separator + "assignments");
		String a = "";
		String expectedResults = "P01, PiggyBank.java, P02, CalendarPrinter.java, P03, "
				 + "ElasticBank.java, P04, ExceptionalPiggyBank.java, P05, ExtendedVersion, "
				 + "WinterCarnival.java, WinterCarnival.java, P06, AlphabetTrain.java, ";
		try {
			DeepFileIterator it = new DeepFileIterator(file);
			while(it.hasNext()) {
				File bb = it.next();
				a = a + bb.getName() + ", ";
			}
			if(a.equals(expectedResults)) {
				return true;
			}
		}catch(FileNotFoundException e1){
			System.out.println("Unexpected Result");
			return false;
		}
		return false;
	}
	
	/**
	 * Check FilteredFileIterator
	 * @param <T> Type
	 * @param file target file to check
	 * @return true when the method works as expected and false otherwise
	 */
	public static <T> boolean testFilteredFileIterator(File file)
	{	
		String a = "";
		String expectedResults =  "PiggyBank.java, CalendarPrinter.java, ElasticBank.java, "
				 + "ExceptionalPiggyBank.java, WinterCarnival.java, WinterCarnival.java, "
				 + "AlphabetTrain.java, codeSamples.java, ";
		try {
			FilteredFileIterator it = new FilteredFileIterator(file,".java");
			while(it.hasNext()) {
				a = a +it.next().getName() + ", ";
			}
			if(a.equals(expectedResults)) {
				return true;
			}
		}catch(FileNotFoundException e1){
			System.out.println("Unexpected Result");
			return false;
		}
		return false;
	}
	
	/**
	 * run the test methods
	 * @param args
	 */
	public static void main (String [] args) {
		File file = new File("filesystem");
		System.out.println("testShallowFileIterator: " + testShallowFileIterator(file));
		System.out.println("testDeepFileIterator: " + testDeepFileIterator(file));
		System.out.println("testFilteredFileIterator: " + testFilteredFileIterator(file));
	}
}
