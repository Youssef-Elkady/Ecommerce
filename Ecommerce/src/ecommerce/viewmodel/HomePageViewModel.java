/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerce.viewmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author taver
 */
public class HomePageViewModel {
       public void createConnection () throws SQLException {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","IDKWHYUWANTIT123");
            System.out.println("connected");
            Statement stmt = con.createStatement();

        }catch(SQLException ex)
        {
            System.out.println("not found driver");
        }
        // validation serial, 
    }
   public   void createTable () throws SQLException{
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","IDKWHYUWANTIT123");
       //id,name,price
       String t = "CREATE TABLE IF NOT EXISTS Products" + "("+ "id int PRIMARY KEY,"+ "name varchar(25),"+ "price float"+ ");";        
        Statement statement = con.createStatement();
        statement.executeUpdate(t);
   }
}
