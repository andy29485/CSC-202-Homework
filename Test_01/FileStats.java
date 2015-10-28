import java.io.*;

class FileStats {
  public  final int      BLOCK_SIZE = 512;
  
  private FileReader     fr;
  private BufferedReader br;
  private String         strShortest;
  private String         strLongest;
  private String         strFileName;
  private int            nChars;
  private int            nWords;
  
  public FileStats(String strFileName) throws Exception {
    this.strFileName = strFileName;
    
    //Check that file can be openned
    File info = new File(this.strFileName);
    if(!info.exists()) {
      System.out.printf("\"%s\" does not exist - Aborting\n", strFileName);
      System.exit(0);
    }
    if(info.isDirectory()) {
      System.out.printf("\"%s\" is a directory - Aborting\n", strFileName);
      System.exit(0);
    }
    if(!info.canRead()) {
      System.out.printf("\"%s\" cannot be read - Aborting\n", strFileName);
      System.exit(0);
    }
    
    //Open file
    this.fr = new FileReader(strFileName);
    this.br = new BufferedReader(fr);
    
    //set some default values
    this.strShortest = "";
    this.strLongest  = "";
    this.nChars      = 0;
    this.nWords      = 0;
    
    //Create a container for the line
    String strLine;
    
    //Compute some stats
    while((strLine = br.readLine()) != null) {
      //Add a new line char to the end of the string, since it gets stripped
      //  when being returned by the readLine() method,
      //But it should still count since it is getting stored in the file
      strLine += "\n";
      
      if(this.strShortest.length() > strLine.length()
      || this.strShortest.length() == 0) {
        this.strShortest = strLine;
      }
      if(strLongest.length() < strLine.length()) {
        this.strLongest = strLine;
      }
      
      this.nChars += strLine.length();
      this.nWords += strLine.split("\\s+").length;
    }
  }
  
  public String getFileName() {
    return this.strFileName;
  }
  
  public int getShortestSize() {
    return this.strShortest.length();
  }
  
  public int getLongestSize() {
    return this.strLongest.length();
  }
  
  public int getDiff() {
    return this.strLongest.length() - this.strShortest.length();
  }
  
  public int getChars() {
    return this.nChars;
  }
  
  public int getWords() {
    return this.nWords;
  }
  
  public int getBlocks() {
    //Asumes that characters are stored as 8-bit ASCII values,
    //  so 1 char = 1 byte
    return (this.nChars+BLOCK_SIZE-1)/BLOCK_SIZE;
    //(this.nChars)/BLOCK_SIZE+((this.nChars)%BLOCK_SIZE==0 ? 0 : 1)//Alt
  }
}
