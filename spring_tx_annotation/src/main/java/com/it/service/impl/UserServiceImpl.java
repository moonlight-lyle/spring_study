package com.it.service.impl;

import com.it.dao.UserDao;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(isolation = Isolation.REPEATABLE_READ) // spring 事务注解
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ) // spring 事务注解,方法上有事务注解优先按照方法上的事务规则来
    public void transfer(String fukuan, String shoukuan, Double money) {
        userDao.reduceMoney(fukuan,money);
        int i=1/0;
        userDao.addMoney(shoukuan,money);
    }
}
