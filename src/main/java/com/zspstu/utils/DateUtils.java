package com.zspstu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String DateToString(Date date){
        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dFormat.format(date);
        return format;
    }

    public static String getCurrentDate(){
        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dFormat.format(new Date());
        return format;
    }
}
