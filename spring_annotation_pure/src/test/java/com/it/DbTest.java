package com.it;

import com.it.bean.Account;
import com.it.config.SpringConfiguration;
import com.it.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class DbTest {
    @Test
    public void fun01() throws Exception {
        //AccountServiceImpl accountService = new AccountServiceImpl();
        //1.创建Spring工厂
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 使用注解的工厂
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.获得对象
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        List<Account> list = accountService.findAll();
        System.out.println(list);
    }
}
