package com.it.service.impl;

import com.it.service.AccountService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service("accountService") // 相当于在applicationContext.xml中配置bean标签，
// ("accountService")：对应bean标签中的id属性值，可以不配置，默认为类名，首字母变小写，即accountServiceImpl
@Scope("singleton")
public class AccountServiceImpl implements AccountService {

    /**
     * 保存账户
     */
    @Override
    public void save() {
        System.out.println("对象创建成功，执行方法。。。");
    }

    @PostConstruct // spring创建对象时触发该方法
    public void initMethod(){
        System.out.println("Spring创建对象了。。。。");
    }

    @PreDestroy // spring销毁对象时触发该方法
    public void destroyMethod(){
        System.out.println("Spring销毁对象了。。。");
    }

}