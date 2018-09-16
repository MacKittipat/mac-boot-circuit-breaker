package com.mackittipat.customerservice.model;

import java.util.List;

public class Customer {

    private int id;
    private String name;
    private List<Product> purchasedProductList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getPurchasedProductList() {
        return purchasedProductList;
    }

    public void setPurchasedProductList(List<Product> purchasedProductList) {
        this.purchasedProductList = purchasedProductList;
    }
}
