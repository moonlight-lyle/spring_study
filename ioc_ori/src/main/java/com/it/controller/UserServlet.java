package com.it.controller;

import com.it.service.UserService;
import org.junit.Test;

/**
 * @Description:
 * @Author: yp
 */
public class UserServlet {

    /**
     * 没有spring 之前，我们需要使用对象都是通过new 来进行创建，这样耦合度太高，不方便进行维护
     */
    @Test
    public void doGet(){
        //1.获得请求参数
        //2.调用业务
        UserService userService = new UserService();
        userService.regist();
        //3.响应
    }

}
