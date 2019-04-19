package com.nolzaj93.macrofriend;

import java.util.Scanner;

public class IntersexUser extends NewUser {

  public IntersexUser(Scanner userScanner, String[] userStrings, Double[] userDoubles) {
    super(userStrings, userDoubles);
    runUserFunctions(userScanner);
  }

  @Override
  public void estimateBasalMetabolicRate() {
    /*
     * The Katch-McArdle Equation gives an estimate for both males and females based on
     * weight and body fat percentage.
     * This estimation averages the male and female Harris-Benedict equations for BMR.
     * Then takes the average of those two estimates.
     */
    setBasalMetabolicRate((getKatchMcArdleBmr()
        + ((getMaleHarrisBenedictBmr() + getFemaleHarrisBenedictBmr()) / 2)) / 2);
  }
}
