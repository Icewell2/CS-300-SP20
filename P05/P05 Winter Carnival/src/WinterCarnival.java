//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   P05 Winter Carnival
// Files:   WinterCarnival.java
// Course:  CS 300 SP20 2020
//
// Author:  Zijian (Joey) Chen
// Email:   zchen697@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name:   Yiran Zhou (name of your pair programming partner)
// Partner Email:  zhou433@wisc.edu (email address of your programming partner)
// Partner Lecturer's Name: Mouna Kacem(name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X__ Write-up states that pair programming is allowed for this assignment.
//   _X__ We have both read and understood the course Pair Programming Policy.
//   _X__ We have registered our team prior to the team registration deadline.
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

import java.util.ArrayList;

/**
 * WinterCarnival class Description: 
 * This class is inherits from SimulationEngine which will print
 * the whole cartoon of the winter carnival
 * @author Zijian Chen, Yiran Zhou
 */
public class WinterCarnival extends SimulationEngine {

  private ArrayList<FrozenStatue> objects = new ArrayList<FrozenStatue>();;

  /**
   * The constructor will assign value to the sub-part of some variable
   */
  public WinterCarnival() {
    FrozenStatue a = new FrozenStatue(new float[] {600, 100});
    FrozenStatue b = new FrozenStatue(new float[] {200, 500});
    objects.add(a);
    objects.add(b);
    StarshipRobot c = new StarshipRobot(new float[][] {{0, 0}, {600, 100}});
    StarshipRobot d = new StarshipRobot(new float[][] {{800, 300}, {200, 500}});
    objects.add(c);
    objects.add(d);
    DancingBadger e = new DancingBadger(new float[] {304, 268},
        new DanceStep[] {DanceStep.Left, DanceStep.Right, DanceStep.Right, DanceStep.Left,
            DanceStep.Down, DanceStep.Left, DanceStep.Right, DanceStep.Right, DanceStep.Left,
            DanceStep.Up});
    DancingBadger f = new DancingBadger(new float[] {368, 268},
        new DanceStep[] {DanceStep.Left, DanceStep.Right, DanceStep.Right, DanceStep.Left,
            DanceStep.Down, DanceStep.Left, DanceStep.Right, DanceStep.Right, DanceStep.Left,
            DanceStep.Up});
    DancingBadger g = new DancingBadger(new float[] {432, 268},
        new DanceStep[] {DanceStep.Left, DanceStep.Right, DanceStep.Right, DanceStep.Left,
            DanceStep.Down, DanceStep.Left, DanceStep.Right, DanceStep.Right, DanceStep.Left,
            DanceStep.Up});
    objects.add(e);
    objects.add(f);
    objects.add(g);
  }

/**
 * This method will update the information ForzenStatue
 */
  @Override
  public void update() {
    for (int i = 0; i < objects.size(); i++)
      objects.get(i).update(this);
  }
  
/**
 * This method help us to have the whole cartoon.
 * @param args
 */
  public static void main(String[] args) {
    WinterCarnival newOne = new WinterCarnival();
  }
}
