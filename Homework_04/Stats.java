//Andriy Zasypkin
//2015-09-24
//Homework 04

public class Stats {
  private StringBuffer strbObj;
  public static final String spChars = "~`!@#$%^&*(){}[]+-_=\\\"/?<>\':;";
  
  //Default constructor
  public Stats() {
    this.strbObj = new StringBuffer();
  }
  
  //1-arg constructor - copies str buff obj
  public Stats(StringBuffer strbObj) {
    this.strbObj = strbObj;
  }
  
  //Output: Number of letter chars in input
  public static int numLetter() {
    int nLetters = 0;
    for(int i=0; i<strbObj; i++) {                   //loop over chars
      if(Character.isLetter(strbObj.charAt(i))) {    // if char is a letter
        nLetters++;                                  // add one to count
      }
    }
    return nLetters;
  }
  
  //Output: Number of special symbols in input
  public static int numSpecial() {
    int nSpecialSymbols = 0;
    for(int i=0; i<strbObj; i++) {                   //loop over chars
      if(spChars.indexOf(strbObj.charAt(i)) > -1) {  // if char is special
        nSpecialSymbols++;                           // add one to count
      }
    }
    return nSpecialSymbols;
  }
  
  //Output: Number of uppercase chars in input
  public static int numUpper() {
    int nUpper = 0;
    for(int i=0; i<strbObj; i++) {                   //loop over chars
      if(Character.isUpperCase(strbObj.charAt(i))) { // if char is uppercase
        nUpper++;                                    // add one to count
      }
    }
    return nUpper;
  }
  
  public void capitalizeFirstSentace() {
    int start = 0;
    for(int i=0; i<this.length(); i++) {
      else if(!Character.isLetter(this.charAt(i))) {
        String strWord = this.substring(start, i);
        strWord = strWord.toLowerCase();
        strWord = strWord.replaceFirst("^.", String.valueOf(
                                               Character.toUpperCase(
                                               strWord.charAt(0))));
        this.replace(start, i, strWord);
      }
      else {
        start = i+1;
      }
    }
  }
  
  //Wrapers - this a sizable section.
  //  Should I have made stats extend StringBuffer?
  
  //Wraper of length
  public int length() {
    teturn strbObj.length();
  }
  
  //Wraper for indexOf
  public int indexOf(char ch, int i) {
    return strbObj.indexOf(ch, i);
  }
  
  //Wraper for for replace only one char, no more is needed
  public void replace(int i, String str) {
    strbObj.indexOf(i, i+1, str);
  }
  
  //wraper for deleteCharAt
  public void delete(int i) {//sice it is a wraper I can call it delete
    strbObj.deleteCharAt(i); //  instead of deleteCharAt - as delete is
  }                          //  shorter
  
  //For output uses(wraper)
  public String toString() {
    return strbObj.toString();
  }
}
