package com.douma.util.list;

import java.util.LinkedList;
import java.util.List;

/**
 * Copyright (c) 2017. douma.cn, All Rights Reserved
 * Description: List工具类
 * User: douma haoxijun
 * Date: 2018-06-12
 * Time: 11:06
 */
public class ListUtil {

    /**
     * 判断list是否为空
     *
     * @param list
     * @return
     */
    static public boolean isEmpty(List list) {
        if (list != null && list.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 判断list是否不为空
     *
     * @param list
     * @return
     */
    static public boolean isNotEmpty(List list) {
        if (list != null && list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取list中最大值
     *
     * @param list
     * @param <T>
     * @return
     */
    static public <T extends Comparable> T getMax(List<T> list) {
        if (isNotEmpty(list)) {
            T max = list.get(0);
            for (T t : list) {
                if (max.compareTo(t) < 0) {
                    max = t;
                }
            }
            return max;
        }
        return null;
    }

    /**
     * 获取list中最小值
     *
     * @param list
     * @param <T>
     * @return
     */
    static public <T extends Comparable<T>> T getMin(List<T> list) {
        if (isNotEmpty(list)) {
            T max = list.get(0);
            for (T t : list) {
                if (max.compareTo(t) > 0) {
                    max = t;
                }
            }
            return max;
        }
        return null;
    }

    /**
     * list中是否包含（根据值）
     *
     * @param list
     * @param value
     * @param <T>
     * @return
     */
    static public <T extends Comparable<T>> boolean containByValue(List<T> list, T value) {
        if (isNotEmpty(list)) {
            for (T t : list) {
                if (t == value
                        || t.compareTo(value) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 字符串list去重
     *
     * @param list
     * @return
     */
    static public List<String> deDuplicationForString(List<String> list) {
        if (isEmpty(list)) {
            return list;
        }
        List<String> newList = new LinkedList<String>();
        for (int i = 0; i < list.size(); i++) {
            if (!newList.contains(list.get(i))) {
                newList.add(list.get(i));
            }
        }
        return newList;
    }
    
}
