//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P02 Calendar Printer
// Files: CalendarPrinter.java CalendarTester.java P02.jar
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

/**
 * Test all the methods in CalendarPrinter.java.
 *
 * Bugs: none known
 *
 * @author Zijian(Joey) Chen, Yiran Zhou
 * @version 1.0
 */
public class CalendarTester {

  /**
   * test whether the FullCenturiesContained function well
   * 
   * @return true the FullCenturiesContained function well, false otherwise
   */
  public static boolean testFullCenturiesContained() {
    if (CalendarPrinter.fullCenturiesContained(new Year(2)) != 0)
      return false;
    if (CalendarPrinter.fullCenturiesContained(new Year(2020)) != 20)
      return false;
    if (CalendarPrinter.fullCenturiesContained(new Year(44444)) != 444)
      return false;
    return true;
  }

  /**
   * test whether the yearOffsetWithinCentur function well
   * 
   * @return true the yearOffsetWithinCentur function well, false otherwise
   */
  public static boolean testYearOffsetWithinCentury() {
    if (CalendarPrinter.yearOffsetWithinCentury(new Year(2)) != 2)
      return false;
    if (CalendarPrinter.yearOffsetWithinCentury(new Year(2020)) != 20)
      return false;
    if (CalendarPrinter.yearOffsetWithinCentury(new Year(44444)) != 44)
      return false;
    return true;
  }

  /**
   * test whether the numberOfDaysInMonth function well
   * 
   * @param February
   * @return true the numberOfDaysInMonth function well, false otherwise
   */
  public static boolean testNumberOfDaysInMonth() {
    if (CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.February, new Year(2000))) != 29)
      return false;
    if (CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.November, new Year(2000))) != 30)
      return false;
    if (CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.July, new Year(2010))) != 31)
      return false;
    return true;
  }

  /**
   * test whether the isLeapYear function well
   * 
   * @return true the isLeapYear function well, false otherwise
   */
  public static boolean testIsLeapYear() {
    if (CalendarPrinter.isLeapYear(new Year(2000)) != true)
      return false;
    if (CalendarPrinter.isLeapYear(new Year(2004)) != true)
      return false;
    if (CalendarPrinter.isLeapYear(new Year(2005)) != false)
      return false;
    return true;
  }

  /**
   * test whether the calcFirstDayOfWeekInMonth function well
   * 
   * @return true the calcFirstDayOfWeekInMonth function well, false otherwise
   */
  public static boolean testCalcFirstDayOfWeekInMonth() {
    if (!CalendarPrinter.calcFirstDayOfWeekInMonth(new Month(MonthOfYear.January, new Year(2020)))
        .equals(DayOfWeek.Wednesday)) {
      return false;
    }
    if (!CalendarPrinter.calcFirstDayOfWeekInMonth(new Month(MonthOfYear.November, new Year(2017)))
        .equals(DayOfWeek.Wednesday)) {
      return false;
    }
    if (!CalendarPrinter.calcFirstDayOfWeekInMonth(new Month(MonthOfYear.June, new Year(2019)))
        .equals(DayOfWeek.Saturday)) {
      return false;
    }
    if (!CalendarPrinter.calcFirstDayOfWeekInMonth(new Month(MonthOfYear.January, new Year(2000)))
        .equals(DayOfWeek.Saturday)) {
      return false;
    }
    return true;
  }

  /**
   * test whether the dayOfWeekAfter function well
   * 
   * @return true the dayOfWeekAfter function well, false otherwise
   */
  public static boolean testDayOfWeekAfter() {
    if (CalendarPrinter.dayOfWeekAfter(DayOfWeek.Monday) != DayOfWeek.Tuesday)
      return false;
    if (CalendarPrinter.dayOfWeekAfter(DayOfWeek.Sunday) != DayOfWeek.Monday)
      return false;
    if (CalendarPrinter.dayOfWeekAfter(DayOfWeek.Wednesday) != DayOfWeek.Thursday)
      return false;
    return true;
  }

  /**
   * test whether the dayOfWeekAfter function well
   * 
   * @return true the dayOfWeekAfter function well, false otherwise
   */
  public static boolean testMonthOfYearAfter() {
    if (CalendarPrinter.monthOfYearAfter(MonthOfYear.December) != MonthOfYear.January)
      return false;
    if (CalendarPrinter.monthOfYearAfter(MonthOfYear.April) != MonthOfYear.May)
      return false;
    if (CalendarPrinter.monthOfYearAfter(MonthOfYear.October) != MonthOfYear.November)
      return false;
    return true;
  }

  /**
   * test whether the createNewMonth function well
   * 
   * @return true the createNewMonth function well, false otherwise
   */
  public static boolean testCreateNewMonth() {
    Month month = CalendarPrinter.createNewMonth(MonthOfYear.February, new Year(2020));
    Day day = month.getDayByDate(1);
    if (day.getDayOfWeek() != DayOfWeek.Saturday)
      return false;
    day = month.getDayByDate(28);
    if (day.getDayOfWeek() != DayOfWeek.Friday)
      return false;
    day = month.getDayByDate(13);
    if (day.getDayOfWeek() != DayOfWeek.Thursday)
      return false;
    return true;
  }

  /**
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("testFullCenturiesContained(): " + testFullCenturiesContained());
    System.out.println("testYearOffsetWithinCentury(): " + testYearOffsetWithinCentury());
    System.out.println("testNumberOfDaysInMonth(): " + testNumberOfDaysInMonth());
    System.out.println("testIsLeapYear(): " + testIsLeapYear());
    System.out.println("testCalcFirstDayOfWeekInMonth(): " + testCalcFirstDayOfWeekInMonth());
    System.out.println("testDayOfWeekAfter(): " + testDayOfWeekAfter());
    System.out.println("testMonthOfYearAfter(): " + testMonthOfYearAfter());
    System.out.println("testCreateNewMonth(): " + testCreateNewMonth());
  }
}


