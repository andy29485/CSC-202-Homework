//Andriy Zasypkin
//2015-11-20
//Homework 09

import java.io.*;

public class Elevator {
  private int             floors;
  private int             current_floor;
  private boolean         doors_open;
  private int             door_wait;
  private int             return_wait;
  private String          password;
  private BufferedReader  input;
  
  public Elevator() {
    floors        = 26;
    current_floor = 1;
    doors_open    = false;
    door_wait     = 60000; //1 minute in miliseconds
    return_wait   = 60000; //1 minute in miliseconds
    password      = "12345";
    input         = new BufferedReader(new InputStreamReader(System.in));
  }
  
  public Elevator(int floor) {
    floors        = 26;
    current_floor = floor;
    doors_open    = false;
    door_wait     = 60000; //1 minute in miliseconds
    return_wait   = 60000; //1 minute in miliseconds
    password      = "12345";
    input         = new BufferedReader(new InputStreamReader(System.in));
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public String getPassword() {
    return this.password;
  }
  
  public void setDoorWait(int door_wait) {
    this.door_wait = door_wait;
  }
  
  public int getDoorWait() {
    return this.door_wait;
  }
  
  public void setReturnWait(int return_wait) {
    this.return_wait = return_wait;
  }
  
  public int getReturnWait() {
    return this.return_wait;
  }
  
  public int getFloor() {
    return this.current_floor;
  }
  
  public void move_to_floor(int floor) throws IOException{
    if(floor > floors || floor < 1 || floor == 13) {
      System.out.printf("No such floor: %d\n", floor);
      return;
    }
    if(floor == floors && !isAuthorized()) {
      System.out.println("Wrong password, access denied");
      return;
    }
    for(; current_floor < floor; current_floor++) {
      System.out.printf("Moving UP, at floor %d\n", current_floor);
    }
    for(; current_floor > floor; current_floor--) {
      System.out.printf("Moving DOWN, at floor %d\n", current_floor);
    }
    System.out.printf("Stopping, at floor %d(input o to keep open)\n", current_floor);
    open();
    while(keepOpen())
      System.out.printf("Doors still open, at floor %d(input o to keep open)\n", current_floor);
    close();
  }
  
  public void open() {
    System.out.printf("Doors openning, at floor %d\n", current_floor);
  }
  
  public boolean keepOpen() throws IOException {
    //Check if button was pressed within timeout,
    //  if yes return true
    //  if timeout was reached return false
    long start = System.currentTimeMillis();
    while((System.currentTimeMillis()-start<door_wait) && !input.ready());
    return input.ready() && input.readLine().matches("(?i)^o.*");
  }
  
  public boolean isAuthorized() throws IOException {//get the password, if correct
    System.out.print("Enter password: ");
    return input.readLine().equals(password);// let 'em through
  }
  
  //main elevator loop
  public void start() throws IOException {
    //CTRL+C or pulling the plug will terminate the elevator
    //  to stop try CTRL+X or CTRL+Z
    
    System.out.print("Enter floor: ");
    while(true) {
      //get floor to move to
      int to_floor = Integer.valueOf(input.readLine()).intValue();
      //move to that floor
      System.out.print("\r");
      move_to_floor(to_floor);
      //wait before returing to floor
      System.out.print("Enter floor: ");
      long start = System.currentTimeMillis();
      while((System.currentTimeMillis()-start<return_wait) && !input.ready());
      //if input was given during that time, don't go down
      //  otherwise go dowd
      if(!input.ready()) {
        System.out.println("\rReturning to first floor");
        for(; current_floor > 1; current_floor--) {
          System.out.printf("Moving DOWN, at floor %d(input o to keep open)\n",
                             current_floor);
        }
        System.out.print("Enter floor: ");
      }
    }
  }
  
  public void close() {
    System.out.printf("Doors closing, at floor %d\n", current_floor);
  }
}
