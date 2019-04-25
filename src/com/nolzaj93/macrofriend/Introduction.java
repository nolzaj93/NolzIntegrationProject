package com.nolzaj93.macrofriend;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * (2) MacroFriend is a program that is able to recommend an estimate of daily calories and
 * macronutrients depending on your activity level and fitness goal. The Introduction class is
 * the driver class for the program.
 *
 * @author Austin Nolz - (1)
 */
public class Introduction {

  /*
   * (16) Below is a header for the main method, void means method doesn't return a value. Public is
   * an access modifier allowing other classes to call this method. Method names should be in lower
   * camelCase and use a verb as first word. The parameter of this method is String[] args.
   */

  /**
   * This is the main method for the MacroFriend program, which uses the Scanner object, userInfo,
   * to retrieve data from the user through the console. This method will be restructured as the GUI
   * is built, and an SQL database is incorporated for the backend.
   *
   * @param args - An array of strings sent to the command-line as arguments.
   */
  public static void main(String[] args) {
    /*
     * (3) Primitive Data Types byte- 8 bit number short 16 bit int 32 bit long 64 bit float- 32 bit
     * floating point double - 64 bit floating point char -single 16 bit Unicode character boolean-
     * true or false, one bit of information
     * (4) The Scanner object userInfo allows us to take user
     * input
     * (26) Operator Precedence: top of table has highest precedence, and binary operators are
     * evaluated left to right, assignment operators evaluated right-to-left Rule governs which is
     * evaluated first when of equal precedence postfix expr++ expr-- unary ++expr --expr +expr
     * -expr ~ ! multiplicative * / % additive + - shift << >> >>> relational < > <= >= instanceof
     * equality == != bitwise AND & bitwise exclusive OR ^ bitwise inclusive OR | logical AND &&
     * logical OR || ternary ? : assignment = += -= *= /= %= &= ^= |= <<= >>= >>>= source:
     * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html
     */
    Scanner userInfo = new Scanner(System.in, StandardCharsets.UTF_8.name());
    /*
     * Creates an object named sampleCalendar from the UserCalendar class, and calls the
     * searchMonthAndDay(Scanner userScanner) method.
     */
    UserCalendar sampleCalendar = new UserCalendar();

    /*
     * (5) Use a boolean variable with an appropriate name
     */
    boolean monthAndDaySearchOption = true;
    while (monthAndDaySearchOption) {
      System.out.println("Please type yes to run the two-dimensional array search, or press\n"
          + "enter to skip this method.");
      String twoDArraySearchInput = userInfo.nextLine().toLowerCase().trim();
      switch (twoDArraySearchInput) {
        case "yes":
          sampleCalendar.searchMonthAndDay(userInfo);
          userInfo.nextLine();
          break;
        case "":
          monthAndDaySearchOption = false;
          break;
        default:
          System.out.println("Your input was invalid.\n");
          break;
      }
    }
    /* (40) Search an array and identify the index where a value was found
     * NewUser contains the static method named searchArray(Scanner userScanner), which is called
     * using the class name because static methods belong to the class and not a specific
     * instance.
     */
    boolean arraySearchOption = true;
    while (arraySearchOption) {
      System.out.println("Please type yes to run the array search, or press\n"
          + "enter to skip this method.");
      String arraySearchInput = userInfo.nextLine().toLowerCase().trim();
      switch (arraySearchInput) {
        case "yes":
          NewUser.searchArray(userInfo);
          break;
        case "":
          arraySearchOption = false;
          break;
        default:
          System.out.println("Your input was invalid.\n");
          break;
      }
    }

    /*
     * (35) Develop code that makes use of polymorphism.
     * Polymorphism means an object can have many different forms. In this case
     * user1 is a NewUser object, and a subclass of Object.
     * NewUser is the superclass of FemaleUser, MaleUser and IntersexUser. So each of these
     * subclasses "is a" NewUser object as well as having their own defined type.
     * Below we cast each subclass object into the NewUser data type due to polymorphism.
     * This feature also allows for Base methods to be overridden in derived classes,
     * and overridden method code will be executed even from a call from an object that
     * has the base type, NewUser.
     */
    NewUser user1 = new NewUser(userInfo);

    /*
     * (15)Identify a method call and argument in comments, the right side of the assignment
     * operator is a method call, userInfo and user1 are arguments.
     */
    user1 = createUserBySex(userInfo, user1);

    /*
     *(6) Use an int variable with an appropriate name (singular noun, lowerCamelCase)
     */

    int currentMonth = sampleCalendar.getCurrentMonth();
    int currentDay = sampleCalendar.getCurrentDay();
    DailyTracker currentDayTracker = sampleCalendar.getMonthAndDayTracker(currentMonth, currentDay);
    Double[][] testMeal = currentDayTracker.addNewMeal(10, 10, 10);
    System.out.println("Calories from Fat, Carbs, and Protein");
    for (int index = 0; index < 3; index++) {
      System.out.print(testMeal[1][index] + " Calories ");
    }

    //(39) Get a sum of the values in an array using an accumulator
    System.out.println("\nTotal Meal Calories: "
        + DailyTracker.getTotalMealCalories(testMeal, 1, 3) + "\n");
    System.out.println("Please type new to add another user.");

    /*
     * NewUser object with reference name user2 is created if the Scanner reads "new" as the next
     * String.
     */
    if ("new".equals(userInfo.next().toLowerCase())) {

      NewUser user2 = new NewUser(userInfo);
      user2 = createUserBySex(userInfo, user2);
    }
    user1.printInfo();
    userInfo.close();
  }

  /**
   * This method creates an object of one of the three subclasses of NewUser depending upon what is
   * returned from the method user.getBiologicalSex()
   *
   * @param userScanner - Scanner object is passed into the constructor of the respective subclass.
   * @param user - NewUser object built from the superclass is passed into the method and holds the
   *     userName, and the biologicalSex determines which subclass object is created.
   * @return - NewUser object is returned by casting the respective subclass object into the NewUser
   *     type.
   */
  public static NewUser createUserBySex(Scanner userScanner, NewUser user) {
    NewUser newUser;
    if ("female".equals(user.getBiologicalSex())) {
      FemaleUser newFemaleUser = new FemaleUser(userScanner, user.getUserName(),
          user.getBiologicalSex());
      /*
       * (35) Develop code that makes use of polymorphism
       */
      newUser = (NewUser) newFemaleUser;

    } else if ("male".equals(user.getBiologicalSex())) {
      MaleUser newMaleUser = new MaleUser(userScanner, user.getUserName(), user.getBiologicalSex());
      newUser = (NewUser) newMaleUser;

    } else {
      IntersexUser newIntersexUser = new IntersexUser(userScanner, user.getUserName(),
          user.getBiologicalSex());
      newUser = (NewUser) newIntersexUser;

    }
    return newUser;
  }
}
