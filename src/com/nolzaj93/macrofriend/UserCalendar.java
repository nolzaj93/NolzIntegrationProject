package com.nolzaj93.macrofriend;
//Austin Nolz

import java.time.*;


public class UserCalendar {

  private LocalDate today = LocalDate.now();
  private DailyTracker[][] monthsAndDays = new DailyTracker[12][];
  private int currentMonth = today.getMonthValue();
  private int currentDay = today.getDayOfMonth();
  /*
   * (42) Use multidimensional arrays
   */
  private DailyTracker currentDayTracker = monthsAndDays[currentMonth][currentDay];

  public UserCalendar() {
    boolean isLeapYr = today.isLeapYear();
    /*
     * (42) Declare and instantiate multi-dimensional arrays
     */
    monthsAndDays[0] = new DailyTracker[31];
    if (isLeapYr) {
      monthsAndDays[1] = new DailyTracker[29];
    } else {
      monthsAndDays[1] = new DailyTracker[28];
    }
    monthsAndDays[2] = new DailyTracker[31];
    monthsAndDays[3] = new DailyTracker[30];
    monthsAndDays[4] = new DailyTracker[31];
    monthsAndDays[5] = new DailyTracker[30];
    monthsAndDays[6] = new DailyTracker[31];
    monthsAndDays[7] = new DailyTracker[31];
    monthsAndDays[8] = new DailyTracker[30];
    monthsAndDays[9] = new DailyTracker[31];
    monthsAndDays[10] = new DailyTracker[30];
    monthsAndDays[11] = new DailyTracker[31];

    for (int month = 0; month < monthsAndDays.length; month++) {
      for (int day = 0; day < monthsAndDays[month].length; day++)
        monthsAndDays[month][day] = new DailyTracker();
    }
  }
 }
