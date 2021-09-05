package com.it.dao.impl;

import com.it.dao.AccountDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    /**
     * 保存账户
     */
    @Override
    public void save() {
        System.out.println("AccountDaoImpl---saveAccount()");

    }
}