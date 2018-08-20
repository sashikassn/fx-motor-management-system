/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.motor.dao.CrudUtil;
import lk.ijse.motor.dao.custom.InvoiceDetailDAO;
import lk.ijse.motor.entity.InvoiceDetail;
import lk.ijse.motor.entity.InvoiceDetail_PK;

/**
 *
 * @author Ranga Lankathilaka
 */
public class InvoiceDetailDaoImpl implements InvoiceDetailDAO{
//    pid           | int(11)     | NO   | PRI | NULL    |       |
//| iid           | int(11)     | NO   | PRI | NULL    |       |
//| detail        | varchar(45) | YES  |     | NULL    |       |
//| qty           | int(11)     | YES  |     | NULL    |       |
//| selling_price | int(11)     | YES  |     | NULL    |       |
//| total         | int(11)     | YES  |     | NULL    |       |
//| total_amount  | int(
                                                                                                                                        
    @Override
    public boolean save(InvoiceDetail entity) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
    
    
        return CrudUtil.executeUpdate("insert into invoicedetail values (?,?,?,?,?,?,?)", entity.getInvoiceDetail_PK().getPid(),entity.getInvoiceDetail_PK().getIid(),entity.getDetail(),entity.getQty(),entity.getSelling_price(),entity.getTotal(),entity.getTotal_amount());
    
    
    }

    @Override
    public boolean update(InvoiceDetail entity) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    return CrudUtil.executeUpdate("update invoicedetail set detail=? ,qty=?,selling_price=?,total=?,total_amount=? where pid=? and iid=?",entity.getDetail(),entity.getQty(),entity.getSelling_price(),entity.getTotal(),entity.getTotal_amount(),entity.getInvoiceDetail_PK().getPid(),entity.getInvoiceDetail_PK().getIid());
    
    }

    @Override
    public boolean delete(InvoiceDetail_PK id) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    
    return CrudUtil.executeUpdate("delete from invoice detail where pid=? and iid=?",id.getPid(),id.getIid());
    
    }

    @Override
    public InvoiceDetail find(InvoiceDetail_PK id) throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ResultSet rst = CrudUtil.executeQuery("select * from invoicedetail where pid=? and iid=?",id.getPid(),id.getIid());
        if(rst.next()){
            return new InvoiceDetail(rst.getString(1),rst.getInt(2),rst.getInt(3),rst.getInt(4),rst.getInt(5),rst.getInt(6),rst.getInt(7));
        }else{
            return  null;
        }
    
    
    
    
    }

    @Override
    public ArrayList<InvoiceDetail> getAll() throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ResultSet rst = CrudUtil.executeQuery("select * from invoicedetail");
        ArrayList<InvoiceDetail> arr=new ArrayList<>();
        while (rst.next()) {            
            InvoiceDetail invoiceDetail=new InvoiceDetail(rst.getString(1),rst.getInt(2),rst.getInt(3),rst.getInt(4),rst.getInt(5),rst.getInt(6),rst.getInt(7));
            arr.add(invoiceDetail);
        }
        return arr;
    }
    
}
