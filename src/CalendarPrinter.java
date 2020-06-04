import java.util.ArrayList;
import java.util.Scanner;
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

public class CalendarPrinter {
  /**
   * Calculates the number of centuries (rounded down) between year 0 and the specified year. For
   * example, the year 2034 has the century index of 20 (as do the other years 2000-2099).
   * 
   * @param year to compute the century offset for
   * @return number of centuries between year 0 and the specified year
   */
  public static int fullCenturiesContained(Year year) {
    int centuries = 0;
    centuries = year.intValue() / 100;
    return centuries;
  }

  /**
   * Calculates the number of years between the specified year and the first year of its century.
   * For example, the year 2034 has the offset within its century of 34 (as do 1234 and 9999934).
   * 
   * @param year to compute the offset within century for
   * @return number of years between the specified year and the first year of century
   */
  public static int yearOffsetWithinCentury(Year year) {
    int yearsBtwn = 0;
    yearsBtwn = year.intValue() % 100;
    return yearsBtwn;
  }

  /**
   * This method computes whether the specified year is a leap year or not.
   * 
   * @param year is the year is being checked for leap-year-ness
   * @return true when the specified year is a leap year, and false otherwise
   */
  public static boolean isLeapYear(Year year) {

    if (year.intValue() % 4 != 0) {
      // common year
      return false;
    }

    else if (year.intValue() % 100 != 0) {
      // leap year
      return true;
    }

    else if (year.intValue() % 400 != 0) {
      // common year
      return false;
    } else {
      return true;
    }
  }

  /**
   * Calculates the number of days in the specified month, while taking into consideration whether
   * or not the specified month is in a leap year. Note: that this is calculated based on the
   * month's monthOfYear and year, and is NOT retrieved from the month's getDayCount() method. This
   * is because this method is used to generate the day objects that are stored within each month.
   * 
   * @param month to determine the number of days within (within its year)
   * @return the number of days in the specified month (between 28-31)
   */
  public static int numberOfDaysInMonth(Month month) {

    MonthOfYear month_of_year = month.getMonthOfYear();

    Year year = month.getYear();

    if (isLeapYear(year) == true) {
      if (month_of_year == MonthOfYear.February || month_of_year == MonthOfYear.April
          || month_of_year == MonthOfYear.June || month_of_year == MonthOfYear.September
          || month_of_year == MonthOfYear.November) {
        return 29;
      }

    } else if (isLeapYear(year) == false) {
      if (month_of_year == MonthOfYear.February) {
        return 28;
      }

      if (month_of_year == MonthOfYear.April || month_of_year == MonthOfYear.June
          || month_of_year == MonthOfYear.September || month_of_year == MonthOfYear.November) {
        return 30;
      }

    }

    return 31;

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
    DayOfWeek firstDay = null;
    MonthOfYear month_of_year = month.getMonthOfYear();

    Year year = month.getYear();

    int intYear = year.intValue();


    int monthCnt = 0;

    if (month_of_year == MonthOfYear.January) {
      intYear--;
      monthCnt = 13;

    } else if (month_of_year == MonthOfYear.February) {
      intYear--;
      monthCnt = 14;

    } else if (month_of_year == MonthOfYear.March) {
      monthCnt = 3;
    } else if (month_of_year == MonthOfYear.April) {
      monthCnt = 4;
    } else if (month_of_year == MonthOfYear.May) {
      monthCnt = 5;
    } else if (month_of_year == MonthOfYear.June) {
      monthCnt = 6;

    } else if (month_of_year == MonthOfYear.July) {
      monthCnt = 7;
    } else if (month_of_year == MonthOfYear.August) {
      monthCnt = 8;
    } else if (month_of_year == MonthOfYear.September) {
      monthCnt = 9;
    } else if (month_of_year == MonthOfYear.October) {
      monthCnt = 10;
    } else if (month_of_year == MonthOfYear.November) {
      monthCnt = 11;

    } else if (month_of_year == MonthOfYear.December) {
      monthCnt = 12;

    }

    int yearOfCentury = intYear % 100;

    int zeroBasedCentury = (intYear / 100);

    // algorithm for leap year calculation
    int day = (1 + ((13 * (monthCnt + 1)) / 5) + yearOfCentury + (yearOfCentury / 4)
        + (zeroBasedCentury / 4) + (5 * (zeroBasedCentury))) % 7;

    if (day == 0) {
      firstDay = DayOfWeek.Saturday;
    } else if (day == 1) {
      firstDay = DayOfWeek.Sunday;
    } else if (day == 2) {
      firstDay = DayOfWeek.Monday;
    } else if (day == 3) {
      firstDay = DayOfWeek.Tuesday;
    } else if (day == 4) {
      firstDay = DayOfWeek.Wednesday;
    } else if (day == 5) {
      firstDay = DayOfWeek.Thursday;
    } else if (day == 6) {
      firstDay = DayOfWeek.Friday;

    }

    return firstDay;

  }

  /**
   * Calculates the day of the week that follows the specified day of week. For example, Thursday
   * comes after Wednesday, and Monday comes after Sunday.
   * 
   * @param dayBefore is the day of week that comes before the day of week returned
   * @return day of week that comes after dayBefore
   */
  public static DayOfWeek dayOfWeekAfter(DayOfWeek dayBefore) {

    DayOfWeek dayAfter = null;

    switch (dayBefore) {

      case Monday:
        return DayOfWeek.Tuesday;
      case Tuesday:
        return DayOfWeek.Wednesday;
      case Wednesday:
        return DayOfWeek.Thursday;
      case Thursday:
        return DayOfWeek.Friday;
      case Friday:
        return DayOfWeek.Saturday;
      case Saturday:
        return DayOfWeek.Sunday;
      case Sunday:
        return DayOfWeek.Monday;
    }

    dayAfter = dayBefore;

    return dayAfter;

  }

  /**
   * Calculates the month of the year that follows the specified month. For example, July comes
   * after June, and January comes after December.
   * 
   * @param monthBefore is the month that comes before the month that is returned
   * @return month of year that comes after monthBefore
   */
  public static MonthOfYear monthOfYearAfter(MonthOfYear monthBefore) {

    MonthOfYear monthAfter = null;

    switch (monthBefore) {

      case January:
        return MonthOfYear.February;
      case February:
        return MonthOfYear.March;
      case March:
        return MonthOfYear.April;
      case April:
        return MonthOfYear.May;
      case May:
        return MonthOfYear.June;
      case June:
        return MonthOfYear.July;
      case July:
        return MonthOfYear.August;
      case August:
        return MonthOfYear.September;
      case September:
        return MonthOfYear.October;
      case October:
        return MonthOfYear.November;
      case November:
        return MonthOfYear.December;
      case December:
        return MonthOfYear.January;
    }

    monthAfter = monthBefore;

    return monthAfter;

  }

  /**
   * Creates a new month object and fully initializes with its corresponding days.
   * 
   * @param monthOfYear which month of the year this new month represents
   * @param year        in which this month is a part
   * @return reference to the newly created month object
   */
  public static Month createNewMonth(MonthOfYear monthOfYear, Year year) {

    Month newMonth = new Month(monthOfYear, year);

    if (numberOfDaysInMonth(newMonth) == 28) {
      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Monday) {

        DayOfWeek dayOfWeek = DayOfWeek.Monday;
        int x = dayOfWeek.ordinal();
        for (int i = 0; i < 28; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;

            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }
      }

      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Tuesday) {

        DayOfWeek dayOfWeek = DayOfWeek.Tuesday;
        int x = dayOfWeek.ordinal();
        for (int i = 0; i < 28; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;

            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }

      }

      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Wednesday) {

        DayOfWeek dayOfWeek = DayOfWeek.Wednesday;
        int x = dayOfWeek.ordinal();
        for (int i = 0; i < 28; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;

            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }

      }

      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Thursday) {

        DayOfWeek dayOfWeek = DayOfWeek.Thursday;
        int x = dayOfWeek.ordinal();
        for (int i = 0; i < 28; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;

            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }

      }

      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Friday) {
        DayOfWeek dayOfWeek = DayOfWeek.Friday;
        int x = dayOfWeek.ordinal();

        for (int i = 0; i < 28; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;

            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }

      }
      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Saturday) {

        DayOfWeek dayOfWeek = DayOfWeek.Saturday;
        int x = dayOfWeek.ordinal();
        for (int i = 0; i < 28; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;

            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }

      }

      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Sunday) {

        DayOfWeek dayOfWeek = DayOfWeek.Sunday;
        int x = dayOfWeek.ordinal();
        for (int i = 0; i < 28; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;

            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }

      }
    }


    if (numberOfDaysInMonth(newMonth) == 29) {
      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Monday) {

        DayOfWeek dayOfWeek = DayOfWeek.Monday;
        int x = dayOfWeek.ordinal();
        for (int i = 0; i < 29; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;

            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }
      }

      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Tuesday) {

        DayOfWeek dayOfWeek = DayOfWeek.Tuesday;
        int x = dayOfWeek.ordinal();
        for (int i = 0; i < 29; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;

            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }

        }
      }
      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Wednesday) {

        DayOfWeek dayOfWeek = DayOfWeek.Wednesday;
        int x = dayOfWeek.ordinal();

        for (int i = 0; i < 29; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }
      }
      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Thursday) {

        DayOfWeek dayOfWeek = DayOfWeek.Thursday;
        int x = dayOfWeek.ordinal();
        for (int i = 0; i < 29; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }
      }
      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Friday) {

        DayOfWeek dayOfWeek = DayOfWeek.Friday;
        int x = dayOfWeek.ordinal();
        for (int i = 0; i < 29; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }
      }
      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Saturday) {

        DayOfWeek dayOfWeek = DayOfWeek.Saturday;
        int x = dayOfWeek.ordinal();
        for (int i = 0; i < 29; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }
      }
      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Sunday) {

        DayOfWeek dayOfWeek = DayOfWeek.Sunday;
        int x = dayOfWeek.ordinal();

        for (int i = 0; i < 29; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }
      }
    }

    if (numberOfDaysInMonth(newMonth) == 30) {
      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Monday) {

        DayOfWeek dayOfWeek = DayOfWeek.Monday;
        int x = dayOfWeek.ordinal();
        for (int i = 0; i < 30; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;

            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }

      }
      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Tuesday) {

        DayOfWeek dayOfWeek = DayOfWeek.Tuesday;
        int x = dayOfWeek.ordinal();
        for (int i = 0; i < 30; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;

            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }
      }

      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Wednesday) {

        DayOfWeek dayOfWeek = DayOfWeek.Wednesday;
        int x = dayOfWeek.ordinal();
        for (int i = 0; i < 30; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;

            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }

      }
      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Thursday) {

        DayOfWeek dayOfWeek = DayOfWeek.Thursday;
        int x = dayOfWeek.ordinal();
        for (int i = 0; i < 30; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;

            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }

      }
      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Friday) {

        DayOfWeek dayOfWeek = DayOfWeek.Friday;
        int x = dayOfWeek.ordinal();

        for (int i = 0; i < 30; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;

            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }

        }
      }
      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Saturday) {

        DayOfWeek dayOfWeek = DayOfWeek.Saturday;
        int x = dayOfWeek.ordinal();
        for (int i = 0; i < 30; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;

            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
            System.out.println(value);
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
            System.out.println(value);
          }
        }
      }
      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Sunday) {
        DayOfWeek dayOfWeek = DayOfWeek.Sunday;
        int x = dayOfWeek.ordinal();
        int i = 0;
        Day newDay = new Day(dayOfWeek, i, newMonth);


        for (i = 1; i < 31; i++) {
          newDay = new Day(dayOfWeek, i, newMonth);
          if (x > 6) {
            newDay = new Day(dayOfWeek, i, newMonth);
            x = 0;
            DayOfWeek value = DayOfWeek.values()[x];
            System.out.println(value);
            dayOfWeek = value;



            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            newDay = new Day(dayOfWeek, i, newMonth);
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;



            System.out.println(x);
            System.out.println(value);
            newMonth.addDay(newDay);
            x++;
          }
        }
      }

    }

    if (numberOfDaysInMonth(newMonth) == 31) {
      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Monday) {

        DayOfWeek dayOfWeek = DayOfWeek.Monday;
        int x = dayOfWeek.ordinal();

        for (int i = 0; i < 31; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;

            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }
      }
      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Tuesday) {

        DayOfWeek dayOfWeek = DayOfWeek.Tuesday;
        int x = dayOfWeek.ordinal();

        for (int i = 0; i < 31; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;

            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }
      }
      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Wednesday) {

        DayOfWeek dayOfWeek = DayOfWeek.Wednesday;
        int x = dayOfWeek.ordinal();

        for (int i = 0; i < 31; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;

            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }
      }
      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Thursday) {

        DayOfWeek dayOfWeek = DayOfWeek.Thursday;
        int x = dayOfWeek.ordinal();

        for (int i = 0; i < 31; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;

            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }
      }
      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Friday) {

        DayOfWeek dayOfWeek = DayOfWeek.Friday;
        int x = dayOfWeek.ordinal();

        for (int i = 0; i < 31; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;

            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }
      }
      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Saturday) {

        DayOfWeek dayOfWeek = DayOfWeek.Saturday;
        int x = dayOfWeek.ordinal();

        for (int i = 0; i < 31; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;

            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }
      }
      if (calcFirstDayOfWeekInMonth(newMonth) == DayOfWeek.Sunday) {

        DayOfWeek dayOfWeek = DayOfWeek.Sunday;
        int x = dayOfWeek.ordinal();
        for (int i = 0; i < 31; i++) {
          if (x > 6) {
            x = 1;
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;

            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          } else if (x <= 6) {
            DayOfWeek value = DayOfWeek.values()[x];
            dayOfWeek = value;


            Day newDay = new Day(dayOfWeek, i, newMonth);
            newMonth.addDay(newDay);
            x++;
          }
        }
      }


    }


    return newMonth;

  }

  /**
   * Prints the contents of the specified month object in calendar form. This printout should begin
   * with the Month an year of the month. The next line should contain the three letter
   * abbreviations for the seven days of the week. And then the dates of each day of that month
   * should follow: one week per line, with periods in positions of days that are a part of the
   * month before or after. For example, January 2020 should be printed as follows:
   *
   * January 2020 MON TUE WED THU FRI SAT SUN . . 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
   * 21 22 23 24 25 26 27 28 29 30 31 . .
   *
   * @param month which is to be printed by this method
   */
  public static void printMonth(Month month) {

    System.out.println(month);

    System.out.println("MON TUE WED THU FRI SAT SUN");

    if (calcFirstDayOfWeekInMonth(month) == DayOfWeek.Monday) {
      if (month.getMonthOfYear() == MonthOfYear.February
          || month.getMonthOfYear() == MonthOfYear.April
          || month.getMonthOfYear() == MonthOfYear.June
          || month.getMonthOfYear() == MonthOfYear.September
          || month.getMonthOfYear() == MonthOfYear.November) {
        if (isLeapYear(month.getYear()) == true) {
          System.out.println("1 2 3 4 5 6 7");
          System.out.println("8 9 10 11 12 13 14");
          System.out.println("15 16 17 18 19 20 21");
          System.out.println("22 23 24 25 26 27 28");
          System.out.println("29 . . . . . .");
        } else {
          if (month.getMonthOfYear() == MonthOfYear.February) {
            System.out.println("1 2 3 4 5 6 7");
            System.out.println("8 9 10 11 12 13 14");
            System.out.println("15 16 17 18 19 20 21");
            System.out.println("22 23 24 25 26 27 28");
            System.out.println(". . . . . . .");
          } else {
            System.out.println("1 2 3 4 5 6 7");
            System.out.println("8 9 10 11 12 13 14");
            System.out.println("15 16 17 18 19 20 21");
            System.out.println("22 23 24 25 26 27 28");
            System.out.println("29 30 . . . . .");
          }
        }

      } else {
        System.out.println("1 2 3 4 5 6 7");
        System.out.println("8 9 10 11 12 13 14");
        System.out.println("15 16 17 18 19 20 21");
        System.out.println("22 23 24 25 26 27 28");
        System.out.println("29 30 31 . . . .");
      }
    } else if (calcFirstDayOfWeekInMonth(month) == DayOfWeek.Tuesday) {
      if (month.getMonthOfYear() == MonthOfYear.February
          || month.getMonthOfYear() == MonthOfYear.April
          || month.getMonthOfYear() == MonthOfYear.June
          || month.getMonthOfYear() == MonthOfYear.September
          || month.getMonthOfYear() == MonthOfYear.November) {
        if (isLeapYear(month.getYear()) == true) {
          System.out.println(". 1 2 3 4 5 6");
          System.out.println("7 8 10 11 12 13");
          System.out.println("14 15 16 17 18 19 20");
          System.out.println("21 22 23 24 25 26 27");
          System.out.println("28 29 . . . . .");
        } else {
          if (month.getMonthOfYear() == MonthOfYear.February) {
            System.out.println(". 1 2 3 4 5 6");
            System.out.println("7 8 10 11 12 13");
            System.out.println("14 15 16 17 18 19 20");
            System.out.println("21 22 23 24 25 26 27");
            System.out.println("28 . . . . . .");
          } else {
            System.out.println(". 1 2 3 4 5 6");
            System.out.println("7 8 10 11 12 13");
            System.out.println("14 15 16 17 18 19 20");
            System.out.println("21 22 23 24 25 26 27");
            System.out.println("28 29 30 . . . .");
          }
        }

      } else {
        System.out.println(". 1 2 3 4 5 6");
        System.out.println("7 8 10 11 12 13");
        System.out.println("14 15 16 17 18 19 20");
        System.out.println("21 22 23 24 25 26 27");
        System.out.println("28 29 30 31 . . .");
      }

    }

    else if (calcFirstDayOfWeekInMonth(month) == DayOfWeek.Wednesday) {
      if (month.getMonthOfYear() == MonthOfYear.February
          || month.getMonthOfYear() == MonthOfYear.April
          || month.getMonthOfYear() == MonthOfYear.June
          || month.getMonthOfYear() == MonthOfYear.September
          || month.getMonthOfYear() == MonthOfYear.November) {
        if (isLeapYear(month.getYear()) == true) {
          System.out.println(". . 1 2 3 4 5");
          System.out.println("6 7 8 9 10 11 12");
          System.out.println("13 14 15 16 17 18 19");
          System.out.println("20 21 22 23 24 25 26");
          System.out.println("27 28 29 . . . .");
        } else {
          if (month.getMonthOfYear() == MonthOfYear.February) {
            System.out.println(". . 1 2 3 4 5");
            System.out.println("6 7 8 9 10 11 12");
            System.out.println("13 14 15 16 17 18 19");
            System.out.println("20 21 22 23 24 25 26");
            System.out.println("27 28 . . . . .");
          } else {
            System.out.println(". . 1 2 3 4 5");
            System.out.println("6 7 8 9 10 11 12");
            System.out.println("13 14 15 16 17 18 19");
            System.out.println("20 21 22 23 24 25 26");
            System.out.println("27 28 29 30 . . .");
          }

        }

      } else {
        System.out.println(". . 1 2 3 4 5");
        System.out.println("6 7 8 9 10 11 12");
        System.out.println("13 14 15 16 17 18 19");
        System.out.println("20 21 22 23 24 25 26");
        System.out.println("27 28 29 30 31 . .");
      }

    }

    else if (calcFirstDayOfWeekInMonth(month) == DayOfWeek.Thursday) {
      if (month.getMonthOfYear() == MonthOfYear.February
          || month.getMonthOfYear() == MonthOfYear.April
          || month.getMonthOfYear() == MonthOfYear.June
          || month.getMonthOfYear() == MonthOfYear.September
          || month.getMonthOfYear() == MonthOfYear.November) {
        if (isLeapYear(month.getYear()) == true) {
          System.out.println(". . . 1 2 3 4");
          System.out.println("5 6 7 8 9 10 11");
          System.out.println("12 13 14 15 16 17 18");
          System.out.println("19 20 21 22 23 24 25");
          System.out.println("26 27 28 29 . . .");
        } else {
          if (month.getMonthOfYear() == MonthOfYear.February) {
            System.out.println(". . . 1 2 3 4");
            System.out.println("5 6 7 8 9 10 11");
            System.out.println("12 13 14 15 16 17 18");
            System.out.println("19 20 21 22 23 24 25");
            System.out.println("26 27 28 . . . .");
          } else {
            System.out.println(". . . 1 2 3 4");
            System.out.println("5 6 7 8 9 10 11");
            System.out.println("12 13 14 15 16 17 18");
            System.out.println("19 20 21 22 23 24 25");
            System.out.println("26 27 28 29 30 . .");
          }

        }

      } else {
        System.out.println(". . . 1 2 3 4");
        System.out.println("5 6 7 8 9 10 11");
        System.out.println("12 13 14 15 16 17 18");
        System.out.println("19 20 21 22 23 24 25");
        System.out.println("26 27 28 29 30 31 .");
      }

    }

    else if (calcFirstDayOfWeekInMonth(month) == DayOfWeek.Friday) {
      if (month.getMonthOfYear() == MonthOfYear.February
          || month.getMonthOfYear() == MonthOfYear.April
          || month.getMonthOfYear() == MonthOfYear.June
          || month.getMonthOfYear() == MonthOfYear.September
          || month.getMonthOfYear() == MonthOfYear.November) {
        if (isLeapYear(month.getYear()) == true) {
          System.out.println(". . . . 1 2 3");
          System.out.println("4 5 6 7 8 9 10");
          System.out.println("11 12 13 14 15 16 17");
          System.out.println("18 19 20 21 22 23 24");
          System.out.println("25 26 27 28 29 . .");
        } else {
          if (month.getMonthOfYear() == MonthOfYear.February) {
            System.out.println(". . . . 1 2 3");
            System.out.println("4 5 6 7 8 9 10");
            System.out.println("11 12 13 14 15 16 17");
            System.out.println("18 19 20 21 22 23 24");
            System.out.println("25 26 27 28 . . .");
          } else {
            System.out.println(". . . . 1 2 3");
            System.out.println("4 5 6 7 8 9 10");
            System.out.println("11 12 13 14 15 16 17");
            System.out.println("18 19 20 21 22 23 24");
            System.out.println("25 26 27 28 29 30 .");
          }

        }

      } else {
        System.out.println(". . . . 1 2 3");
        System.out.println("4 5 6 7 8 9 10");
        System.out.println("11 12 13 14 15 16 17");
        System.out.println("18 19 20 21 22 23 24");
        System.out.println("25 26 27 28 29 30 31");
      }

    }

    else if (calcFirstDayOfWeekInMonth(month) == DayOfWeek.Saturday) {
      if (month.getMonthOfYear() == MonthOfYear.February
          || month.getMonthOfYear() == MonthOfYear.April
          || month.getMonthOfYear() == MonthOfYear.June
          || month.getMonthOfYear() == MonthOfYear.September
          || month.getMonthOfYear() == MonthOfYear.November) {
        if (isLeapYear(month.getYear()) == true) {
          System.out.println(". . . . . 1 2");
          System.out.println("3 4 5 6 7 8 9");
          System.out.println("10 11 12 13 14 15 16");
          System.out.println("17 18 19 20 21 22 23");
          System.out.println("24 25 26 27 28 29 .");
        } else {
          if (month.getMonthOfYear() == MonthOfYear.February) {
            System.out.println(". . . . . 1 2");
            System.out.println("3 4 5 6 7 8 9");
            System.out.println("10 11 12 13 14 15 16");
            System.out.println("17 18 19 20 21 22 23");
            System.out.println("24 25 26 27 28 . .");
          } else {
            System.out.println(". . . . . 1 2");
            System.out.println("3 4 5 6 7 8 9");
            System.out.println("10 11 12 13 14 15 16");
            System.out.println("17 18 19 20 21 22 23");
            System.out.println("24 25 26 27 28 29 30");
          }

        }

      } else {
        System.out.println(". . . . . 1 2");
        System.out.println("3 4 5 6 7 8 9");
        System.out.println("10 11 12 13 14 15 16");
        System.out.println("17 18 19 20 21 22 23");
        System.out.println("24 25 26 27 28 29 30");
        System.out.println("31");
      }

    }


    else if (calcFirstDayOfWeekInMonth(month) == DayOfWeek.Sunday) {
      if (month.getMonthOfYear() == MonthOfYear.February
          || month.getMonthOfYear() == MonthOfYear.April
          || month.getMonthOfYear() == MonthOfYear.June
          || month.getMonthOfYear() == MonthOfYear.September
          || month.getMonthOfYear() == MonthOfYear.November) {
        if (isLeapYear(month.getYear()) == true) {
          System.out.println(". . . . . . 1");
          System.out.println("2 3 4 5 6 7 8");
          System.out.println("9 10 11 12 13 14 15");
          System.out.println("16 17 18 19 20 21 22");
          System.out.println("23 24 25 26 27 28 29");

        } else {
          if (month.getMonthOfYear() == MonthOfYear.February) {
            System.out.println(". . . . . . 1");
            System.out.println("2 3 4 5 6 7 8");
            System.out.println("9 10 11 12 13 14 15");
            System.out.println("16 17 18 19 20 21 22");
            System.out.println("23 24 25 26 27 28 .");;

          } else {
            System.out.println(". . . . . . 1");
            System.out.println("2 3 4 5 6 7 8");
            System.out.println("9 10 11 12 13 14 15");
            System.out.println("16 17 18 19 20 21 22");
            System.out.println("23 24 25 26 27 28 29");
            System.out.println("30");
          }

        }

      } else {
        System.out.println(". . . . . . 1");
        System.out.println("2 3 4 5 6 7 8");
        System.out.println("9 10 11 12 13 14 15");
        System.out.println("16 17 18 19 20 21 22");
        System.out.println("23 24 25 26 27 28 29");
        System.out.println("30 31");
      }

    }

  }

  /**
   * Creates an array list of months that are initialized with their full complement of days. Prints
   * out each of these months in calendar form, and then returns the resulting ArrayList.
   * 
   * @param month of the year for the first month that is created and printed
   * @param year  that the first month created and printed is a part of
   * @param count is the total number of sequential months created and printed
   * @return the array list of months that this method generates and prints.
   */
  public static ArrayList<Month> createAndPrintMonths(MonthOfYear month, Year year, int count) {

    ArrayList<Month> monthList = new ArrayList<Month>();

    int x = month.ordinal();
    int intYear = year.intValue();

    for (int i = 0; i < count; i++) {
      if (x < 12) {
        MonthOfYear value = MonthOfYear.values()[x];
        Month monthRun = createNewMonth(value, year);
        monthList.add(monthRun);
        x++;
      } else if (x >= 12) {
        x = 0;
        intYear++;
        year = new Year(intYear);
        MonthOfYear value = MonthOfYear.values()[x];
        Month monthRun = createNewMonth(value, year);
        monthList.add(monthRun);
        x++;
      }

      printMonth(monthList.get(i));

    }

    return monthList;

  }



  /**
   * Driver for the CalendarPrinter Application. This program asks the user to enter an initial
   * month, an initial year, and the total number of months to create and display in calendar form.
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
