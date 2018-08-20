/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.bussiness.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.motor.bussiness.custom.CustomerBO;
import lk.ijse.motor.dao.DAOFactory;
import lk.ijse.motor.dao.custom.CustomerDAO;
import lk.ijse.motor.dao.custom.CustomerDetailDAO;
import lk.ijse.motor.dao.custom.InvoiceDAO;
import lk.ijse.motor.dao.custom.InvoiceDetailDAO;
import lk.ijse.motor.dao.custom.PartDAO;
import lk.ijse.motor.dao.custom.impl.CustomerDaoImpl;
import lk.ijse.motor.db.DBConnection;
import lk.ijse.motor.dto.CustomerDTO;
import lk.ijse.motor.dto.CustomerDetailDTO;
import lk.ijse.motor.dto.InvoiceDTO;
import lk.ijse.motor.dto.InvoiceDetailDTO;
import lk.ijse.motor.dto.PartDTO;
import lk.ijse.motor.entity.Customer;
import lk.ijse.motor.entity.CustomerDetail;
import lk.ijse.motor.entity.Invoice;
import lk.ijse.motor.entity.InvoiceDetail;
import lk.ijse.motor.entity.Part;

/**
 *
 * @author Ranga Lankathilaka
 */
public class CustomerBOImpl implements CustomerBO {
    
    CustomerDAO customerDAO;
    InvoiceDAO invoiceDAO;
    InvoiceDetailDAO invoiceDetailDAO;
    CustomerDetailDAO customerDetailDAO;
    PartDAO partDAO;
    
    public CustomerBOImpl() {
        customerDAO = (CustomerDAO) DAOFactory.getInstance().getDaotype(DAOFactory.Daotype.CUSTOMER);
        invoiceDAO = (InvoiceDAO) DAOFactory.getInstance().getDaotype(DAOFactory.Daotype.INVOICE);
        invoiceDetailDAO = (InvoiceDetailDAO) DAOFactory.getInstance().getDaotype(DAOFactory.Daotype.INVOICEDETAIL);
        customerDetailDAO = (CustomerDetailDAO) DAOFactory.getInstance().getDaotype(DAOFactory.Daotype.CUSTOMERDETAIL);
        partDAO = (PartDAO) DAOFactory.getInstance().getDaotype(DAOFactory.Daotype.PART);
    }

//    @Override
//    public boolean save(CustomerDTO dto) throws Exception {
//       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//   
//    
//    }
    @Override
    public boolean delete(Integer cid) throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        return customerDAO.delete(cid);
        
    }
    
    @Override
    public ArrayList<CustomerDTO> getAll(CustomerDTO dto) throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        ArrayList<Customer> arr = customerDAO.getAll();
        ArrayList<CustomerDTO> arr2 = new ArrayList<>();
        for (Customer customer : arr) {
            int cid = customer.getCid();
            String cname = customer.getCname();
            int contact = customer.getContact();
            String address = customer.getAddress();
            
            CustomerDTO customerDTO = new CustomerDTO(cid, cname, contact, address);
            arr2.add(customerDTO);
        }
        return arr2;
    }
    
    @Override
    public boolean save(CustomerDTO cus, InvoiceDTO inv, ArrayList<InvoiceDetailDTO> arr, CustomerDetailDTO cusde, PartDTO part) throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        Connection con = DBConnection.getBConnection().getConnection();
        con.setAutoCommit(false);
        
        Customer customer = new Customer(cus.getCid(), cus.getCname(), cus.getContact(), cus.getAddress());
        //  System.out.println(dto.getCid());
        boolean save = customerDAO.save(customer);
        if (save) {
            Invoice invoice = new Invoice(inv.getIid(), inv.getDiscription(), inv.getCid());
            
            boolean save1 = invoiceDAO.save(invoice);
            if (save1) {
                InvoiceDetail invoiceDetail = null;
                
                for (InvoiceDetailDTO invoiceDetailDTO : arr) {
                    int pid = invoiceDetailDTO.getPid();
                    int iid = invoiceDetailDTO.getIid();
                    String detail = invoiceDetailDTO.getDetail();
                    int qty = invoiceDetailDTO.getQty();
                    int selling_price = invoiceDetailDTO.getSelling_price();
                    int total = invoiceDetailDTO.getTotal();
                    int total_amount = invoiceDetailDTO.getTotal_amount();
                    System.out.println("/////////////////////" + arr.size());
                    invoiceDetail = new InvoiceDetail(detail, qty, selling_price, total, total_amount, iid, pid);
                    boolean save2 = invoiceDetailDAO.save(invoiceDetail);
                    
                    if (save2) {
                        Part part1 = new Part(part.getPid(), null, 0, 0, part.getQty(), null);
                        System.out.println("----------------" + part.getQty());
                        partDAO.updateQty(part1);
                        
                    } else {
                        con.rollback();
                    }
                }
                CustomerDetail customerDetail = new CustomerDetail(null, cusde.getCid(), cusde.getPid());
                
                boolean save3 = customerDetailDAO.save(customerDetail);
                if (save3) {
                    con.commit();
                    con.setAutoCommit(true);
                    
                } else {
                    con.rollback();
                    con.setAutoCommit(true);
                }
                
            }
            
        } else {
            con.rollback();
        }
        return false;
        
    }
    
    @Override
    public boolean save(CustomerDTO dto) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        Customer customer = new Customer(dto.getCid(), dto.getCname(), dto.getContact(), dto.getAddress());
        return customerDAO.save(customer);
        
    }
    
}
