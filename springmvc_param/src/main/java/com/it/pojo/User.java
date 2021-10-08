package com.it.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @Author: yp
 */
public class User implements Serializable{
    private String username;
    private String password;
    private int age;

    // 一个用户可以有多个账户
    private List<Account> accountList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", accountList=" + accountList +
                '}';
    }
}
