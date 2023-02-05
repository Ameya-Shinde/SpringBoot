package com.example.Restaurant.model;

public class Restaurant {
    private String name;
    private String address;
    private String number;
    private String speciality;
    private int totalStaff;
    private int rating;

    public Restaurant(){

    }

    public Restaurant(String name, String address, String number, String speciality, int totalStaff, int rating) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.speciality = speciality;
        this.totalStaff = totalStaff;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getTotalStaff() {
        return totalStaff;
    }

    public void setTotalStaff(int totalStaff) {
        this.totalStaff = totalStaff;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                ", speciality='" + speciality + '\'' +
                ", totalStaff=" + totalStaff +
                ", rating=" + rating +
                '}';
    }
}
