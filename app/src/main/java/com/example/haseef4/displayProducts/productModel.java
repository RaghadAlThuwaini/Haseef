package com.example.haseef4.displayProducts;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class productModel {
    String name, image,company,product_id, sensor;
    Long restock, weight;
//    private DatabaseReference Rref;
//    private DatabaseReference Sref;

    public productModel(String name, Long restock, String image,String company,String product_id, Long weight,String sensor) {
        this.name = name;
        this.restock = restock;
        this.image = image;
        this.company=company;
        this.product_id=product_id;
        this.weight = weight;
        this.sensor = sensor;
    }

    public productModel() {
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

    public Long getRestock() {
        return restock;
    }

    public void setRestock(Long restock) {
//        Sref = FirebaseDatabase.getInstance().getReference().child("Sensors");
//        String getReadaleWeight = Sref.child(getSensor()).child("Weight").get().toString();
//        this.restock = Long.valueOf(getReadaleWeight);
        this.restock = restock;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public String getCompany() {
        return company;
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
