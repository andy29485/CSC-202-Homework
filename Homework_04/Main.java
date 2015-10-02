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
  *  - for #6, words are defined as letters surrounded by white space or
  *                     beggining/end of text
  *  - for #6, capitalize is defined as first char is uppercase, others lower
  *  - for #7, takes precidence over #6(will happen after, however)
  *  - for #7, first line is defined as: all chars until and including first \n
  *                     or to the end if no '\n's are found
  *  - for #8, First then last, w/ space before name part as seperator
  *  - for #9, this part comes after the name(#8)
  *  - for #10, using compareTo method
  *  - for #10, line 1 is uppercase during comparison
  *  - for #10, will print "$1 line is greater than $2 line"
  *                     $1 being either "first" or "last" depending on result
  */

public class Main {
  //In: a String - asumes it only contains a word.
  //out: same string but capitalized, see line 33
  public static String capitalize(String strIn) {
    return strIn.toLowerCase().replaceFirst("^.", String.valueOf(Character.toUpperCase(strIn.charAt(0))));
  }

  public static void main(String[] args) {
    //create an input reader object
    BufferedReader input
            = new BufferedReader(new InputStreamReader(System.in));
    
    //Create string buffer
    StringBuffer strbIn = new StringBuffer();
    
    //INPUT:
    //ask for a statment
    System.out.print("Enter string(200 char min):");
    do {
      strbIn.append(input.readLine());
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
        document.delete(i) //delete special chars - if they are special chars
    }
    
    //Task #07
    int line_end = document.indexOf('\n', 0);//did not create wrapper for indexOf(int)
    if(line_end == -1)
      line_end = document.length();
    document.replace(0, line_end,
                     document.substring(0, line_end).toUpperCase());
    
    //Task #08
    document.append("Andriy Zasypkin");
    
    //Task #09
    System.out.print("Enter another line:");
    String strExtraLine = input.readLine();
    document.append(strExtraLine);
    
    //Task #10
    int nCompare = document.substring(0, line_end).compareTo(strExtraLine);
    if(nCompare == 0)
      System.out.println("First and last lines are identical");
    else if(nCompare < 0)
      System.out.println("Last line is greater than first line");
    else
      System.out.println("Last line is greater than last line");
    
    //OUTPUT:
    //  Altered string in python style multi-line string quotes
    System.out.printf("\n\Altered string:\n\"\"\"%s\n\"\"\"\n", document);
    
    //close stream
    input.close();
    
    //C/C++ habit
    System.exit(0);
  }
}
