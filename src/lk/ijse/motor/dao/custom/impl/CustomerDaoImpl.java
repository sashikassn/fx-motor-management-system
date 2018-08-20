/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.motor.dao.CrudUtil;
import lk.ijse.motor.dao.custom.CustomerDAO;
import lk.ijse.motor.entity.Customer;

/**
 *
 * @author Ranga Lankathilaka
 */
public class CustomerDaoImpl implements CustomerDAO{

    @Override
    public boolean save(Customer entity) throws Exception {
      
//        System.out.println(entity.getCid());
//        System.out.println(entity.getCname());
//        System.out.println(entity.getContact());
//        System.out.println(entity.getAddress());
         return CrudUtil.executeUpdate("insert into customer values(?,?,?,?)",entity.getCid(),entity.getCname(),entity.getContact(),entity.getAddress());
    }

    @Override
    public boolean update(Customer entity) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 
    return CrudUtil.executeUpdate("update customer set cname=?,contact=?,address=? where cid=?",entity.getCname(),entity.getContact(),entity.getAddress(),entity.getCid());
    
    
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    return CrudUtil.executeUpdate("delete from customer where cid=?",id);
    
    }

    @Override
    public Customer find(Integer id) throws Exception {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ResultSet rst = CrudUtil.executeQuery("select * from customer where cid=?", id);
        if(rst.next()){
        
    return new Customer(rst.getInt(1), rst.getString(2),rst.getInt(3),rst.getString(4));
    
    
    
        }else{
            return  null;
        }
    
    
    
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ResultSet rst = CrudUtil.executeQuery("select * from customer");
         ArrayList<Customer> arrayList=new ArrayList<>();
         while (rst.next()) {            
            
        Customer customer=new Customer(rst.getInt(1),rst.getString(2),rst.getInt(3),rst.getString(4));
    arrayList.add(customer);
         
         }
     
      return arrayList;
    
    
    
    
    }
    
}
