package com.it.service;

import com.it.dao.UserDao;

public class UserService {


    /**
     * 注册
     */
    public void regist() {
        System.out.println("UserService...regist()");
        //1.处理业务
        //2.调用Dao

        //UserDao userDao = new UserDao();
        //userDao.save();
        UserDao userDao = new UserDao();
        userDao.save();

    }
}
