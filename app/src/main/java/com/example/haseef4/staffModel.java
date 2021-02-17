package com.example.haseef4;

public class staffModel {
    private String age;
    private String location;
    private String staffName;
    private String working_since;
    private String staffID;
    private String image;

    public staffModel(String Age, String Location, String Name, String Working_since, String staffID, String image){
        this.age=Age;
        this.location=Location;
        this.staffName=Name;
        this.working_since=Working_since;
        this.staffID = staffID;
        this.image = image;
    }

    public staffModel() {
    }

    public String getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getWorking_since() {
        return working_since;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStaffName(String name) {
        this.staffName = name;
    }

    public void setWorking_since(String working_since) {
        this.working_since = working_since;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
