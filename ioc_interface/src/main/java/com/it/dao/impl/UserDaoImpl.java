package com.it.dao.impl;

import com.it.dao.UserDao;

public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("UserDao...save()使用DBUtils操作数据库");
    }
}
