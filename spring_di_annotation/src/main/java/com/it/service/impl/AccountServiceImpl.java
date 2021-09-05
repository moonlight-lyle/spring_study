package com.it.service.impl;

import com.it.dao.AccountDao;
import com.it.service.AccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Value("张三")
    private String name;

    // @Autowired自动装配
    // 1. 如果AccountDao接口只有只一个实现类，自动把该实现类实例注入进来，
    // 2. 如果AccountDao有多个实现类，从容器里面找id和当前字段值（即accountDao）一致的实例对象进行注入，找不到会报错
    // 3.强行注入与当前字段值不一致的实例对象可以同时使用注解@Qualifier（注意这种场景需要@Autowired和@Qualifier同时使用）
    // @Autowired
    // @Qualifier("accountDao02")
    @Resource(name = "accountDao02")
    // 等同于上面@Autowired和@Qualifier同时使用，如果不指定(name = "accountDao02")，等同于@Autowired注解
    private AccountDao accountDao;

    /**
     * 保存账户
     */
    @Override
    public void save() {
        System.out.println("对象创建成功，执行方法。。。"+name);
        accountDao.save();
    }

}