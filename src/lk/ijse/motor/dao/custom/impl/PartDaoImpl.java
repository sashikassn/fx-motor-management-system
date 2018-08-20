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
import lk.ijse.motor.dao.custom.PartDAO;
import lk.ijse.motor.entity.Part;

/**
 *
 * @author Ranga Lankathilaka
 */
public class PartDaoImpl implements PartDAO{
//     pid           | int(11)     | NO   | PRI | NULL    |       |
//| pname         | varchar(45) | NO   |     | NULL    |       |
//| buying_price  | varchar(45) | NO   |     | NULL    |       |
//| selling_price | varchar(45) | NO   |     | NULL    |       |
//| qty           | varchar(45) | NO   |     | NULL    |       |
//| supplier      | varchar(45) | YES  |     | NULL    |

    @Override
    public boolean save(Part entity) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    
        return CrudUtil.executeUpdate("insert into part values (?,?,?,?,?,?)",entity.getPid(),entity.getPname(),entity.getBuying_price(),entity.getSelling_price(),entity.getQty(),entity.getSupplier());
    
    
    
    }

    @Override
    public boolean update(Part entity) throws Exception {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    return CrudUtil.executeUpdate("update part set pname=?,buying_price=?,selling_price=?,qty=?,supplier=? where pid=?",entity.getPname(),entity.getBuying_price(),entity.getSelling_price(),entity.getQty(),entity.getSupplier(),entity.getPid());
    
    
    
    
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
    return CrudUtil.executeUpdate("delete from part where pid=?",id);
    
    
    }

    @Override
    public Part find(Integer pid) throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ResultSet rst = CrudUtil.executeQuery("select * from part where pid=?",pid);
        if(rst.next()){
            return new Part(rst.getInt(1),rst.getString(2), rst.getInt(3), rst.getInt(4), rst.getInt(5), rst.getString(6));
        }else{
            return  null;
        }
    
    
    }

    @Override
    public ArrayList<Part> getAll() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ResultSet rst = CrudUtil.executeQuery("select * from part");
        ArrayList<Part> arr=new ArrayList<>();
        
        
        
        while (rst.next()) {            
            Part part=new Part(rst.getInt(1),rst.getString(2), rst.getInt(3), rst.getInt(4), rst.getInt(5), rst.getString(6));
            arr.add(part);
        }
    
    return arr;
    
    
    
    }

    @Override
    public boolean updateQty(Part entity) throws Exception {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    
    return CrudUtil.executeUpdate("update part set  qty=? where pid=?;",entity.getQty(),entity.getPid());
    
    }

    @Override
    public ArrayList<Part> showQtyLessFive() throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ResultSet rst = CrudUtil.executeQuery("select pid,pname from part where qty<5");
        ArrayList<Part> arr=new ArrayList<>();
       
        while (rst.next()) {     
            //  rst.getInt(1);
            Part part = new Part(rst.getInt(1),rst.getString(2), 0, 0, 0, null);
            arr.add(part);
            
        }
        
        return arr;
        
    
    }

    @Override
    public ArrayList<Part> showSumQty() throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Part> arr=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select pid,sum(qty) from invoicedetail group by pid order by sum(qty) desc limit 8");
        while (rst.next()) {            
            
            
            
            Part part=new Part(rst.getInt(1),null, 0, 0, rst.getInt(2),null);
            arr.add(part);
        }
    
    return  arr;
    }

  
    
}
