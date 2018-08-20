/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.motor.dao.CrudUtil;
import lk.ijse.motor.dao.custom.WarrentyDAO;
import lk.ijse.motor.entity.Warrenty;

/**
 *
 * @author Ranga Lankathilaka
 */
public class WarrentyDaoImpl implements WarrentyDAO{

    @Override
    public boolean save(Warrenty entity) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return CrudUtil.executeUpdate("insert into warrenty values (?,?)", entity.getWid(),entity.getPeriod());
    }

    @Override
    public boolean update(Warrenty entity) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    return CrudUtil.executeUpdate("update warrenty set period=? where wid=?",entity.getPeriod(),entity.getWid());
    
    
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
   return CrudUtil.executeUpdate("delete from warrenty where wid=?",id);
    
    
    }

    @Override
    public Warrenty find(Integer id) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ResultSet rst = CrudUtil.executeQuery("select * from warrenty where wid=?", id);
        
        if (rst.next()){
            return new Warrenty(rst.getInt(1),rst.getString(2));
            
        }
        else{
            return  null;
        }
        
        
    
    
    
    
    
    }

    @Override
    public ArrayList<Warrenty> getAll() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ResultSet rst = CrudUtil.executeQuery("select * from warrenty");
        ArrayList<Warrenty> arr=new ArrayList<>();
        while (rst.next()) {            
            Warrenty warrenty=new Warrenty(rst.getInt(1), rst.getString(2));
            arr.add(warrenty);
            
        }
    
    return  arr;
    
    }
    
}
