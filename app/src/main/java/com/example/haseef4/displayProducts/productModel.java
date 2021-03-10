package com.example.haseef4.displayProducts;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class productModel {

    String name,location, image,company,product_id, sensor,product_number,restock;
    Long restock1, weight;
    String restock2;

//    private DatabaseReference Rref;
//    private DatabaseReference Sref;

    public productModel() {
    }

  /*  public productModel(String name, String restock, String location, String image, String company, String product_id, Long weight, String sensor, String product_number) {
        this.name = name;
        this.restock = restock;
        this.image = image;
        this.company=company;
        this.product_id=product_id;
        this.weight = weight;
        this.sensor = sensor;
        this.product_number=product_number;
        this.location=location;
    }*/

    public productModel(String name, String company, String  restock2) {
        this.name = name;
        this.company = company;
        this.restock2 = restock2;

    }

    public productModel(String name, String image, String company, String restock, String product_id) {
        this.name=name;
        this.image=image;
        this.company=company;
        this.restock=restock;
        this.product_id=product_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRestock() {
        return restock;
    }

    public void setRestock(String restock) {
     this.restock=restock;

    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public String getCompany() {
        return company;
    }

    public String getProduct_number() {
        return product_number;
    }

    public void setProduct_number(String product_number) {
        this.product_number = product_number;
    }

    public String getProduct_id() {
        return product_id;
    }
    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }
}
