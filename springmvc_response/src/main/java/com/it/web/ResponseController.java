package com.it.web;

import com.it.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/response")
public class ResponseController {
    /***********************一,返回值分类 *******************/

    /**
     * 测试返回String
     * 1.success                      逻辑视图
     * 2./WEB-INF/pages/success.jsp   物理视图
     * 【逻辑视图通过视图解析器解析成了物理视图】
     * <p>
     * 数据库删除:
     * 1.逻辑删除: 不是真删除,数据还在, 设置了一个状态值  state = 1, state = 0
     * 2.物理删除: 真删除,删除不在了
     * 【我们工作里面一般很少进行物理删除,一般使用逻辑删除】
     */
    @RequestMapping("/testReturnString")
    public String testReturnString(HttpServletRequest request) {
        System.out.println("testReturnString()...");
        request.setAttribute("akey", "aaa");
        return "success";
    }

    /**
     * 测试返回void 【了解】
     * 1.情况一方法没有response, 自动的转发到页面: 前缀+类上面RequestMapping+方法上面的RequestMapping+后缀
     * 2.情况二方法有response, 不会自动响应的(空白页面),自己通过response响应
     */
    @RequestMapping("/testReturnVoid")
    public void testReturnVoid(HttpServletResponse response) throws IOException {
        System.out.println("testReturnVoid()...");
        response.getWriter().print("Hello Void");
    }

    /**
     * 测试返回ModelAndView
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() throws IOException {
        ModelAndView mv = new ModelAndView();
        // 设置数据(model)
        mv.addObject("akey", "aaa"); //相当于向request域存了akey:aaa
        // 设置逻辑视图(view)
        mv.setViewName("success");
        System.out.println("testModelAndView()...");
        return mv;
    }


    /***********************二,转发和重定向(返回值都是String) *******************/
    // 转发到页面.  语法:  forward:/页面绝对路径(物理视图)
    @RequestMapping("/forwardToPage")
    public String forwardToPage() {
        System.out.println("forwardToPage()...");
        return "forward:/forward.jsp";
    }

    // 转发到Controller的方法. 语法: forward:/类上面的RequestMapping/方法上面的RequestMapping
    @RequestMapping("/forwardToController")
    public String forwardToController() {
        System.out.println("forwardToController()...");
        return "forward:/response/testReturnString";
    }

    // 重定向到页面.  语法:  redirect:/页面绝对路径(物理视图)
    @RequestMapping("/redirectToPage")
    public String redirectToPage() {
        System.out.println("redirectToPage()...");
        return "redirect:/redirect.jsp";
        // return "redirect:/WEB-INF/pages/success.jsp"; //WEB-INF 重定向不过去的
    }

    // 重定向到Controller的方法. 语法: redirect:/类上面的RequestMapping/方法上面的RequestMapping
    @RequestMapping("/redirectToController")
    public String redirectToController() {
        System.out.println("redirectToController()...");
        return "redirect:/response/testReturnString";
    }

    /***********************三,响应json *******************/
    @RequestMapping("/testJson")
    @ResponseBody
    public User testJson(User user) {
        System.out.println("testJson()" + user);
        User user02 = new User("zs", "123456");
        return user02;
    }

    @RequestMapping("/testJson02")
    @ResponseBody
    public List<Map> testJson02() {
        System.out.println("testJson02()");
        List<Map> list = new ArrayList<Map>();
        for(int i =0;i<3;i++){
            Map map = new HashMap();
            map.put("akey"+i,"a"+i);
            map.put("bkey"+i,"b"+i);
            list.add(map);
        }
        return list;
        // [{"bkey0":"b0","akey0":"a0"},{"bkey1":"b1","akey1":"a1"},{"bkey2":"b2","akey2":"a2"}]
    }
}
