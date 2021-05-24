package com.neutrix.videolibrary.models;

import java.util.Objects;
import java.util.UUID;

public class Client {
    private String customerId;
    private String name;
    private int accountBalance;

    public Client(String name, int accountBalance) {
        this.name = name;
        this.accountBalance = accountBalance;
        this.customerId = UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return accountBalance == client.accountBalance && customerId.equals(client.customerId) && name.equals(client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, name, accountBalance);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }
}
