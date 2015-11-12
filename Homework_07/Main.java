//Andriy Zasypkin
//2015-11-06
//Homework 07

import java.io.*;

/** Description:
  *   Create a program to record status(?) of a tuning circut
  *     - For frequencies in range [Fmin, Fmax]
  *     - Use a random acces file
  *        * also save Fmin and Fmax
  *     - Read all variables
  *     - Compute value of L
  *     - Compute value of C(should happen before prev step)
  *     - change value of Cmax for entriy 1(0)
  *     - change Fmin(see assumptions) based on inputed Cmax and save
  *
  * Assumptions:
  *   - Calculations are in base units
  *   - After looking up "Tuning Circuts" and finding formulas, I have come to
  *         to the conclusion that I coppied the instructions down incorrectly
  *         because after deriving Fmin/Fmax, I noticed that they were invers-
  *         ely, and not proportionally related to Cmin/Cmax respectively
  *   - The database gets created/overwriten at the begining of /each/ run
  *   - The database only saves over the part that was overwriten after asking
  *         user for a new Cmax value
  *   - The new Cmax value relates *only* to the one entry that it overwrites
  *   - Cmax(and therefore Fmin) do not change - except for after the user set
  *         a new calue for one of the Cmaxs, at which point both(in that row)
  *         get overwriten
  *   - Users /can/ chose, if they so desire, which row they wish to modify
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
         if(info.isDirectory()) {
            System.out.printf("\"%s\" exists, but it's a directory\n",
                               info.getPath());
         }
         else if(!info.exists()) {
            System.out.printf("\"%s\" does not exist - will be created\n",
                               info.getPath());
         }
         else {
            System.out.printf("\"%s\" exists - will be overwriten\n",
                               info.getPath());
         }
      } while(info.isDirectory());

      //create database and set the filename for database
      Database db1 = new Database(info.getPath());

      // Used to generate table
      // default values:
      //   frequency(MHz):                 16.7
      //   increment(pF):                  30
      //   minimal capacitance value(pF):  15
      //   maximum capacitance value(pF): 365

      //INPUT:
      //  get vars from user as per directions
      System.out.print("Enter a frequency(MHz): "); //Multiplyed to get to base
      double f = Double.valueOf(input.readLine()).doubleValue()*1000000;
      System.out.print("Enter an increment(pF): ");
      double inc = Double.valueOf(input.readLine()).doubleValue();
      System.out.print("Enter a minimal capacitance value(pF): ");
      double cn = Double.valueOf(input.readLine()).doubleValue();
      System.out.print("Enter a maximum capacitance value(pF): ");
      double cx = Double.valueOf(input.readLine()).doubleValue();

      double c = Math.sqrt(cn/1000000000000.*cx/1000000000000.);
      double l = Math.sqrt(Math.pow((2*Math.PI/f), 2)/c);

      //set minimum and maximum capacitance
      db1.setCmin(cn);
      db1.setCmax(cx);

      for(double i=cn; i<=cx; i+=inc) {
         db1.add(l, i, cx);
      }

      db1.save();   //Save entire database

      Database db2 = new Database();
      db2.setFilename(info.getPath());

      //load from file
      db2.load();

      System.out.println("\nFrom File:");
      db2.print();//Print database that already exists

      int index = -1;

      //INPUT:
      //  ask user which entry they want to modify
      do {
         System.out.printf("\nEntry to modify[1-%d]: ", db2.size());
         index  = Integer.valueOf(input.readLine()).intValue() - 1;
      } while(index > db2.size() -1 || index < 0);

      //INPUT:
      //  get the value of Cmax of entry user wants to modify from the user
      System.out.printf("New value for Cmax of entry %d in pF: ", index+1);
      double new_cmax = Double.valueOf(input.readLine()).doubleValue();

      //Set the value of Cmax of entry user wants to modify, and re-calc 'C'
      db2.modify(index, new_cmax);

      System.out.println("\nModified database:");
      db2.print();//Print database after the modification

      db2.save(index);//save only the modified entry

      //close input stream
      input.close();

      System.exit(0);
   }
}

