//Andriy Zasypkin
//2015-10-18
//Homework 06

import java.io.*;

public class Main {
  /** Problem description:
  *   Write a program to create a database file named "dbs3"
  *   database is a character based file
  *   7 records with 6 fields:
  *     - first name      (string)
  *     - last name       (string)
  *     - id              (int)
  *     - age             (int)
  *     - salary          (double)
  *     - part/full time  (bool)
  *   Display contents(of db)
  *   add another record(with own name) and save as new file
  *
  * Problem Assumptions:
  *   - dbs3 has no extension
  *   - dbs3 already exists and has 7 records
  *   - records are representations of employees
  *   - db structure:
  *      * records '\n' seperated
  *      * fields ' '(space) seperated
  *      * first/last names cannot have spaces(spaces will be replaced)
  *      * bools will be stored as a 'T' or 'F' character
  *   - new database will be saved as dbs4 - no extension
  *   - apart from my name nothing in new entry must be real
  */
  
  public static void main(String[] args) throws Exception {
    //create an input reader object
    BufferedReader input
            = new BufferedReader(new InputStreamReader(System.in));
    
    //Create an empty database
    Database db = new Database();
    
    //INPUT:
    // a file name
    //read db from user inuted file
    System.out.print("Enter a filename: ");
    db.open(input.readLine());
    
    //print contents of database
    db.print();
    
    //create an employee obj to add to db
    Employee tmp_emp = new Employee();
    
    //INPUT:
    //a new record for the database
    System.out.print("First Name: ");
    tmp_emp.setFirstName(input.readLine());
    
    System.out.print("Last Name: ");
    tmp_emp.setLastName(input.readLine());
    
    System.out.print("ID: ");
    tmp_emp.setID(Integer.valueOf(input.readLine()).intValue());
    
    System.out.print("Age: ");
    tmp_emp.setAge(Integer.valueOf(input.readLine()).intValue());
    
    System.out.print("Salary: ");
    tmp_emp.setSalary(Double.valueOf(input.readLine()).doubleValue());
    
    System.out.print("Are you a full time worker[y/n]: ");
    tmp_emp.setFullTime(input.readLine().matches("(?i)y.*"));
    
    //add record to db
    db.add(tmp_emp);
    
    //save to "db4"
    db.save("db4");
    
    input.close();
    System.exit(0);
  }
}
