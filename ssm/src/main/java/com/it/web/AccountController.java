package com.it.web;


import com.it.pojo.Account;
import com.it.service.AccountService;
import com.it.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @RequestMapping("/findAll")
    public String findAll(HttpServletRequest request) {
        System.out.println("AccountController...findAll()");
        // 调用业务
        // AccountService accountService = new AccountServiceImpl();
        List<Account> list = accountService.findAll();
        System.out.println(list);
        request.setAttribute("list",list);
        return "success";
    }

    @RequestMapping("/save")
    public String save(Account account) {
        System.out.println("AccountController...save()");
        // 调用业务
        accountService.save(account);
        // 响应
        return "redirect:/account/findAll";
    }
}
