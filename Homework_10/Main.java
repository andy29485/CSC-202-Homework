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

    System.out.print("Enter a 5 digit number for the ArrayStack: ");
    num = input.readLine();
    for(int i=0; i<5; i++) {
      int tmp_digit = Integer.valueOf(num.charAt(i)).intValue();
      as.push(tmp_digit);
    }
    System.out.println("Popping digits from ArrayStack:");
    while(!as.empty()) {
      System.out.print(as.pop());
    }

    System.out.print("\n\nEnter a 5 digit number for the LinkStack: ");
    num = input.readLine();
    for(int i=0; i<5; i++) {
      int tmp_digit = Integer.valueOf(num.charAt(i)).intValue();
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
