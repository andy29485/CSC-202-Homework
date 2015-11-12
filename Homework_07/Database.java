//Andriy Zasypkin
//2015-11-06
//Homework 07

import java.util.*;
import java.io.*;

public class Database {
  private List<Entry> entries;  //List of entries in database
  private String filename;      //Filename associated with database
  private double cmin;          //minimum
  private double cmax;          //  and maximum frequencies supported

  public Database() { //default database - set filename later
    this.entries  = new ArrayList<Entry>();
    this.filename = "";
    this.cmin     = 0;
    this.cmax     = 0;
  }

  public Database(String filename) { //database from filename(do not load yet)
    this.entries  = new ArrayList<Entry>();
    this.filename = filename;
    this.cmin     = 0;
    this.cmax     = 0;
  }

  public void add(double l, double cmin, double cmax) {
    Entry tmp = new Entry();//create tmp empty entry
    tmp.setL(l);            //  fill the empty entry
    tmp.calcF(cmin, cmax);
    tmp.calcC();
    entries.add(tmp);       //  add filled entry to database
  }

  public void modify(int index, double cx) {
    this.cmax = cx;
    entries.get(index).calcF(cmin, cmax);
    entries.get(index).calcC();
  }

  public int size() {
    return entries.size();//return number of entries
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public String getFilename() {
    return this.filename;
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

  public void save(long index) throws IOException {
    //open to write
    RandomAccessFile raf = new RandomAccessFile(this.filename, "rw");
    Entry tmp = entries.get((int)index);//Retrieve entry

    //Write min/max values for capacitance(just in case)
    raf.writeDouble(this.cmin);
    raf.writeDouble(this.cmax);

    raf.seek(32*index+16);//seek to postion of entry to write

    raf.writeDouble(tmp.getL());//Write info on entry
    raf.writeDouble(tmp.getC());
    raf.writeDouble(tmp.getFmin());
    raf.writeDouble(tmp.getFmax());

    raf.close();//close stream
  }

  public void save() throws IOException {
    //open to write
    RandomAccessFile raf = new RandomAccessFile(this.filename, "rw");

    //Write min/max values for capacitance
    raf.writeDouble(this.cmin);
    raf.writeDouble(this.cmax);

    for(Entry entry : entries) {    //For each entry in database
      raf.writeDouble(entry.getL());//  Write info on entry
      raf.writeDouble(entry.getC());
      raf.writeDouble(entry.getFmin());
      raf.writeDouble(entry.getFmax());
    }
    raf.close();//close stream
  }

  public void load() throws IOException {
    //open as read only
    RandomAccessFile raf = new RandomAccessFile(this.filename, "r");
    Entry tmp;

	  //Read min/max values for frequency
    this.cmin = raf.readDouble();
    this.cmax = raf.readDouble();

    while(raf.length() > raf.getFilePointer()) {//While there is stuff to read
      tmp = new Entry();                        //  create an empty entry
      tmp.setL(raf.readDouble());               //  read each value from file
      tmp.setC(raf.readDouble());
      tmp.setFmin(raf.readDouble());
      tmp.setFmax(raf.readDouble());
      this.entries.add(tmp);                    //add read entry to database
    }
    raf.close();//close stream
  }

  public void print() {//print the database in a table format to std out
    System.out.println("      L      |       C      |    Fmin   |    Fmax");
    System.out.println("---------------------------------------------------");
    for(Entry entry : entries) {//Print all values whilst formating them
      System.out.printf("%10.7f H |%10.6f pF |%7.2f Hz |%7.2f Hz\n",
                        entry.getL(),
                        entry.getC(),
                        entry.getFmin(),
                        entry.getFmax());
    }
  }
}
