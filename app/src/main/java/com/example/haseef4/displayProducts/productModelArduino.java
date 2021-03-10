package com.example.haseef4.displayProducts;

public class productModelArduino {

    String name,company,product_id, image;
    Long restock, weight;

    public productModelArduino(String name, String company, String products_id, String image, Long restock, Long weight) {
        this.name = name;
        this.company = company;
        this.product_id = products_id;
        this.image = image;
        this.restock = restock;
        this.weight = weight;
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

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }
}
