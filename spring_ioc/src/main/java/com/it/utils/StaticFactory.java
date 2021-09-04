package com.it.utils;

import com.it.service.AccountService;
import com.it.service.impl.AccountServiceImpl02;

/**
 * @Description: 静态工厂
 * @Author: yp
 */
public class StaticFactory {

    public static AccountService getBean(){
        return new AccountServiceImpl02();
    }


}