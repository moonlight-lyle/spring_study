package com.it.dao;

import com.it.pojo.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountDao {
//    @Select(value ="select * from account")
    // xml文件方式
    List<Account> findAll();

    @Insert(value = "insert into account(name,money) values(#{name},#{money})")
    void  save(Account account);
}
