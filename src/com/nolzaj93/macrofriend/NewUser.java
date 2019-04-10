package com.nolzaj93.macrofriend;
// Austin Nolz

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/*
 * (32)Make a class in a separate file with private fields, public getters and setters, a
 * constructor with and without parameters. (34) Describe inheritance and its benefits Inheritance
 * through the keyword "extends" allows the NewUser class to inherit all the members from the
 * superclass, Introduction. Note: constructors are not members, but the superclass constructor can
 * be called directly by the subclass if accessible. This is beneficial because we can quickly type
 * extends and the superclass name, instead of copying and pasting the code into the subclass. This
 * is much more efficient.
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
  private boolean calcServingOption = true;
  private double basalMetabolicRate;
  private double totalDailyEnergyExpenditure;
  private double percentFat;
  private double percentCarb;
  private double percentProtein;
  private double gramsFat;
  private double gramsCarb;
  private double gramsProtein;
  private double[] grams; // (37) declare a one-dimensional array
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

        userStrings[0] = name;
        userNameIsSet = true;
      }
    }

    // (13) This string is formatted using the escape sequence for a new line
    System.out.println("Thank you, " + userStrings[0] + ". "
        + "Please enter your age expressed as a whole number.\n");

    // (29) do while loops
    boolean ageIsSet = false;
    double age = 0;
    do {
      try {

        age = userScanner.nextDouble();

        if (age > 120 || age < 0) {
          throw new Exception();

        } else {

          userDoubles[0] = age;
          ageIsSet = true;
        }
        /*
         * (45) Effectively utilize exception handling for user input of an int
         */
      } catch (InputMismatchException ex) {
        System.out
            .println("Error: your input included text. Please input your age as a whole number.");
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
    double weight = 0;
    do {
      try {
        /*
         * (7) double is Java's default floating point number
         */

        weight = userScanner.nextDouble();

        if (weight <= 0) {
          System.out.println("Invalid entry. Please enter your weight in pounds.\n");
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

    boolean workoutsPerWeekIsSet = false;
    double workoutsPerWeek = 0;
    do {
      try {

        System.out.println("\nIn the past month, how many hours \n"
            + "have you exercised each week on average?\n");

        workoutsPerWeek = userScanner.nextDouble();

        // (19) if/else constructs
        if (workoutsPerWeek < 0) {

          System.out.println("Invalid ent. Please enter a positive number.");

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

  public double getDailyEnergy() {

    return totalDailyEnergyExpenditure;
  }

  public void setDailyEnergy(double newDailyEnergy) {

    totalDailyEnergyExpenditure = newDailyEnergy;
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

  public boolean getCalcServingOption() {
    return calcServingOption;
  }

  public void setCalcServingOption(boolean newVal) {
    calcServingOption = newVal;
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

  public double getGramsFat() {

    return gramsFat;
  }

  public void setGramsFat(double newGramsFat) {

    gramsFat = newGramsFat;
  }

  public double getGramsCarb() {

    return gramsCarb;
  }

  public void setGramsCarb(double newGramsCarb) {

    gramsCarb = newGramsCarb;
  }

  public double getGramsProtein() {

    return gramsProtein;
  }

  public void setGramsProtein(double newGramsProtein) {

    gramsProtein = newGramsProtein;
  }

  public double getGrams(int n) {

    return grams[n];
  }

  public double[] getGrams() {

    return grams;
  }

  public void setGrams(double[] newGrams) {

    grams = newGrams;
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

    /*
     * This calculation estimates basal metabolic rate(BMR) depending on biological sex, body fat %,
     * height, weight, and age. We take the average of two equations: the Katch-McArdle equation,
     * and the Harris-Benedict equation. (23) use +, - , * , /, an example of order of operations
     * PEMDAS
     */

    if (getBiologicalSex().equals("female")) {
      /*
       * Sourced from this website: https://www.ajdesigner.com/phpweightloss/
       * weight_loss_equations_total_daily_energy_expenditure_moderate.php
       *
       */
      setBasalMetabolicRate(((370 + (21.6 * (1 - getUserBodyFat()) * (getUserWeight() / 2.2)))
          + (655 + (9.6 * (getUserWeight() / 2.2)) + (1.8 * getUserHeight() * 2.54)
          - (4.7 * getUserAge())) / 2.0));

    } else if (getBiologicalSex().equals("male")) {

      setBasalMetabolicRate(((370 + (21.6 * (1 - getUserBodyFat()) * (getUserWeight() / 2.2))) + (66
          + (13.7 * getUserWeight() / 2.2) + (5 * getUserHeight() * 2.54) - (6.8 * getUserAge())))
          / 2.0);

    }

    /*
     * (21) Use a switch statement This estimates total daily energy expenditure using BMR and
     * workouts per week
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
     * (18) Use Math class, Math.rint returns double value closest to the argument
     */
    setDailyEnergy(Math.rint(totalDailyEnergyExpenditure));

    System.out.println("\n" + "Name: " + getUserName() + "\n" + "Age: " + getUserAge()
        + " years old" + "\n" + "Height: " + getUserHeight() + " inches" + "\n" + "Weight: "
        + getUserWeight() + "\n" + "Sex: " + getBiologicalSex() + "\n" + "Body Fat Percentage: "
        + (getUserBodyFat() * 100) + "%\n" + "Workouts per week: " + getWorkoutsPerWeek());

    System.out.printf("Estimated Total Daily Energy Expenditure (TDEE): " + "%.0f Calories\n\n",
        getDailyEnergy());

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

  public void changeMacronutrientPercent(Scanner userInfo) {

    /*
     * resets these three variables, if someone types "back" in incrementMacroPercent or
     * decrementMacroPercent
     */
    setPercentFat(0);
    setPercentCarb(0);
    setPercentProtein(0);

    System.out.println("\n Please enter your preferred percentage of "
        + "Calories from fat sources. An average American diet \n"
        + "consists of 20-35 percent fat, 45-65 percent carbohydrate, and \n"
        + "10-35 percent protein. A classic ketogenic diet \n"
        + "would have 60-75 percent fat, 5-10 percent carbohydrate, \n"
        + "and 15-30 percent protein.");

    do {
      try {

        System.out
            .println("What percent of daily Calories " + "from fat do you prefer? Example: 20");
        setPercentFat(userInfo.nextDouble());

        /*
         * (24) Use relation operators (<=, <) (25) Use conditional operators (&& ||)
         */
        if (percentFat <= 0 || percentFat > 75) {
          System.out.println(
              "Invalid entry. Please enter your preferred percentage of Calories from fat.");
          setPercentFat(0);
          continue;
        }
        System.out.println((0 < percentFat && percentFat < 20)
            ? "Warning: this is below the recommended minimum percentage from fat. \n"
            + "Consult a physician and/or a nutritionist to get an individual \n"
            + "recommendation of your ideal macronutrient distribution."
            : "");

      } catch (InputMismatchException e) {
        System.out.println("Error: please enter your preferred percentage of \n"
            + "Calories from fat. Example: 20.5");
      }
      userInfo.nextLine();

    } while (percentFat == 0);

    System.out.println("\nPlease enter your preferred percentage of "
        + "Calories from carbohydrate sources. An average American diet \n"
        + "consists of 20-35 percent fat, 45-65 percent carbohydrate, and \n"
        + "10-35 percent protein. A classic ketogenic diet \n"
        + "would have 60-75 percent fat,  5-10 percent carbohydrate, \n"
        + "and 15-30 percent protein. What percent of daily Calories \n"
        + "from fat do you prefer? Example: 20 ");

    do {
      try {

        setPercentCarb(userInfo.nextDouble());
        if (percentCarb <= 0 || percentCarb > 65) {
          System.out.println("Invalid entry. Please enter your preferred"
              + " percentage of Calories from carbohydrate between \n" + "5 and 65 percent.");
          setPercentCarb(0);
          continue;
        }
        System.out.println((0 < percentCarb && percentCarb < 45)
            ? "Warning: this is below the recommended minimum percentage from carbohydrate. \n"
            + "Consult a physician and/or a nutritionist to get an individual \n\n"
            + "recommendation of your ideal macronutrient distribution."
            : "");

      } catch (InputMismatchException e) {
        System.out.println("Error: please enter your preferred percentage of "
            + "Calories from carbohydrate. Example: 45.5");
      }
      userInfo.nextLine();
      // (23) Use %
      setPercentProtein(Math.rint((1 - ((percentFat + percentCarb) / 100.0) % 1.0) * 100.0));
      System.out.println("Percent fat: " + percentFat + "\n" + "Percent carb: " + percentCarb + "\n"
          + "Percent protein: " + percentProtein + "\n");

    } while (percentCarb == 0);

  }

  // (23) use ++
  public void incrementMacroPercent(Scanner userInfo) {

    boolean incrementOption = true;
    do {
      System.out.println("\n To increase a percentage by 1.0% type in the macronutrient,\n"
          + "either: fat, carb, or protein \n"
          + "This will automatically reduce the other two macronutrients by 0.5%. \n"
          + "To re-enter your preferred percentages type: back \n"
          + "To proceed press enter/return.\n");
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
          System.out.println("Invalid input.");
          break;
      }

      System.out.println((incrementOption)
          ? "\nCurrent distribution: \n" + "Percent fat: " + percentFat + "\n" + "Percent carb: "
          + percentCarb + "\n" + "Percent protein: " + percentProtein
          : "\n");

    } while (incrementOption == true);
  }

  // (23) use -- and +=
  public void decrementMacroPercent(Scanner userInfo) {
    System.out.println("To decrease a percentage by 1.0% type in the macronutrient,\n"
        + "either: fat, carb, or protein \n"
        + "This will automatically increase the other two macronutrients by 0.5%. \n"
        + "To re-enter your preferred percentages type: back \n" + "To proceed press enter/return");

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
          System.out.println("Invalid input.");
          break;
      }

      System.out.println(
          (decrementOption) ? "\nCurrent distribution: \n" + "Percent fat: " + percentFat + "\n"
              + "Percent carb: " + percentCarb + "\n" + "Percent protein: " + percentProtein + "\n"
              + "Please type either \n " + "fat, carb, or protein to increment the respective \n"
              + "macronutrient. To re-enter your percentages type: back \n"
              + "To proceed press enter/return" : "\n");

    } while (decrementOption == true);
  }

  /*
   * (14) Parameters are userScanner and newGoalIsSet, returns the boolean named goalIsSet
   */
  public boolean changeMacrosByGoal(Scanner userScanner, boolean newGoalIsSet) {
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
          setDailyEnergy(getDailyEnergy() - 500);
          setGoal("Lose 1 pound per week");
          /*
           *(36) Use this to access objects
           */
          goalIsSet = confirmGoal(this, userScanner, newGoalIsSet);
          break;
        case "2":
          setDailyEnergy(getDailyEnergy() - 1000);
          setGoal("Lose 2 pounds per week");
          goalIsSet = confirmGoal(this, userScanner, newGoalIsSet);
          break;
        case "3":
          setDailyEnergy(getDailyEnergy() + 250);
          setGoal("Gain half a pound per week");
          goalIsSet = confirmGoal(this, userScanner, newGoalIsSet);
          break;
        case "4":
          setDailyEnergy(getDailyEnergy() + 500);
          setGoal("Gain one pound per week");
          goalIsSet = confirmGoal(this, userScanner, newGoalIsSet);
          break;
        default:
          setGoal("Maintain current weight");
          goalIsSet = confirmGoal(this, userScanner, newGoalIsSet);
          break;
      }

    } while (goalIsSet == false);

    return goalIsSet;
  }

  /*
   * User previously input their preferred fatPercent, carbPercent and proteinPercent, and this
   * method accepts these arguments with the parameters defined within the parentheses. Grams of
   * each macronutrient is set using each setter method, and the values are printed to stdout. Using
   * the get method for each grams variable, we instantiate and initialize a one-dimensional array
   * using setGrams().
   */
  public void calculateGrams(double fatPercent, double carbPercent, double proteinPercent) {

    setGramsFat(Math.rint((fatPercent / 100) * (getDailyEnergy()) / 9));
    setGramsCarb(Math.rint((carbPercent / 100) * (getDailyEnergy()) / 4));
    setGramsProtein(Math.rint((proteinPercent / 100) * (getDailyEnergy()) / 4));
    System.out.println("Your daily macronutrient requirements in grams:\n" + "Fat: " + getGramsFat()
        + " g\n" + "Carbs: " + getGramsCarb() + " g\n" + "Protein: " + getGramsProtein() + " g\n");

    // (37) instantiate and initialize a one-dimensional array
    setGrams(new double[]{getGramsFat(), getGramsCarb(), getGramsProtein()});
  }

  public void generateMealPlanOptions() {

    // (28) Use for loops
    for (int meals = 1; meals <= 6; meals++) {

      System.out.println("Meals per day: " + meals + "\n" + "Fat: "
          + (Math.rint(getGrams(0) / meals)) + " g\n" + "Carbs: " + (Math.rint(getGrams(1) / meals))
          + " g\n" + "Protein: " + (Math.rint(getGrams(2) / meals)) + " g\n");
    }
  }

  public void generateMealPlanOptions(int meals) {
    System.out.println("Meals per day: " + meals + "\n" + "Fat: " + (Math.rint(getGrams(0) / meals))
        + " g\n" + "Carbs: " + (Math.rint(getGrams(1) / meals)) + " g\n" + "Protein: "
        + (Math.rint(getGrams(2) / meals)) + " g\n");
  }

  /*
   * This method allows the user an option to calculate grams of each macronutrient in an arbitrary
   * number of servings. This is helpful if you plan on eating a number of servings that is not a
   * whole integer
   */
  public void calculateGramsPerServing(Scanner userScanner) {

    /*
     * getCalcServingOption() returns the boolean calcServingOption, which is initialized to true.
     * If user input is yes, then the Scanner will prompt for grams of each macronutrient per
     * serving and number of servings. Otherwise, calcServingOption is set to false and the loop is
     * broken
     */
    while (getCalcServingOption()) {
      System.out.println("If you would like to estimate the grams of \n"
          + "fat, carbs, and protein in your last meal using the \n"
          + "grams per serving on the nutritional label please \n"
          + "type yes, otherwise type anything else to continue.\n");
      String input = userScanner.nextLine().toLowerCase().trim();

      if (input.equals("yes")) {
        System.out.println("Please enter grams of fat per serving.");
        double servingFatGrams = userScanner.nextDouble();

        System.out.println("Please enter grams of carbohydrate per serving.");
        double servingCarbGrams = userScanner.nextDouble();

        System.out.println("Please enter grams protein per serving.");
        double servingProteinGrams = userScanner.nextDouble();

        System.out.println("Roughly how many servings did you have?");
        double servings = userScanner.nextDouble();

        /*
         * Two arrays are declared, instantiated and initialized locally to print out the gram
         * totals for the number of servings given by the user.
         */

        String[] macronutrients = new String[]{"Fat: ", "Carbs: ", "Protein: "};
        double[] gramTotals = new double[]{(servingFatGrams * servings),
            (servingCarbGrams * servings), (servingProteinGrams * servings)};

        System.out.println("Total macronutrients for " + servings + " servings:\n");

        // (28) Use for loops; this for loop prints the values
        for (String index1 : macronutrients) {
          System.out.print(index1);
          for (double index2 : gramTotals) {
            System.out.printf("%.0f\n", index2);
          }
        }
      } else {
        setCalcServingOption(false);
        break;
      }
      userScanner.nextLine();
    }
  }

  public boolean confirmGoal(NewUser user, Scanner userScanner, boolean goalBool) {
    calculateGrams(user.getPercentFat(), user.getPercentCarb(), user.getPercentProtein());
    System.out.println("Current goal: " + user.getGoal() + " \n"
        + "Type back to choose a different goal,\n" + "or press enter to continue.");

    boolean isInvalidInput = false;
    do {
      String input = userScanner.nextLine();

      switch (input) {
        case "":
          goalBool = true;
          isInvalidInput = false;
          break;
        case "back":
          goalBool = true;
          returnToMaintenance(this);
          changeMacrosByGoal(userScanner, goalBool);
          isInvalidInput = false;
          break;
        default:
          System.out.println("Invalid input.");
          isInvalidInput = true;
          break;

      }

    } while (isInvalidInput == true);

    return goalBool;
  }

  public void returnToMaintenance(NewUser user) {
    String chosenGoal = user.getGoal();
    switch (chosenGoal) {
      case "Lose 1 pound per week":
        user.setDailyEnergy(getDailyEnergy() + 500);
        calculateGrams(user.getPercentFat(), user.getPercentCarb(), user.getPercentProtein());
        break;
      case "Lose 2 pounds per week":
        user.setDailyEnergy(getDailyEnergy() + 500);
        calculateGrams(user.getPercentFat(), user.getPercentCarb(), user.getPercentProtein());
        break;
      case "Gain half a pound per week":
        user.setDailyEnergy(getDailyEnergy() - 250);
        calculateGrams(user.getPercentFat(), user.getPercentCarb(), user.getPercentProtein());
        break;
      case "Gain one pound per week":
        user.setDailyEnergy(getDailyEnergy() - 500);
        calculateGrams(user.getPercentFat(), user.getPercentCarb(), user.getPercentProtein());
        break;
      default:
        break;
    }
  }

  public void printInfo() {
    System.out.println("\n" + "Name: " + getUserName() + "\n" + "Age: " + getUserAge()
        + " years old" + "\n" + "Height: " + getUserHeight() + " inches" + "\n" + "Weight: "
        + getUserWeight() + "\n" + "Sex: " + getBiologicalSex() + "\n" + "Body Fat Percentage: "
        + (getUserBodyFat() * 100) + "%\n" + "Workouts per week: " + getWorkoutsPerWeek());

    System.out.printf("Estimated Daily Calories: " + "%.0f Calories\n\n", getDailyEnergy());

    // (37) Use a one-dimensional array
    System.out.println("Percent fat: " + getPercentFat() + "\n" + "Daily grams of fat: "
        + getGrams(0) + "\n" + "Percent carbs: " + getPercentCarb() + "\n"
        + "Daily grams of carbs: " + getGrams(1) + "\n" + "Percent protein: " + getPercentProtein()
        + "\n" + "Daily grams of protein: " + getGrams(2) + "\n");
  }

  public void giveRandomExampleOption(Scanner userScanner) {

    while (randomOption) {

      System.out.println("Would you like to generate a random distribution of macronutrients?\n"
          + "Type yes for a random example or \n type anything else to enter your own"
          + " percentages.\n");
      userScanner.nextLine();
      String randomInput = userScanner.nextLine();

      if (randomInput.toLowerCase().equals("yes")) {

        generateRandomExample();
        randomOption = false;

      } else {
        randomOption = false;

      }
    }
  }

  public void generateRandomExample() {

    Random macroSample = new Random();

    /*
     * (11) final fields (17) Use the Random class
     */

    final int FAT_PERCENT = macroSample.nextInt(15) + 20;
    final int CARB_PERCENT = macroSample.nextInt(20) + 45;
    final int PROTEIN_PERCENT = 100 - FAT_PERCENT - CARB_PERCENT;

    System.out.printf("Randomized example of daily macronutrient distribution: "
        + "%d%% Fat %d%% Carbs %d%% Protein\n\n", FAT_PERCENT, CARB_PERCENT, PROTEIN_PERCENT);

    final double caloriesFromFat = (FAT_PERCENT / 100.0) * (getDailyEnergy());
    final double caloriesFromCarb = (CARB_PERCENT / 100.0) * (getDailyEnergy());
    final double caloriesFromProtein = (PROTEIN_PERCENT / 100.0) * (getDailyEnergy());

    System.out.printf(
        "If we multiply each percentage by the total daily energy expenditure we get: \n"
            + "(%d/100)*(%.0f) = %.0f Calories from fat\n"
            + "(%d/100)*(%.0f) = %.0f Calories from carbs\n"
            + "(%d/100)*(%.0f) = %.0f Calories from protein.\n\n",
        FAT_PERCENT, getDailyEnergy(), caloriesFromFat,
        CARB_PERCENT, getDailyEnergy(), caloriesFromCarb,
        PROTEIN_PERCENT, getDailyEnergy(), caloriesFromProtein);

    final double gramsOfFat = caloriesFromFat / 9; // 9 Cal/gram
    final double gramsOfCarb = caloriesFromCarb / 4; // 4 Cal/gram
    final double gramsOfProtein = caloriesFromProtein / 4; // 4 Cal/gram

    System.out.printf(
        "We then divide by Calories per gram for each "
            + "macronutrient, which gives daily macronutrient needs \n"
            + "in grams: \n\n%.2f grams of fat, %.2f grams of carbs, %.2f grams of protein \n\n",
        gramsOfFat, gramsOfCarb, gramsOfProtein);

    /*
     * (20) A nested ternary operator is used to print different Strings depending on the conditions
     * of caloriesFromFat > caloriesFromCarb
     */
    String result = (caloriesFromFat != caloriesFromCarb
        ? (caloriesFromFat > caloriesFromCarb ? "is fat dominant." : "is carbohydrate dominant.")
        : "has equal Calories from fat and carbs");

    System.out.println("This random sample distribution of macronutrients " + result);
  }

  public void runUserFunctions(Scanner userScanner) {

    estimateTDEE();
    giveRandomExampleOption(userScanner);

    while (!getRandomOption()) {
      changeMacronutrientPercent(userScanner);
      incrementMacroPercent(userScanner);
      decrementMacroPercent(userScanner);
      calculateGrams(getPercentFat(), getPercentCarb(), getPercentProtein());
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
       * grams per meal for every number 1-6. If the user types a single number between 1 and 6 then
       * the switch statement will call generateMealPlanOptions(int meals) which prints an estimate
       * of grams per meal for that #. Any other input exits the loop.
       */
      System.out.println("Type yes to estimate grams per meal for 1, 2, 3, 4, 5, and 6 meals. \n"
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

    if (!getMealPlanOption()) {
      calculateGramsPerServing(userScanner);

    }

    System.out.println("A daily caloric deficit of roughly 500 Calories must\n"
        + "be expended to lose one pound in one week. Conversely, a daily\n"
        + "caloric surplus of roughly 500 Calories must be consumed to gain\n"
        + "one pound in one week. Rapid weight changes are not recommended.\n");

    /*
     * Once getCalServingOption returns false,
     */
    while (!getCalcServingOption()) {
      boolean goalSet = false;
      do {
        goalSet = changeMacrosByGoal(userScanner, goalSet);

      } while (goalSet == false);
      break;
    }

    printInfo();
    findSmallest(getGrams());

  }

  /*
   * (38) Manually find the smallest value in an array
   */
  public void findSmallest(double[] gramsParam) {
    double smallestInGrams = gramsParam[0];

    for (int count = 1; count < gramsParam.length; count++) {
      if (gramsParam[count] < smallestInGrams) {
        smallestInGrams = gramsParam[count];
      }

    }
    if (smallestInGrams == gramsParam[0]) {
      System.out
          .println("Your smallest number of daily grams is from fat: " + gramsParam[0] + " g\n"
              + (gramsParam[0] < 40.0
              ? "Please consult a physician and/or a nutritionist to get \n"
              + "an individual recommendation of daily fat requirements. This a very low \n"
              + "amount of daily fat."
              : ""));

    } else if (smallestInGrams == gramsParam[1]) {
      System.out
          .println("Your smallest number of daily grams is from carbs: " + gramsParam[1] + " g\n");
    } else {
      System.out.println(
          "Your smallest number of daily grams is from protein: " + gramsParam[2] + " g\n");
    }
  }

}
