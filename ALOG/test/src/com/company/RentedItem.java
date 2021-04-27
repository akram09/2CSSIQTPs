package com.company;


import java.util.Date;

public class RentedItem {
    private  StockItem item ;
    private Client client ;
    private Date dueDate ;

    public StockItem getItem() {
        return item;
    }

    public void setItem(StockItem item) {
        this.item = item;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public RentedItem(StockItem item, Client client, Date dueDate) {
        this.item = item;
        this.client = client;
        this.dueDate = dueDate;
    }
}
