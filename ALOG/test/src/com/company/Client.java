package com.company;

public class Client {
    private String name ;
    private float accoutnBalance ;
    private String customerID ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAccoutnBalance() {
        return accoutnBalance;
    }

    public void setAccoutnBalance(float accoutnBalance) {
        this.accoutnBalance = accoutnBalance;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Client(String name, float accoutnBalance, String customerID) {
        this.name = name;
        this.accoutnBalance = accoutnBalance;
        this.customerID = customerID;
    }
}
