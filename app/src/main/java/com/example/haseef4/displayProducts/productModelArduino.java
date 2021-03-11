package com.example.haseef4.displayProducts;

import com.google.firebase.database.DatabaseReference;

public class productModelArduino {

    String name,company,product_id, image;
    Long restock, weight2, itemWight;
    DatabaseReference PRef;


    public productModelArduino(String name, String company, String products_id, String image, Long restock, Long weight2, Long itemWight) {
        this.name = name;
        this.company = company;
        this.product_id = products_id;
        this.image = image;
        this.restock = restock;
        this.weight2 = weight2;
        this.itemWight=itemWight;
    }
    public productModelArduino() {
    }
    public Long getItemWight() {
        return itemWight;
    }

    public void setItemWight(Long itemWight) {
        this.itemWight = itemWight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProducts_id() {
        return product_id;
    }

    public void setProducts_id(String products_id) {
        this.product_id = products_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getRestock() {
        return restock;
    }

    public void setRestock(Long restock) {
        this.restock = restock;
    }

    public Long getWeight2() {
        return weight2;
    }

    public void setWeight2(Long weight2) {
        if(weight2==0){
            setRestock((long) 0);
    }
         //PRef.child("productArduino").child("dairyProducts").child("D1").child("restock").setValue(0);
        }
    }
