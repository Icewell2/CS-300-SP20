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
 * StarshipRobot class Description: 
 * This class inherit from the FroazenStatue and will
 * deal with the movement of starship which can deliver food.
 * @author Zijian Chen, Yiran Zhou
 */
public class StarshipRobot extends FrozenStatue {

  protected float[][] beginAndEnd = new float[2][2];
  //array of two positions, that this robot moves back and forth between
  //the contents of this 2d array are organized as follows: 
  //{ { beginX, beginY }, { endX, endY }}
  protected float[] destination = new float[2];
  //the position that this robot is currently moving towards
  protected float speed;
  //the speed in pixels that this robot moves during each update
  
/**
 * A constructor of StatshipRobot which will assign initial value
 * to some variable
 * @param a value of two positions which robot will move back and forth
 */
  public StarshipRobot(float[][] a) {
    super(a[0]);
    beginAndEnd[0][0] = a[0][0];
    beginAndEnd[0][1] = a[0][1];
    beginAndEnd[1][0] = a[1][0];
    beginAndEnd[1][1] = a[1][1];
    destination[0] = a[1][0];
    destination[1] = a[1][1];
    speed = 6;
    this.isFacingRight = true;
    this.imageName = "images" + File.separator + "starshipRobot.png";
  }
/**
 * The moveTowardDestination method will update the position of the object 
 * that it is called on by moving it speed units closer to its destination.
 * @return true if the variable is under the boundary we set
 */
  protected boolean moveTowardDestination() {
    float distance = (float) Math.sqrt(
        (x - destination[0])*(x - destination[0])+(y - destination[1])*(y - destination[1]));
    x = x + speed * (destination[0] - x) / distance;
    y = y + speed * (destination[1] - y) / distance; // update the current position
    if (destination[0] >= x) //if the destination's x value is greater than current is right
      this.isFacingRight = true;
    else
      this.isFacingRight = false;
    if (distance < 2 * speed)//the distance between initial position and destination
      return true; // should less than 2 * speed
    else
      return false;
  }

/**
 * update the position when starship is close enough to the destination
 */
  protected void updateDestination() {
    if (destination[0] == beginAndEnd[0][0])
      destination[0] = beginAndEnd[1][0];
    else
      destination[0] = beginAndEnd[0][0];
    if (destination[1] == beginAndEnd[0][1])
      destination[1] = beginAndEnd[1][1];
    else
      destination[1] = beginAndEnd[0][1];
  }

  /**
   *  call this moveTowardDestination() method and update the position as required
   */
  @Override
  public void update(SimulationEngine engine) {
    if (moveTowardDestination())
      updateDestination();
    super.update(engine);
  }
}
