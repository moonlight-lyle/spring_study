package com.it.service.impl;

import com.it.dao.AccountDao;
import com.it.service.AccountService;

/**
 * Set方法方式
 * 1.提供set()方法
 * 2.在配置文件里面配置 <property></property>
 */
public class AccountServiceImpl05 implements AccountService {

   private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void save() {
        System.out.println("AccountServiceImpl05..save()");
        //1.调用Dao
        accountDao.save();
    }



}