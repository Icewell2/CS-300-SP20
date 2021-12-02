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

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Print out the calendar for the requested months in the standard format.
 *
 * Bugs: none known
 *
 * @author Zijian(Joey) Chen, Yiran Zhou
 * @version 1.0
 */
public class CalendarPrinter {

  /**
   * Calculates the number of centuries (rounded down) between year 0 and the specified year. For
   * example, the year 2034 has the century index of 20 (as do the other years 2000-2099).
   * 
   * @param year to compute the century offset for
   * @return number of centuries between year 0 and the specified year
   */
  public static int fullCenturiesContained(Year year) {
    return (year.intValue()) / 100;
  }

  /**
   * Calculates the number of years between the specified year and the first year of * its century.
   * For example, the year 2034 has the offset within its century of 34 * (as do 1234 and 9999934).
   * 
   * @param year to compute the offset within century for
   * @return number of years between the specified year and the first year of century
   */
  public static int yearOffsetWithinCentury(Year year) {
    return year.intValue() % 100;
  }

  /**
   * Calculates the number of days in the specified month, while taking into consideration whether
   * or not the specified month is in a leap year. Note: that this is calculated based on the
   * month's monthOfYear and year, and * is NOT retrieved from the month's getDayCount() method.
   * This is because this * method is used to generate the day objects that are stored within each
   * month.
   * 
   * @param month to determine the number of days within (within its year)
   * @return the number of days in the specified month (between 28-31)
   */
  public static int numberOfDaysInMonth(Month month) {
    // check whether this month has 30 or 31 days, it will be 29/28 when it is February
    if (month.getMonthOfYear() == MonthOfYear.January || month.getMonthOfYear() == MonthOfYear.March
        || month.getMonthOfYear() == MonthOfYear.May || month.getMonthOfYear() == MonthOfYear.July
        || month.getMonthOfYear() == MonthOfYear.August
        || month.getMonthOfYear() == MonthOfYear.October
        || month.getMonthOfYear() == MonthOfYear.December)
      return 31;
    if (month.getMonthOfYear() == MonthOfYear.April || month.getMonthOfYear() == MonthOfYear.June
        || month.getMonthOfYear() == MonthOfYear.September
        || month.getMonthOfYear() == MonthOfYear.November)
      return 30;
    if (month.getMonthOfYear() == MonthOfYear.February) {
      if (isLeapYear(month.getYear()))
        return 29;
      else
        return 28;
    }
    return 0;
  }

  /**
   * This method computes whether the specified year is a leap year or not.
   * 
   * @param year is the year is being checked for leap-year-ness
   * @return true when the specified year is a leap year, and false otherwise
   */
  public static boolean isLeapYear(Year year) {
    // if the year can divided by 4 and cannot divided by 100, it should be leapYear
    if (year.intValue() % 4 == 0 && year.intValue() % 100 != 0) {
      return true;
    } else if (year.intValue() % 400 == 0) { // when year can divided by 400 is leapYear
      return true;
    } else {
      return false;
    }
  }

  /**
   * Calculates which day of the week the first day of the specified month falls on. Note: that this
   * is calculated based on the month's monthOfYear and year, and is NOT retrieved from the month's
   * getDayByDate(1) day. This is because this method is used to generate the day objects that are
   * stored within each month.
   * 
   * @param month within which we are calculate the day of week for the first day
   * @return DayOfWeek corresponding to the first day within the specified month
   */
  public static DayOfWeek calcFirstDayOfWeekInMonth(Month month) {
    int dayOfWeek = 0;
    int assignMonth = 0;
    int kOne = yearOffsetWithinCentury(month.getYear());
    Year jSpecial = month.getYear();
    int jOne = fullCenturiesContained(new Year(jSpecial.intValue()));

    // if the month is January or February it will be counted as month of previous year
    // so we need to modify the year by minus one
    if (month.getMonthOfYear() == MonthOfYear.January) {
      assignMonth = 13;
      kOne = yearOffsetWithinCentury(month.getYear()) - 1;
      jOne = fullCenturiesContained(new Year(jSpecial.intValue() - 1));
      if (jSpecial.intValue() % 100 == 0) { // if the year can be divided by 100 we should
        kOne = yearOffsetWithinCentury(new Year(jSpecial.intValue() - 1)); // modify the K
      }
    } else if (month.getMonthOfYear() == MonthOfYear.February) {
      assignMonth = 14;
      kOne = yearOffsetWithinCentury(month.getYear()) - 1;
      jOne = fullCenturiesContained(new Year(jSpecial.intValue() - 1));
      if (jSpecial.intValue() % 100 == 0) {
        kOne = yearOffsetWithinCentury(new Year(jSpecial.intValue() - 1));
      }
      // for other months, we just assign the actual number representation of them
    } else if (month.getMonthOfYear() == MonthOfYear.March) {
      assignMonth = 3;
    } else if (month.getMonthOfYear() == MonthOfYear.April) {
      assignMonth = 4;
    } else if (month.getMonthOfYear() == MonthOfYear.May) {
      assignMonth = 5;
    } else if (month.getMonthOfYear() == MonthOfYear.June) {
      assignMonth = 6;
    } else if (month.getMonthOfYear() == MonthOfYear.July) {
      assignMonth = 7;
    } else if (month.getMonthOfYear() == MonthOfYear.August) {
      assignMonth = 8;
    } else if (month.getMonthOfYear() == MonthOfYear.September) {
      assignMonth = 9;
    } else if (month.getMonthOfYear() == MonthOfYear.October) {
      assignMonth = 10;
    } else if (month.getMonthOfYear() == MonthOfYear.November) {
      assignMonth = 11;
    } else if (month.getMonthOfYear() == MonthOfYear.December) {
      assignMonth = 12;
    }
    dayOfWeek =
        (1 + ((13 * (assignMonth + 1)) / 5) + kOne + (kOne / 4) + (jOne / 4) + 5 * jOne) % 7;
    // return the actual day of the week
    if (dayOfWeek == 0) {
      return DayOfWeek.Saturday;
    } else if (dayOfWeek == 1) {
      return DayOfWeek.Sunday;
    } else if (dayOfWeek == 2) {
      return DayOfWeek.Monday;
    } else if (dayOfWeek == 3) {
      return DayOfWeek.Tuesday;
    } else if (dayOfWeek == 4) {
      return DayOfWeek.Wednesday;
    } else if (dayOfWeek == 5) {
      return DayOfWeek.Thursday;
    } else if (dayOfWeek == 6) {
      return DayOfWeek.Friday;
    } else {
      return null;
    }
  }

  /**
   * Calculates the day of the week that follows the specified day of week. For example, Thursday
   * comes after Wednesday, and Monday comes after Sunday.
   * 
   * @param dayBefore is the day of week that comes before the day of week returned
   * @return day of week that comes after dayBefore
   */
  // we assign the day of the week based on the previous day in the week
  public static DayOfWeek dayOfWeekAfter(DayOfWeek dayBefore) {
    if (dayBefore == DayOfWeek.Monday)
      return DayOfWeek.Tuesday;
    if (dayBefore == DayOfWeek.Tuesday)
      return DayOfWeek.Wednesday;
    if (dayBefore == DayOfWeek.Wednesday)
      return DayOfWeek.Thursday;
    if (dayBefore == DayOfWeek.Thursday)
      return DayOfWeek.Friday;
    if (dayBefore == DayOfWeek.Friday)
      return DayOfWeek.Saturday;
    if (dayBefore == DayOfWeek.Saturday)
      return DayOfWeek.Sunday;
    return DayOfWeek.Monday;
  }

  /**
   * Calculates the month of the year that follows the specified month. For example July comes after
   * June, and January comes after December.
   * 
   * @param monthBefore is the month that comes before the month that is returned
   * @return month of year that comes after monthBefor
   */
  // we assign the new month based on the previous month
  public static MonthOfYear monthOfYearAfter(MonthOfYear monthBefore) {
    if (monthBefore == MonthOfYear.January)
      return MonthOfYear.February;
    if (monthBefore == MonthOfYear.February)
      return MonthOfYear.March;
    if (monthBefore == MonthOfYear.March)
      return MonthOfYear.April;
    if (monthBefore == MonthOfYear.April)
      return MonthOfYear.May;
    if (monthBefore == MonthOfYear.May)
      return MonthOfYear.June;
    if (monthBefore == MonthOfYear.June)
      return MonthOfYear.July;
    if (monthBefore == MonthOfYear.July)
      return MonthOfYear.August;
    if (monthBefore == MonthOfYear.August)
      return MonthOfYear.September;
    if (monthBefore == MonthOfYear.September)
      return MonthOfYear.October;
    if (monthBefore == MonthOfYear.October)
      return MonthOfYear.November;
    if (monthBefore == MonthOfYear.November)
      return MonthOfYear.December;
    return MonthOfYear.January;
  }

  /**
   * Creates a new month object and fully initializes with its corresponding days.
   * 
   * @param monthOfYear which month of the year this new month represents
   * @param year        in which this month is a part
   * @return reference to the newly created month object
   */
  public static Month createNewMonth(MonthOfYear monthOfYear, Year year) {
    // create a new Month variable, assign the number of days and first day in that month
    Month month = new Month(monthOfYear, year);
    int num = numberOfDaysInMonth(month);
    DayOfWeek dayname = calcFirstDayOfWeekInMonth(month);
    // create the whole month with corresponding to the day of week
    for (int i = 1; i <= num; i++) {
      Day day = new Day(dayname, i, month);
      month.addDay(day);
      dayname = dayOfWeekAfter(dayname);
    }
    return month;
  }

  /**
   * Prints the contents of the specified month object in calendar form. This printout should begin
   * with the Month an year of the month. The next line should * contain the three letter
   * abbreviations for the seven days of the week. And then * the dates of each day of that month
   * should follow: one week per line, with periods in positions of days that are a part of the
   * month before or after. For * example, January 2020 should be printed as follows:
   *
   * January 2020 
   * MON TUE WED THU FRI SAT SUN 
   *  .   .   1   2   3   4   5 
   *  6   7   8   9   10  11  12
   *  13  14  15  16  17  18  19
   *  20  21  22  23  24  25  26 
   *  27  28  29  30  31   .   .
   *
   * @param month which is to be printed by this method
   */
  public static void printMonth(Month month) {
    // first print the basic format of calendar
    System.out.println(month.getMonthOfYear() + " " + month.getYear());
    System.out.println("MON TUE WED THU FRI SAT SUN");
    DayOfWeek firstday = calcFirstDayOfWeekInMonth(month);
    DayOfWeek dayname = DayOfWeek.Monday;
    int num = numberOfDaysInMonth(month);
    int i = 1;

    // check how many empty day we have in the first line
    System.out.print(" ");
    while (dayname != firstday) {
      System.out.print(".   ");
      dayname = dayOfWeekAfter(dayname);
    }
    // print out the valid day in the calendar
    for (i = 1; i <= num; i++) {
      if (i < 10)
        System.out.print(i + "   ");
      else
        System.out.print(i + "  ");
      if (dayname == DayOfWeek.Sunday) {
        System.out.println(" ");
        System.out.print(" ");
      }
      dayname = dayOfWeekAfter(dayname);
    }
    // print out the empty day in the end of the calendar
    while (dayname != DayOfWeek.Sunday) {
      System.out.print(".   ");
      dayname = dayOfWeekAfter(dayname);
    }
    System.out.println(". ");
  }

  /**
   * Creates an array list of months that are initialized with their full complement of days. Prints
   * out each of these months in calendar form, and then returns the resulting ArrayList.
   * 
   * @param month of the year for the first month that is created and printed
   * @param year  that the first month created and printed is a part of
   * @param count is the total number of sequential months created and printed
   */
  public static ArrayList<Month> createAndPrintMonths(MonthOfYear month, Year year, int count) {
    // create a new ArrayList and assign the formated calendar to it
    ArrayList<Month> ans = new ArrayList<Month>();
    for (int i = 1; i <= count; i++) {
      ans.add(createNewMonth(month, year));
      printMonth(ans.get(i - 1));
      if (month == MonthOfYear.December)
        year = new Year(year.intValue() + 1);
      month = monthOfYearAfter(month);
    }
    return ans;
  }

  /**
   * Driver for the CalendarPrinter Application. This program asks the user to enter * an initial
   * month, an initial year, and the total number of months to create and * display in calendar
   * form.
   * 
   * @param args is not used by this program
   */
  public static void main(String[] args) {
    // print welcome message
    Scanner in = new Scanner(System.in);
    System.out.println("Welcome to the Calendar Printer.");
    System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
    // read input from the user
    System.out.print("Enter the month to begin calendar: ");

    String monthString = in.nextLine().trim();
    System.out.print("Enter the year to begin calendar: ");
    String yearString = in.nextLine().trim();
    System.out.print("Enter the number of months to include in this calendar: ");
    String countString = in.nextLine().trim();
    // convert user input into usable form
    monthString = monthString.substring(0, 3).toUpperCase();
    MonthOfYear month = null;
    for (int i = 0; i < MonthOfYear.values().length; i++)
      if (monthString.equals(MonthOfYear.values()[i].name().substring(0, 3).toUpperCase()))
        month = MonthOfYear.values()[i];
    Year year = new Year(Integer.parseInt(yearString.trim()));
    int count = Integer.parseInt(countString.trim());
    // create months and display them in calendar form
    System.out.println();
    createAndPrintMonths(month, year, count);
    // display thank you message
    System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
    System.out.println("Thanks, and have a nice day.");
    in.close();
  }
}


