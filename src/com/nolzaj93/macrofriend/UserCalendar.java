package com.nolzaj93.macrofriend;

//
// Austin Nolz
// The UserCalendar class is still in a primitive stage of development. This class will create
// a DailyTracker object for every day of every year, and will eventually connect to a database.
//

import java.time.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserCalendar {

  private LocalDate today = LocalDate.now();
  /*
   * (42) Declare multi-dimensional arrays
   */
  private String[][] monthsAndDays = new String[12][];
  private DailyTracker[][] monthAndDayTracker = new DailyTracker[12][];
  private int currentMonth;
  private int currentDay;

  public UserCalendar() {
    currentMonth = today.getMonthValue();
    currentDay = today.getDayOfMonth();
    boolean isLeapYr = today.isLeapYear();
    /*
     * (42)instantiate multi-dimensional arrays
     */
    monthsAndDays[0] = new String[31];
    monthAndDayTracker[0] = new DailyTracker[31];
    if (isLeapYr) {
      monthsAndDays[1] = new String[29];
      monthAndDayTracker[1] = new DailyTracker[29];
    } else {
      monthsAndDays[1] = new String[28];
      monthAndDayTracker[1] = new DailyTracker[28];
    }
    monthsAndDays[2] = new String[31];
    monthAndDayTracker[2] = new DailyTracker[31];
    monthsAndDays[3] = new String[30];
    monthAndDayTracker[3] = new DailyTracker[30];
    monthsAndDays[4] = new String[31];
    monthAndDayTracker[4] = new DailyTracker[31];
    monthsAndDays[5] = new String[30];
    monthAndDayTracker[5] = new DailyTracker[30];
    monthsAndDays[6] = new String[31];
    monthAndDayTracker[6] = new DailyTracker[31];
    monthsAndDays[7] = new String[31];
    monthAndDayTracker[7] = new DailyTracker[31];
    monthsAndDays[8] = new String[30];
    monthAndDayTracker[8] = new DailyTracker[30];
    monthsAndDays[9] = new String[31];
    monthAndDayTracker[9] = new DailyTracker[31];
    monthsAndDays[10] = new String[30];
    monthAndDayTracker[10] = new DailyTracker[30];
    monthsAndDays[11] = new String[31];
    monthAndDayTracker[11] = new DailyTracker[31];

    /*
     * (42) Use multidimensional arrays
     */
    for (int month = 0; month < monthAndDayTracker.length; month++) {
      for (int day = 0; day < monthAndDayTracker[month].length; day++) {
        monthAndDayTracker[month][day] = new DailyTracker();
      }
    }
    for (int month = 0; month < monthsAndDays.length; month++) {
      for (int day = 0; day < monthsAndDays[month].length; day++) {
        monthsAndDays[month][day] = Integer.toString(month + 1) + " " + Integer.toString(day + 1);
      }
    }
  }
  public int getCurrentMonth() {
    return currentMonth;
  }

  public void setCurrentMonth(int currentMonth) {
    this.currentMonth = currentMonth;
  }

  public int getCurrentDay() {
    return currentDay;
  }

  public void setCurrentDay(int currentDay) {
    this.currentDay = currentDay;
  }

  public DailyTracker getMonthAndDayTracker(int month, int day) {
    return monthAndDayTracker[month][day];
  }

  public void setMonthAndDayTracker(DailyTracker[][] monthAndDayTracker) {
    this.monthAndDayTracker = monthAndDayTracker;
  }

  public void searchMonthAndDay(Scanner userScanner) {
    System.out.println("Two-dimensional array search: ");
    boolean monthIsSet = false;
    int inputMonth = 0;
    int monthLowerBound = 1;
    int monthUpperBound = 12;
    String inputString = "month";
    inputMonth = setInput(userScanner, monthIsSet, inputMonth, monthLowerBound, monthUpperBound,
        inputString);

    inputString = "day";
    boolean dayIsSet = false;
    int inputDay = 0;
    int dayLowerBound = 1;
    int dayUpperBound = 0;
    switch (inputMonth) {
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
        dayUpperBound = 31;
        break;
      case 4:
      case 6:
      case 9:
      case 11:
        dayUpperBound = 30;
        break;
      case 2:
        if (today.isLeapYear()) {
          dayUpperBound = 29;
        } else {
          dayUpperBound = 28;
        }
      default:
        break;
    }

    inputDay = setInput(userScanner, dayIsSet, inputDay, dayLowerBound, dayUpperBound, inputString);
    String monthAndDay = Integer.toString(inputMonth) + " " + Integer.toString(inputDay);

    for (int month = 0; month < monthsAndDays.length; month++) {
      for (int day = 0; day < monthsAndDays[month].length; day++) {
        if (monthAndDay.equals(monthsAndDays[month][day])) {
          System.out.print("Your input month and day was found at the coordinates: "
              + month + " " + day + "\n");
          break;
        }
      }
    }
  }

  public int setInput(Scanner userScanner, boolean inputIsSet,
      int inputVar, int lowerBound, int upperBound, String inputString) {
    System.out.printf("Please enter the %s you would like to search for expressed as an %n"
        + "integer between %d and %d. Example: 5%n", inputString, lowerBound, upperBound);

    while (!inputIsSet) {
      try {

        inputVar = userScanner.nextInt();
        if (inputVar >= lowerBound && inputVar <= upperBound) {
          inputIsSet = true;
          break;
        } else {
          throw new Exception();
        }
      } catch (InputMismatchException ex) {
        System.out.printf("Your input included text or was expressed as a decimal number. %n"
            + "Please enter the %s expressed as an integer. Example: 5%n", inputString);
      } catch (Exception ex) {
        System.out.printf("Your input was not in the correct range.%n"
            + "Please enter the %s expressed as an integer. Example: 5%n", inputString);
      }
      userScanner.nextLine();
    }
    return inputVar;
  }
}


