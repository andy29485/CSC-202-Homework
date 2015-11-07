//Andriy Zasypkin
//2015-11-06
//Homework 07

public class Entry {
  private double l;     //Variables that seem
  private double c;     //  have something to
  private double cmin;  //  do with tuning or
  private double cmax;  //  maybe circuts

  //Default constructor - create 'empty' entry for database
  public Entry() {
    l    = 0; //Not sure what these values are, but I do have formulas.
    c    = 0; // I am assuming that the formulas take base units,
    cmin = 0; // Since input/output will not be in base units, the units will
    cmax = 0; // be raised/lowered by appropriate power of 10
  }

  //Accessor/modifier methods
  public double calcC() {
    return this.c = Math.sqrt(cmin*cmax);
  }

  public void setCmin(double cmin) {
    this.cmin = cmin/1000000000000.; //Convert to base unit form pF -> F
  }

  public double getCmin() {
    return this.cmin*1000000000000.; ///Convert from base unit form F -> pF
  }

  public void setCmax(double cmax) {
    this.cmax = cmax/1000000000000.; //Convert to base unit form pF -> F
  }

  public double getCmax() {
    return this.cmax*1000000000000.; //Convert from base unit form F -> pF
  }

  public void setL(double l) {
    this.l = l;
  }

  public double getL() {
    return this.l;
  }

  public void setC(double c) {
    this.c = c/1000000000000.;
  }

  public double getC() {
    return this.c*1000000000000.;
  }
}
