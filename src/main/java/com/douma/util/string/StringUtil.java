package com.douma.util.string;

/**
 * Copyright (c) 2017. douma.cn, All Rights Reserved
 * Description: 字符工具类
 * User: douma haoxijun
 * Date: 2018-06-13
 * Time: 14:46
 */
public class StringUtil {

    /**
     * 字符串为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 字符串非空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        if (str != null && !"".equals(str)) {
            return true;
        } else {
            return false;
        }
    }

}
