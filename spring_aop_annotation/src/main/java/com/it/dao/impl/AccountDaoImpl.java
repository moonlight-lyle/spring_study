package com.it.dao.impl;

import com.it.dao.AccountDao;

/**
 * @author Lyle
 * @date 2021/9/19
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public void save() {
        System.out.println("AccountDaoImpl...save()");
    }
    @Override
    public String delete() {
        System.out.println("AccountDaoImpl...delete()");
        return "后置通知返回值";
    }
    @Override
    public void findAll() {
        // 模拟耗时
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("AccountDaoImpl...findAll()");
    }
    @Override
    public void update() {
        System.out.println("AccountDaoImpl...update()");
        int i=1/0;
    }
    @Override
    public void findById() {
        System.out.println("AccountDaoImpl...findById()");
    }
}
