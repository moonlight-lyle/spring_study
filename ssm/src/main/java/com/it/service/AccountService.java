package com.it.service;

import com.it.pojo.Account;
import java.util.List;

public interface AccountService {

    List<Account> findAll();

    void save(Account account);
}
