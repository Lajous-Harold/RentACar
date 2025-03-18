package com.example.RentACar;

public class Car {

    String plateNumber;
    String brand;
    float price;
    boolean isRented;

    public Car(String plateNumber, String brand, float price) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
        this.isRented = false;
    }
    public String getPlateNumber() {
        return plateNumber;
    }
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public boolean isRented() { 
        return isRented; 
    }
    public void setRented(boolean rented) { 
        isRented = rented; 
    }

     
}
