class FileStats 
  FileInputStream 
  public FileStats(String strFileName) {
    File info = new File(strFileIn);
    if(!info.exists()) {
      System.out.printf("\"%s\" does not exist - Aborting\n", strFileIn);
      System.exit(0);
    }
    if(!info.isDirectory()) {
      System.out.printf("\"%s\" is a directory - Aborting\n", strFileIn);
      System.exit(0);
    }
    if(!info.canRead()) {
      System.out.printf("\"%s\" cannot be read - Aborting\n", strFileIn);
      System.exit(0);
    }
    
    FileInputStream fs = new FileInputStream(strFileIn);
  }
}
