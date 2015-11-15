//Andriy Zasypkin
//2015-11-14
//Homework 08

public class Matrix {
  private double data[][];
  private int    rows;
  private int    cols;
  
  public Matrix() {
    this.data = new double[0][0];
    this.rows = 0;
    this.cols = 0;
  }
  public Matrix(int rows, int cols) {
    this.data = new double[rows][col];
    this.rows = rows;
    this.cols = cols;
  }
  
  public void setSize(int rows, int cols) {
    this.data = new double[rows][col];
    this.rows = rows;
    this.cols = cols;
  }
  
  public int getRows() {
    return this.rows;
  }
  
  public int getColumns() {
    return this.cols;
  }
  
  public void set(int i, int j, double x) {
    if(i >= this.rows || j >= this.cols)
      throw new RuntimeException("Illegal matrix coordinates");
    this.data[i][j] = x;
  }
  
  public double get(int i, int j) {
    if(i >= this.rows || j >= this.cols)
      throw new RuntimeException("Illegal matrix coordinates");
    return data[i][j];
  }
  
  //add A to this matrix
  public Matrix add(Matrix A) {
    if(A.getRows() != this.rows || A.getColumns() != this.cols)
      throw new RuntimeException("Illegal matrix dimensions");
    Matrix B = new Matrix(this.rows, this.cols);
    for(int i=0; i<this.rows; i++)
      for(int j=0; j<this.cols; j++)
        B.set(i, j, this.get(i, j) + A.get(i, j));
    return B;
  }
  
  //subtract A from this matrix
  public Matrix subtract(Matrix A) {
    if(A.getRows() != this.rows || A.getColumns() != this.cols)
      throw new RuntimeException("Illegal matrix dimensions");
    Matrix B = new Matrix(this.rows, this.cols);
    for(int i=0; i<this.rows; i++)
      for(int j=0; j<this.cols; j++)
        B.set(i, j, this.get(i, j) - A.get(i, j));
    return B;
  }

  //transpose this matrix(do not modify, return transposed)
  public Matrix transpose() {
    Matrix A = new Matrix(this.cols, this.rows);
    for(int i=0; i<this.rows; i++)
      for(int j=0; j<this.cols; j++)
        A.set(j, i, this.get(i, j);
    return A;
  }

  //multiply this by A
  public Matrix multiply(Matrix A) {
      if(this.rows != B.getColumns())
        throw new RuntimeException("Illegal matrix dimensions");
      Matrix B = new Matrix(this.rows, A.getColumns());
      for(int i=0; i < B.getRows(); i++)
        for(int j=0; j < B.getColumns(); j++)
          for(int k=0; k < this.cols; k++)
            B.set(i, j, B.get(i, j) + this.get(i, k)*A.get(k, j));
      return B;
  }

  //OUTPUT
  // print the matrix
  public void print() {
    for(int i=0; i<this.rows; i++) {
      for(int j=0; j<this.cols; j++) 
        System.out.printf("%6.2f ", this.get(i, j));
      System.out.println();
    }
  }
}