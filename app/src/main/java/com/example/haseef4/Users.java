package com.example.haseef4;

public class Users {

    private String id;
    private String email;
    private String password;
    private static String type;
    private String line;
    private String image;
    public Users(){


    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
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

    public Users(String id , String email , String password , String type,String line,String image) {
        this.id = id;
        this.email=email;
        this.password=password;
        this.type=type;
        this.line=line;
        this.image=image;

    }
}
