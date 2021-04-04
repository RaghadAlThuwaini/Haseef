package com.example.haseef4.displayProducts;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class productModelArduino {

    String name,company,product_id, image;
    long restock, weight2, itemWeight;
    long weightPerItem;
    DatabaseReference PRef = FirebaseDatabase.getInstance().getReference();


    public productModelArduino(String name, String company, String products_id, String image, long restock, long weight2, long itemWeight) {
        this.name = name;
        this.company = company;
        this.product_id = products_id;
        this.image = image;
        this.restock = restock;
        this.weight2 = weight2;
        this.itemWeight=itemWeight;
    }
    public productModelArduino() {
    }
    public long getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(long itemWeight) {
        this.itemWeight = itemWeight;
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

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public long getWeightPerItem() {
        return weightPerItem;
    }

    public void setWeightPerItem(long weightPerItem) {
        this.weightPerItem = weightPerItem;
    }
    public void setWeight2(long weight2) {
//        if(weight2==0){
//            setRestock((long) 0);
//    }
        long w = Math.abs(weightPerItem);
        setRestock((long)(weight2/w));
//        if(getItemWeight()>0L)
//            setRestock((long)(weight2/getItemWeight()));
        PRef.child("productArduino").child("dairyProducts").child(getProduct_id()).child("restock").setValue((long)(weight2/w));
    }



    public long getRestock() {
        return restock;
    }

    public void setRestock(long restock) {
        this.restock = restock;
    }

    public long getWeight2() {
        return weight2;
    }


    }
