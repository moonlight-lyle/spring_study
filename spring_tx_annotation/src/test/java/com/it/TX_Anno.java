package com.it;

import com.it.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class TX_Anno {

    @Autowired
    private UserService userService;

    @Test
    public void fun01(){
        userService.transfer("zs","ls",100.0);
    }
}
