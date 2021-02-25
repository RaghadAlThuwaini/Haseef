package com.example.haseef4.displayProducts;

public class productModel {
    String name, image,company,product_id,product_number;
    Long restock;

    public productModel(String name, Long restock, String image,String company,String product_id,String product_number) {
        this.name = name;
        this.restock = restock;
        this.image = image;
        this.company=company;
        this.product_id=product_id;
        this.product_number=product_number;
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
}
