package com.example.hm4.mvcAnother.entitesB;

public class ProductB {
    private int id;
    private String title;
    private int cost;

    public ProductB(int id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public ProductB() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCost() {
        return cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
