package com.it.dao.impl;

import com.it.dao.AccountDao;
import com.it.pojo.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Map;

/**
 * @author Lyle
 * @date 2021/9/19
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public void save(Account account) {
        //1. 创建数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_day01");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        //2. 创建JDBC模版
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        //3.操作数据库
        String sql = "insert into account values(?,?,?)";
        jdbcTemplate.update(sql, null,account.getName(),account.getMoney());
    }
    @Override
    public void delete(int id) {
        //1. 创建数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_day01");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        //2. 创建JDBC模版
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        //3.操作数据库
        String sql = "delete from account where id=?";
        jdbcTemplate.update(sql, id);
    }
    @Override
    public List<Account> findAll() {
        //1. 创建数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_day01");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        //2. 创建JDBC模版
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        //3.操作数据库
        String sql = "select * from account";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);
        return null;
    }

    @Override
    public void update(Account account) {
        //1. 创建数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_day01");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        //2. 创建JDBC模版
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        // 操作数据库
        String sql ="update account set name = ? where id = ?";
        Object[] objects = {account.getName(), account.getId()};
        jdbcTemplate.update(sql,objects);
    }
    @Override
    public Account findById(int id) {
        //1. 创建数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_day01");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        //2. 创建JDBC模版
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        // 操作数据库
        String sql = "select * from account where id = ?";
        Account account = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Account.class),id);
        return account;
    }
}
