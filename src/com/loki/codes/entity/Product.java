package com.loki.codes.entity;



public class Product {
    private String code;
    private int price;
    private  String name;

    public Product(String code, int price, String name) {
        this.code = code;
        this.price = price;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
