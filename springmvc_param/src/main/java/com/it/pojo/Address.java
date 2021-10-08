package com.it.pojo;

import java.io.Serializable;

/**
 * @Description:
 * @Author: yp
 */
public class Address implements Serializable{

    private String provinceName;
    private String cityName;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "provinceName='" + provinceName + '\'' +
                ", cityName=" + cityName +
                '}';
    }
}
