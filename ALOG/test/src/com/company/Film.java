package com.company;

public class Film extends StockItem {

private String actor;
    public Film(float rentelPrice, String title, String itemID,String actor) {
        super(rentelPrice, title, itemID);
        this.actor = actor;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
