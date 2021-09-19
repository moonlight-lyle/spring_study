package com.it;

import com.it.dao.impl.ProductDaoImpl;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import javax.jws.soap.SOAPBinding;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: yp
 */
public class C_Cglib {

    @Test
    public void fun01(){
        ProductDaoImpl productDao = new ProductDaoImpl();
        // productDao.save();
        // 1.创建Enhancer对象
        Enhancer enhancer = new Enhancer();
        // 2.设置父类
        enhancer.setSuperclass(ProductDaoImpl.class);
        // 3.设置callback  类似JDK动态代理里面的InvocationHandler
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            // 参数1:代理对象 慎用
            // 参数2:代理对象执行的方法
            // 参数3:代理对象执行的方法传入的参数
            // 参数4: 代理方法对象
            // 返回值是代理对象执行方法的返回值
            public Object intercept(Object proxy, Method method,
                                    Object[] args, MethodProxy methodProxy)
                    throws Throwable {
                // 增强save
                if ("save".equals(method.getName())) {
                    System.out.println("权限的校验...");
                    return  method.invoke(productDao, args);
                    //return null;
                }
                // 其它的方法调用之前的逻辑(method.invoke()就是当前执行方法的返回值)
                Object obj = method.invoke(productDao, args);
                return obj;
            }
        });
        // 4.创建代理对象
        ProductDaoImpl proxyDao = (ProductDaoImpl) enhancer.create();
        proxyDao.save();
    }
}
