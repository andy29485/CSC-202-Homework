//Andriy Zasypkin
//2015-11-06
//Homework 07

public class Entry {
  private double l;
  private double c;
  private double cmin;
  private double cmax;

  //Default constructor
  public Entry() {
    l    = 0; //Not sure what these values are, but I do have formulas.
    c    = 0;
    cmin = 0;
    cmax = 0;
  }

  public double calcC() {
    return this.c = Math.sqrt(cmin*cmax);
  }

  public void setCmin(double cmin) {
    this.cmin = cmin;
  }

  public double getCmin() {
    return this.cmin;
  }

  public void setCmax(double cmax) {
    this.cmax = cmax;
  }

  public double getCmax() {
    return this.cmax;
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
