//Andriy Zasypkin
//2015-11-06
//Homework 07

import java.util.List;
import java.util.ArrayList;

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

  public void print() {
    System.out.println("    L    |    C    |   Cmin  |   Cmax  ");
    System.out.println("---------------------------------------");
    for(Entry entry : entries) {
      System.out.printf("%8f |%8f |%8f |%8f\n",
                        entry.getL(),
                        entry.getC(),
                        entry.getCmin(),
                        entry.getCmax());
    }
  }
}
