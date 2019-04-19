package com.nolzaj93.macrofriend;

import java.util.Scanner;

public class MaleUser extends NewUser {

  public MaleUser(Scanner userScanner, String[] userStrings, Double[] userDoubles) {
    super(userStrings, userDoubles);
    runUserFunctions(userScanner);
  }

  /*
   * (14) This method estimates total daily energy expenditure with parameters within the
   * parentheses. The return value is a double.
   */
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
     */
    //equations for males
    setBasalMetabolicRate((super.getKatchMcArdleBmr() + super.getMaleHarrisBenedictBmr()) / 2.0);
  }
}
