package com.neutrix.tp4.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class StockItem  {
    private float rentalPrice ;
    private String title;
    @Id
    private String itemId ;




    public StockItem(float rentalPrice, String title) {
        this.rentalPrice = rentalPrice;
        this.title = title;
        this.itemId = UUID.randomUUID().toString();
    }

    public StockItem() {
    }

    @Override
    public String toString() {
        return "StockItem{" +
                "rentalPrice=" + rentalPrice +
                ", title='" + title + '\'' +
                ", itemId='" + itemId + '\'' +
                '}';
    }

    public StockItem(float rentalPrice, String title, String itemId) {
        this.rentalPrice = rentalPrice;
        this.title = title;
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockItem stockItem = (StockItem) o;
        return Float.compare(stockItem.rentalPrice, rentalPrice) == 0 && Objects.equals(title, stockItem.title) && Objects.equals(itemId, stockItem.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentalPrice, title, itemId);
    }

    public float getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(float rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
