package com.it.service.impl;

import com.it.service.AccountService;

import java.util.Arrays;

/**
 * Set方法方式
 * 1.提供set()方法
 * 2.在配置文件里面配置 <property></property>
 */
public class AccountServiceImpl03 implements AccountService {

    private String[] hobby;

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    @Override
    public void save() {
        System.out.println("AccountServiceImpl03---save()"+ Arrays.toString(hobby));
    }

}