package com.it.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;
/**
 * JDBC相关的配置类
 */
public class JdbcConfig {

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean("dataSource") // @Bean注解：作用在方法上，将方法返回的对象注册到Spring容器中，("dataSource")：id属性值，不指定的话默认为方法名："createDataSource"
    public DataSource createDataSource(){
        // 创建对象
        DruidDataSource druidDataSource = new DruidDataSource();
        // 设置属性
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

    @Bean("queryRunner")
    // 1.作用在方法上，将方法返回的对象注册到Spring容器中，2.自动的从Spring容器中找和形参类型一致的对象并进行注入
    // 3.若存在多个DruidDataSource对象，可以在形参中使用@Qualifier注解，例如：@Qualifier("dataSource02") DataSource dataSource
    public QueryRunner createQueryRunner(DataSource dataSource){
        QueryRunner queryRunner=new QueryRunner(dataSource);
        return queryRunner;
    }
}
