package com.neutrix.tp4.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Client {
    @Id
    private String customerId;

    private String name;
    private float accountBalance;

    protected Client() {
    }

    public Client(String name, float accountBalance) {
        this.name = name;
        this.accountBalance = accountBalance;
        this.customerId = UUID.randomUUID().toString();
    }

    public Client(String customerId, String name, float accountBalance) {
        this.customerId = customerId;
        this.name = name;
        this.accountBalance = accountBalance;
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

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "Client{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
