package com.cc.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App 
{
 // Argumente für Connection-Parameter
        static String conURL = "jdbc:mysql://139.162.164.50:3306/mydb";
        static String usrStr = "remote_user";
        static String usrPwd = "neues_passwort";
        
        static Connection con;
        static Statement stmt;
        static ResultSet rs;


    public static void main(String[] args) {


        try {
          
          // Load SQL Server JDBC driver and establish connection.
          System.out.print("Connecting to SQL Server ... ");

   
          try (Connection con = DriverManager.getConnection(conURL, usrStr, usrPwd)) {
            System.out.println("Success!");
            System.out.println(con);
        

             // Creating a statement object
             Statement stmt = con.createStatement();

             // Executing the query and storing the result in a ResultSet object
             ResultSet rs = stmt.executeQuery("SELECT * FROM mydb.t_mitarbeiter");
             System.out.println(rs);

            // Iterating through the ResultSet and printing the contents
            while (rs.next()) {

            // fetch
             String name = rs.getString("name");
             String surname = rs.getString("surname");
                int age = rs.getInt("age");
             int salary = rs.getInt("salary");
             int employee_id = rs.getInt("employee_id");

            // print
            String printStr =   "ID: " + employee_id +
                                     ", Name: " + surname + " " + name +
                                       ", Salary: " + salary +
                                          ", Age: " + age;
             System.out.println(printStr);
}

            // Objekte schließen
            rs.close();
            stmt.close();
            con.close();



            
          } catch (Exception e) {
            e.printStackTrace();
          }


        }   catch (Exception e) {
            e.printStackTrace();
        }


    }
    
}