package com.nolzaj93.macrofriend;
//Austin Nolz

import java.time.*;
import java.time.LocalDate;

public class UserCalendar {

  private static final ZonedDateTime startDate = ZonedDateTime.now();
  LocalDate today = LocalDate.now();
  boolean isLeapYr = today.isLeapYear();

  public DailyTracker[][] monthsAndDays = new DailyTracker[12][];

  public UserCalendar() {
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
