/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.bussiness.custom.impl;

import java.util.ArrayList;
import lk.ijse.motor.bussiness.custom.PartBO;
import lk.ijse.motor.dao.DAOFactory;
import lk.ijse.motor.dao.custom.PartDAO;
import lk.ijse.motor.dto.PartDTO;
import lk.ijse.motor.entity.Part;

/**
 *
 * @author Ranga Lankathilaka
 */
public class PartBOImpl implements PartBO{
    
   private PartDAO partDAO;
    
    
    public PartBOImpl(){
   this.partDAO= (PartDAO) DAOFactory.getInstance().getDaotype(DAOFactory.Daotype.PART);
    }

    @Override
    public boolean save(PartDTO dto) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Part part=new Part(dto.getPid(),dto.getPname(),dto.getBuying_price(),dto.getSelling_price(),dto.getQty(),dto.getSupplier());
    
    return partDAO.save(part);
    
    
    }

    @Override
    public boolean delete(Integer pid) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    
    return partDAO.delete(pid);
    }

    @Override
    public ArrayList<PartDTO> getAll() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    
    ArrayList<Part> arr=partDAO.getAll();
    ArrayList<PartDTO> arr2=new ArrayList<>();
        for (Part part : arr) {
            
            
        int pid = part.getPid();
        String pname = part.getPname();
        int buying_price = part.getBuying_price();
        int selling_price = part.getSelling_price();
            int qty = part.getQty();
        String supplier = part.getSupplier();
            
        PartDTO partDTO=new PartDTO(pid, pname, buying_price, selling_price, qty, supplier);
       
        arr2.add(partDTO);
        
        }
    
    
    return arr2;
    
    }

    @Override
    public ArrayList<PartDTO> getAllPartID() throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
       ArrayList<PartDTO> arr=getAll();
       ArrayList<PartDTO> arr2=new ArrayList<>();
        for (PartDTO partDTO : arr) {
            int id=partDTO.getPid();
            PartDTO partDTO1=new PartDTO(id);
            arr2.add(partDTO1);
        }
        
       return arr2;
    }

    @Override
    public PartDTO find(Integer pid) throws Exception {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    ArrayList<Part> arr=partDAO.getAll();
//   
//    for (Part part : arr) {
////        int pid1 = part.getPid();
////        String pname = part.getPname();
////        int buying_price = part.getBuying_price();
//       int selling_price = part.getSelling_price();
//       int qty = part.getQty();
////        String supplier = part.getSupplier();
//        String pname = part.getPname();
//        return new PartDTO(pname, selling_price,qty);
//        // arr2.add(partDTO);
//
//        
//        }
//       return null;
//
//
       Part find = partDAO.find(pid);
       String pname = find.getPname();
       int selling_price = find.getSelling_price();
       int qty = find.getQty();
    
    return new PartDTO(pname,selling_price, qty);
    }

    @Override
    public boolean updateQty(PartDTO dto) throws Exception {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
   Part part=new Part(dto.getPid(),null, 0, 0, dto.getQty(),null);
      
      return partDAO.updateQty(part);
    
    
    
    }

    @Override
    public boolean update(PartDTO dto) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  //Part part=partDAO.update();
   Part part=new Part(dto.getPid(),dto.getPname(),dto.getBuying_price(), dto.getSelling_price(), dto.getQty(), dto.getSupplier());
   
    return partDAO.update(part);
    
    
    
    }

    @Override
    public ArrayList<PartDTO> showQtyLessFive() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    ArrayList<Part> arr=partDAO.showQtyLessFive();
    ArrayList<PartDTO> arr2=new ArrayList<>();
        for (Part part : arr) {
        int pid = part.getPid();
        String name=part.getPname();
        PartDTO partDTO=new PartDTO(pid, name);
            //System.out.println("ggggggggggggg"+name);
        arr2.add(partDTO);
        }
 return arr2;
    
    
    }

    @Override
    public ArrayList<PartDTO> showSumQty() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
    ArrayList<Part> arr=partDAO.showSumQty();
    ArrayList<PartDTO> arr2=new ArrayList<>();
        for (Part part : arr) {
        int pid = part.getPid();
        int qty = part.getQty();
        
        PartDTO partDTO=new PartDTO(pid, qty);
        arr2.add(partDTO);
        
        
        }
    
    return arr2;
    
    }

    
    
    

  
    
}
