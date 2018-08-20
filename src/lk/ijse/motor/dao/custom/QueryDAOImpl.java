/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.dao.custom;

import java.sql.ResultSet;
import java.sql.SQLException;
import lk.ijse.motor.dao.CrudUtil;
import lk.ijse.motor.dao.QueryDAO;

/**
 *
 * @author Ranga Lankathilaka
 */
public class QueryDAOImpl implements QueryDAO{

    @Override
    public int getIncome() throws ClassNotFoundException, SQLException {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ResultSet rst = CrudUtil.executeQuery("select  sum(p.buying_price-inv.selling_price) from part p,invoicedetail inv where p.pid=inv.pid");
        if(rst.next()){
            int income=rst.getInt(1);
            return income;
        }
        return 0;
    
    }
    
}
