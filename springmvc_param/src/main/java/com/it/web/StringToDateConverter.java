package com.it.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 自定义类型转换器
 *          Converter<String,Date>: String 数据原始类型, Date:转换后类型
 * @Author: yp
 */
public class StringToDateConverter implements Converter<String,Date> {

    @Nullable
    @Override
    // 转换的方法, 参数source: 就是转换成Date的内容
    public Date convert(String source) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(source);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
