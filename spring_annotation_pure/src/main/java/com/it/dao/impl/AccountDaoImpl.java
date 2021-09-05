package com.it.dao.impl;

import com.it.bean.Account;
import com.it.dao.AccountDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner queryRunner;

    @Override
    public void save(Account account) throws SQLException {
        //3. 执行sql语句
        queryRunner.update("insert into values(?,?,?)",null,account.getName(),account.getMoney());

    }

    @Override
    public void update(Account account) throws SQLException {
        queryRunner.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());

    }

    @Override
    public void delete(Integer id) throws SQLException {
        queryRunner.update("delete from  account  where id=?",id);

    }

    @Override
    public Account findById(Integer id) throws SQLException {
        return queryRunner.query("select * from  account  where id=?",new BeanHandler<Account>(Account.class),id);
    }

    @Override
    public List<Account> findAll() throws SQLException {
        return queryRunner.query("select * from  account ",new BeanListHandler<Account>(Account.class));
    }
}
