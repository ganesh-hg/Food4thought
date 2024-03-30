package com.example.food4thought;

public class Ngooder {



    String ngoname,address,hname,number;

    public Ngooder() {
    }

    public Ngooder(String ngoname, String address, String hname, String number) {
        this.ngoname = ngoname;
        this.address = address;
        this.hname = hname;
        this.number = number;
    }

    public String getNgoname() {
        return ngoname;
    }

    public void setNgoname(String ngoname) {
        this.ngoname = ngoname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
