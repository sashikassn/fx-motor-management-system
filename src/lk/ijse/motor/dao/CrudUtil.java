/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lk.ijse.motor.db.DBConnection;

/**
 *
 * @author Ranga Lankathilaka
 */
public class CrudUtil {
    
    
    public static PreparedStatement getPrepareStatement(String sql,Object... params) throws ClassNotFoundException, SQLException{
        Connection con=DBConnection.getBConnection().getConnection();
      
        PreparedStatement pst=con.prepareStatement(sql);
        
        for (int i = 0; i <params.length; i++) {
            pst.setObject(i+1,params[i]);
        }
        return pst;
       
    }
    
    public static ResultSet executeQuery(String sql,Object...params) throws ClassNotFoundException, SQLException{
       return getPrepareStatement(sql, params).executeQuery();
       
        
    }
    
    public static  boolean executeUpdate(String sql,Object...params) throws ClassNotFoundException, SQLException{
      return getPrepareStatement(sql, params).executeUpdate()>0;
    }
    
}
