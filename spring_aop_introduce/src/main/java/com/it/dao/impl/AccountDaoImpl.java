package com.it.dao.impl;

import com.it.dao.AccountDao;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2021/9/19
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public void save() {
        System.out.println("AccountDaoImpl...save()");
    }

    @Override
    public void delete() {
        System.out.println("AccountDaoImpl...delete()");
    }

    @Override
    public void findAll() {
        System.out.println("AccountDaoImpl...findAll()");
    }

    @Override
    public void update() {
        System.out.println("AccountDaoImpl...update()");
    }

    @Override
    public void findById() {
        System.out.println("AccountDaoImpl...findById()");
    }
}
