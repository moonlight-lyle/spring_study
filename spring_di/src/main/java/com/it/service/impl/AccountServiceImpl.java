package com.it.service.impl;

import com.it.bean.User;
import com.it.dao.AccountDao;
import com.it.dao.impl.AccountDaoImpl;
import com.it.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private String username;
    private int age;
    private User user;

    public AccountServiceImpl(String username,int age,User user) {
        this.username = username;
        this.age=age;
        this.user=user;
    }

    /**
     * 保存账户
     */
    @Override
    public void save() {
//        System.out.println("AccountServiceImpl---saveAccount()");
//        AccountDao accountDao = new AccountDaoImpl(); //TODO 耦合待解决
//        accountDao.save();
        System.out.println("构造方法注入。。。"+username+":"+age);

    }

    public void initMethod(){
        System.out.println("Spring创建对象了。。。。");
    }

    public void destroyMethod(){
        System.out.println("Spring销毁对象了。。。");
    }


}