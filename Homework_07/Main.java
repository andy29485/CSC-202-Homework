//Andriy Zasypkin
//2015-11-06
//Homework 07

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //create an input reader object
    BufferedReader input
            = new BufferedReader(new InputStreamReader(System.in));

    //Create a file obj - for checks;
    File info;

    //INPUT:
    // a file name
    //read db from user inuted file
    do {
      System.out.print("Enter location to save database: ");
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

    System.out.println("\nFrom File:");
    db.print();//Print database that already exists

    /* Used to generate table
    // default values:
    //   frequency(MHz):                 16.7
    //   increment(pF):                  30
    //   mi/imal capacitance value(pF):  15
    //   maximum capacitance value(pF): 365

    System.out.print("Enter a frequency(MHz): "); //Multiplyed to get to base
    double f = Double.valueOf(input.readLine()).doubleValue(); //unit
    System.out.print("Enter an increment(pF): ");
    double inc = Double.valueOf(input.readLine()).doubleValue();
    System.out.print("Enter a minimal capacitance value(pF): ");
    double cmn = Double.valueOf(input.readLine()).doubleValue();
    System.out.print("Enter a maximum capacitance value(pF): ");
    double cmx = Double.valueOf(input.readLine()).doubleValue();

    double c = Math.sqrt(cmn*cmx);
    double l = Math.sqrt(Math.pow((2*Math.PI/f), 2)/c);

    for(double i=cmn; i<=cmx; i+=inc) {
      db.add(l, cmn, i);
    }
    /*/

    System.out.printf("\nEntry to modify[1-%d]: ", db.size());
    int index = Integer.valueOf(input.readLine()).intValue() - 1;

    System.out.printf("New value for cmax of entry %d in Farads: ", index);
    double new_cmax = Double.valueOf(input.readLine()).doubleValue();

    db.modify(index).setCmax(new_cmax);
    db.modify(index).calcC();

    System.out.println("\nModified database:");
    db.print();//Print database after the modification */

    //db.save(index);//save only the modified entry
    db.save();   //Save entire database

    //close input stream
    input.close();

    System.exit(0);
  }
}

