//Andriy Zasypkin
//2015-11-06
//Homework 07

public class Entry {
  private double l;
  private double c;
  private double cmin;
  private double cmax;

  public Entry() {
    l    = 0;
    c    = 0;
    cmin = 0;
    cmax = 0;
  }

  public double calcC() {
    return this.c = Math.sqrt(cmin*cmax);
  }

  public double calcL() {
    return this.l = Math.sqrt(Math.pow((2*Math.PI/f, 2)/this.c);//TODO - set f
  }

  public void setCmin(double cmin) {
    this.cmin = cmin;
  }

  public doubl getCmin() {
    return this.cmin;
  }

  public void setCmax(double cmax) {
    this.cmax = cmax;
  }

  public doubl getCmax() {
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
