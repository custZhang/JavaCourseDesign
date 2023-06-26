package com.zspstu.utils;

import org.springframework.beans.factory.annotation.Value;

import java.util.Properties;

public class GetPathUtils {

    private static Properties  properties;

//    @Value("${path.filePath}")
//    private static String filepath;

    //加载path.properties类
    static {
        properties = new Properties();
        try {
            properties.load(GetPathUtils.class.getResourceAsStream("/path.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key){
        return GetPathUtils.properties.getProperty(key);
//        return filepath;
    }

}
