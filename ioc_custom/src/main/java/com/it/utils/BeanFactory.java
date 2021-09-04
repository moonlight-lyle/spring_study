package com.it.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  //程序初始化的时候, 把xml解析好 反射创建好 存到容器【map key是id, value是对应的对象】里面
 * 终极：解决初级版本存在的问题
 * 1. 每次调用getBean()都要读取配置文件applicationContext.xml，解决方案：通过静态代码块，配置文件只读取一次
 * 2. 每次临时用的时候才通过反射去创建对象，解决方案：程序初始化的时候，解析配置文件，通过反射创建相关对象存入Map容器中，使用的时候从Map容器中去获取
 */
public class BeanFactory {
    public static Map<String,Object> beanMap=new HashMap<String, Object>();
    static {
        InputStream is = null;
        try {
            // 1.创建SAXReader对象
            SAXReader saxReader = new SAXReader();
            // 2.读取xml 获得document对象
            is = BeanFactoryOri.class.getClassLoader().getResourceAsStream("applicationContext.xml");
            Document document = saxReader.read(is);
            // 3.获得所有的bean标签
            List<Element> beanEles =  document.selectNodes("//bean");
            // 4.遍历所有的bean标签
            for (Element beanEle : beanEles) {
                // 5.获得bean标签的id和class属性值
                String id = beanEle.attributeValue("id");
                String className = beanEle.attributeValue("class");
                // 6.根据class属性值反射创建对象, 把id作为key,把反射创建的对象作为value存到beanMap
                Object obj  = Class.forName(className).newInstance();
                beanMap.put(id,obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static Object getBean(String id){ // applicationContext.xml中bean标签配置的id名
        return beanMap.get(id);
    }
}
