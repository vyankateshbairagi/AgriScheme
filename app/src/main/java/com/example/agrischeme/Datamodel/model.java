package com.example.agrischeme.Datamodel;



public class model {
    String name, address, phone,filename,fileurl,pan,fileurl1,uatara,fileurl2;


    public model(String name, String address, String phone, String filename, String fileurl, String pan, String fileurl1, String uatara, String fileurl2) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.filename = filename;
        this.fileurl = fileurl;
        this.pan = pan;
        this.fileurl1 = fileurl1;
        this.uatara = uatara;
        this.fileurl2 = fileurl2;
    }

    public model() {

    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    public String getFileurl1() {
        return fileurl1;
    }

    public void setFileurl1(String fileurl1) {
        this.fileurl1 = fileurl1;
    }

    public String getFileurl2() {
        return fileurl2;
    }

    public void setFileurl2(String fileurl2) {
        this.fileurl2 = fileurl2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getUatara() {
        return uatara;
    }

    public void setUatara(String uatara) {
        this.uatara = uatara;
    }
}