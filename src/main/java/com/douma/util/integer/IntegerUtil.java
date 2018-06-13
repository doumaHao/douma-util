package com.douma.util.integer;

/**
 * Copyright (c) 2017. douma.cn, All Rights Reserved
 * Description: 整型工具类
 * User: douma haoxijun
 * Date: 2018-06-13
 * Time: 14:50
 */
public class IntegerUtil {

    /**
     * 整型为空
     *
     * @param in
     * @return
     */
    public static boolean isNull(Integer in) {
        if (in == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 整型不为空
     *
     * @param in
     * @return
     */
    public static boolean isNotNull(Integer in) {
        if (in != null) {
            return true;
        } else {
            return false;
        }
    }
}
