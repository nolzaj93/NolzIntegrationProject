package com.nolzaj93.macrofriend;

import java.util.Scanner;

/**
 * (2) MacroFriend is a program that is able to recommend an estimate of daily calories and
 * macronutrients depending on your activity level and fitness goal. This class is a
 * subclass/derived class/child class of NewUser. The only method different for an intersex user
 * compared to a female or male user is estimateBasalMetabolicRate().
 *
 * @author Austin Nolz
 */
public class IntersexUser extends NewUser {

  /**
   * This method constructs an IntersexUser object by calling the overloaded NewUser constructor.
   *
   * @param userScanner - Scanner object is passed into the superclass constructor call and into the
   *     runUserFunctions method.
   * @param name - The name parameter holds the userName that was set within the NewUser class to be
   *     set for this object within the superclass constructor called.
   * @param sex - The sex parameter holds the biological sex that was retrieved and set from the
   *     enterUserStrings method within the NewUser class, which is the same for the name.
   */
  public IntersexUser(Scanner userScanner, String name, String sex) {
    super(userScanner, name, sex);
    runUserFunctions(userScanner);
  }

  /**
   * (35) Develop code that makes use of polymorphism This overridden method for IntersexUser
   * objects estimates BMR by taking the average of the KatchMcArdleBMR and the
   * FemaleHarrisBenedictBMR.
   */
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
