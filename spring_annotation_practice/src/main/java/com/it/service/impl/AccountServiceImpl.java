package com.it.service.impl;

import com.it.dao.AccountDao;
import com.it.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;


    /**
     * 保存账户
     */
    @Override
    public void save() {
        System.out.println("对象创建成功，执行方法。。。");
        accountDao.save();
    }

}