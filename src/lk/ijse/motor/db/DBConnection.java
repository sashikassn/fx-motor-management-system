/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ranga Lankathilaka
 */
public class DBConnection {
    
    
    private static DBConnection dbconnection;
     private Connection con;
    
    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/motor","root","asdf1234");
        
        
    }
    public static DBConnection getBConnection() throws ClassNotFoundException, SQLException{
       if(dbconnection==null){
           dbconnection=new DBConnection();
       }
        
        
        return dbconnection;
    }
    public Connection getConnection(){
        return con;
    }

   
}
