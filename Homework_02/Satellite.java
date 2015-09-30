//Andriy Zasypkin
//2015-09-06
//Homework 02

public class Satellite {
  //Speed of light in m/s, public since others may need this value(read only)
  public static final int SPEED_OF_LIGHT = 299792458;
  
  private int    id;          //ID of satellite object
  private double receiveTime; //Time signal was received by satellite object
  
  //2 arg constructor 
  //  id
  //  receive time
  //default constructor will not be used therefore it is not needed
  public Satellite(int id, double receiveTime) {
    this.receiveTime = receiveTime;
    this.id          = id;
  }
  
  //return the pseudo range for a given broadcast time
  public double getPseudoRange(double broadcastTime) {
    return (receiveTime - broadcastTime) * SPEED_OF_LIGHT;
  }
  
  //Accessor methods
  public int getId() {
    return id;
  }
  
  public double getReceiveTime() {
    return receiveTime;
  }
  
  //Mutator methods
  public void getId(int id) {
    this.id = id;
  }
  
  public void getReceiveTime(double receiveTime) {
    this.receiveTime = receiveTime;
  }
}
