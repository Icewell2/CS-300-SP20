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
 * DancingBadger class Description: 
 * This class inherit StarshipRobot which will deal with
 * the movement of dancing badger
 * @author Zijian Chen, Yiran Zhou
 */
public class DancingBadger extends StarshipRobot {
  protected DanceStep[] danceSteps;
  //the sequence of directions / dance steps for this badger to move
  protected int stepIndex;
  //the index of the next step within danceSteps for this badger to move through
  
  /**
   * This constructor will assign some initial value of some variable as required
   * @param start starting position of badger
   * @param step steps to move
   */
  public DancingBadger(float[] start, DanceStep[] step) {
    super(new float[][] {start, step[0].getPositionAfter(start)});
    danceSteps = step;
    stepIndex = 1;
    this.imageName = "images" + File.separator + "dancingBadger.png";
    this.speed = 2;
    this.isFacingRight = true;
  }

  /**
   * This method will update the destination according to the next dance step
   * which wee need to override the method in order to have a different 
   * functionality than the one in starshipRobot
   */
  @Override
  protected void updateDestination() {
    destination = danceSteps[stepIndex].getPositionAfter(destination);
    stepIndex++;
    if (stepIndex >= danceSteps.length)
      stepIndex = 0;
  }
}

