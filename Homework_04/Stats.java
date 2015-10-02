//Andriy Zasypkin
//2015-09-24
//Homework 04

import java.util.regex.*;

public class Stats {
  private StringBuffer strbObj;
  public static final String spChars = "~`!@#$%^&*(){}[]+-_=\\\"/?<>\':;";
  
  //Default constructor
  public Stats() {
    this.strbObj = new StringBuffer();
  }
  
  //Output: Number of letter chars in input
  public int numLetter() {
    int nLetters = 0;
    for(int i=0; i<strbObj.length(); i++) {          //loop over chars
      if(Character.isLetter(strbObj.charAt(i))) {    // if char is a letter
        nLetters++;                                  // add one to count
      }
    }
    return nLetters;
  }
  
  //Output: Number of special symbols in input
  public int numSpecial() {
    int nSpecialSymbols = 0;
    for(int i=0; i<strbObj.length(); i++) {          //loop over chars
      if(spChars.indexOf(strbObj.charAt(i)) > -1) {  // if char is special
        nSpecialSymbols++;                           // add one to count
      }
    }
    return nSpecialSymbols;
  }
  
  //Output: Number of uppercase chars in input
  public int numUpper() {
    int nUpper = 0;
    for(int i=0; i<strbObj.length(); i++) {          //loop over chars
      if(Character.isUpperCase(strbObj.charAt(i))) { // if char is uppercase
        nUpper++;                                    // add one to count
      }
    }
    return nUpper;
  }
  
  public StringBuffer capitalize() {
    //Patern to match words
    Pattern p = Pattern.compile("\\b[A-Za-z_-]+\\b");
    Matcher m = p.matcher(strbObj.toString());
    int start_index = 0;
    int end_index   = 0;
    while (m.find()) {
      String strWord  = m.group();
      start_index     = m.start();
      end_index       = start_index + strWord.length();
      
      //Capitalize word -- make word lower, then make first letter upper
      strWord = strWord.toLowerCase();
      strWord = strWord.replaceFirst("^.", String.valueOf(
                                             Character.toUpperCase(
                                             strWord.charAt(0))));
      
      //Change original text to contain capitalized word
      strbObj.replace(start_index, end_index, strWord);
    }
    //Technialy not needed, but in the case that it is chained with something
    //  else, the StringBuffer will be returned
    return strbObj;
  }
  
  //Wrapers - this a sizable section.
  //  Should I have made stats extend StringBuffer?
  //  Oh wait, I can't it's a final class, thanks oracle
  
  //Wraper of length
  public int length() {
    return strbObj.length();
  }
  
  //Wraper for indexOf
  public int indexOf(char ch, int i) {
    return strbObj.indexOf(String.valueOf(ch), i);
  }
  
  //Wraper for append
  public void append(String str) {
    strbObj.append(str);
  }
  
  //Wraper for subsring
  public String substring(int start, int end) {
    return strbObj.substring(start, end);
  }
  
  //Wraper for for replace
  public void replace(int start, int end, String str) {
    strbObj.replace(start, end, str);
  }
  
  //Wraper for deleteCharAt
  public void delete(int i) {//sice it is a wraper I can call it delete
    strbObj.deleteCharAt(i); //  instead of deleteCharAt - as delete is
  }                          //  shorter
  
  //Wraper for charAt
  public char charAt(int i) {
    return strbObj.charAt(i);
  }
  
  //For output uses(yep - a wraper)
  public String toString() {
    return strbObj.toString();
  }
}
