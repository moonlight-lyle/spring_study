package com.it.pojo;

import java.io.Serializable;
/**
 * @Description:
 * @Author: yp
 */
public class Account implements Serializable {

    private String name;
    private double money;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", address=" + address +
                '}';
    }
}
