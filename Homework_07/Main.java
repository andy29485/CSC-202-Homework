//Andriy Zasypkin
//2015-11-06
//Homework 07

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //create an input reader object
    BufferedReader input
            = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Enter location to save database: ");
    //Create a file obj - for checks;
    File info;

    //INPUT:
    // a file name
    //read db from user inuted file
    do {
      System.out.print("Enter a filename: ");
      info = new File(input.readLine());
      if(!info.exists()) {
        System.out.printf("\"%s\" does not exist exists - will not read\n",
                          info.getPath());
      }
      else if(info.isDirectory()) {
        System.out.printf("\"%s\" exists, but it's a directory\n",
                          info.getPath());
      }
    } while(info.isDirectory());

    Database db = new Database(info.getPath());
    if(info.exists())
      db.load();

    System.out.println("From File:");
    db.print();//Print database that already exists

    /* Used to generate table
    // default values:
    //   frequency(Hz):                      16700000
    //   increment(F):                 0.000000000030
    //   minimal capacitance value(F): 0.000000000015
    //   maximum capacitance value(F): 0.000000000365

    System.out.print("Enter a frequency(Hz): ");
    double f = Double.valueOf(input.readLine()).doubleValue();
    System.out.print("Enter an increment(F): ");
    double inc = Double.valueOf(input.readLine()).doubleValue();
    System.out.print("Enter a minimal capacitance value(F): ");
    double cmin = Double.valueOf(input.readLine()).doubleValue();
    System.out.print("Enter a maximum capacitance value(F): ");
    double cmax = Double.valueOf(input.readLine()).doubleValue();

    double c = Math.sqrt(cmin*cmax);
    double l = Math.sqrt(Math.pow((2*Math.PI/f), 2)/c);

    for(double i=cmin; i<=cmax; i+=inc) {
      db.add(l, cmin, i);
    }
    */

    System.out.printf("Entry to modify[0-%d]: ", db.size()-1);
    int index = Integer.valueOf(input.readLine()).intValue();

    System.out.printf("New value for cmax of entry %d in Farads: ", index);
    double new_cmax = Double.valueOf(input.readLine()).doubleValue();

    db.modify(index).setCmax(new_cmax);
    db.modify(index).calcC();

    System.out.println("Modified database:");
    db.print();//Print database after the modification

    //db.save(index);//save only the modified entry
    db.save();   //Save entire database

    //close input stream
    input.close();

    System.exit(0);
  }
}

