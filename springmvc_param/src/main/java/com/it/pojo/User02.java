package com.it.pojo;

import java.io.Serializable;
import java.util.Map;

/**
 * @Description:
 * @Author: yp
 */
public class User02 implements Serializable{
    private String username;
    private String password;
    private int age;

    // 一个用户可以有多个账户
    private Map<String,Account> accountMap;

    public void setAccountMap(Map<String, Account> accountMap) {
        this.accountMap = accountMap;
    }

    public Map<String, Account> getAccountMap() {
        return accountMap;
    }

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

    @Override
    public String toString() {
        return "User02{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", accountMap=" + accountMap +
                '}';
    }
}
