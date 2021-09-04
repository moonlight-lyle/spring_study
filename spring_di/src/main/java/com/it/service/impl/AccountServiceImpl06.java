package com.it.service.impl;

import com.it.service.AccountService;

/**
 * P名称空间方式
 * 1.提供set()方法
 * 2.直接使用p名称空间里面的属性
 */
public class AccountServiceImpl06 implements AccountService {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void save() {
        System.out.println("AccountServiceImpl06..save()"+name);
    }



}