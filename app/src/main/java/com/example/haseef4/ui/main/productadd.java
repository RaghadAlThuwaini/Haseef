package com.example.haseef4.ui.main;

public class productadd {
    String  product_name;
    String product_type;
    String product_location;
    String product_id;

    public productadd() {
    }

    public productadd(String product_name , String product_type, String product_location, String product_id) {
        this.product_name = product_name;
        this.product_type= product_type;
        this.product_id=product_id;
        this.product_location= product_location;
    }


    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getProduct_location() {
        return product_location;
    }

    public void setProduct_location(String product_location) {
        this.product_location = product_location;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }
}
