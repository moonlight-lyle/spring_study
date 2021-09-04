package com.it.service.impl;

import com.it.dao.UserDao;
import com.it.service.IUserService;
import com.it.utils.BeanFactory;
import com.it.utils.BeanFactoryOri;

public class UserService implements IUserService {


    /**
     * 注册
     */
    @Override
    public void regist() {
        System.out.println("UserService...regist()");
        //1.处理业务
        //2.调用Dao
        // IOC：控制反转，将对象的创建和管理交给spring来做，实现解耦
        // 自定义IOC实现技术：xml+工厂模式+反射
//        UserDao userDao = new UserDaoMybatis();
        UserDao userDao = (UserDao) BeanFactory.getBean("userDao");
        userDao.save();

    }
}
