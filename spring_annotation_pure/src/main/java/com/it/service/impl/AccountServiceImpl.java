package com.it.service.impl;

import com.it.bean.Account;
import com.it.dao.AccountDao;
import com.it.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void save(Account account) throws Exception {
        accountDao.save(account);
    }

    @Override
    public void update(Account account) throws Exception {
        accountDao.update(account);
    }

    @Override
    public void delete(Integer id) throws Exception {
        accountDao.delete(id);
    }

    @Override
    public Account findById(Integer id) throws Exception {
        return  accountDao.findById(id);
    }

    @Override
    public List<Account> findAll() throws Exception {
        return  accountDao.findAll();
    }
}
