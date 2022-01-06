package com.example.ezyfood.model;

public abstract class Beverage {
    private String beverageName;
    private int price;

    public Beverage(String beverageName, int price) {
        this.beverageName = beverageName;
        this.price = price;
    }

    public String getBeverageName() {
        return beverageName;
    }

    public void setBeverageName(String beverageName) {
        this.beverageName = beverageName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
