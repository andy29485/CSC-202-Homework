//Andriy Zasypkin
//2015-11-06
//Homework 07

import java.util.*;
import java.io.*;

public class Database {
  List<Entry> entries;
  String filename;

  public Database() {
    this.entries  = new ArrayList<Entry>();
    this.filename = "";
  }

  public Database(String filename) {
    this.entries  = new ArrayList<Entry>();
    this.filename = filename;
  }

  public void add(double l, double cmin, double cmax) {
    Entry tmp = new Entry();
    tmp.setL(l);
    tmp.setCmin(cmin);
    tmp.setCmax(cmax);
    tmp.calcC();
    entries.add(tmp);
  }

  public Entry modify(int index) {
    return entries.get(index);
  }

  public int size() {
    return entries.size();
  }

  public void save(long index) throws IOException {
    RandomAccessFile raf = new RandomAccessFile(this.filename, "rw");
    Entry tmp = entries.get((int)index);

    raf.seek(32*index);

    raf.writeDouble(tmp.getL());
    raf.writeDouble(tmp.getC());
    raf.writeDouble(tmp.getCmin());
    raf.writeDouble(tmp.getCmax());

    raf.close();
  }

  public void save() throws IOException {
    RandomAccessFile raf = new RandomAccessFile(this.filename, "rw");

    for(Entry entry : entries) {
      raf.writeDouble(entry.getL());
      raf.writeDouble(entry.getC());
      raf.writeDouble(entry.getCmin());
      raf.writeDouble(entry.getCmax());
    }
    raf.close();
  }

  public void load() throws IOException {
    RandomAccessFile raf = new RandomAccessFile(this.filename, "r");
    Entry tmp;

    while(raf.length() > raf.getFilePointer()) {
      tmp = new Entry();
      tmp.setL(raf.readDouble());
      tmp.setC(raf.readDouble());
      tmp.setCmin(raf.readDouble());
      tmp.setCmax(raf.readDouble());
      this.entries.add(tmp);
    }
    raf.close();
  }

  public void print() {
    System.out.println("    L    |    C    |   Cmin  |   Cmax  ");
    System.out.println("---------------------------------------");
    for(Entry entry : entries) {
      System.out.printf("%8.7f |%8f |%5.0f pF |%5.0f pF\n",
                        entry.getL(),
                        entry.getC(),
                        entry.getCmin(),
                        entry.getCmax());
    }
  }
}
