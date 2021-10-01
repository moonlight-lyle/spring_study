package com.it.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
/**
 * @Description: 增强逻辑类
 * @Author: Lx
 */
public class MyAscept {
    // 前置通知增强逻辑
    public void checkPrivilege(){
        System.out.println("权限的校验...");
    }

    // 后置通知增强逻辑，特点：获取目标方法返回值
    // 获取目标方法（此处是delete）的返回值，注意形参要与applicationContext.xml中aop:after-returning配置的名称一致
    public void showLog(String obj){
        System.out.println("日志打印..."+":"+obj);
    }

    // 环绕通知增强逻辑，特点：阻止目标方法执行
    public void showTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("目标方法调用之前:"+System.currentTimeMillis());
        // 调用目标方法
        joinPoint.proceed();
        System.out.println("目标方法调用之后:"+System.currentTimeMillis());
    }

    // 异常通知增强逻辑，特点：获取异常信息
    public void showException(Exception e){
        System.out.println("目标方法执行异常。。。"+":"+e);
    }

    // 最终通知增强逻辑
    public void showFinal(){
        System.out.println("目标方法执行,最终通知。。。");
    }
}
