package com.company;

public class StockItem {
    private float rentelPrice ;
    private String title ;
    private String itemID;

    public StockItem(float rentelPrice, String title, String itemID) {
        this.rentelPrice = rentelPrice;
        this.title = title;
        this.itemID = itemID;
    }

    public float getRentelPrice() {
        return rentelPrice;
    }

    public void setRentelPrice(float rentelPrice) {
        this.rentelPrice = rentelPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

}
