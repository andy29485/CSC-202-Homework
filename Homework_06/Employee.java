//Andriy Zasypkin
//2015-10-18
//Homework 06

public class Employee {
  private String  strFirstName;
  private String  strLastName;
  private int     nID;
  private int     nAge;
  private double  dSalary;
  private boolean bFullTime;
  
  //Default constructor set things to default(and mostly pointless) values
  public Employee() {
    strFirstName = "";
    strLastName  = "";
    nID          = -1;
    nAge         = -1;
    dSalary      = 0.0;
    bFullTime    = false;
  }
  
  //Set Employee metadata from record string
  public void set(String strRecord) throws IllegalArgumentException {
    if(!strRecord.matches("\\w+ \\w+ \\d+ \\d+ [\\d\\.]+ [TFtf]"))
      throw new IllegalArgumentException("not a valid record: " + strRecord);
    
    String[] astrFields = strRecord.split(" ");
    
    strFirstName = astrFields[0];
    strLastName  = astrFields[1];
    nID          = Integer.valueOf(astrFields[2]).intValue();
    nAge         = Integer.valueOf(astrFields[3]).intValue();
    dSalary      = Double .valueOf(astrFields[4]).doubleValue();
    bFullTime    = astrFields[5].equalsIgnoreCase("T");
  }
  
  
  //Accessor|Modifier methods - grouped by var used
  public void setFirstName(String strFirstName) {
    this.strFirstName = strFirstName.replaceAll("\\s+", "_");
  }
  
  public String getFirstName() {
    return this.strFirstName;
  }
  
  public void setLastName(String strLastName) {
    this.strLastName = strLastName.replaceAll("\\s+", "_");
  }
  
  public String getLastName() {
    return this.strLastName;
  }
  
  public void setID(int nID) {
    this.nID = nID;
  }
  
  public int getID() {
    return this.nID;
  }
  
  public void setAge(int nAge) {
    this.nAge = nAge;
  }
  
  public int getAge() {
    return this.nAge;
  }
  
  public void setSalary(double dSalary) {
    this.dSalary = dSalary;
  }
  
  public double getSalary() {
    return this.dSalary;
  }
  
  public void setFullTime(boolean bFullTime) {
    this.bFullTime = bFullTime;
  }
  
  public boolean getFullTime() {
    return this.bFullTime;
  }
  
  //Used to store an Employee in a database
  public String toString() {
    return String.format("%s %s %d %d %f %s",
                          strFirstName,
                          strLastName,
                          nID,
                          nAge,
                          dSalary,
                          bFullTime ? "T" : "F");
  }
}
