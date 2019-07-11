package me.look.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**日期工具类*/
public class DateUtils {


    /**获取当前日期yyyy-MM-dd HH:mm:ss*/
    public static String GetCurrentDateTimeToString()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间
    }

    /**获取当前日期yyyy-MM-dd*/
    public static String GetCurrentDateToString()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间
    }
}
