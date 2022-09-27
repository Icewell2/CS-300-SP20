//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: DeepFileIterator
// Files: DeepFileIterator.java
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
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Description:
 * This class will return all elements in the folder including the sub-folder
 * @author Zijian Chen
 */

public class DeepFileIterator implements Iterator<File> {
	private File[] folderContents;
	private int nextIndex = 0;
	private DeepFileIterator contentsIterator;

	/**
	 * The constructor of DeepFileIterator
	 * @param file The file/folder to check
	 * @throws FileNotFoundException if the file/folder is not found
	 */
	public DeepFileIterator(File file) throws FileNotFoundException {
		if (!file.exists() || !file.isDirectory()) {
			throw new FileNotFoundException("directory not exist!");
		}
		folderContents = file.listFiles();
		Arrays.sort(folderContents);
		nextIndex = 0;
		contentsIterator = null;
	}

	@Override
	/**
	 *  This method will check whether there is a next element and return false
	 *  if there is not.
	 *  @return true is there is a next element
	 */
	public boolean hasNext() {
		return nextIndex < folderContents.length;
	}

	@Override
	/**
	 *  This method return the next item in the folder
	 *  set contentIterator if the it reach the end
	 *  @return the next item's information
	 */
	public File next() {
		if (!hasNext()) {
			throw new NoSuchElementException("No next Element");
		}
		File file;
		if (contentsIterator != null) {
			file = contentsIterator.next();
			if (!contentsIterator.hasNext()) {
				nextIndex++;
				contentsIterator = null;
			}
		} else {
			file = folderContents[nextIndex];
			try {
				contentsIterator = new DeepFileIterator(file);
				if(!contentsIterator.hasNext()) {
					nextIndex++;
					contentsIterator = null;
				}
			} catch (FileNotFoundException e) {
				contentsIterator = null;
				nextIndex++;
			}
		}
		return file;
	}
}
