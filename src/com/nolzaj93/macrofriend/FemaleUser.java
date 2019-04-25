package com.nolzaj93.macrofriend;

import java.util.Scanner;

/**
 * This class is a subclass/derived class/child class of NewUser. The only method different for a
 * female user compared to a male or intersex user is estimateBasalMetabolicRate().
 *
 * @author Austin Nolz
 */
public class FemaleUser extends NewUser {

  /**
   * This method constructs a FemaleUser object by calling the overloaded NewUser constructor.
   *
   * @param userScanner - Scanner object is passed into the superclass constructor call and into
   *     the runUserFunctions method.
   * @param name - The name parameter holds the userName that was set within the NewUser class
   *     to be set for this object within the superclass constructor called.
   * @param sex - The sex parameter holds the biological sex that was retrieved and set from
   *     the enterUserStrings method within the NewUser class, which is the same for the name.
   */
  public FemaleUser(Scanner userScanner, String name, String sex) {

    super(userScanner, name, sex);
    this.runUserFunctions(userScanner);
  }

  /** (35) Develop code that makes use of polymorphism
   * This overridden method for FemaleUser objects estimates BMR by taking the average of the
   * KatchMcArdleBMR and the FemaleHarrisBenedictBMR.
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
     *  The average of the two equations for females is found below.
     */

    setBasalMetabolicRate((getKatchMcArdleBmr() + getFemaleHarrisBenedictBmr()) / 2.0);
  }
}
