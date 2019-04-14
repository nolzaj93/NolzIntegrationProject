package com.nolzaj93.macrofriend;
// Austin Nolz

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/*
 * (32)Make a class in a separate file with private fields, public getters and setters, a
 * constructor with and without parameters.
 * (34) Describe inheritance and its benefits.
 * Inheritance through the keyword "extends" allows the NewUser class to inherit all the members
 * from the superclass, Introduction. Note: constructors are not members, but the superclass
 * constructor can be called directly by the subclass if accessible. This is beneficial
 * because we can quickly type extends and the superclass name, instead of copying and pasting
 * the code into the subclass. This is much more efficient.
 */
public class NewUser extends Introduction {

  private String userName = "";
  private double userAge;
  private double userHeight;
  private double userWeight;
  private String userBiologicalSex;
  private double userBodyFatPercentage;
  private double workoutsPerWeek;
  private boolean randomOption = true;
  private boolean mealPlanOption = true;
  private boolean calculateGramsPerMealOption = true;
  private double basalMetabolicRate;
  private double totalDailyEnergyExpenditure;
  private double goalDailyCalories;
  private double percentFat;
  private double percentCarb;
  private double percentProtein;
  private double goalGramsFat;
  private double goalGramsCarb;
  private double goalGramsProtein;
  private double[] goalGrams; // (37) declare a one-dimensional array
  private String[] macronutrients = {"Fat", "Carb", "Protein"};
  private double[] mealGramTotals = new double[3];
  private String goal;

  public NewUser() {
    /*
     * (36) Use super and this to access objects and constructors.
     * The compiler automatically provides a no-argument, default constructor implicitly. When we
     * explicitly define this no-argument constructor, then we must explicitly define one for
     * the superclass as well.
     *
     * super() is a call to the constructor of the explicitly defined superclass and is a redundant
     * statement in this case, because creation of a NewUser object calls NewUser() and
     * Introduction() by default.
     */
    super();
  }

  public NewUser(Scanner userScanner) {
    /* (36) It is incorrect to call super() and this() constructors within the same constructor.
     * Uncomment super(); to see the error. The statement this(); is redundant because the
     * no-argument constructor will be called automatically, even when NewUser(Scanner userScanner)
     * is called.
     */
    //super();
    this();

    /*
     * userStrings and userDoubles are declared and instantiated locally and passed into
     * the method enterUserInfo() as arguments
     */
    String[] userStrings = new String[2];
    Double[] userDoubles = new Double[5];
    enterUserInfo(userScanner, userStrings, userDoubles);
    setUserName(userStrings[0]);
    setBiologicalSex(userStrings[1]);
    setUserAge(userDoubles[0]);
    setUserHeight(userDoubles[1]);
    setUserWeight(userDoubles[2]);
    setUserBodyFat(userDoubles[3]);
    setWorkoutsPerWeek(userDoubles[4]);
  }

  public void enterUserInfo(Scanner userScanner, String[] userStrings, Double[] userDoubles) {
    System.out.println("Please enter your name.");
    /*
     * (8) String object userName is initialized with the input string literal
     */
    boolean userNameIsSet = false;
    String name = "";
    while (!userNameIsSet) {

      name = userScanner.next().trim();

      // checks if there is at least one letter in name
      if (!name.matches(".*[a-zA-Z]+.*")) {
        System.out.println(
            "Your user name must have at least one letter. \n" + "Please enter your name.");
        /*
         * (31) If the name input does not have a letter, then this iteration of the loop ends and
         * the variable, userName, is not set
         */
        continue;
      } else {
        userNameIsSet = true;
      }
      userStrings[0] = name;
    }

    // (13) This string is formatted using the escape sequence for a new line
    System.out.println("Thank you, " + userStrings[0] + ". "
        + "Please enter your age expressed as a whole number.\n");

    // (29) do while loops
    boolean ageIsSet = false;
    int age = 0;
    do {
      try {

        age = userScanner.nextInt();

        if (age > 120 || age < 0) {
          throw new Exception();

        } else {

          userDoubles[0] = (double) age;
          ageIsSet = true;
        }
        /*
         * (45) Effectively utilize exception handling for user input of an int
         */
      } catch (InputMismatchException ex) {
        System.out.println("Error: your input included text or had a decimal point.\n"
            + "Please input your age as a whole number.");
      } catch (Exception ex) {
        System.out.println("Error: your age must be greater than zero, or less than 120.\n"
            + "Please enter your age expressed as a whole number.");
      }
      userScanner.nextLine();
    } while (!ageIsSet);

    /*
     * (9) A variable is a location in memory that consists of an ID or name that refers to the
     * value stored in memory. (6) the range for int data type is from -2_147_483_648 to +
     * 2_147_483_647 (12) If we were to use userAge in a calculation with other integers it would be
     * automatically casted to int, which is shown manually below. Casting is the action of
     * converting one data type to another if possible
     */

    // int intAgeBoxTooBig = (int) userAge;
    // casting the int value back to a byte variable
    // userAge = (byte) intAgeBoxTooBig;

    System.out.println("Please enter your height in inches. \n");
    boolean heightIsSet = false;
    double height = 0;
    do {

      try {

        height = userScanner.nextDouble();
        if (height <= 21.4 || height > 100) {
          throw new Exception();
        } else {

          userDoubles[1] = height;
          heightIsSet = true;
        }
      } catch (InputMismatchException ex) {
        System.out.println(
            "Error: your input included text. Please enter your height in inches. Example: 70\n");
      } catch (Exception ex) {
        System.out.println("Error: your height must be greater than 21.4 inches, or\n"
            + "less than 100 inches. Please enter your height in inches.\n");
      }
      userScanner.nextLine();

    } while (!heightIsSet);

    /*
     * (10) Scope refers to how variables can only be accessed in the methods they are declared.
     */

    System.out.println("Please enter your current weight in pounds.\n");
    boolean weightIsSet = false;
    double weight;
    do {
      try {
        /*
         * (7) double is Java's default floating point number
         */

        weight = userScanner.nextDouble();

        if (weight <= 0) {
          System.out.println("Your entry was less than or equal to zero. "
              + "Please enter your weight in pounds.\n");
          continue;
        } else {
          userDoubles[2] = weight;
          weightIsSet = true;
        }
      } catch (InputMismatchException ex) {
        System.out.println("Error: your input included text. Please enter your weight in pounds.\n"
            + "Example: 155.5\n");

      }
      userScanner.nextLine();

    } while (!weightIsSet);

    /*
     * (5) boolean loopExit declared and initialized as false Only exits loop if user inputs correct
     * info (22) equals() and compareTo() methods, == is not appropriate with Strings and other
     * objects because == compares the object references not the literals that they reference.
     * (27)This while loop is event-controlled by user input, and only exits if the input is either
     * female or male. An error message is printed if the input is incorrect
     */

    boolean biologicalSexIsSet = false;
    String biologicalSex = "";
    while (!biologicalSexIsSet) {

      System.out.println("Are you male or female?\n");
      biologicalSex = userScanner.next().toLowerCase();

      // (19) if/else constructs
      if (biologicalSex.equals("male")) {
        biologicalSexIsSet = true;
        userStrings[1] = biologicalSex;

      } else if (biologicalSex.compareTo("female") == 0) {
        biologicalSexIsSet = true;
        userStrings[1] = biologicalSex;

      } else {

        System.out
            .println("Error: invalid input for the Katch-McArdle and Harris-Benedict equations.\n");
        continue;
      }
      userScanner.nextLine();
    }

    System.out.println("\nThank you, now please input your estimated body fat percentage \n"
        + "without a percentage sign. For example: 20.8. If you \n"
        + "have not had your body fat tested with calipers, \n"
        + "bioelectric impedence analysis, or a DEXA scan copy this link \n"
        + "into your web browser for a less precise visual estimate: \n\n"
        + "https://www.builtlean.com/2012/09/24/body-fat-percentage-men-women/ \n");

    boolean bodyFatIsSet = false;
    double bodyFatPercentage = 0;
    do {
      try {
        /*
         * (7) double is Java's default floating point data type
         */
        bodyFatPercentage = userScanner.nextDouble() / 100.0;

        // (19) if/else constructs
        if (bodyFatPercentage <= 0 || bodyFatPercentage >= 0.75) {

          System.out.println("Invalid entry. Please enter your body fat "
              + "percentage as an integer or decimal. For example: 20.5 \n");
          continue;

        } else {

          userDoubles[3] = bodyFatPercentage;
          bodyFatIsSet = true;
        }
      } catch (InputMismatchException ex) {
        System.out.println("Error: your input included text.\n " + "Please enter your body fat \n"
            + "percentage as an integer or decimal. For example: 20.5 \n");

      }
      userScanner.nextLine();

    } while (!bodyFatIsSet);
    /*
     * Do-while loop used with a boolean to set
     */
    boolean workoutsPerWeekIsSet = false;
    double workoutsPerWeek = 0;
    do {
      try {
        System.out.println("\nIn the past month, how many hours \n"
            + "have you exercised each week on average?\n");
        workoutsPerWeek = userScanner.nextDouble();

        // (19) if/else constructs
        if (workoutsPerWeek < 0) {
          System.out.println("Your entry was less than zero. Please enter a number greater than"
              + "or equal to zero.");
          continue;
        } else if (workoutsPerWeek > 21) {
          System.out.println("Please enter a realistic number. Olympic level sprinters \n"
              + "workout at most 21 hours per week. If this number is accurate\n"
              + "you are likely overtraining. Please consult your physician for individual \n"
              + "recommendations.\n");
          continue;
        } else {
          workoutsPerWeekIsSet = true;
          userDoubles[4] = workoutsPerWeek;
        }
      } catch (InputMismatchException ex) {
        System.out.println("Error: please input a number.");
        userScanner.nextLine();
      }

    } while (workoutsPerWeekIsSet == false);
  }

  // getter and setter methods
  public String getUserName() {

    return userName;
  }

  public void setUserName(String newName) {

    userName = newName;
  }

  public double getUserAge() {

    return userAge;
  }

  public void setUserAge(double newAge) {

    userAge = newAge;
  }

  public double getUserHeight() {

    return userHeight;
  }

  public void setUserHeight(double newHeight) {

    userHeight = newHeight;
  }

  public double getUserWeight() {

    return userWeight;
  }

  public void setUserWeight(double newWeight) {

    userWeight = newWeight;
  }

  public String getBiologicalSex() {

    return userBiologicalSex;
  }

  public void setBiologicalSex(String newBiologicalSex) {

    userBiologicalSex = newBiologicalSex;
  }

  public double getUserBodyFat() {

    return userBodyFatPercentage;
  }

  public void setUserBodyFat(double newBodyFat) {

    userBodyFatPercentage = newBodyFat;
  }

  public double getWorkoutsPerWeek() {

    return workoutsPerWeek;
  }

  public void setWorkoutsPerWeek(double newWorkoutDays) {

    workoutsPerWeek = newWorkoutDays;
  }

  public double getBasalMetabolicRate() {

    return basalMetabolicRate;
  }

  public void setBasalMetabolicRate(double newBMR) {

    basalMetabolicRate = newBMR;
  }

  public double getTDEE() {

    return totalDailyEnergyExpenditure;
  }

  public void setTDEE(double newTDEE) {

    totalDailyEnergyExpenditure = newTDEE;
  }

  public double getGoalDailyCalories() {

    return goalDailyCalories;
  }

  public void setGoalDailyCalories(double newGoalCals) {

    goalDailyCalories = newGoalCals;
  }

  public boolean getRandomOption() {
    return randomOption;
  }

  public void setRandomOption(boolean newVal) {
    randomOption = newVal;
  }

  public boolean getMealPlanOption() {
    return mealPlanOption;
  }

  public void setMealPlanOption(boolean newVal) {
    mealPlanOption = newVal;
  }

  public boolean getCalculateGramsPerMealOption() {
    return calculateGramsPerMealOption;
  }

  public void setCalculateGramsPerMealOption(boolean calculateGramsPerMealOption) {
    this.calculateGramsPerMealOption = calculateGramsPerMealOption;
  }

  public double getPercentFat() {

    return percentFat;
  }

  public void setPercentFat(double newPercentFat) {

    percentFat = newPercentFat;
  }

  public double getPercentCarb() {

    return percentCarb;
  }

  public void setPercentCarb(double newPercentCarb) {

    percentCarb = newPercentCarb;
  }

  public double getPercentProtein() {

    return percentProtein;
  }

  public void setPercentProtein(double newPercentProtein) {

    percentProtein = newPercentProtein;
  }

  public double getGoalGramsFat() {

    return goalGramsFat;
  }

  public void setGoalGramsFat(double newGramsFat) {

    goalGramsFat = newGramsFat;
  }

  public double getGoalGramsCarb() {

    return goalGramsCarb;
  }

  public void setGoalGramsCarb(double newGramsCarb) {

    goalGramsCarb = newGramsCarb;
  }

  public double getGoalGramsProtein() {

    return goalGramsProtein;
  }

  public void setGoalGramsProtein(double newGramsProtein) {

    goalGramsProtein = newGramsProtein;
  }

  public double getGoalGrams(int n) {

    return goalGrams[n];
  }

  public double[] getGoalGrams() {

    return goalGrams;
  }

  public void setGoalGrams(double[] newGrams) {

    goalGrams = newGrams;
  }

  public void setGoal(String newGoal) {

    goal = newGoal;
  }

  public String getGoal() {

    return goal;
  }

  /*
   * (14) This method estimates total daily energy expenditure with parameters within the
   * parentheses. The return value is a double.
   */
  public double estimateTDEE() {
// Sourced from this website:
//https://www.ajdesigner.com/phpweightloss/weight_loss_equations_total_daily_energy_expenditure_moderate.php
    /*
     * This calculation estimates basal metabolic rate(BMR) depending on biological sex, body fat %,
     * height, weight, and age. We take the average of two equations: the Katch-McArdle equation,
     * and the Harris-Benedict equation. (23) use +, - , * , /, an example of order of operations
     * PEMDAS.
     *
     */
    if (getBiologicalSex().equals("female")) {
      /*
       *  equations for females
       */
      setBasalMetabolicRate(((370 + (21.6 * (1 - getUserBodyFat()) * (getUserWeight() / 2.2)))
          + (655 + (9.6 * (getUserWeight() / 2.2)) + (1.8 * getUserHeight() * 2.54)
          - (4.7 * getUserAge())) / 2.0));

    } else if (getBiologicalSex().equals("male")) {
      //equations for males
      setBasalMetabolicRate(((370 + (21.6 * (1 - getUserBodyFat()) * (getUserWeight() / 2.2))) +
          (66 + (13.7 * (getUserWeight() / 2.2)) + (5 * getUserHeight() * 2.54)
              - (6.8 * getUserAge()))) / 2.0);
    }

    /*
     * (21) Use a switch statement This estimates total daily energy expenditure(TDEE) using BMR
     * and workouts per week, based on the equations referenced above.
     */
    int workouts = (int) Math.rint(getWorkoutsPerWeek());
    switch (workouts) {
      case 0:
        totalDailyEnergyExpenditure = (1.2 * basalMetabolicRate);
        break;
      case 1:
      case 2:
        totalDailyEnergyExpenditure = (1.375 * basalMetabolicRate);
        break;
      case 3:
      case 4:
      case 5:
        totalDailyEnergyExpenditure = (1.55 * basalMetabolicRate);
        break;
      case 6:
      case 7:
        totalDailyEnergyExpenditure = (1.725 * basalMetabolicRate);
        break;
      default:
        totalDailyEnergyExpenditure = (1.9 * basalMetabolicRate);
        break;
    }
    /*
     * (18) Use Math class, Math.rint returns double value closest to the argument.
     * This rounds the estimated TDEE to the nearest integer, and also sets goalDailyCalories to
     * this number by default.
     */
    totalDailyEnergyExpenditure = Math.rint(totalDailyEnergyExpenditure);
    setGoalDailyCalories(getTDEE());

    System.out.println("\n" + "Name: " + getUserName() + "\n" + "Age: " + getUserAge()
        + " years old" + "\n" + "Height: " + getUserHeight() + " inches" + "\n" + "Weight: "
        + getUserWeight() + "\n" + "Sex: " + getBiologicalSex() + "\n" + "Body Fat Percentage: "
        + (getUserBodyFat() * 100) + "%\n" + "Workouts per week: " + getWorkoutsPerWeek());

    System.out.printf("Estimated Total Daily Energy Expenditure (TDEE): " + "%.0f Calories\n\n",
        getTDEE());

    System.out.println("This amount of Calories will maintain your current \n"
        + "weight. When you look at a nutrition label it has \n"
        + "the number of servings, and for each serving it shows \n"
        + "grams of fat, grams of carbohydrate and grams of protein. \n"
        + "Fat and carbohydrates are the two macronutrients used primarily \n"
        + "for energy, and protein is broken down into amino acids, \n"
        + "which are used to repair all types of cells including muscle. \n"
        + "Fat requires ~9 Calories to burn 1 gram, while carbohydrates \n"
        + "and protein require 4 Calories to burn 1 gram.\n");

    return totalDailyEnergyExpenditure;
  }

  /*
   * This method gives the user the option to call the generateRandomExample() method.
   */
  public void giveRandomExampleOption(Scanner userScanner) {
    userScanner.nextLine();
    while (randomOption) {
      System.out.println("Would you like to generate a random distribution of macronutrients?\n"
          + "Type yes for a random example or type anything else to enter your own percentages.\n");
      String randomInput = userScanner.nextLine();

      if (randomInput.toLowerCase().equals("yes")) {
        generateRandomExample();
        setRandomOption(false);
      } else {
        setRandomOption(false);
      }
    }
  }

  /*
   * This method generates a random example of daily grams to maintain weight using the user's
   * total daily energy expenditure(TDEE).
   */
  public void generateRandomExample() {

    Random macroSample = new Random();

    /*
     * (11) final fields (17) Use the Random class
     * Random integers are generated for an example of percentage of Calories from fat,
     * carbohydrate, and protein.
     */
    final int FAT_PERCENT = macroSample.nextInt(15) + 20;
    final int CARB_PERCENT = macroSample.nextInt(20) + 45;
    final int PROTEIN_PERCENT = 100 - FAT_PERCENT - CARB_PERCENT;

    System.out.printf("Randomized example of daily macronutrient distribution: "
        + "%d%% Fat %d%% Carbs %d%% Protein\n\n", FAT_PERCENT, CARB_PERCENT, PROTEIN_PERCENT);

    /*
     * Daily Calories from each macronutrient is calculated by multiplying the user's
     * total daily energy expenditure by the percentage of daily Calories from each macronutrient
     */
    final double caloriesFromFat = (FAT_PERCENT / 100.0) * (getTDEE());
    final double caloriesFromCarb = (CARB_PERCENT / 100.0) * (getTDEE());
    final double caloriesFromProtein = (PROTEIN_PERCENT / 100.0) * (getTDEE());

    System.out.printf(
        "If we multiply each percentage by the total daily energy expenditure we get: \n"
            + "(%d/100)*(%.0f) = %.0f Calories from fat\n"
            + "(%d/100)*(%.0f) = %.0f Calories from carbs\n"
            + "(%d/100)*(%.0f) = %.0f Calories from protein.\n\n",
        FAT_PERCENT, getTDEE(), caloriesFromFat,
        CARB_PERCENT, getTDEE(), caloriesFromCarb,
        PROTEIN_PERCENT, getTDEE(), caloriesFromProtein);

    /*
     * Daily grams of each macronutrient is calculated by multiplying number of daily Calories
     * for each macronutrient by the respective number of Calories per gram.
     */
    final double gramsOfFat = caloriesFromFat / 9; // 9 Cal/gram of fat
    final double gramsOfCarb = caloriesFromCarb / 4; // 4 Cal/gram of Carb
    final double gramsOfProtein = caloriesFromProtein / 4; // 4 Cal/gram of Protein
    System.out.printf("We then divide by Calories per gram for each macronutrient, which gives\n"
            + "daily macronutrient needs in grams: \n\n"
            + "%.2f grams of fat, %.2f grams of carbs, %.2f grams of protein \n\n",
        gramsOfFat, gramsOfCarb, gramsOfProtein);

    /*
     * (20) A nested ternary operator is used to print different Strings depending on the conditions
     * of caloriesFromFat > caloriesFromCarb
     */
    String result = (caloriesFromFat != caloriesFromCarb
        ? ((caloriesFromFat > caloriesFromCarb) ? "is fat dominant." : "is carbohydrate dominant.")
        : "has equal Calories from fat and carbs");

    System.out.println("This random sample distribution of macronutrients " + result);
  }

  /*
   * This method allows the user to enter their preferred percentage of daily Calories from fat,
   * carbohydrate, and protein. User input is only accepted when within normal ranges based
   * on the US Dietary guidelines.
   */
  public void changeMacronutrientPercent(Scanner userScanner) {
    /*
     * The method resets these three variables to account for when someone types "back" in
     * incrementMacroPercent or decrementMacroPercent
     */
    setPercentFat(0);
    setPercentCarb(0);
    setPercentProtein(0);

    System.out.println("\n Please enter your preferred percentage of "
        + "Calories from fat sources. An average American diet \n"
        + "consists of 20-35 percent fat. A classic ketogenic diet \n"
        + "would have 60-75 percent fat.\n"
        + "What percent of daily Calories from fat do you prefer? Your input must be"
        + "between 20.0 and 75.0.\n");

    do {
      try {
        setPercentFat(userScanner.nextDouble());
        /*
         * (24) Use relation operators (<=, <) (25) Use conditional operators (&& ||)
         * Exception is thrown if user inputs a double not within the inclusive range [20.0, 75.0],
         * and InputMismatchException is thrown if the input includes text.
         */
        if (getPercentFat() <= 19.9 || getPercentFat() > 75) {
          setPercentFat(0);
          throw new Exception();
        }
      } catch (InputMismatchException ex) {
        System.out.println("Error: your input included text. Please enter your preferred\n"
            + "percentage of Calories from fat. Example: 45.5");
        userScanner.nextLine();
      } catch (Exception ex) {
        System.out.println("Error: your entry was not between 20.0 and 75.0. Please enter your\n"
            + "preferred percentage of Calories from fat. Example: 25.5");
        userScanner.nextLine();
      }

    } while (percentFat == 0);

    System.out.println("\nPlease enter your preferred percentage of Calories from carbohydrate\n"
        + "sources. An average American diet 45-65 percent carbohydrate.\n"
        + "A classic ketogenic diet would have 5-10 percent carbohydrate.\n"
        + "What percent of daily Calories from fat do you prefer? Your input must be \n"
        + "between 5.0 and 65.0 ");

    do {
      try {
        setPercentCarb(userScanner.nextDouble());
        /*
         * Exception is thrown if user inputs a double not within the inclusive range [5.0, 65.0],
         * and InputMismatchException is thrown if the input includes text.
         */
        if (percentCarb < 5 || percentCarb > 65) {
          setPercentCarb(0);
          throw new Exception();
        }
        System.out.println((5 <= percentCarb && percentCarb < 45)
            ? "Warning: this is below the recommended minimum percentage from carbohydrate.\n"
            + "Consult a physician and/or a nutritionist to get an individual\n"
            + "recommendation of your ideal macronutrient distribution."
            : "");
      } catch (InputMismatchException ex) {
        System.out.println("Error: your input included text. Please enter your preferred\n"
            + "percentage of Calories from carbohydrate. Example: 45.5");
        userScanner.nextLine();
      } catch (Exception ex) {
        System.out.println("Error: your entry was not between 5.0 and 65.0. Please enter your\n"
            + "preferred percentage of Calories from carbohydrates between 5.0 and 65.0.");
        userScanner.nextLine();
      }
    } while (percentCarb == 0);
    userScanner.nextLine();

    /*
     *(23) Use %, proteinPercent is found by taking the remainder of the sum of (percentFat and
     * percentCarb)/100 divided by 1.0. Example: percentFat = 20, percentCarb = 50,
     * remaining percent = 0.3 so percentProtein = 30
     */
    double remainingPercent = (1 - ((percentFat + percentCarb) / 100.0) % 1.0);
    setPercentProtein(Math.rint(remainingPercent * 100.0));
    System.out.println("Percent fat: " + percentFat + "\n" + "Percent carb: " + percentCarb + "\n"
        + "Percent protein: " + percentProtein + "\n");
  }

  /*
   * (23) use ++. This method allows the user to increment the percent of each macronutrient
   * by typing the name of the macronutrient: fat, carb, or protein. Also, allows them to
   * proceed by pressing enter, or to call changeMacronutrientPercent(Scanner userScanner)
   * by entering "back".
   */
  public void incrementMacroPercent(Scanner userInfo) {

    boolean incrementOption = true;
    do {
      System.out.println("To increase a percentage by 1.0% type in the macronutrient,\n"
          + "either: fat, carb, or protein.\n"
          + "This will automatically reduce the other two macronutrients by 0.5%. \n"
          + "To re-enter your preferred percentages type: back\n"
          + "To proceed press enter/return.");
      String changePercent = userInfo.nextLine();
      switch (changePercent.toLowerCase()) {
        case "fat":
          setPercentFat(++percentFat);
          setPercentCarb(percentCarb -= 0.5);
          setPercentProtein(percentProtein -= 0.5);
          break;
        case "carb":
          setPercentCarb(++percentCarb);
          setPercentFat(percentFat -= 0.5);
          setPercentProtein(percentProtein -= 0.5);
          break;
        case "protein":
          setPercentProtein(++percentProtein);
          setPercentFat(percentFat -= 0.5);
          setPercentCarb(percentCarb -= 0.5);
          break;
        case "back":
          changeMacronutrientPercent(userInfo);
          break;
        case "":
          incrementOption = false;
          break;
        default:
          System.out.println("Your input did not match fat, carb, protein, or back.");
          break;
      }
      System.out.println("Current distribution: \n"
          + "Percent fat: " + percentFat + "\n"
          + "Percent carb: " + percentCarb + "\n"
          + "Percent protein: " + percentProtein + "\n");
    } while (incrementOption);
  }

  /* (23) use -- and +=. This method allows the user to decrement the percent of each macronutrient
   * by typing the name of the macronutrient: fat, carb, or protein. Also, allows them to
   * proceed by pressing enter, or to call changeMacronutrientPercent(Scanner userScanner) again
   * by entering "back".
   */
  public void decrementMacroPercent(Scanner userInfo) {
    System.out.println("To decrease a percentage by 1.0% type in the macronutrient,\n"
        + "either: fat, carb, or protein.\n"
        + "This will automatically increase the other two macronutrients by 0.5%. \n"
        + "To re-enter your preferred percentages type: back \n"
        + "To proceed press enter/return");

    boolean decrementOption = true;
    do {
      String changePercent = userInfo.nextLine();
      switch (changePercent.toLowerCase()) {
        case "fat":
          setPercentFat(--percentFat);
          setPercentCarb(percentCarb += 0.5);
          setPercentProtein(percentProtein += 0.5);
          break;
        case "carb":
          setPercentCarb(--percentCarb);
          setPercentFat(percentFat += 0.5);
          setPercentProtein(percentProtein += 0.5);
          break;
        case "protein":
          setPercentProtein(--percentProtein);
          setPercentFat(percentFat += 0.5);
          setPercentCarb(percentCarb += 0.5);
          break;
        case "back":
          changeMacronutrientPercent(userInfo);
          break;
        case "":
          decrementOption = false;
          break;
        default:
          System.out.println("Your input did not match fat, carb, protein, or back.");
          break;
      }
      System.out.println("Current distribution: \n"
          + "Percent fat: " + percentFat + "\n"
          + "Percent carb: " + percentCarb + "\n"
          + "Percent protein: " + percentProtein + "\n");
    } while (decrementOption);
  }

  /*
   * User previously input their preferred fatPercent, carbPercent and proteinPercent, and this
   * method accepts these arguments with the parameters defined within the parentheses. Grams of
   * each macronutrient are set using each setter method, and the values are printed to stdout.
   * Using the get method for each goalGrams variable, we instantiate and initialize a
   * one-dimensional array using setGoalGrams().
   */
  public void calculateGoalGrams(double fatPercent, double carbPercent, double proteinPercent) {

    setGoalGramsFat(Math.rint((fatPercent / 100) * (getGoalDailyCalories()) / 9));
    setGoalGramsCarb(Math.rint((carbPercent / 100) * (getGoalDailyCalories()) / 4));
    setGoalGramsProtein(Math.rint((proteinPercent / 100) * (getGoalDailyCalories()) / 4));
    System.out.println("Your daily macronutrient requirements in grams:\n"
        + "Fat: " + getGoalGramsFat() + " g from " + fatPercent + "% of daily Calories" + "\n"
        + "Carbs: " + getGoalGramsCarb() + " g from " + carbPercent + "% of daily Calories" + "\n"
        + "Protein: " + getGoalGramsProtein() + " g from " + proteinPercent + "% of daily Calories"
        + "\n");

    // (37) instantiate and initialize a one-dimensional array
    setGoalGrams(new double[]{getGoalGramsFat(), getGoalGramsCarb(), getGoalGramsProtein()});
  }

  /* (33) Overload a Method.
   * generateMealPlanOptions() is overloaded, and the method below without a parameter prints each
   * possible count of grams of fat, carbohydrate and protein for each meal if the user were to
   * eat 1,2,3,4,5, or 6 meals per day.
   */
  public void generateMealPlanOptions() {

    // (28) Use for loops
    for (int meals = 1; meals <= 6; meals++) {
      System.out.println("Meals per day: " + meals + "\n"
          + "Fat: " + (Math.rint(getGoalGrams(0) / meals)) + " g\n"
          + "Carbs: " + (Math.rint(getGoalGrams(1) / meals)) + " g\n"
          + "Protein: " + (Math.rint(getGoalGrams(2) / meals)) + " g\n");
    }
  }

  /* (33) Overload a method.
   * This method prints the grams of fat, carb, and protein per meal for the specific number of
   * meals that the user enters, which is passed into the parameter, int meals.
   */
  public void generateMealPlanOptions(int meals) {
    System.out.println("Meals per day: " + meals + "\n"
        + "Fat: " + (Math.rint(getGoalGrams(0) / meals)) + " g\n"
        + "Carbs: " + (Math.rint(getGoalGrams(1) / meals)) + " g\n"
        + "Protein: " + (Math.rint(getGoalGrams(2) / meals)) + " g\n");
  }

  /*
   * This method allows the user an option to calculate goalGrams of each macronutrient in an
   * arbitrary number of servings. This is helpful if you plan on eating a number of servings
   * that is not a whole integer
   */
  public void calculateGramsPerServing(Scanner userScanner) {
    /*
     * This method gives the user the option of calculating the total grams of each
     * If user input is yes, then the Scanner will prompt for goalGrams of each macronutrient per
     * serving and number of servings. Otherwise, calcServingOption is set to false and the loop is
     * broken
     */
    while (getCalculateGramsPerMealOption()) {
      System.out.println("If you would like to estimate the total grams of \n"
          + "fat, carbs, and protein in an specific number of servings of a food using the \n"
          + "the nutritional label please type yes, otherwise type anything else to continue.\n");
      String input = userScanner.nextLine().toLowerCase().trim();

      if (input.equals("yes")) {
        System.out.println("Please enter the grams of fat per serving.");
        double servingFatGrams = userScanner.nextDouble();

        System.out.println("Please enter the grams of carbohydrate per serving.");
        double servingCarbGrams = userScanner.nextDouble();

        System.out.println("Please enter the grams protein per serving.");
        double servingProteinGrams = userScanner.nextDouble();

        System.out.println("Roughly how many servings did you or will you have?");
        double servings = userScanner.nextDouble();
        /*
         * The array named mealGramTotals is initialized with the total grams of fat, carbs,
         * and protein for the given number of servings.
         */
        mealGramTotals[0] = (servingFatGrams * servings);
        mealGramTotals[1] = (servingCarbGrams * servings);
        mealGramTotals[2] = (servingProteinGrams * servings);
        System.out.println("Total grams for " + servings + " servings:");
        /*
         *(28) Use for loops; this for loop prints the Strings in the array
         * named macronutrients, and the double values in the array named gramTotals
         *(41) Create and use the enhanced for loop
         */
        for (String macro : macronutrients) {
          System.out.print(macro + " ");
        }
        System.out.println();
        for (double gramTotal : mealGramTotals) {
          System.out.printf("%.0f    ", gramTotal);
        }
        System.out.println();
        userScanner.nextLine();
      } else {
        setCalculateGramsPerMealOption(false);
      }
    }
  }

  /*
   * (14) Parameters are userScanner and newGoalIsSet, returns the boolean named goalIsSet.
   * This method allows the user to change the daily goal grams of each macronutrient according
   * to their goal. If their goal is to maintain, then no change occurs. If the goal is to
   * lose 1 pound per week, then 500 Calories is deducted from the estimated TDEE. For 2 pounds
   * per week, 1000 Calories is deducted. To gain a half pound per week, 250 Calories are added
   * to the goalDailyCalories, and for 1 pound of weight gain per week, 500 Calories are added.
   */
  public void changeMacrosByGoal(Scanner userScanner) {
    /*
     * The do-while loop is only broken when the goalIsSet boolean is set to true by the returned
     * boolean from the confirmGoal() method.
     */
    boolean goalIsSet = false;
    do {
      System.out.println("Type the number next to your goal to set your current "
          + "daily macronutrients. Type anything else if your goal is to maintain\n"
          + "your current weight.\n" + "1 : lose ~1 pound per week\n"
          + "2 : lose ~2 pounds per week\n" + "3 : gain ~0.5 pound per week\n"
          + "4 : gain ~1 pound per week\n");

      String userGoal = userScanner.nextLine();
      switch (userGoal) {
        case "1":
          setGoalDailyCalories(getTDEE() - 500);
          setGoal("Lose 1 pound per week");
          /*
           *(36) Use this to access objects
           */
          goalIsSet = confirmGoal(this, userScanner, goalIsSet);
          break;
        case "2":
          setGoalDailyCalories(getTDEE() - 1000);
          setGoal("Lose 2 pounds per week");
          goalIsSet = confirmGoal(this, userScanner, goalIsSet);
          break;
        case "3":
          setGoalDailyCalories(getTDEE() + 250);
          setGoal("Gain half a pound per week");
          goalIsSet = confirmGoal(this, userScanner, goalIsSet);
          break;
        case "4":
          setGoalDailyCalories(getTDEE() + 500);
          setGoal("Gain one pound per week");
          goalIsSet = confirmGoal(this, userScanner, goalIsSet);
          break;
        default:
          setGoalDailyCalories(getTDEE());
          setGoal("Maintain current weight");
          goalIsSet = confirmGoal(this, userScanner, goalIsSet);
          break;
      }
    } while (!goalIsSet);
  }

  /*
   * This method calls calculateGoalGrams() which uses percentFat, percentCarb, and percentProtein
   * to calculate an estimate of daily grams according to the users weight change goal. It is
   * called from changeMacrosByGoal() and returns a boolean to confirm that the goal has been set.
   */
  public boolean confirmGoal(NewUser user, Scanner userScanner, boolean goalSet) {

    calculateGoalGrams(user.getPercentFat(), user.getPercentCarb(), user.getPercentProtein());
    /*
     * Prints the users chosen goal, and requests an input of back to choose a different goal,
     * or enter to continue. If the scanner reads an empty line with nextLine() then goalSet
     * is set to true, which is returned to the method changeMacrosByGoal() where this method
     * is called.
     */
    System.out.println("Current goal: " + user.getGoal() + " \n"
        + "Type back to choose a different goal,\n" + "or press enter to continue.");
    boolean isInvalidInput;
    do {
      String input = userScanner.nextLine();
      switch (input) {
        case "":
          goalSet = true;
          isInvalidInput = false;
          break;
        case "back":
          /*
           * Resets the goalDailyCalories to the estimated TDEE, which is daily Calories to
           * maintain weight, sets the isInvalidInput boolean to false to break the while loop,
           * and calls the method changeMacrosByGoal() again.
           */
          setGoalDailyCalories(getTDEE());
          isInvalidInput = false;
          changeMacrosByGoal(userScanner);
          break;
        default:
          System.out.println("Invalid input. Please press enter to continue, or type back\n"
              + "then press enter to reset your goal.");
          isInvalidInput = true;
          break;
      }
    } while (isInvalidInput);
    return goalSet;
  }

  public void printInfo() {
    /*
     * Prints user's name, age, height, weight, sex, body fat percentage, workouts per week,
     * and estimated daily Calories.
     */
    System.out.printf("Name: " + getUserName() + "\n"
        + "Age: " + getUserAge() + " years old" + "\n"
        + "Height: " + getUserHeight() + " inches" + "\n"
        + "Weight: " + getUserWeight() + "\n"
        + "Sex: " + getBiologicalSex() + "\n"
        + "Body Fat Percentage: " + (getUserBodyFat() * 100) + "%%\n"
        + "Workouts per week: " + getWorkoutsPerWeek() + "\n"
        + "Current Goal: " + getGoal() + "\n"
        + "Estimated Goal Daily Calories: %.0f Calories\n", getGoalDailyCalories());
    /*
     *(37) Use a one-dimensional array. Prints user goal, percent of Calories from each
     * macronutrient, and the daily target grams of each macronutrient for the user's goal
     */
    System.out.println("Percent fat: " + getPercentFat() + "\n"
        + "Percent carbs: " + getPercentCarb() + "\n"
        + "Percent protein: " + getPercentProtein() + "\n"
        + "Daily target grams of fat: " + getGoalGrams(0) + "\n"
        + "Daily target grams of carbs: " + getGoalGrams(1) + "\n"
        + "Daily target grams of protein: " + getGoalGrams(2) + "\n");
  }

  @Override
  public void runUserFunctions(Scanner userScanner) {
    /* (35) Develop code that makes use of polymorphism
     * First, the method estimateTDEE() calculates an estimate of basal metabolic rate(BMR)
     * and total daily energy expenditure (TDEE). Then, the method giverRandomExampleOption()
     * is called, which gives the user the option to generate a random example of daily grams
     * from fat, carbohydrate, and protein.
     */
    estimateTDEE();
    giveRandomExampleOption(userScanner);
    /*
     * Once the user opts against generating a random example, then the methods within the
     * while loop are called. Once the user makes it through these methods, then the break
     * statement exits the loop.
     */
    while (!getRandomOption()) {
      changeMacronutrientPercent(userScanner);
      incrementMacroPercent(userScanner);
      decrementMacroPercent(userScanner);
      calculateGoalGrams(getPercentFat(), getPercentCarb(), getPercentProtein());
      /*
       * (30) The break statement will break the loop, and operates as if we were to write:
       * randomOption = true Both statements will exit the loop
       */
      break;
    }
    /*
     * While loop gives user the option to type yes which will call the generateMealPlanOption()
     * method
     */
    System.out.println("Would you like to see how many grams of fat,\n"
        + "carbs, and protein you would need if you ate 1-6 meals?\n");

    while (getMealPlanOption()) {
      /*
       * If the user types "yes" the switch statement calls generateMealPlanOptions(), which prints
       * goalGrams per meal for every number 1-6. If the user types a single number between 1 and 6
       * then the switch statement will call generateMealPlanOptions(int meals) which prints an
       * estimate of goalGrams per meal for that #. Any other input exits the loop.
       */
      System.out
          .println("Type yes to estimate goalGrams per meal for 1 through 6 meals. \n"
              + "Type 1, 2, 3, 4, 5 or 6 to estimate grams per meal for only one meal frequency,\n"
              + "or type anything else to continue.\n");
      String input = userScanner.nextLine().toLowerCase().trim();
      switch (input) {
        case "":
          setMealPlanOption(false);
          break;
        case "yes":
          generateMealPlanOptions();
          break;
        case "1":
          generateMealPlanOptions(1);
          break;
        case "2":
          generateMealPlanOptions(2);
          break;
        case "3":
          generateMealPlanOptions(3);
          break;
        case "4":
          generateMealPlanOptions(4);
          break;
        case "5":
          generateMealPlanOptions(5);
          break;
        case "6":
          generateMealPlanOptions(6);
          break;
        default:
          setMealPlanOption(false);
          break;
      }
    }
    /*
     * Once calculateGramsPerMealOption is set to false, then the
     * changeMacrosByGoal(Scanner userScanner) method is called.
     * Within the calculateGramsPerMeal() method, the user is given the option to calculate the
     * grams of each macronutrient in a food with nutrition information for an arbitrary decimal
     * number of servings.
     */

    calculateGramsPerServing(userScanner);

    System.out.println("A daily caloric deficit of roughly 500 Calories must\n"
        + "be expended to lose one pound in one week. Conversely, a daily\n"
        + "caloric surplus of roughly 500 Calories must be consumed to gain\n"
        + "one pound in one week. Rapid weight changes are not recommended.\n");
    changeMacrosByGoal(userScanner);
    printInfo();
    findSmallest(getGoalGrams());
  }

  /*
   * (38) Manually find the smallest value in an array. Finds macronutrient with smallest number of
   * daily Calories according to user's goal.
   */
  public void findSmallest(double[] gramsParam) {
    double[] caloriesForEachMacro = {(gramsParam[0] * 9), (gramsParam[1] * 4), (gramsParam[2] * 4)};
    double smallestCalorieCount = caloriesForEachMacro[0];
    for (int count = 1; count < caloriesForEachMacro.length; count++) {
      if (caloriesForEachMacro[count] < smallestCalorieCount) {
        smallestCalorieCount = caloriesForEachMacro[count];
      }

    }
    if (smallestCalorieCount == caloriesForEachMacro[0]) {
      System.out.println("Your smallest number of daily Calories is from fat: "
          + caloriesForEachMacro[0] + " Calories\n");

    } else if (smallestCalorieCount == caloriesForEachMacro[1]) {
      System.out.println("Your smallest number of daily Calories is from carbs: "
          + caloriesForEachMacro[1] + " Calories\n");
    } else {
      System.out.println("Your smallest number of daily Calories is from protein: "
          + caloriesForEachMacro[2] + " Calories\n");
    }
  }

  /*
   * (40)Search an array and identify the index where a value was found.
   */
  public static void searchArray(Scanner userScanner) {
    System.out.println("Array search method: please enter a number of integers you would like\n"
        + "to search through. The number must be a whole number greater than or \n"
        + "equal to 1 and less than or equal to 10.");
    /*
     * The user enters an array size in the inclusive range [0,10]. InputMismatchException is
     * caught if text or decimals are entered, and custom exception is thrown if the input is
     * not within the inclusive range [0,10],
     */
    boolean arraySizeIsSet = false;
    int arraySize = 0;
    while (!arraySizeIsSet) {
      try {
        arraySize = userScanner.nextInt();
        if (arraySize < 1 || arraySize > 10) {
          throw new Exception();
        }
        arraySizeIsSet = true;
      } catch (InputMismatchException ex) {
        System.out.println("Your input included text or was a decimal number.\n"
            + "Please enter a whole number greater than or equal to 1 and less than\n"
            + "or equal to 10. Example: 5");
        userScanner.nextLine();
      } catch (Exception ex) {
        System.out.println("Your input was not in the correct range.\n"
            + "Please enter a whole number greater than or equal to 1 and less than\n"
            + "or equal to 10. Example: 5");
      }
    }
    /*
     * Array named inputArray is declared and instantiated with the input arraySize. The for loop
     * sets elementIsSet to false and initializes each element of the array on each iteration.
     * The while loop contains a try/catch block to make sure each input is an int.
     */
    int[] inputArray = new int[arraySize];
    int index = 0;
    boolean elementIsSet;
    for (index = 0; index < arraySize; index++) {
      elementIsSet = false;
      System.out.println("Please enter integer number " + (index + 1) + ". Example: 5");
      while (!elementIsSet) {
        try {
          inputArray[index] = userScanner.nextInt();
          elementIsSet = true;
        } catch (InputMismatchException ex) {
          System.out.println("Your input included text or was a decimal number.\n"
              + "Please enter a whole number. Example: 5");
          userScanner.nextLine();
        }
      }
    }
    /*
     * The searchValue is ensured to be an integer with the try/catch block within the while loop.
     */
    int searchValue = 0;
    boolean searchValueEntered = false;
    System.out
        .println("Please enter the whole integer value you would like to search for in the array.");
    while (!searchValueEntered) {
      try {
        searchValue = userScanner.nextInt();
        searchValueEntered = true;
      } catch (InputMismatchException ex) {
        System.out.println("Your input included text or was a decimal number.\n"
            + "Please enter a whole integer value. Example: 5");
        userScanner.nextLine();
      }
    }
    index = 0;
    /*
     * (43) Declare an ArrayList of a given type
     */
    ArrayList<Integer> indexesFound = new ArrayList<>(inputArray.length);
    /*
     * Searches the entire array for the searchValue, and adds the indexes to the arrayList
     * named indexesFound.
     */
    boolean searchValueFound = false;
    while (index < inputArray.length) {
      if (inputArray[index] == searchValue) {
        searchValueFound = true;
        indexesFound.add(index);
        index += 1;
      } else {
        index += 1;
      }
    }
    /*
     * If the searchValue is found the indexes are printed to stdout, otherwise the user is
     * notified that the searchValue was not found.
     */
    if (searchValueFound) {
      System.out.println("The value was found at the following index(es).");
      /*
       * (43) Use an ArrayList of a given type
       */
      for (int num : indexesFound) {
        System.out.print(num + " ");
      }
      System.out.println();
    } else {
      System.out.println("The value was not found in the integers you entered.\n");
    }
  }
}
