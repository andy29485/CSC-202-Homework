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
  *     - change value of Fmax for entriy 1(0)
  *     - change Fmax(see assumptions) based on inputed Cmin and save
  *
  * Assumptions:
  *   - Calculations are in base units
  *   -*After looking up "Tuning Circuts" and finding formulas, I have come to
  *         to the conclusion that I coppied the instructions down incorrectly
  *         because after deriving Fmin/Fmax, I noticed that they were invers-
  *         ely, and not proportionally related to Cmin/Cmax respectively
  *   - The database gets created/overwriten at the begining of each run
  *   - The database only saves over the part that was overwriten after asking
  *         user for a new Cmax value and a new Cmin value
  *   - The new Cmin value relates *only* to the one entry that it overwrites
  *   - Cmin will be changed so that the Fmax value changes(not the Cmax value)
  *   - Cmin will cna gea new calue for one of the Cmaxs, at which point both(in that row)
  *         get overwriten
  *   - Users /can/ chose, if they so desire, which row they wish to modify
  */

public class Main {
   public static void main(String[] args) throws IOException {
      //create default database
      Database db = new Database();
      db.generate();

      //save generated database
      db.save();

      System.out.println("\nGenerated:");
      db.print();//Print database that already exists

      //modify an entry
      db.modify();

      System.out.println("\nModified database:");
      db.print();//Print database after the modification

      //close input stream(opened by constructor)
      db.close();

      System.exit(0);
   }
}
