package com.it;

import com.it.dao.AccountDao;
import com.it.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DbTest {
    @Test
    public void fun01() throws Exception {
        //1. 创建工厂，指定配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        //2. 根据id获得对象
        AccountService accountService01 = (AccountService) applicationContext.getBean("accountService");
        AccountService accountService02 = (AccountService) applicationContext.getBean("accountService");
        System.out.println(accountService01==accountService02);
        accountService01.save();

//        AccountDao accountDao= (AccountDao) applicationContext.getBean("accountDao");
//        accountDao.save();

        ((ClassPathXmlApplicationContext)applicationContext).close(); // 证明容器销毁时调用配置的destroy-method
    }
}
