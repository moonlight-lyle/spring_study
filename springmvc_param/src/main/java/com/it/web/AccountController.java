package com.it.web;

import com.it.pojo.Account;
import com.it.pojo.User;
import com.it.pojo.User02;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Date;
/**
 * @Description:
 * @Author: yp
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @RequestMapping("/save")
    // 基本类型和String类型作为参数: 方法的形参必须和请求参数的name一致
    public String save(String name,int age){
        System.out.println(name + ":" + age);
        System.out.println("AccountController...save()");
        return "success";
    }

    @RequestMapping("/update")
    // pojo类型: pojo的属性必须和提交过来的name一致
    public String update(Account account){
        System.out.println("AccountController...update()"+account);
        return "success";
    }

    @RequestMapping("/delete")
    // pojo类型包含List: pojo的属性必须和提交过来的name一致, list取下标
    public String delete(User user){
        System.out.println("AccountController...delete()"+user);
        return "success";
    }

    @RequestMapping("/findAll")
    // pojo类型包含Map: pojo的属性必须和提交过来的name一致, map根据key取值
    public String findAll(User02 user02){
        System.out.println("AccountController...findAll()"+user02);
        return "success";
    }

    @RequestMapping("/findById")
    public String findById(Date birthday) throws ParseException {
        // 方式一: 用String来接收, 自己转换; 缺点: 需要在每一个用到的方法里面转换
        // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // Date date = simpleDateFormat.parse(birthday);

        // 方式二: 直接使用Date接收, 自定义类型转换器 优点: 配置一次 缺点: 配置有点麻烦
        System.out.println("AccountController...findById()"+birthday);
        return "success";
    }

    @RequestMapping("/findCount")
    public String findCount(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request.getParameter("name"));
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
        return "success";
    }
}
