package com.douma.util.date;

import java.util.Calendar;
import java.util.Date;

/**
 * Copyright (c) 2017. douma.cn, All Rights Reserved
 * Description: 日期工具类
 * User: douma haoxijun
 * Date: 2018-06-13
 * Time: 10:02
 */
public class DateUtil {

    /**
     * 日历对象
     */
    private static final Calendar calendar = Calendar.getInstance();

    /**
     * 获取服务器当前时间
     *
     * @return
     */
    public static Date currentDate() {
        Date now = new Date();
        return now;
    }

    /**
     * 获取 time 之后 month 个月的日期
     *
     * @param time
     * @param month
     * @return
     */
    public static Date afterMonth(Date time, int month) {
        if (time == null
                || month <= 0) {
            throw new IllegalArgumentException("参数异常");
        }
        calendar.setTime(time);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    /**
     * 获取 time 之前 month 个月的日期
     *
     * @param time
     * @param month
     * @return
     */
    public static Date lastMonth(Date time, int month) {
        if (time == null
                || month <= 0) {
            throw new IllegalArgumentException("参数异常");
        }
        calendar.setTime(time);
        calendar.add(Calendar.MONTH, -1 * month);
        return calendar.getTime();
    }

    /**
     * big 的日期是否比 small 晚
     *
     * @param big
     * @param small
     * @return
     */
    public static boolean greater(Date big, Date small) {
        if (big == null
                || small == null) {
            throw new IllegalArgumentException("参数异常");
        }
        if (big.compareTo(small) > 0) {
            return true;
        } else {
            return false;
        }
    }

}
