/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.entity;

/**
 *
 * @author Ranga Lankathilaka
 */
public class Invoice {

    private int iid;
    private String discription;
    
    private int cid;

    public Invoice() {
    }

    public Invoice(int iid, String discription, int cid) {
        this.iid = iid;
        this.discription = discription;
        this.cid = cid;
    }

    
    

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    
    
    

}
