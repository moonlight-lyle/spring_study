package com.it.dao;

public interface UserDao {

    void reduceMoney(String fukuan, Double money);

    void addMoney(String shoukuan, Double money);
}
