package com.nolzaj93.macrofriend;

import java.util.ArrayList;

/**
 * (2) MacroFriend is a program that is able to recommend an estimate of daily calories and
 * macronutrients depending on your activity level and fitness goal. The FoodBank class is in the
 * primitive stages of development. This class will be used to store the macronutrients of meals
 * that the user regularly eats.
 *
 * @author austinnolz
 */
public class FoodBank {

  private ArrayList<Double[]> foodBankItems = new ArrayList<>();

  public FoodBank() {

  }

  public ArrayList<Double[]> getFoodBankItems() {
    return foodBankItems;
  }

  public void setFoodBankItems(ArrayList<Double[]> foodBankItems) {
    this.foodBankItems = foodBankItems;
  }
}
