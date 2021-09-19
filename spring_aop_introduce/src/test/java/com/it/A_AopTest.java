package com.it;

import com.it.dao.UserDao;
import com.it.dao.impl.UserDaoImpl;
import org.junit.Test;

/**
 * Aop测试
 *
 * @author Lyle
 * @date 2021/9/19
 */
public class A_AopTest {

    @Test
    public void fun(){
        UserDao userDao=new UserDaoImpl();
        // 对save()方法进行增强，在调用save()方法之前进行权限校验

//        userDao.save();
    }
}
