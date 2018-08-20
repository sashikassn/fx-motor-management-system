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
public class InvoiceDetail_PK {
    
    private  int iid;
    private int pid;

    public InvoiceDetail_PK() {
    }

    public InvoiceDetail_PK(int iid, int pid) {
        this.iid = iid;
        this.pid = pid;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
    
    
}
