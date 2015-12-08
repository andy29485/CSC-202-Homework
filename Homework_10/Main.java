//Andriy Zasypkin
//2015-12-07
//Homework 10

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //create an input reader object
    BufferedReader input
            = new BufferedReader(new InputStreamReader(System.in));

    ArrayStack as = new ArrayStack();
    LinkStack  ls = new LinkStack();
    String     num;

    //ask and input a string of 5 characters
    System.out.print("Enter a 5 digit number for the ArrayStack: ");
    num = input.readLine();
    for(int i=0; i<5; i++) {
      //Since these are characters, which are stored as 16 bit integers,
      //  and digit characters are stored in order(in unicode), we can
      //  subtract the value of the digit zero('0' - 48 in unicode) we can
      //  extract the integer value that the chrarcter represents
      //
      //Note: when passing a chracter to Integer.valueOf(),
      //  the unicode value of the character is returned,
      //  e.g. Integer.valueOf('0') would give 48
      int tmp_digit = num.charAt(i) - '0';
      as.push(tmp_digit);//add int represented by each character in string
    }

    //print a message
    System.out.println("Popping digits from ArrayStack:");
    while(!as.empty()) {//while there are item in the list
      System.out.print(as.pop());//remove top item from the list
    }

    //same as Array stack
    System.out.print("\n\nEnter a 5 digit number for the LinkStack: ");
    num = input.readLine();
    for(int i=0; i<5; i++) {
      int tmp_digit = num.charAt(i) - '0';
      ls.push(tmp_digit);
    }
    System.out.println("Popping digits from ArrayStack:");
    while(!ls.empty()) {
      System.out.print(ls.pop());
    }

    System.out.println();//always end program with a new line at the end

    //close stream
    input.close();
    System.exit(0);
  }
}
