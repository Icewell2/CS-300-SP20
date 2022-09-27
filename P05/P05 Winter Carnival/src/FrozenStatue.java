//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P05 Winter Carnival
// Files: FrozenStatue.java
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
import java.io.File;

/**
 * FrozenStatue class Description: 
 * deal with the location of the FrozenStatue
 * @author Zijian Chen, Yiran Zhou
 */
public class FrozenStatue {

  protected float x;
  protected float y;
  protected boolean isFacingRight;
  protected String imageName;
  
  /**
   * This constructor provide the initial value of the statues(which won't change actually) 
   * @param a location of statue
   */
  public FrozenStatue(float[] a) {
   x = a[0];
   y = a[1];
   this.isFacingRight =  true;
   this.imageName = "images" + File.separator + "frozenStatue.png";
  }
  
  
  /**
   * draw out the whole picture of statue
   * @param engine the object to draw
   */
  public void update(SimulationEngine engine) {
   engine.draw(imageName,x,y,isFacingRight);
  }
  
}