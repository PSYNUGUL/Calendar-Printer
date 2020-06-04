//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: CalendarPrinter
// Files: CalendarPrinter.java , CalendarTester.java
// Course: CS300 Spring 2020
//
// Author: Yeon Jae Cho
// Email: ycho226@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
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
public class CalendarTester {
  /**
   * tests the fullCenturiesContained() method with different cases
   * 
   * @return true when test works as expected
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
   * tests the yearOffSetWithCentury() method with different cases
   * 
   * @return true when test works as expected
   */
  public static boolean testYearOffSetWithinCentury() {
    if (CalendarPrinter.yearOffsetWithinCentury(new Year(2001)) != 1) {
      System.out
          .println("Problem Detected: yearsOffSetWithinCentury() did not return correct answer");
      return false;

    }

    if (CalendarPrinter.yearOffsetWithinCentury(new Year(2211)) != 11) {
      System.out
          .println("Problem Detected: yearsOffSetWithinCentury() did not return correct answer");
      return false;
    }

    if (CalendarPrinter.yearOffsetWithinCentury(new Year(2915)) != 15) {
      System.out
          .println("Problem Detected: yearsOffSetWithinCentury() did not return correct answer");
      return false;
    }


    return true;
  }

  /**
   * tests the isLeapYear() method with different cases case 1: leap year case 2: common year case
   * 3: common year w/ less value
   * 
   * @return true when test works as expected
   */
  public static boolean testIsLeapYear() {
    if (CalendarPrinter.isLeapYear(new Year(444)) != true) {
      System.out.println("Problem Detected: isLeapYear() did not return correct answer.");
      return false;
    }

    if (CalendarPrinter.isLeapYear(new Year(5000)) != false) {
      System.out.println("Problem Detected: isLeapYear() did not return correct answer.");
      return false;
    }

    if (CalendarPrinter.isLeapYear(new Year(2000)) == false) {
      System.out.println("Problem Detected: isLeapYear() did not return correct answer.");
      return false;
    }

    return true;
  }

  /**
   * tests numberOfDaysInMonth() method with different cases case 1: February, leap year case 2:
   * February, common year case 3: April, common year
   * 
   * @return true when test works as expected
   */
  public static boolean testNumberOfDaysInMonth() {
    if (CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.February, new Year(444))) != 29) {
      System.out.println(
          "Problem Detected: numberOfDaysInMonth() did not return correct number of days of the inputted Month.");
      return false;
    }

    if (CalendarPrinter
        .numberOfDaysInMonth(new Month(MonthOfYear.February, new Year(2001))) != 28) {
      System.out.println(
          "Problem Detected: numberOfDaysInMonth() did not return correct number of days of the inputted Month.");
      return false;
    }

    if (CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.April, new Year(555))) != 30) {
      System.out.println(
          "Problem Detected: numberOfDaysInMonth() did not return correct number of days of the inputted Month.");
      return false;
    }

    return true;
  }

  /**
   * tests calcFirstDayOfWeekInMonth() method with different cases case 1: January, leap year case
   * 2: March, leap year case 3: September, common year
   * 
   * @return true when test works as expected
   */
  public static boolean testCalcFirstDayOfWeekInMonth() {
    if (CalendarPrinter.calcFirstDayOfWeekInMonth(
        new Month(MonthOfYear.January, new Year(2000))) != DayOfWeek.Saturday) {
      System.out.println(
          "Problem Detected: calcFirstDayOfWeekInMonth() did not return correct first Day of the inputted Week.");
      return false;
    }

    if (CalendarPrinter.calcFirstDayOfWeekInMonth(
        new Month(MonthOfYear.March, new Year(2000))) != DayOfWeek.Wednesday) {
      System.out.println(
          "Problem Detected: calcFirstDayOfWeekInMonth() did not return correct first Day of the inputted Week.");
      return false;

    }

    if (CalendarPrinter.calcFirstDayOfWeekInMonth(
        new Month(MonthOfYear.September, new Year(9090))) != DayOfWeek.Monday) {
      System.out.println(
          "Problem Detected: calcFirstDayOfWeekInMonth() did not return correct first Day of the inputted Week.");
      return false;
    }

    return true;
  }

  /**
   * tests dayOfWeekAfter() method with different cases
   * 
   * @return true when test works as expected
   */
  public static boolean testDayOfWeekAfter() {
    if (CalendarPrinter.dayOfWeekAfter(DayOfWeek.Monday) != DayOfWeek.Tuesday) {
      System.out.println("Problem Detected: dayOfWeekAfter() did not return next Day.");
      return false;
    }

    if (CalendarPrinter.dayOfWeekAfter(DayOfWeek.Sunday) != DayOfWeek.Monday) {
      System.out.println("Problem Detected: dayOfWeekAfter() did not return next Day.");
      return false;
    }

    if (CalendarPrinter.dayOfWeekAfter(DayOfWeek.Thursday) != DayOfWeek.Friday) {
      System.out.println("Problem Detected: dayOfWeekAfter() did not return next Day.");
      return false;
    }


    return true;

  }

  /**
   * tests monthOfYearAfter() method with different cases
   * 
   * @return true when test works as expected
   */
  public static boolean testMonthOfYearAfter() {
    if (CalendarPrinter.monthOfYearAfter(MonthOfYear.April) != MonthOfYear.May) {
      System.out.println("Problem Detected: monthOfYearAfter() did not return next Month.");
      return false;

    }

    if (CalendarPrinter.monthOfYearAfter(MonthOfYear.June) != MonthOfYear.July) {
      System.out.println("Problem Detected: monthOfYearAfter() did not return next Month.");
      return false;
    }

    if (CalendarPrinter.monthOfYearAfter(MonthOfYear.December) != MonthOfYear.January) {
      System.out.println("Problem Detected: monthOfYearAfter() did not return next Month.");
      return false;
    }
    return true;
  }

  /**
   * tests createNewMonth() method with different cases case 1: September, common year case 2:
   * February, common year case 3: June, leap year
   * 
   * @return true when test works as expected
   */
  public static boolean testCreateNewMonth() {

    if (CalendarPrinter.createNewMonth(MonthOfYear.September, new Year(1991)).getDayCount() != 30) {
      System.out
          .println("Problem Detected: createNewMethod() did not create correct number of Days.");
      return false;
    }
    if (CalendarPrinter.createNewMonth(MonthOfYear.February, new Year(1999)).getDayCount() != 28) {
      System.out
          .println("Problem Detected: createNewMethod() did not create correct number of Days.");
      return false;
    }
    if (CalendarPrinter.createNewMonth(MonthOfYear.June, new Year(2020)).getDayCount() != 29) {
      System.out
          .println("Problem Detected: createNewMethod() did not create correct number of Days.");
      return false;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println("Testing fullCenturiesContained() method: " + testFullCenturiesContained());
    System.out
        .println("Testing yearOffsetWithinCentury() method: " + testYearOffSetWithinCentury());
    System.out.println("Testing isLeapYear() method: " + testIsLeapYear());
    System.out.println("Testing numberOfDaysInMonth() method: " + testNumberOfDaysInMonth());
    System.out
        .println("Testing calcFirstDayOfWeekInMonth() method: " + testCalcFirstDayOfWeekInMonth());
    System.out.println("Testing dayOfWeek() method: " + testDayOfWeekAfter());
    System.out.println("Testing monthOfYearAfter() method: " + testMonthOfYearAfter());
    System.out.println("Testing createNewMonth() method: " + testCreateNewMonth());
  }

}
