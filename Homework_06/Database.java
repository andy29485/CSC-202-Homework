//Andriy Zasypkin
//2015-10-18
//Homework 06

import java.util.*;
import java.io.*;

public class Database {
  private List<Employee> employees;
  
  public Database() {
    employees = new ArrayList<Employee>();
  }
  
  public void add(Employee employee) {
    employees.add(employee);
  }
  
  public void open(String filename) throws Exception {
    FileReader     fr = new FileReader(filename); //Open file
    BufferedReader br = new BufferedReader(fr);   // and create a reader
    
    String line;
    while((line = br.readLine()) != null) { //while a line is read(until EOF)
      Employee tmp_emp = new Employee();    //create a temporary ref to a new 
      tmp_emp.set(line);                    // Employee and set metadata from
      employees.add(tmp_emp);               // line read - then add to list
    }
    
    br.close();
  }
  
  public void save(String filename) throws Exception {
    FileWriter     fw = new FileWriter(filename); //Open file
    BufferedWriter bw = new BufferedWriter(fw);   // and create a writer
    
    String line;
    for(Employee employee : employees) { //for each employee
      bw.write(employee.toString() + "\n");
    }
    
    bw.close();
  }
  
  public void print() {
    for(Employee employee : employees) { //for each employee
      //OUTPUT:
      //print chart for employee
      System.out.printf("Employee #%04d:\n",           employee.getID());
      System.out.printf("Name:          %s %s\n",
                        employee.getFirstName(),       employee.getLastName());
      System.out.printf("Age:           %d\n",         employee.getAge());
      System.out.printf("Salary:        $%.2f/hour\n", employee.getSalary());
      System.out.printf("Contract Type: %s-time\n\n",
                        employee.getFullTime() ? "Full" : "Part");
    }
  }
}
