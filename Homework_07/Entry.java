//Andriy Zasypkin
//2015-11-06
//Homework 07

public class Entry {
  private double l;     //Variables that seem
  private double c;     //  have something to
  private double fmin;  //  do with tuning or
  private double fmax;  //  maybe circuts

  //Default constructor - create 'empty' entry for database
  public Entry() {
    l    = 0; //Not sure what these values are, but I do have formulas.
    c    = 0;
    fmin = 0;
    fmax = 0;
  }

  //Accessor/modifier methods
  public double calcC() {
    return this.c = Math.sqrt(fmin*fmax);
  }
  
  public void calcF(double cn, double cx) {
    this.fmin = 2*Math.PI/Math.sqrt(l*cn);
    this.fmax = 2*Math.PI/Math.sqrt(l*cx);
  }

  public void setFmin(double fmin) {
    this.fmin = fmin;
  }

  public double getFmin() {
    return this.fmin;
  }

  public void setFmax(double fmax) {
    this.fmax = fmax;
  }

  public double getFmax() {
    return this.fmax;
  }

  public void setL(double l) {
    this.l = l;
  }

  public double getL() {
    return this.l;
  }

  public void setC(double c) {
    this.c = c;
  }

  public double getC() {
    return this.c;
  }
}
