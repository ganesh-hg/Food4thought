package com.example.food4thought;

public class Hotelfeed {

    String ngoname,address,feedback,hotelname;

    public Hotelfeed() {
    }

    public Hotelfeed(String ngoname, String address, String feedback, String hotelname) {
        this.ngoname = ngoname;
        this.address = address;
        this.feedback = feedback;
        this.hotelname = hotelname;
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

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }
}
