package com.it;

import com.it.dao.AccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 指定运行环境
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class AopTest {

    @Autowired
    private AccountDao accountDao;

    // 测试前置通知
    @Test
    public void fun01(){
        accountDao.save();
    }

    // 测试后置通知
    @Test
    public void fun02(){
        accountDao.delete();
    }

    // 测试环绕通知
    @Test
    public void fun03(){
        accountDao.findAll();
    }

    @Test
    // 测试异常通知
    public void fun04(){
        accountDao.update();
    }

    @Test
    // 测试最终通知
    public void fun05(){
        accountDao.findById();
    }

}
