package com.nolzaj93.macrofriend;
//Austin Nolz

import java.time.*;
import java.util.ArrayList;

public class UserCalendar {

  private LocalDate today = LocalDate.now();
  private String[][] monthsAndDays = new String[12][];
  private DailyTracker[][] monthAndDayTracker = new DailyTracker[12][];
  private int currentMonth = today.getMonthValue();
  private int currentDay = today.getDayOfMonth();

  /*
   * (42) Use multidimensional arrays
   */
  private DailyTracker currentDayTracker = monthAndDayTracker[currentMonth][currentDay];

  public UserCalendar() {
    boolean isLeapYr = today.isLeapYear();
    /*
     * (42) Declare and instantiate multi-dimensional arrays
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

    for (int month = 0; month < monthAndDayTracker.length; month++) {
      for (int day = 0; day < monthAndDayTracker[month].length; day++) {
        monthAndDayTracker[month][day] = new DailyTracker();
      }
    }
    for (int month = 0; month < monthsAndDays.length; month++) {
      for (int day = 0; day < monthsAndDays[month].length; day++)
        monthsAndDays[month][day] = Integer.toString(++month)+ " " + Integer.toString(++day) ;
    }
  }

  public ArrayList<ArrayList<Integer>> searchMonthAndDay(){

    ArrayList<ArrayList<Integer>> twoDimensionalIndicesFound = new ArrayList<ArrayList<Integer>>();
    return twoDimensionalIndicesFound;
  }
}
