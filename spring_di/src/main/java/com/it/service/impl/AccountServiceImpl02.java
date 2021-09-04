package com.it.service.impl;

import com.it.service.AccountService;

/**
 * Set方法方式
 * 1.提供set()方法
 * 2.在配置文件里面配置 <property></property>
 */
public class AccountServiceImpl02 implements AccountService {

    private String username;
    private int age;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void save() {
        System.out.println("AccountServiceImpl---save()"+username+":"+age);
    }

}