package com.it.dao.impl;

import com.it.dao.UserDao;

/**
 * 一个接口可以创建多个不同的实现类，以便实现扩展
 */
public class UserDaoMybatis implements UserDao {
    public void save() {
        System.out.println("UserDao...save()使用Mybatis操作数据库");
    }
}
