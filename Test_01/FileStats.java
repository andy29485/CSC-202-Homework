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
    
    FileInputStream fs = new FileInputStream(strFileIn);
  }
}
