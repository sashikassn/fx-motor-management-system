/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.bussiness.custom.impl;

import lk.ijse.motor.bussiness.custom.CustomerDetailBO;
import lk.ijse.motor.dao.DAOFactory;
import lk.ijse.motor.dao.custom.CustomerDetailDAO;
import lk.ijse.motor.dto.CustomerDetailDTO;
import lk.ijse.motor.entity.CustomerDetail;

/**
 *
 * @author Ranga Lankathilaka
 */
public class CustomerDetailBOImpl implements CustomerDetailBO{
    
    CustomerDetailDAO customerDetailDAO;

    public CustomerDetailBOImpl() {
        
        customerDetailDAO=(CustomerDetailDAO) DAOFactory.getInstance().getDaotype(DAOFactory.Daotype.CUSTOMERDETAIL);
    }
    
    
    
    

    @Override
    public boolean save(CustomerDetailDTO entity) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        CustomerDetail customerDetail=new CustomerDetail(null, entity.getCid(), entity.getPid());
    
 return customerDetailDAO.save(customerDetail);
    
    }
    
}
