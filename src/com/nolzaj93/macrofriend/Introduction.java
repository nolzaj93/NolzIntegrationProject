package com.nolzaj93.macrofriend;
/*
 * (1) Austin Nolz (2) This program will be able to recommend an estimate of daily calories and
 * macronutrients depending on your activity level and fitness goals.
 */

import java.util.*;

public class Introduction {

  /*
   * (16) Below is a header for the main method, void means method doesn't return a value. Public is
   * an access modifier allowing other classes to call this method. Method names should be in lower
   * camelCase and use a verb as first word. The parameter of this method is String[] args.
   *
   */
  public static void main(String[] args) {
    /*
     * (3) Primitive Data Types byte- 8 bit number short 16 bit int 32 bit long 64 bit float- 32 bit
     * floating point double - 64 bit floating point char -single 16 bit Unicode character boolean-
     * true or false, one bit of information (4) The Scanner object userInfo allows us to take user
     * input (26) Operator Precedence: top of table has highest precedence, and binary operators are
     * evaluated left to right, assignment operators evaluated right-to-left Rule governs which is
     * evaluated first when of equal precedence postfix expr++ expr-- unary ++expr --expr +expr
     * -expr ~ ! multiplicative * / % additive + - shift << >> >>> relational < > <= >= instanceof
     * equality == != bitwise AND & bitwise exclusive OR ^ bitwise inclusive OR | logical AND &&
     * logical OR || ternary ? : assignment = += -= *= /= %= &= ^= |= <<= >>= >>>= source:
     * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html
     */
    Scanner userInfo = new Scanner(System.in);
    /*
     * Creates an object named sampleCalendar from the UserCalendar class, and calls the
     * searchMonthAndDay(Scanner userScanner) method.
     */
    UserCalendar sampleCalendar = new UserCalendar();

    boolean monthAndDaySearchOption = true;
    while(monthAndDaySearchOption) {
      System.out.println("Please type yes to run the two-dimensional array search, or press\n"
          + "enter to skip this method.");
      String twoDArraySearchInput = userInfo.nextLine().toLowerCase().trim();
      switch (twoDArraySearchInput) {
        case "yes":
          sampleCalendar.searchMonthAndDay(userInfo);
          break;
        case "":
          monthAndDaySearchOption = false;
          break;
        default:
          System.out.println("Your input was invalid.\n");
          break;
      }
    }
    /*
     * NewUser contains the static method named searchArray(Scanner userScanner), which is called
     * using the class name because static methods belong to the class and not a specific
     * instance.
     */
    boolean arraySearchOption = true;
    while(arraySearchOption) {
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
     * user1 is a NewUser, an Object, and also an Introduction object because
     * of inheritence. We can cast the user1 object into a different
     * variable with type Introduction, which is the base/super/parent class.
     * This feature also allows for Base methods to be overridden in derived classes,
     * and overridden method code will be executed even from a call from an object that
     * has the base type.
     */
    NewUser user1 = new NewUser(userInfo);
    Introduction user = (Introduction) user1;
    user.runUserFunctions(userInfo);

    System.out.println("Please type new to add another user.");

    /*
     * NewUser object with reference name user2 is created if the Scanner reads "new" as the next
     * String.
     */
    if (userInfo.next().toLowerCase().equals("new")) {

      NewUser user2 = new NewUser(userInfo);
      user2.runUserFunctions(userInfo);
    }
    user1.printInfo();
    userInfo.close();
  }

  // Explicitly defined no-argument constructor prints welcome message every time
  public Introduction() {

  }

  /*
   * (35) Develop code that makes use of polymorphism
   */
  public void runUserFunctions(Scanner userScanner) {
    System.out.println("This method and statement will not be reached from a NewUser object even "
        + "when it is cast to the Introduction type due to polymorphism and rules of the "
        + "Java Runtime Environment.");
  }
}
