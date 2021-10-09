package com.it.test;
import com.it.pojo.Account;
import com.it.dao.AccountDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void fun01() throws Exception {
//        //1.读取SqlMapConfig.xml
//        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
//        //2.构建SqlSessionFactory  构建者
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
//        //3.打开SqlSession  工厂模式
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //4.获得AccountDao代理对象 动态代理
//        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
//        //5.调用方法 操作数据库
//        List<Account> list = accountDao.findAll();
//        System.out.println(list);
//        //6.释放资源
//        sqlSession.close();
//        is.close();
    }

}
