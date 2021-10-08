package com.it.service.impl;

import com.it.dao.UserDao;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void transfer(String fukuan, String shoukuan, Double money) {
        userDao.reduceMoney(fukuan,money);
        int i=1/0;
        userDao.addMoney(shoukuan,money);
    }
}
