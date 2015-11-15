//Andriy Zasypkin
//2015-11-14
//Homework 08

import java.io.*;

/** Description:
  *   - 
  *
  * Assumptions:
  *   - 
  */

public class  {
  public static void main(String[] args) {
    //create an input reader object
    BufferedReader input
            = new BufferedReader(new InputStreamReader(System.in));
    
    //read 3 matrixes
    System.out.print("Rows in matrix A: ");
    int rows = Integer.valueOf(input.readLine()).intValue();
    System.out.print("Columns in matrix A: ");
    int cols = Integer.valueOf(input.readLine()).intValue();
    Matrix A = new Matrix(rows, cols);
    
    //close stream
    input.close();
    System.exit(0);
  }
}
