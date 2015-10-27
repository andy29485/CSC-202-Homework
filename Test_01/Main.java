import java.io.*;

public class Main {
  /** Description:
    *   Write a program that read a file and:
    *     - counts # of characters
    *     - finds the shortest and longest lines
    *       * compares them
    *     - counts number of words
    *     - prints number of blocks(512 B) that the file uses
    *     - Change fisrt char in line to uppercase
    *     - s/ +/ /g
    *     - sample output:
    *     - "  Filename  | smallest | largest | diff | chars | words | blocks"
    *     - " sample.txt |       30 |      90 |   60 |  5000 |    40 |     20"
    *
    * Assumptions:
    *   - input file will be specified by user
    *   - invalid file will cause program to shut down
    *   - after changing letters toUpperCase, user must speccify output file
    */
  
  public static void main(String[] args) throws Exception {
    BufferedReader input
            = new BufferedReader(new InputStreamReader(System.in));
    
    System.out.print("Enter a filename of an existing char-based file: ");
    String strFileIn = input.readLine();
    
    FileStats stats = new FileStats(strFileIn);
    
    System.out.printf("%15s |%9s |%9s |%7s |%15s |%9s |%9s\n",
                      "filename",
                      "smallest",
                      "largest",
                      "diff",
                      "chars",
                      "words",
                      "blocks");
    
    System.out.printf("%15s |%9d |%9d |%7d |%15d |%9d |%9d\n",
                      stats.getFileName(),
                      stats.getShortestSize(),
                      stats.getLongestSize(),
                      stats.getDiff(),
                      stats.getChars(),
                      stats.getWords(),
                      stats.getBlocks());
    
    input.close();
  }
}
