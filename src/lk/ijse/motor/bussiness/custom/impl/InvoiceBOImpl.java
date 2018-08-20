/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.bussiness.custom.impl;

import java.util.ArrayList;
import lk.ijse.motor.bussiness.custom.InvoiceBO;
import lk.ijse.motor.dao.DAOFactory;
import lk.ijse.motor.dao.custom.InvoiceDAO;
import lk.ijse.motor.dto.InvoiceDTO;
import lk.ijse.motor.entity.Invoice;

/**
 *
 * @author Ranga Lankathilaka
 */
public class InvoiceBOImpl implements InvoiceBO{
    InvoiceDAO invoiceDAO;

    public InvoiceBOImpl() {
        
        invoiceDAO=(InvoiceDAO) DAOFactory.getInstance().getDaotype(DAOFactory.Daotype.INVOICE);
    }
    

    @Override
    public boolean save(InvoiceDTO entity) throws Exception{
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Invoice invoice=new Invoice(0,entity.getDiscription(),entity.getCid());
        return invoiceDAO.save(invoice);
        
    
    
    
    }

    @Override
    public InvoiceDTO getLastIID() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Invoice lastIID = invoiceDAO.getLastIID();
        int iid;
        
         iid = lastIID.getIid();
        
        return new InvoiceDTO(iid);
        }
    
    
    
}
