package com.neutrix.videolibrary.models;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class RentedItem {
    private String itemId ;
    private Date dueDate;

    public RentedItem(Date dueDate) {
        this.dueDate = dueDate;
        this.itemId = UUID.randomUUID().toString();
    }

    public RentedItem() {
    }

    public RentedItem(String itemId, Date dueDate) {
        this.itemId = itemId;
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentedItem that = (RentedItem) o;
        return itemId.equals(that.itemId) && dueDate.equals(that.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, dueDate);
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
