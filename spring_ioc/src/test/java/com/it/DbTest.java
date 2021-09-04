package com.it;

import com.it.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DbTest {
    @Test
    public void fun01() throws Exception {
        //1. 创建工厂，指定配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        //2. 根据id获得对象
        AccountService accountService01 = (AccountService) applicationContext.getBean("accountService03");
        AccountService accountService02 = (AccountService) applicationContext.getBean("accountService03");
        System.out.println(accountService01==accountService02); // 证明默认是单例的,<bean id="accountService" class="com.it.service.impl.AccountServiceImpl" scope="singleton"></bean>
        accountService01.save();
        ((ClassPathXmlApplicationContext)applicationContext).close(); // 证明容器销毁时调用配置的destroy-method
    }
}
