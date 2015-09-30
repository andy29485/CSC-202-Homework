//Andriy Zasypkin
//2015-09-06
//Homework 02

import java.util.ArrayList;

public class SatelliteSystem {
  private ArrayList<Satellite> satellites;    //List of all sats. in system
  private double               broadcastTime; //System's broadcast timestamp
  
  //2 arg constructor 
  //  broadcast time
  //default constructor will not be used therefore it is not needed
  public SatelliteSystem(double broadcastTime) {
    this.satellites    = new ArrayList<Satellite>();
    this.broadcastTime = broadcastTime;
  }
  
  //return the id of the closest satellite, by time
  //  broadcast time will be constant in this method
  //  (speed of light is also constant), therefore
  //  the only variable is receive time -- to save
  //  processing power, range will not be computed
  //  and only time will be used to find the closest
  //  satellite
  //
  //If -1 is returned, then there were no satellites
  //  in the list
  public int closestSatId() {
    //MAX_VALUE is used so that it is possible to find the smallest
    //  receive time(no time can be greater that MAX_VALUE)
    double shortestTime = Double.MAX_VALUE;
    int    idOfClosest  = -1;
    
    //Iterate through sats finding the one with the smallest time
    for(Satellite sat : satellites) {
      //'<=' is used for the unlikely case that the closest satellite's
      //  receive time is equal to Double.MAX_VALUE
      //  since otherwise(if '<' was used) sat. id -1 would be returned
      if(sat.getReceiveTime() <= shortestTime) {
        idOfClosest  = sat.getId();
        shortestTime = sat.getReceiveTime();
      }
    }
    
    return idOfClosest;
  }
  
  //Accessor methods
  public double getBroadcastTime() {
    return this.broadcastTime;
  }
  
  public ArrayList<Satellite> getSatellites() {
    return satellites;
  }
  
  /*
   *Not used in this implementation but may be needed
   *  commented for now - may be needed if implementation
   *                      was diffrent
   *
   * //Returns satellite object if found
   * //throws IllegalArgumentException if not found
   * public Satellite getSatelliteById(int id) throws RuntimeException {
   *   for(Satellite sat : satellites) {
   *     if(sat.getId() == id) {
   *       return sat;
   *     }
   *   }
   *   throw new IllegalArgumentException("sat with specified id must exist");
   * }
   */
  
  //Mutator methods
  public void setBroadcastTime(double broadcastTime) {
    this.broadcastTime = broadcastTime;
  }
  
  //Add a satellite with specified parameters to the list
  public void addSatellite(int id, double receiveTime) {
    satellites.add(new Satellite(id, receiveTime));
  }
}
