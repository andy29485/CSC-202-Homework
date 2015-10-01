//Andriy Zasypkin
//2015-09-24
//Homework 04

/** Problem description:
  *  - Read string that consists of 200 chars
  *  - Perform following opperation
  *    01) count uppercase chars
  *    02) count letter and special chars
  *    03) find position(s) of "$"
  *    04) replace "$" with "#"
  *    05) delete all other special chars
  *    06) capitalize every word
  *    07) Make first line uppercase
  *    08) add name to last line(in uppercase)
  *    09) ask user to add line of text
  *    10) compare 'it'(line from #9) with first line
  *
  * Problem Assumptions
  *  - If input size is > 200 char, there is /NO/ need to shorten it
  *  - Intput/Output will be as follows:
  *      * IN:  200(+) char text
  *      * OUT: original text
  *      * IN:  New line
  *      * OUT: Stats as requested in problem description
  *      * OUT: New text with all changes.
  *  - for #2, counts are seperate
  *  - for #2, special chars are ~`!@#$%^&*(){}[]+-_=\"/?<>':;
  *                     defined in Stats class as const(final) String
  *  - for #5, special chars *see assumptions for #2*
  *  - for #6, words are defined as letters, "_", or "-" surrounded by white
  *                     space, beggining/end of text, or some symbols
  *                     simply put: matches "\b([A-Za-z_-]+)\b"
  *  - for #6, capitalize is defined as first char is uppercase, others lower
  *  - for #7, takes precidence over #6(will happen after, however)
  *  - for #7, first line is defined as: all chars until and including first \n
  *  - for #8, First then last, w/ space before name part as seperator
  *  - for #9, this part comes after the name(#8)
  *  - for #10, using compareTo method
  *  - for #10, line 1 is uppercase during comparison
  *  - for #10, will print "$1 line is greater than $2 line"
  *                     $1 being either "first" or "last" depending on result
  */

import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    //create an input reader object
    BufferedReader input
            = new BufferedReader(new InputStreamReader(System.in));
    
    //Create string buffer
    StringBuffer strbIn = new StringBuffer();
    
    //Create string for line input
    String strLineIn;
    
    //INPUT:
    //ask for a statment
    System.out.print("Enter string(200 char min): ");
    do {
      while((strLineIn = input.readLine()) != null) {
        strbIn.append(strLineIn);
      }
    } while(strbIn.length() < 200);   //Read input until 200 char minimum
                                      // is achived
    
    //Create stats obj - to compute stats
    Stats document = new Stats(strbIn);
    
    //OUTPUT:
    //  Original string in python style multi-line string quotes
    System.out.printf("\n\nOriginal string:\n\"\"\"%s\n\"\"\"\n\n", document);
    
    //Task #01
    System.out.printf("Number of uppercase chars in String: %d\n",
                       document.numUpper());
    //Task #02
    System.out.printf("Number of letters in String: %d\n",
                       document.numLetter());
    System.out.printf("Number of special chars in String: %d\n",
                       document.numSpecial());
    //Task #03,04
    System.out.print("Positions(indices) of \"$\" in document:\n");
    int i=-1;
    do {
      System.out.printf(" %d", i=document.indexOf('$', i)); //print indices(3)
      document.replace(i, "#"); //replace found '$' with '#'(4)
    } while(i>-1);
    System.out.println();
    
    //Task #05
    //I though about using j in for loop since i is taken, but
    //  i isn't being used... 
    for(i=0; i<document.length(); i++) {
      if(Stats.spChars.indexOf(document.charAt(i)) < -1)//find special chars
        document.delete(i); //delete special chars - if they are special chars
    }
    
    //Task #6
    //All word that are currently in the document, are now capitalized
    document.capitalize();
    
    //OUTPUT:
    //  Altered string in python style multi-line string quotes
    System.out.printf("\n\nAltered string:\n\"\"\"%s\n\"\"\"\n", document);
    
    //close stream
    input.close();
    
    //C/C++ habit
    System.exit(0);
  }
}
