package com.example.haseef4;

public class Users {

    private String id;
    private String email;
    private String password;
    private static String type;

    public Users(){


    }

    public String getId() {
        return id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static String getType() {
        return type;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Users(String id , String email , String password , String type) {
        this.id = id;
        this.email=email;
        this.password=password;
        this.type=type;
    }
}
