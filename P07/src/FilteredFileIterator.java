//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P07 File Finder
// Files: FilterFileIterator.java
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
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Description:
 * only return the most inner (sub-folder's) file's name
 * @author Zijian Chen
 */
public class FilteredFileIterator implements Iterator<File> {
	private DeepFileIterator fileIterator;
	private String searchPattern;
	private File nextMatchingFile;

	/**
	 * The constructor of the FilteredFileIterator
	 * @param file The target file to reach
	 * @param searchPattern filter the results that are returned from this iterator
	 * @throws FileNotFoundException if file not exist in target folder
	 */
	public FilteredFileIterator(File file, String searchPattern) throws FileNotFoundException {
		this.fileIterator = new DeepFileIterator(file);
		this.searchPattern = searchPattern;
		this.nextMatchingFile = findMatchingFile();
	}

	/**
	 * This method can repeatedly call next on the 
	 * fileIterator, until it returns a file that contains the specified searchPattern.
	 * @return the file contains the searchPattern and null otherwise
	 */
	private File findMatchingFile() {
		while (fileIterator.hasNext()) {
			File file = fileIterator.next();
			if (file.getName().contains(searchPattern)) {
				return file;
			}
		}
		return null;
	}

	@Override
	/**
	 *  This method will check whether there is a next element and return false
	 *  if there is not.
	 *  @return true is there is a next element
	 */
	public boolean hasNext() {
		return nextMatchingFile != null;
	}

	@Override
	/**
	 *  This method return the next item in the folder
	 *  @return the next item's information
	 */
	public File next() {
		if (!hasNext()) {
			throw new NoSuchElementException("No next Element");
		}
		File file = nextMatchingFile;
		nextMatchingFile = findMatchingFile();
		return file;
	}
}
