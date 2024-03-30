package com.example.food4thought;

public class Ngofeed {

    String hname,address,feedback,ngoname,ngdoadress;

    public Ngofeed() {
    }

    public Ngofeed(String hname, String address, String feedback, String ngoname, String ngdoadress) {
        this.hname = hname;
        this.address = address;
        this.feedback = feedback;
        this.ngoname = ngoname;
        this.ngdoadress = ngdoadress;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getNgoname() {
        return ngoname;
    }

    public void setNgoname(String ngoname) {
        this.ngoname = ngoname;
    }

    public String getNgdoadress() {
        return ngdoadress;
    }

    public void setNgdoadress(String ngdoadress) {
        this.ngdoadress = ngdoadress;
    }
}
