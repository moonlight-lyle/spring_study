package com.it.service.impl;

import com.it.pojo.Account;
import com.it.dao.AccountDao;
import com.it.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@SuppressWarnings("all")
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("AccountServiceImpl...findAll()");
        List<Account> list = accountDao.findAll();
        return list;
    }

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }
}
