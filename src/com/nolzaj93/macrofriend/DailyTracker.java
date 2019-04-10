package com.nolzaj93.macrofriend;
//Austin Nolz
import java.util.ArrayList;

public class DailyTracker {

  private static final int fatCaloriesPerGram = 9;
  private static final int carbOrProteinCaloriesPerGram = 4;

  private ArrayList<Double> dailyFatGrams = new ArrayList<>();
  private ArrayList<Double> dailyCarbGrams = new ArrayList<>();
  private ArrayList<Double> dailyProteinGrams = new ArrayList<>();

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

  /*
   * (39) Get a sum of the values in an array using an accumulator.
   */
  public double[] addNewMeal(double fatGrams, double carbGrams, double proteinGrams) {
    double totalMealCalories = 0;
    double[] newMealGrams = {fatGrams, carbGrams, proteinGrams};
    double[] newMealCalories = new double[4];

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
    return newMealCalories;
  }

}
