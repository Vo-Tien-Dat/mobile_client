package com.hoanganhnhan.catalog.models;

import java.util.List;

public class Category {
    private  String nameCagetory;
    private List<Laptop> laptops;

    public Category(String nameCagetory, List<Laptop> laptops) {
        this.nameCagetory = nameCagetory;
        this.laptops = laptops;
    }

    public String getNameCagetory() {
        return nameCagetory;
    }

    public void setNameCagetory(String nameCagetory) {
        this.nameCagetory = nameCagetory;
    }

    public List<Laptop> getProducts() {
        return laptops;
    }

    public void setProducts(List<Laptop> laptops) {
        this.laptops = laptops;
    }
}
