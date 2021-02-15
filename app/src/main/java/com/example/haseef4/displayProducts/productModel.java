package com.example.haseef4.displayProducts;

public class productModel {
    String name, image;
    Long restock;

    public productModel(String name, Long restock, String image) {
        this.name = name;
        this.restock = restock;
        this.image = image;
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
        this.restock = restock;
    }
}
