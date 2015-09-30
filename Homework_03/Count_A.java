//Andriy Zasypkin
//2015-09-24
//Homework 03

import java.io.*;

public class Count_A {
  public static void main(String[] args) throws IOException {
    //create an input reader object
    BufferedReader input
        = new BufferedReader(new InputStreamReader(System.in));
    
    //INPUT:
    //  Ask user for input and recive a string
    System.out.print("Enter string: ");
    String strIn = input.readLine();
    
    //num_a holds number of character 'a'(or 'A') appearances in a string
    int num_a = 0;                                        //create a count var
    
    for(int i=0; i<strIn.length(); i++) {                 //For each char in
                                                          //  the string
      if(Character.toLowerCase(strIn.charAt(i)) == 'a') { //Convert to lower
        num_a++;                                          //  case and check if
      }                                                   //  it's the char
    }                                                     //  'a' - if yes then
                                                          //  add one to the 
                                                          //  count variable
    
    //OUTPUT:
    //Print the message idicating the number of 'a's found in the string
    System.out.printf("There are %d 'a'(or 'A') in the string\n", num_a);
    System.exit(0);
  }
}
