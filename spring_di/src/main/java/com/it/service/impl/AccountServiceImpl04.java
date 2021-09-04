package com.it.service.impl;

import com.it.service.AccountService;

import java.util.Map;
import java.util.Set;

/**
 * Set方法方式
 * 1.提供set()方法
 * 2.在配置文件里面配置 <property></property>
 */
public class AccountServiceImpl04 implements AccountService {

    private Map<String,String> map;

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public void save() {
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + ":" + map.get(key));
        }
        System.out.println("AccountServiceImpl04---save()");
    }

}