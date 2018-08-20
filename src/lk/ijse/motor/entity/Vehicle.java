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
public class Vehicle {
 
  private  int vid;  
    private String type;
     private String issue;
     private  int cid;

    public Vehicle() {
    }

    public Vehicle(int vid, String type, String issue, int cid) {
        this.vid = vid;
        this.type = type;
        this.issue = issue;
        this.cid = cid;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "vid=" + vid + ", type=" + type + ", issue=" + issue + ", cid=" + cid + '}';
    }
     
     
     
     
     
     
}
