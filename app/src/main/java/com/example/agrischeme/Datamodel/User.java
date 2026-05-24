package com.example.agrischeme.Datamodel;

public class User{
    private String scheme;
    private String date;
    private String Image;
    private String doc;

    public User(String scheme, String date, String image, String doc) {
        this.scheme = scheme;
        this.date = date;
        Image = image;
        this.doc = doc;
    }

    public User( ) {
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }
}
