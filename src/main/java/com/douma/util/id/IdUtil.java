package com.douma.util.id;

import java.security.SecureRandom;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Copyright (c) 2017. douma.cn, All Rights Reserved
 * Description: 随机唯一key工具类
 * User: douma haoxijun
 * Date: 2018-06-13
 * Time: 10:02
 */
public class IdUtil {

    /**
     * 随机 SecureRandom
     */
    private static final SecureRandom random = new SecureRandom();

    /**
     * uuid4dateLong标准18位
     * 可以实现毫秒级别1000个随机不唯一
     */
    private static final int uuidForDateLong_standard = 18;

    /**
     * java原生uuid
     *
     * @return
     */
    public static String uid() {
        return UUID.randomUUID().toString();
    }

    /**
     * 当前时间13位+bit位字符 根据时间获取id 时间的long类型
     *
     * @param bit id的位数长度
     * @return
     */
    public static String uuidForDateLong(int bit) {
        if (bit < 13) {
            throw new IllegalArgumentException("参数长度最少为13");
        }
        Date date = new Date();
        String id = String.valueOf(date.getTime());
        if (bit > 13) {
            id = id + uuid(bit - 13);
        }
        return id;
    }

    /**
     * 当前时间13位字符 根据时间获取id 时间的long类型
     *
     * @return
     */
    public static String uuidForDateLong() {
        return uuidForDateLong(uuidForDateLong_standard);
    }

    /**
     * 随机bit位字符
     *
     * @param bit
     * @return
     */
    public static String uuid(int bit) {
        String id = "";
        for (int i = 0; i < bit; i++) {
            int ra = random.nextInt(10);
            id = id + ra;
        }
        return id;
    }

    /**
     * 随机32位字符 jdk uuid
     *
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void main(String[] args) {
        Set set = new HashSet<String>();
        for (int i = 0; i < 1000; i++) {
//            String id = uuid4dateLong(18);
//            set.add(id);
//            System.out.println(id);
        }
//        System.out.println(set.size());
        System.out.println(uid().toLowerCase());
    }

}
