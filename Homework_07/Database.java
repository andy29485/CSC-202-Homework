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
  private BufferedReader input;

  public Database() { //default database - set file name later
    this.entries  = new ArrayList<Entry>();
    this.filename = "";
    this.cmin     = 0;
    this.cmax     = 0;
    this.input    = new BufferedReader(new InputStreamReader(System.in));
  }

  public Database(String filename) { //database from filename(do not load yet)
    this.entries  = new ArrayList<Entry>();
    this.filename = filename;
    this.cmin     = 0; //but still some default values
    this.cmax     = 0;
    this.input    = new BufferedReader(new InputStreamReader(System.in));
  }

  public void generate() throws IOException {
    // Used to generate table
    // default values:
    //   frequency(MHz):                 16.7
    //   increment(pF):                  30
    //   minimal capacitance value(pF):  15
    //   maximum capacitance value(pF): 365

    //INPUT:
    //  get vars from user as per directions
    System.out.print("Enter a frequency(MHz): "); //Multiplyed to get to base
    double f = Double.valueOf(this.input.readLine()).doubleValue()*1000000;
    System.out.print("Enter an increment(pF): ");
    double inc = Double.valueOf(this.input.readLine()).doubleValue();
    System.out.print("Enter a minimal capacitance value(pF): ");
    double cn = Double.valueOf(this.input.readLine()).doubleValue();
    System.out.print("Enter a maximum capacitance value(pF): ");
    double cx = Double.valueOf(this.input.readLine()).doubleValue();

    //Calculate an initial "L" value(and "C" to get "L")
    double c = Math.sqrt(cn/1000000000000.*cx/1000000000000.);
    double l = Math.sqrt(Math.pow((2*Math.PI/f), 2)/c);

    //set minimum and maximum capacitance
    this.setCmin(cn);
    this.setCmax(cx);

    for(double i=cn; i<=cx; i+=inc) {//iterate Cmin form Cmin to Cmax
       this.add(l, i, cx);//add such entry to database
    }
  }

  public void add(double l, double cmin, double cmax) {
    Entry tmp = new Entry();//create tmp empty entry
    tmp.setL(l);            //  fill the empty entry
    tmp.calcF(cmin, cmax);  //    - calculate Fmin/Fmax
    tmp.calcC();            //    - calculate C
    entries.add(tmp);       //  add filled entry to database
  }

  public void modify() throws IOException {
    int index = -1;

    //INPUT:
    //  ask user which entry they want to modify
    do {
       System.out.printf("\nEntry to modify[1-%d]: ", this.size());
       index = Integer.valueOf(this.input.readLine()).intValue() - 1;
    } while(index > this.size() - 1 || index < 0);

    String srtMod; //To check validity of input

    //INPUT:
    //  get the value of Cmin of entry user wants to modify from the user
    System.out.printf("New Cmin in pF(empty - no modification): ", index+1);
    srtMod = this.input.readLine();
    if(srtMod.matches("\\d+(\\.\\d*)?"))
      this.setCmin(Double.valueOf(srtMod).doubleValue());

    //  get the value of Cmax of entry user wants to modify from the user
    System.out.printf("New Cmax in pF(empty - no modification): ", index+1);
    srtMod = this.input.readLine();
    if(srtMod.matches("\\d+(\\.\\d*)?"))
      this.setCmax(Double.valueOf(srtMod).doubleValue());

    this.entries.get(index).calcF(getCmin(), getCmax()); //re-calc Fmin/max of
                                                         //  selected entry
    this.entries.get(index).calcC();

    this.save(index);//save only the modified entry
  }

  public void modifyCmin(int index, double cn) {
    this.setCmin(cn);
    this.entries.get(index).calcF(getCmin(), getCmax()); //re-calc Fmin/max of
                                                         //  selected entry
    this.entries.get(index).calcC();
  }

  public int size() {
    return entries.size();//return number of entries
  }

  public void setFile() throws IOException {
    System.out.print("Enter location to save database: ");
    this.filename = this.input.readLine();
  }

  public String getFilename() {
    return this.filename;
  }

  public void setCmin(double cmin) {
    this.cmin = cmin/1000000000000.; //conversion to/from base units
  }

  public double getCmin() {
    return this.cmin*1000000000000.; //conversion to/from base units
  }

  public void setCmax(double cmax) {
    this.cmax = cmax/1000000000000.; //conversion to/from base units
  }

  public double getCmax() {
    return this.cmax*1000000000000.; //conversion to/from base units
  }

  public void save(long index) throws IOException {
    if(this.filename.length() == 0)//Set file name if not set
      setFile();

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
    if(this.filename.length() == 0)//Set file name if not set
      setFile();

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
    if(this.filename.length() == 0)//Set file name if not set
      setFile();

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

  public void close() throws IOException {
    this.input.close();
  }

  public void print() {//print the database in a table format to std out
    System.out.println("      L      |       C      |    Fmin    |    Fmax");
    System.out.println("-----------------------------------------------------");
    for(Entry entry : entries) {//Print all values whilst formating them
      System.out.printf("%10.7f H |%10.6f pF |%7.2f MHz |%7.2f MHz\n",
                        entry.getL(),
                        entry.getC(),
                        entry.getFmin(),
                        entry.getFmax());
    }
  }
}
