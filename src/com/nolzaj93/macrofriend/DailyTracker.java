package com.nolzaj93.macrofriend;

import java.util.ArrayList;

/**
 * The DailyTracker class will create objects which will hold the user's daily nutrition data. This
 * class is still in progress.
 *
 * @author - Austin Nolz
 */
public class DailyTracker {

  private Double[] newMealGrams;
  private Double[] newMealCalories;
  private static final int fatCaloriesPerGram = 9;
  private static final int carbOrProteinCaloriesPerGram = 4;
  private ArrayList<Double> dailyFatGrams = new ArrayList<>();
  private ArrayList<Double> dailyCarbGrams = new ArrayList<>();
  private ArrayList<Double> dailyProteinGrams = new ArrayList<>();
  private ArrayList<Double[][]> dailyMeals = new ArrayList<>();
  private double totalDailyFatGrams = 0;
  private double totalDailyCarbGrams = 0;
  private double totalDailyProteinGrams = 0;

  public DailyTracker() {
    newMealGrams = new Double[3];
    newMealCalories = new Double[4];
  }

  public ArrayList<Double> getDailyFatGrams() {
    return dailyFatGrams;
  }

  public void setDailyFatGrams(ArrayList<Double> dailyFatGrams) {
    this.dailyFatGrams = dailyFatGrams;
  }

  public ArrayList<Double> getDailyCarbGrams() {
    return dailyCarbGrams;
  }

  public void setDailyCarbGrams(ArrayList<Double> dailyCarbGrams) {
    this.dailyCarbGrams = dailyCarbGrams;
  }

  public ArrayList<Double> getDailyProteinGrams() {
    return dailyProteinGrams;
  }

  public void setDailyProteinGrams(ArrayList<Double> dailyProteinGrams) {
    this.dailyProteinGrams = dailyProteinGrams;
  }

  public ArrayList<Double[][]> getDailyMeals() {
    return dailyMeals;
  }

  public void setDailyMeals(ArrayList<Double[][]> dailyMeals) {
    this.dailyMeals = dailyMeals;
  }

  /**
   * The addNewMeal method takes arguments for grams of fat, carbs and protein, adds each value to
   * the respective daily gram total, and adds these values to each respective daily arrayList. The
   * method also uses a for loop to find the Calories from each quantity of grams. The two
   * dimensional array, newMeal, is added to an arrayList of type double[][].
   *
   * @param fatGrams - This parameter holds the grams of fat entered by the user in the new meal.
   * @param carbGrams - This parameter holds the grams of carbs entered by the user in the new
   *     meal.
   * @param proteinGrams - This parameter holds the grams of protein entered by the user in the new
   *     meal.
   * @return newMeal- This method returns a two dimensional array of doubles. The first array holds
   *     the grams of fat, carbs, and protein, and the second array holds the calories from each
   *     macronutrient, as well as the total meal Calories at index [1][3].
   */

  public Double[][] addNewMeal(double fatGrams, double carbGrams, double proteinGrams) {
    double totalMealCalories = 0;
    newMealGrams[0] = fatGrams;
    newMealGrams[1] = carbGrams;
    newMealGrams[2] = proteinGrams;

    dailyFatGrams.add(fatGrams);
    dailyCarbGrams.add(carbGrams);
    dailyProteinGrams.add(proteinGrams);

    totalDailyFatGrams += fatGrams;
    totalDailyCarbGrams += carbGrams;
    totalDailyProteinGrams += proteinGrams;
    /*
     *(39)Get a sum of the values in an array using an accumulator.
     */
    int index;

    for (index = 0; index < newMealGrams.length; index++) {
      if (index == 0) {
        newMealCalories[0] = fatGrams * fatCaloriesPerGram;
        totalMealCalories += (newMealGrams[index] * fatCaloriesPerGram);
      } else {
        newMealCalories[index] = newMealGrams[index] * carbOrProteinCaloriesPerGram;
        totalMealCalories += (newMealGrams[index] * carbOrProteinCaloriesPerGram);
      }
    }
    newMealCalories[3] = totalMealCalories;

    Double[][] newMeal = {newMealGrams, newMealCalories};
    dailyMeals.add(newMeal);
    return newMeal;
  }

  public static double getTotalMealCalories(Double[][] newMeal, int row, int column) {
    return newMeal[row][column];
  }
}
