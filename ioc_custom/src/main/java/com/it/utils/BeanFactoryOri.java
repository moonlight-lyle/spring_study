package com.it.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

/**
 * 初级版本：存在一定的问题
 * 1. 每次调用getBean()都要读取配置文件applicationContext.xml
 * 2. 每次临时用的时候才通过反射去创建对象
 */
public class BeanFactoryOri {

    /**
     * 根据id获取对应的Bean对象
     * <bean id="userDao" class="com.it.dao.impl.UserDaoImpl"></bean>
     * 思路：根据id获取到bean标签，进而获取到class属性值，通过反射创建对象
     * @param id
     * @return
     */
    public static Object getBean(String id){ // applicationContext.xml中bean标签配置的id名
        InputStream resourceAsStream=null;
        try {
            // 1.创建SAXReader对象
            SAXReader saxReader = new SAXReader();
            // 2.读取xml 获得document对象
            resourceAsStream = BeanFactoryOri.class.getClassLoader().getResourceAsStream("applicationContext.xml");
            Document document = saxReader.read(resourceAsStream);
            // 3.获得所有的bean标签
            Element element = (Element) document.selectSingleNode("//bean[@id='" + id + "']");
            String aClass = element.attributeValue("class"); // 获取class属性值
            System.out.println(aClass);
            // 4.遍历所有的bean标签
            // 5.根据class属性值，通过反射创建对象返回
            Class<?> aClass1 = Class.forName(aClass); // 获取字节码对象
            Object obj = aClass1.newInstance(); // 创建实例对象
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
}
