/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.dao.custom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.motor.dao.CrudUtil;
import lk.ijse.motor.dao.custom.InvoiceDAO;
import lk.ijse.motor.entity.Invoice;

/**
 *
 * @author Ranga Lankathilaka
 */
public class InvoiceDaoImpl implements InvoiceDAO{
   @Override
    public boolean save(Invoice entity) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return CrudUtil.executeUpdate("insert into invoice values(?,?,?) ",entity.getIid(),entity.getDiscription(),entity.getCid());
    
    
    
    }

    @Override
    public boolean update(Invoice entity) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    
   return CrudUtil.executeUpdate("update invoice set values discription=?,cid=? where iid=?" , entity.getDiscription(),entity.getCid(),entity.getIid());
    
    
    
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    return CrudUtil.executeUpdate("delete from invoice where iid=?",id);
    
    }

    @Override
    public Invoice find(Integer id) throws Exception {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ResultSet rst = CrudUtil.executeQuery("select * from invoice where iid=?",id);
        if (rst.next()){
        return new Invoice(rst.getInt(1),rst.getString(2),rst.getInt(3));
        
        }else{
            return  null;
        }
    
    }

    @Override
    public ArrayList<Invoice> getAll() throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ResultSet rst = CrudUtil.executeQuery("select * from invoice");
        ArrayList<Invoice> arr=new ArrayList<>();
        while (rst.next()) {            
            Invoice invoice=new Invoice(rst.getInt(1), rst.getString(2), rst.getInt(3));
            arr.add(invoice);
            
        }
    
    return  arr;
    
    }

    @Override
    public Invoice getLastIID() throws ClassNotFoundException, SQLException {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       ResultSet rst = CrudUtil.executeQuery("select iid from invoice order by iid desc limit 1");
      if(rst.next()){
         rst.getInt(1);
         return new Invoice(rst.getInt(1),null, 0);
      }
      else{
          return null;
              }
    
    }

   
  
}
