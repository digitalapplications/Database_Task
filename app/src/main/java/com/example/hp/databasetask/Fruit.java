package com.example.hp.databasetask;

/**
 * Created by HP on 10/5/2016.
 */
public class Fruit {
    int fid;
    String fpic;
    String ftype;
    String fname;
    int fcal;
    int fval;
    String fintro;
    String fdetail;
    int fgrams;



    public int getFval() {
        return fval;
    }

    public void setFval(int fval) {
        this.fval = fval;
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }

    public String getFpic() {
        return fpic;
    }

    public void setFpic(String fpic) {
        this.fpic = fpic;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFintro() {
        return fintro;
    }

    public void setFintro(String fintro) {
        this.fintro = fintro;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getFgrams() {
        return fgrams;
    }

    public void setFgrams(int fgrams) {
        this.fgrams = fgrams;
    }

    public String getFdetail() {
        return fdetail;
    }

    public void setFdetail(String fdetail) {
        this.fdetail = fdetail;
    }

    public int getFcal() {
        return fcal;
    }

    public void setFcal(int fcal) {
        this.fcal = fcal;
    }

    @Override
    public String toString() {
        return fname;
    }

}
