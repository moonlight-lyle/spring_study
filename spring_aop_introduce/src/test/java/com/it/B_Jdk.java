package com.it;

import com.it.dao.UserDao;
import com.it.dao.impl.UserDaoImpl;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Description:
 * @Author: yp
 */
public class B_Jdk {
    /**
     * 1.1.0  所有的保存之前 进行权限的校验
     * 1.1.1  不需要这个权限校验的功能
     * ...
     * 2.0.0  有些Dao里面需要, 有些Dao里面不需要
     */

    @Test
    // 对save()方法进行增强, 在save()方法调用之前,进行权限的校验
    public void fun01() {
        UserDao userDao = new UserDaoImpl();
        // 参数一: 类加载器 【加载代理对象的】
        // 参数二: 被增强类实现的接口的字节码对象数组 new Class[]{UserDao.class}
        // 参数三: 处理器  代理对象的方法的执行逻辑全部由处理器控制了
        // 返回值: 代理对象
        UserDao proxyDao = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            // 代理对象的方法的执行逻辑全部由invoke控制了,代理对象的方法执行一次, invoke就执行一次
            // 参数1:代理对象 慎用
            // 参数2:代理对象执行的方法
            // 参数3:代理对象执行的方法传入的参数
            // 返回值是代理对象执行方法的返回值
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强save
                if ("save".equals(method.getName())) {
                    System.out.println("权限的校验...");
                    return  method.invoke(userDao, args);
                    //return null;
                }
                //其它的方法调用之前的逻辑(method.invoke()就是当前执行方法的返回值)
                Object obj = method.invoke(userDao, args);
                return obj;
                //System.out.println("obj=" + obj);
                //return "哈哈";
            }
        });

//         proxyDao.save();
        Object returnObj = proxyDao.findById(1);
        System.out.println("returnObj=" + returnObj);


    }


}
