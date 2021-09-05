package com.it.dao.impl;

import com.it.dao.AccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao02")
public class AccountDaoImpl02 implements AccountDao {
    /**
     * 保存账户
     */
    @Override
    public void save() {
        System.out.println("AccountDaoImpl02---saveAccount()");

    }
}