//Andriy Zasypkin
//2015-09-06
//Homework 02

/*DESCIPTION:
 *  Using broadcast time and receive times
 *  figure out a satellite's pseudo range,
 *  also find the closest satellite within
 *  a group of satellite
 */

import java.io.*;

public class GPS {
  private static BufferedReader input;
  
  //Slightly better way of getting input, w/o crashing
  private static int getInt(String message) throws IOException {
    String line;
    
    do {
      System.out.print(message);        //Print message to prompt user
      line = input.readLine();          //Ask for input
    } while(!line.matches("^\\d+$"));   //If input does not look like an int,
                                        //  try again
    return Integer.valueOf(line);
  }
  
  //see getInt above(it's the same thing)
  private static double getDouble(String message) throws IOException {
    String line;
    
    do {
      System.out.print(message);
      line = input.readLine();
    } while(!line.matches("^[\\d\\.]+$"));

    return Double.valueOf(line);
  }
  
  public static void main(String[] args) throws IOException{
    InputStreamReader isr = new InputStreamReader(System.in);
    SatelliteSystem   satSys;
    
    input = new BufferedReader(isr);
    
    //INPUT:
    //Ask for the number of satellites
    int numberOfSats = getInt("Enter the number of satellites: ");
    
    //INPUT:
    //Using the inputed timestamp of the sig brodcast,
    //  instantiate a satellite system
    satSys = new SatelliteSystem(getDouble("Enter the broadcast time: "));
    
    //INPUT:
    //For each satellite, ask for an id and a receive timestamp.
    //  then create the object
    for(int i=0; i<numberOfSats; i++) {
      int    id   = getInt(String.format("Sat %d id: ", i+1));
      double time = getDouble(String.format("Sat %d receive time: ", i+1));
      satSys.addSatellite(id, time);
    }
    //input no longer needed - close input streams
    isr.close();
    input.close();
    
    //OUTPUT:
    //Preceed output with message for aesthetics
    //For each satellite in array,
    //  print id, receive time, and pseudo range
    System.out.println("\nOutput:");
    for(Satellite sat : satSys.getSatellites()) {
      System.out.printf("ID:    %d\n", sat.getId());
      System.out.printf("Time:  %f seconds\n", sat.getReceiveTime());
      System.out.printf("Range: %fm\n\n",
                         sat.getPseudoRange(satSys.getBroadcastTime()));
    }
 
    //OUTPUT:
    //  print id of closest satellite
    System.out.printf("Closest satellite(by id): %d\n", satSys.closestSatId());
    
    System.exit(0);
  }
}
