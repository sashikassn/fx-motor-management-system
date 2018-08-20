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
import lk.ijse.motor.dao.custom.CustomerDetailDAO;
import lk.ijse.motor.entity.Customer;
import lk.ijse.motor.entity.CustomerDetail;
import lk.ijse.motor.entity.CustomerDetail_PK;

/**
 *
 * @author Ranga Lankathilaka
 */
public class CustomerDetailDaoImpl implements CustomerDetailDAO{

    @Override
    public boolean save(CustomerDetail entity) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
    return CrudUtil.executeUpdate("insert into customerdetail values (?,?,curdate())",entity.getCustomerDetail_PK().getCid(),entity.getCustomerDetail_PK().getPid());
    
    
    }

    @Override
    public boolean update(CustomerDetail entity) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
    return CrudUtil.executeUpdate("update customerdetail set date=? where cid=? and pid=?", entity.getDate(),entity.getCustomerDetail_PK().getCid(),entity.getCustomerDetail_PK().getPid());
    
    
    
    
    }

    @Override
    public boolean delete(CustomerDetail_PK id) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
    return CrudUtil.executeUpdate("delete from customerdetail where cid=? and pid=?",id.getCid(),id.getPid() );
    
    
    
    
    
    
    }

    @Override
    public CustomerDetail find(CustomerDetail_PK id) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ResultSet rst = CrudUtil.executeQuery("select * from customerdetail where cid=? and pid=?",id.getCid(),id.getPid());
        
        if(rst.next()){
           return new CustomerDetail(rst.getDate(1),rst.getInt(2),rst.getInt(2));
        }else{
            return null;
        }
    
    
    
    
    }

    @Override
    public ArrayList<CustomerDetail> getAll() throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ResultSet rst = CrudUtil.executeQuery("select * from cusdetail");
        ArrayList<CustomerDetail> customerDetails=new ArrayList<>();
        while (rst.next()) {            
            CustomerDetail customerDetail=new CustomerDetail(rst.getDate(1), rst.getInt(2), rst.getInt(3));
            customerDetails.add(customerDetail);
        }
    
    
    
    return customerDetails;
    
    
    
    
    }

  
    
    
}
