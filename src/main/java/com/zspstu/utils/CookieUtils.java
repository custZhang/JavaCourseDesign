package com.zspstu.utils;

import javax.servlet.http.Cookie;

public class CookieUtils {
    public static Cookie findCookie(String name,Cookie[] cookies){
        if(name == null || name.equals("") || cookies == null || cookies.length == 0){
            return null;
        }
        for(Cookie cookie:cookies){
            if(name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }

    public static Cookie deleteCookie(String name,Cookie[] cookies){
        if(name == null || name.equals("") || cookies == null || cookies.length == 0){
            return null;
        }
        for(Cookie cookie:cookies){
            if(name.equals(cookie.getName())){
                cookie.setMaxAge(0);
                return cookie;
            }
        }
        return null;
    }
}
