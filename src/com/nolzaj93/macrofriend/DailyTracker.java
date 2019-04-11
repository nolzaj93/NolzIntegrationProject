package com.nolzaj93.macrofriend;
//Austin Nolz

import java.util.ArrayList;

public class DailyTracker {

  private double totalMealCalories;
  private double[] newMealGrams;
  private double[] newMealCalories;
  private static final int fatCaloriesPerGram = 9;
  private static final int carbOrProteinCaloriesPerGram = 4;
  /*
   * (43) Declare an ArrayList of a given type
   */
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
  public Object[] addNewMeal(double fatGrams, double carbGrams, double proteinGrams) {
    totalMealCalories = 0;
    newMealGrams = new double[]{fatGrams, carbGrams, proteinGrams};
    newMealCalories = new double[4];
    /*
     * (43) Use an ArrayList of a given type
     */
    dailyFatGrams.add(fatGrams);
    dailyCarbGrams.add(carbGrams);
    dailyProteinGrams.add(proteinGrams);
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

    return new Object[]{newMealGrams, newMealCalories};
  }

  public ArrayList<Integer> searchArray(double[] doubleArray, int searchValue) {

    int index = 0;
    int[] intArray = new int[doubleArray.length];
    for (index = 0; index < doubleArray.length; index++) {
      intArray[index] = (int) Math.rint(doubleArray[index]);
    }

    index = 0;
    ArrayList<Integer> indicesFound = new ArrayList<>(intArray.length);

    /*
     * Searches the entire array for the searchValue
     */
    while (index < intArray.length) {
      if (intArray[index] == searchValue) {
        indicesFound.add(index);
      } else {
        index += 1;
      }
    }
    return indicesFound;
  }
  public ArrayList<ArrayList<Integer>> search2DArray(){

    ArrayList<ArrayList<Integer>> twoDimensionalIndicesFound = new ArrayList<ArrayList<Integer>>();
    return twoDimensionalIndicesFound;
  }
}
