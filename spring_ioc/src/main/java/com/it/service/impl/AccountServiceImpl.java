package com.it.service.impl;

import com.it.dao.AccountDao;
import com.it.dao.impl.AccountDaoImpl;
import com.it.service.AccountService;

public class AccountServiceImpl implements AccountService {

    /**
     * 保存账户
     */
    @Override
    public void save() {
        System.out.println("AccountServiceImpl---saveAccount()");
        AccountDao accountDao = new AccountDaoImpl();//TODO 耦合待解决
        accountDao.save();
    }

    public void initMethod(){
        System.out.println("Spring创建对象了。。。。");
    }

    public void destroyMethod(){
        System.out.println("Spring销毁对象了。。。");
    }


}