package com.zspstu.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class WebUtils {


    public static String readString(HttpServletRequest req,String name){
        try {
            return new String(req.getParameter(name).getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return bean;
    }

//    public static FileService getFileService(){
//        AnnotationConfigApplicationContext ctx =
//                new AnnotationConfigApplicationContext(SpringConfig.class);
//        return ctx.getBean(FileService.class);
//    }
}
