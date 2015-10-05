//Andriy Zasypkin
//2015-10-02
//Homework 05

/** Problem description:
  *   Read an input string value number and convert it to a number.
  *           proper type(double or int)
  *   Use valueOf doubleValue intValue and any other applicable methods
  *
  * Problem Assumptions:
  *   - Nothing actualy needs to be done to the numbers,
  *           appart from converting the string to a number
  *   - what are doubles(examples):
  *           Valid:
  *             0.0
  *             4.9
  *             6.1
  *             .5
  *             500.
  *             98.9
  *             -96.9
  *
  *            Invalid:
  *              9   (no decimal point)
  *              +7. (plus in front - not acceptable by my standards)
  *              .   (not sure how this can be concidered a bse 10 number
  *                   in the forst place)
  */

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //create an input reader object
    BufferedReader input
            = new BufferedReader(new InputStreamReader(System.in));
    String strValue; //The string that will hold the input
    
    //INPUT:
    //  ask for a number
    //  read a string
    System.out.print("Enter a number: ");
    do {    
      strValue = input.readLine();
    } while(strValue == null);//readLine kept returning null
    
                                                      //If input matches
    if(strValue.matches("-?(\\d*\\.\\d+|\\d+\\.)")) { //  double/float pattern
      double dValue = Double.valueOf(strValue).doubleValue();//create double
      System.out.printf("You entered %f - a double\n", dValue);//print output
    }
    else if(strValue.matches("-?\\d+")) { //If input is not a double,
                                        //  but is a number - it's an int
      int nValue = Integer.valueOf(strValue).intValue();//create int
      System.out.printf("You entered %d - an interger\n", nValue);//print output
    } 
    else { //The user did not follow directions - exit with an error
      System.out.println("you did not enter a number");
      System.exit(1);
    }
    
    input.close();
    
    System.exit(0);
  }
}
