package com.company;

public class Jeux extends StockItem{
    private  String platform;
    public Jeux(float rentelPrice, String title, String itemID,String platform) {
        super(rentelPrice, title, itemID);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
