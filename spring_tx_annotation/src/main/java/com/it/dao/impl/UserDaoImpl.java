package com.it.dao.impl;

import com.it.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void reduceMoney(String fukuan, Double money) {
        jdbcTemplate.update("update account set money = money - ? where name = ?  ", 	money,fukuan);

    }

    @Override
    public void addMoney(String shoukuan, Double money) {
        jdbcTemplate.update("update account set money = money + ? where name = ?  ", money,shoukuan);
    }
}
