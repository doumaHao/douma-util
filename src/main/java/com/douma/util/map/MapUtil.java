package com.douma.util.map;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Copyright (c) 2017. douma.cn, All Rights Reserved
 * Description: map工具类
 * User: douma haoxijun
 * Date: 2018-06-19
 * Time: 20:49
 */
public class MapUtil {

    /**
     * 对象转map
     *
     * @return
     */
    public static Map object2map(Object object) {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Map result = new LinkedHashMap();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                result.put(field.getName(), field.get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
