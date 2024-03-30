package com.example.food4thought;

public class Userfood {
    String Hotelname,chapati,dal,sabji,address,time,status,number;

    public Userfood() {
    }

    public Userfood(String hotelname, String chapati, String dal, String sabji, String address, String time, String status, String number) {
        Hotelname = hotelname;
        this.chapati = chapati;
        this.dal = dal;
        this.sabji = sabji;
        this.address = address;
        this.time = time;
        this.status = status;
        this.number = number;
    }

    public String getHotelname() {
        return Hotelname;
    }

    public void setHotelname(String hotelname) {
        Hotelname = hotelname;
    }

    public String getChapati() {
        return chapati;
    }

    public void setChapati(String chapati) {
        this.chapati = chapati;
    }

    public String getDal() {
        return dal;
    }

    public void setDal(String dal) {
        this.dal = dal;
    }

    public String getSabji() {
        return sabji;
    }

    public void setSabji(String sabji) {
        this.sabji = sabji;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
