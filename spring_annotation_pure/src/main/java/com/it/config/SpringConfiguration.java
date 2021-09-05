package com.it.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration // 标记该类是一个配置类
@ComponentScan(value = "com.it") // 开启包扫描
@Import(value = {JdbcConfig.class}) // @Import注解：引入其他的配置类
@PropertySource(value = {"classpath:jdbc.properties"})  // 引入properties配置文件 classpath：类路径
public class SpringConfiguration {


}
