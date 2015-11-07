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
    //   frequency(MHz):                 16.7
    //   increment(pF):                  30
    //   mi/imal capacitance value(pF):  15
    //   maximum capacitance value(pF): 365

    System.out.print("Enter a frequency(MHz): "); //Multiplyed to get to base
    double f = Double.valueOf(input.readLine()).doubleValue()*1000000.; //unit
    System.out.print("Enter an increment(pF): ");
    double inc = Double.valueOf(input.readLine()).doubleValue();
    System.out.print("Enter a minimal capacitance value(pF): ");
    double cmn = Double.valueOf(input.readLine()).doubleValue();
    System.out.print("Enter a maximum capacitance value(pF): ");
    double cmx = Double.valueOf(input.readLine()).doubleValue();

    //Once again, input needs to be converted to base units
    double c = Math.sqrt(cmn/1000000000000.*cmx/1000000000000.);
    double l = Math.sqrt(Math.pow((2*Math.PI/f), 2)/c);

    for(double i=cmn; i<=cmx; i+=inc) {
      db.add(l, cmn, i);
    }
    /*/

    System.out.printf("Entry to modify[0-%d]: ", db.size()-1);
    int index = Integer.valueOf(input.readLine()).intValue();

    System.out.printf("New value for cmax of entry %d in Farads: ", index);
    double new_cmax = Double.valueOf(input.readLine()).doubleValue();

    db.modify(index).setCmax(new_cmax);
    db.modify(index).calcC();

    System.out.println("Modified database:");
    db.print();//Print database after the modification */

    //db.save(index);//save only the modified entry
    db.save();   //Save entire database

    //close input stream
    input.close();

    System.exit(0);
  }
}

