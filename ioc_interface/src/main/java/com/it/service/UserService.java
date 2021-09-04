package com.it.service;

import com.it.dao.UserDao;
import com.it.dao.impl.UserDaoImpl;
import com.it.dao.impl.UserDaoMybatis;

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
        // 多态：使用父类UserDao来代替所有的子类
        UserDao userDao = new UserDaoMybatis();
        userDao.save();

    }
}
