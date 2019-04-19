package com.nolzaj93.macrofriend;

import java.util.Scanner;

public class FemaleUser extends NewUser {

  public FemaleUser(Scanner userScanner, String[] userStrings, Double[] userDoubles) {

    super(userStrings, userDoubles);
    runUserFunctions(userScanner);
  }

  @Override
  public void estimateBasalMetabolicRate() {
    // Sourced from this website:
    //https://www.ajdesigner.com/phpweightloss/weight_loss_equations_total_daily_energy_expenditure_moderate.php
    /*
     * This calculation estimates basal metabolic rate(BMR) depending on biological sex, body fat %,
     * height, weight, and age. We take the average of two equations: the Katch-McArdle equation,
     * and the Harris-Benedict equation. (23) use +, - , * , /, an example of order of operations
     * PEMDAS.
     *
     *  The average of the two equations for females is found below.
     */

    setBasalMetabolicRate((getKatchMcArdleBmr() + getFemaleHarrisBenedictBmr()) / 2.0);
  }
}
