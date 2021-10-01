package com.it.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @Description: 增强逻辑类
 * @Author: Lx
 */
@Aspect // 添加注解，标识该类是切面类
public class MyAscept {
    // 前置通知增强逻辑
    @Before("execution(* com.it.dao.impl.AccountDaoImpl.save(..))")
    public void checkPrivilege(){
        System.out.println("权限的校验...");
    }

    // 后置通知增强逻辑，特点：获取目标方法返回值
    // 获取目标方法（此处是delete）的返回值，注意形参要与applicationContext.xml中aop:after-returning配置的名称一致
    @AfterReturning(value = "execution(* com.it.dao.impl.AccountDaoImpl.delete(..))",returning = "obj")
    public void showLog(String obj){
        System.out.println("日志打印..."+":"+obj);
    }

    // 环绕通知增强逻辑，特点：阻止目标方法执行
    @Around("execution(* com.it.dao.impl.AccountDaoImpl.findAll(..))")
    public void showTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("目标方法调用之前:"+System.currentTimeMillis());
        // 调用目标方法
        joinPoint.proceed();
        System.out.println("目标方法调用之后:"+System.currentTimeMillis());
    }

    // 异常通知增强逻辑，特点：获取异常信息
    @AfterThrowing(value = "execution(* com.it.dao.impl.AccountDaoImpl.update(..))",throwing = "e")
    public void showException(Exception e){
        System.out.println("目标方法执行异常。。。"+":"+e);
    }

    // 最终通知增强逻辑
    @After(value = "execution(* com.it.dao.impl.AccountDaoImpl.findById(..))")
    public void showFinal(){
        System.out.println("目标方法执行,最终通知。。。");
    }
}
