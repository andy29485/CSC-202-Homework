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
    Pattern p = Pattern.compile("\\b([A-Za-z_-])([A-Za-z_-]*)\\b");
    Matcher m = p.matcher(strbObj.toString());
    while (m.find()) {
      
      //Change original text to contain capitalized word
      strbObj.replace(m.start(), m.end(),
                      m.group(1).toUpperCase.concat(m.group(2)));
    }
    
    return strbObj;
  }
  
  //Wrappers - this a sizable section.
  //  Should I have made stats extend StringBuffer?
  //  Oh wait, I can't it's a final class, thanks oracle
  
  //Wrapper of length
  public int length() {
    return strbObj.length();
  }
  
  //Wrapper for indexOf
  public int indexOf(char ch, int i) {
    return strbObj.indexOf(String.valueOf(ch), i);
  }
  
  //Wrapper for append
  public StringBuffer append(String str) {
    return strbObj.append(str);
  }
  
  //Wrapper for subsring
  public String substring(int start, int end) {
    return strbObj.substring(start, end);
  }
  
  //Wrapper for for replace
  public StringBuffer replace(int start, int end, String str) {
    return strbObj.replace(start, end, str);
  }
  
  //Wrapper for deleteCharAt
  public StringBuffer delete(int i) {//sice it is a wrapper I can call it delete
    return strbObj.deleteCharAt(i); //  instead of deleteCharAt - as delete is
  }                          //  shorter
  
  //Wrapper for charAt
  public char charAt(int i) {
    return strbObj.charAt(i);
  }
  
  //For output uses(yep - a wrapper)
  public String toString() {
    return strbObj.toString();
  }
}
