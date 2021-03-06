//Andriy Zasypkin
//2015-11-14
//Homework 08

import java.io.*;

/** Description:
  *   - Write a program to read 3 matrixes
  *     - A, B, and C
  *   - Create 2 more
  *     - D = A + B
  *     - E = A - B + C
  *   - Read in a constant k
  *   - Multiply E by k
  *
  * Assumptions:
  *   - When it says E*k, it means create another matrix
  *   - A = [[ -1   2]
  *          [-10   5]]
  *   - B = [[  6  25]
  *          [ 21  16]]
  *   - C = [[ 10  15]
  *          [  5   6]]
  */

public class Main {
  public static void main(String[] args) throws IOException {
    //create an input reader object
    BufferedReader input
            = new BufferedReader(new InputStreamReader(System.in));
    
    //read 3 matrixes
    System.out.print("Rows in matrix A: ");//get rows
    int rows = Integer.valueOf(input.readLine()).intValue();
    System.out.print("Columns in matrix A: ");//get columns
    int cols = Integer.valueOf(input.readLine()).intValue();
    Matrix A = new Matrix(rows, cols);//and create empty
    //fill
    for(int i=0; i<rows; i++) {
      for(int j=0; j<cols; j++) {
        System.out.printf("A[%02d][%02d] = ", i+1, j+1);
        A.set(i, j, Double.valueOf(input.readLine()).doubleValue());
      }
    }
    
    System.out.print("Rows in matrix B: ");//get rows
    rows = Integer.valueOf(input.readLine()).intValue();
    System.out.print("Columns in matrix B: ");//get columns
    cols = Integer.valueOf(input.readLine()).intValue();
    Matrix B = new Matrix(rows, cols);//and create
    //fill
    for(int i=0; i<rows; i++) {
      for(int j=0; j<cols; j++) {
        System.out.printf("B[%02d][%02d] = ", i+1, j+1);
        B.set(i, j, Double.valueOf(input.readLine()).doubleValue());
      }
    }
    
    System.out.print("Rows in matrix C: ");//get rows
    rows = Integer.valueOf(input.readLine()).intValue();
    System.out.print("Columns in matrix C: ");//get columns
    cols = Integer.valueOf(input.readLine()).intValue();
    Matrix C = new Matrix(rows, cols);//and create
    //fill
    for(int i=0; i<rows; i++) {
      for(int j=0; j<cols; j++) {
        System.out.printf("C[%02d][%02d] = ", i+1, j+1);
        C.set(i, j, Double.valueOf(input.readLine()).doubleValue());
      }
    }
    
    //D = A + B
    Matrix D = A.add(B);
    
    //E = A + C - B
    Matrix E = A.add(C).subtract(B);
    
    //E * k
    System.out.print("Enter a constant: ");
    Matrix Ek = E.multiply(Integer.valueOf(input.readLine()).intValue());
    
    //OUTPUT:
    //  print all matrixes
    System.out.println("A:");
    A.print();
    System.out.println("B:");
    B.print();
    System.out.println("C:");
    C.print();
    System.out.println("D:");
    D.print();
    System.out.println("E:");
    E.print();
    System.out.println("E*k:");
    Ek.print();
    
    //close stream
    input.close();
    System.exit(0);
  }
}
