package com.it.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/annotation")
public class AnnotationController {
    /**
     * @RequestParam: 把请求中指定名称的参数给控制器中的形参赋值
     *      name属性: 请求参数的key
     *      required属性: true 这个参数是必须有的; false 不是必须有的【默认】
     *      defaultValue属性: 默认值
     *
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name",required =true,defaultValue = "ls") String username){
        System.out.println("testRequestParam()" + username);
        return "success";
    }

    /**
     * @RequestBody
     * 1.用于获取请求体内容。 直接使用得到是 key=value&key=value...结构的字符串。【了解】
     * 2.把获得json类型的数据转成pojo对象【重点,后面再讲】
     *      class User{
     *           private String username;
     *           private String password;
     *      }
     *
     *      前端: {"username":"zs","password":"123456"} --->User   @RequestBody User user
     *
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String params){
        System.out.println("testRequestBody()"+params);
        return "success";
    }

    /**
     * @testPathVariable:  用来做Rest风格路径
     */
    @RequestMapping("/testPathVariable/{uid}")
    public String testPathVariable(@PathVariable(value = "uid") int id){
        System.out.println("testPathVariable()"+id);
        return "success";
    }

    // 获得请求头
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader("User-Agent") String userAgent){
        System.out.println("testRequestHeader()"+userAgent);
        return "success";
    }

    // 获得cookie的值
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId){
        System.out.println("testCookieValue()"+sessionId);
        return "success";
    }
}
