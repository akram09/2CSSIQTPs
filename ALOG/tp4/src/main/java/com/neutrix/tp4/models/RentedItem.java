package com.neutrix.tp4.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
public class RentedItem {
    @Id
    private String rentedItemId;

    private String itemId ;

    private String dueDate;
    private String clientId;


    public RentedItem(String rentedItemId, String itemId, String dueDate, String clientId) {
        this.rentedItemId = rentedItemId;
        this.itemId = itemId;
        this.dueDate = dueDate;
        this.clientId = clientId;
    }

    public RentedItem(String dueDate, String clientId, String itemId) {
        this.dueDate = dueDate;
        this.clientId = clientId;
        this.itemId = itemId;
        this.rentedItemId = UUID.randomUUID().toString();
    }

    public String getRentedItemId() {
        return rentedItemId;
    }

    public void setRentedItemId(String rentedItemId) {
        this.rentedItemId = rentedItemId;
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

    public RentedItem(String itemId, String dueDate) {
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


    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}