package com.it.service.impl;

import com.it.service.AccountService;

/**
 * SpEL方式
 * 1.提供set()方法
 * 2.配置property标签, 使用#{}
 */
public class AccountServiceImpl07 implements AccountService {

    private String name;

    private String age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public void save() {
        System.out.println("AccountServiceImpl07..save()"+name+":"+age);
    }



}