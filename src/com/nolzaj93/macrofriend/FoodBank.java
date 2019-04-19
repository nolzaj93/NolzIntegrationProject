package com.nolzaj93.macrofriend;
/*
 *Austin Nolz
 *Food Bank class is in the primitive stages of development. This class will be used to store
 *the macronutrients of meals that the user regularly eats.
*/

import java.util.ArrayList;

public class FoodBank {
  private ArrayList<Double[]> foodBankItems = new ArrayList<>();

  public FoodBank(){

  }

  public ArrayList<Double[]> getFoodBankItems() {
    return foodBankItems;
  }

  public void setFoodBankItems(ArrayList<Double[]> foodBankItems) {
    this.foodBankItems = foodBankItems;
  }
}
