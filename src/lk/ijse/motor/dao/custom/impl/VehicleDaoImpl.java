/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.dao.custom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.motor.dao.CrudDAO;
import lk.ijse.motor.dao.CrudUtil;
import lk.ijse.motor.dao.custom.VehecleDAO;
import lk.ijse.motor.entity.Vehicle;

/**
 *
 * @author Ranga Lankathilaka
 */
public class VehicleDaoImpl implements VehecleDAO{

    @Override
    public boolean save(Vehicle entity) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
        return CrudUtil.executeUpdate("insert into vehicle values (?,?,?,?)",entity.getVid(),entity.getType(),entity.getIssue(),entity.getCid());
    
    }

    @Override
    public boolean update(Vehicle entity) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    return CrudUtil.executeUpdate("update vehicle set type=?,issue=?,cid=? where vid=?", entity.getType(),entity.getIssue(),entity.getCid(),entity.getVid());
    
    
    
    
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        return CrudUtil.executeUpdate("delete from vehicle where vid=?",id);
    }

    @Override
    public Vehicle find(Integer id) throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ResultSet rst = CrudUtil.executeQuery("select * from vehicle where vid =?", id);
    if(rst.next()){
       return new Vehicle(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4));
    }else{
        return null;
    }
    }

    @Override
    public ArrayList<Vehicle> getAll() throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ResultSet rst = CrudUtil.executeQuery("select * from vehicle");
        ArrayList<Vehicle> arrayList=new ArrayList<>();
        while (rst.next()) {            
            Vehicle vehicle=new Vehicle(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4));
            arrayList.add(vehicle);
        }
    
    return arrayList;
    }

    @Override
    public int getVehicleCount() throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ResultSet rst = CrudUtil.executeQuery("select count(*) from vehicle");
        if(rst.next()){
        return rst.getInt(1);
        
        }else{
            
        }
        return 0;
    
    }
    
}
