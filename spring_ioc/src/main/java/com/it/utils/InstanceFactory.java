package com.it.utils;

import com.it.service.AccountService;
import com.it.service.impl.AccountServiceImpl03;

/**
 * @Description: 实例化工厂方式
 * @Author: yp
 */
public class InstanceFactory {

    public AccountService getBean(){
        return new AccountServiceImpl03();
    }


}