//Andriy Zasypkin
//2015-11-18
//Homework 09

import java.io.*;

/** Description:
  *   Write a program in java to simulate the behaviour of an elevator
  *     - starts at first(1) floor
  *     - goes to first floor if no message
  *     - only authorized users can go to top floor(26)
  *     - 25 story building
  *     - no floor 13
  *     - door has a delay of 1 min
  *       * button may be pressed to extend time
  *
  * Assumptions:
  *   - print out every time elevator does something
  *     * move up/down a floor
  *     * open/close door
  *     * button to keep door waiting, will output waiting
  *   - times are actual times
  *   - input done via command line args
  *   - will not move to first floor unless not active
  *     * timeout will also be a minute
  *     * will print that timeout was reached when it is reached, before going
  *         down
  *   - input will be a number(1-26) to move to that floor
  *     * or 'o' to keep doors open
  *   - queueing will not be implemented
  *     * elevator will not move up/down, unless current move is finished
  *     * guests are encouraged to keep poundng on the button
  *         until the elevator opens its doors on their floor
  *   - password will be needed to go to the top floor
  *     * this will not have a timeout
  *     * in honour of king roland of Druidia, the combination will be 12345
  *     * wrong combination means that they will need to request the
  *         top floor again
  */

public class Main {
  public static void main(String[] args) throws java.io.IOException {
    
    Elevator elevator = new Elevator();
    
    elevator.start();
    
    System.exit(0);
  }
}
