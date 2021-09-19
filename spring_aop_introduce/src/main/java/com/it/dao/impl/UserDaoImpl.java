package com.it.dao.impl;

import com.it.dao.AccountDao;
import com.it.dao.UserDao;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2021/9/19
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("UserDaoImpl...save()");
    }

    @Override
    public void delete() {
        System.out.println("AccountDaoImpl...delete()");
    }

    @Override
    public Object findById(int id) {
        System.out.println("AccountDaoImpl...findAll()"+id);
        return "hello...findAll()";
    }
}
