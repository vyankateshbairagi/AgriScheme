package com.example.agrischeme.Datamodel;

public class ProductModel {
    public String product_id;
    public String title;
    public String category;
    public String details;
    public String photo;

    public ProductModel() {
        this.product_id = product_id;
        this.title = title;

        this.category = category;
        this.details = details;
        this.photo = photo;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
