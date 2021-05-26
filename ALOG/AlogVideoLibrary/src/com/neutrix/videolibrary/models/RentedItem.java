package com.neutrix.videolibrary.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class RentedItem {
    private String itemId ;
    private LocalDate dueDate;
    private String clientId;

    public RentedItem(LocalDate dueDate, String clientId, String itemId) {
        this.dueDate = dueDate;
        this.clientId = clientId;
        this.itemId = itemId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "RentedItem{" +
                "itemId='" + itemId + '\'' +
                ", dueDate=" + dueDate +
                ", clientId='" + clientId + '\'' +
                '}';
    }

    public RentedItem() {
    }

    public RentedItem(String itemId, LocalDate dueDate) {
        this.itemId = itemId;
        this.dueDate = dueDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentedItem that = (RentedItem) o;
        return Objects.equals(itemId, that.itemId) && Objects.equals(dueDate, that.dueDate) && Objects.equals(clientId, that.clientId);
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


    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
