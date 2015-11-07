//Andriy Zasypkin
//2015-11-06
//Homework 07

import java.io.*;

/** Description:
  *   Create a program to record status(?) of a tuning circut
  *     - For frequencies in range [Fmin, Fmax] #TODO - fix
  *     - Use a random acces file
  *        * also save Fmin and Fmax #TODO
  *
  * Assumptions:
  *   Movies and movie metadata can be hard coded
  */

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

    //create database and set the filename for database
    Database db = new Database(info.getPath());
    
    //Load the database form file(if file exists)
    if(info.exists())
      db.load();

    System.out.println("\nFrom File:");
    db.print();//Print database that already exists

    /* Used to generate table
    // default values:
    //   frequency(MHz):                 16.7
    //   increment(pF):                  30
    //   minimal capacitance value(pF):  15
    //   maximum capacitance value(pF): 365

    System.out.print("Enter a frequency(MHz): "); //Multiplyed to get to base
    double f = Double.valueOf(input.readLine()).doubleValue()*1000000.; //unit
    System.out.print("Enter an increment(pF): ");
    double inc = Double.valueOf(input.readLine()).doubleValue();
    System.out.print("Enter a minimal capacitance value(pF): ");
    double fn = Double.valueOf(input.readLine()).doubleValue();
    System.out.print("Enter a maximum capacitance value(pF): ");
    double fx = Double.valueOf(input.readLine()).doubleValue();

    //Once again, input needs to be converted to base units
    double c = Math.sqrt(fn/1000000000000.*fn/1000000000000.);
    double l = Math.sqrt(Math.pow((2*Math.PI/f), 2)/c);

    for(double i=cmn; i<=cmx; i+=inc) { #TODO - fix(see line 9ish)
      db.add(l, cmn, i);
    }
    /*/

    //INPUT:
    //  ask user which entry they want to modify
    System.out.printf("\nEntry to modify[1-%d]: ", db.size());
    int index = Integer.valueOf(input.readLine()).intValue() - 1;

    //INPUT:
    //  get the value of Cmax of entry user wants to modify from the user
    System.out.printf("New value for cmax of entry %d in pF: ", index);
    double new_cmax = Double.valueOf(input.readLine()).doubleValue();

    //Set the value of Cmax of entry user wants to modify, and re-calc 'C'
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

