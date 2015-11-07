//Andriy Zasypkin
//2015-11-06
//Homework 07

import java.util.*;
import java.io.*;

public class Database {
  private List<Entry> entries;  //List of entries in database
  private String filename;      //Filename associated with database
  private double fmin;          //minimum
  private double fmax;          //  and maximun frequencies supported

  public Database() { //default database - set filename later
    this.entries  = new ArrayList<Entry>();
    this.filename = "";
    this.fmin     = 0;
    this.fmax     = 0;
  }

  public Database(String filename) { //database from filename(do not load yet)
    this.entries  = new ArrayList<Entry>();
    this.filename = filename;
    this.fmin     = 0;
    this.fmax     = 0;
  }

  public void add(double l, double cmin, double cmax) {
    Entry tmp = new Entry();//create tmp empty entry
    tmp.setL(l);            //  fill the empty entry
    tmp.setCmin(cmin);
    tmp.setCmax(cmax);
    tmp.calcC();
    entries.add(tmp);       //  add filled entry to database
  }

  public Entry modify(int index) {
    return entries.get(index);//Retrieve entry
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

  public void save(long index) throws IOException {
    //open to write
    RandomAccessFile raf = new RandomAccessFile(this.filename, "rw");
    Entry tmp = entries.get((int)index);//Retrieve entry

    raf.seek(32*index+16);//seek to postion of entry to write

    raf.writeDouble(tmp.getL());//Write info on entry
    raf.writeDouble(tmp.getC());
    raf.writeDouble(tmp.getCmin());
    raf.writeDouble(tmp.getCmax());

    raf.close();//close stream
  }

  public void save() throws IOException {
    //open to write
    RandomAccessFile raf = new RandomAccessFile(this.filename, "rw");

    //Write min/max values for frequency
    raf.writeDouble(this.fmin);
    raf.writeDouble(this.fmax);

    for(Entry entry : entries) {    //For each entry in database
      raf.writeDouble(entry.getL());//  Write info on entry
      raf.writeDouble(entry.getC());
      raf.writeDouble(entry.getCmin());
      raf.writeDouble(entry.getCmax());
    }
    raf.close();//close stream
  }

  public void load() throws IOException {
    //open as read only
    RandomAccessFile raf = new RandomAccessFile(this.filename, "r");
    Entry tmp;

	//Read min/max values for frequency
    this.fmin = raf.readDouble();
    this.fmax = raf.readDouble();

    while(raf.length() > raf.getFilePointer()) {//While there is stuff to read
      tmp = new Entry();                        //  create an empty entry
      tmp.setL(raf.readDouble());               //  read each value from file
      tmp.setC(raf.readDouble());
      tmp.setCmin(raf.readDouble());
      tmp.setCmax(raf.readDouble());
      this.entries.add(tmp);                    //add read entry to database
    }
    raf.close();//close stream
  }

  public void print() { //print the database in table format to std out
    System.out.println("      L      |       C      |    Cmin   |    Cmax");
    System.out.println("---------------------------------------------------");
    for(Entry entry : entries) {//Print all values whilst formating them
      System.out.printf("%10.7f H |%10.6f pF |%7.2f pF |%7.2f pF\n",
                        entry.getL(),
                        entry.getC(),
                        entry.getCmin(),
                        entry.getCmax());
    }
  }
}
