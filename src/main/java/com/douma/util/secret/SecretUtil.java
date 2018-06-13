package com.douma.util.secret;

import com.alibaba.druid.filter.config.ConfigTools;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Copyright (c) 2017. douma.cn, All Rights Reserved
 * Description: 加密方法
 * User: douma haoxijun
 * Date: 2018-06-11
 * Time: 16:20
 */
public class SecretUtil {

    //RSAKeysUtil生成的私钥
    private static final String PRIVATE_KEY_STRING = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIr6KLFL2Trrgf3Q5Kt9LiKpZY55Tsm4BdED2NS67d6bmYamm3Rt1Zv+0uoM92hy4KSbAf6ariegZLqNJJEG99dLFRLQPvQtX5/FvkzlqPlFLlDK5yKPd0L6KotZwX+jeKyLaPg4uE/rAZz/GmLO7qoGzLxWP44Sl3qRa4Ud7PcbAgMBAAECgYBeLXWD5+1WQx+822EKYPLxpC9g5A2jHqQ6Zsv6JI5rKrBYEfEIbiGx63YMCythSW+3vB8W5MUdr1BzJpBgAwPRjU/QdzesWymkFW05UnB4alX1bBZhPl8pKIzbo+5s1X//k1RFvBDSkYaiSJMiipsmwmKW81CzrCxUOyFfSML4KQJBANF9BtHgSWweinAejP2oDrytzpUczotM602q78sCc0WjXQeSIkIKBsdV8uonitsnnIH0E1zhdZr7Dua/AzgJlF8CQQCp1WRoJ/dFi7ltb0pQ0tBV3argk8i76Dd51HC339w6nq/zUobORn1IEjl92HoQcIoeJZm6XA4ZEHi+SsysFnbFAkBSNeWSQZmuw4GCpIqiFOzLoM3ceLSZuDLzhOyb17dTEdw1V2T4U6T7X0B4IdJ9VNs3qIhcv+H+Ux4y8a0ata+zAkBZ1333L3U6gBDGmIH6wZreYZYcmXEuHkkClORQEQdip0Gy+WxAwL9Tmfh530OrYK1gB0oMcNgwYCtPlygwvO11AkEAjRPHfaFe6Tr1FFNw1ZE9Adj2oFVcmuH0lZY8NGxSqvM72YfhwjcLQmnWZ9gCG2mt8/tLbkI48O4y7/eHOhEKLg==";
    //RSAKeysUtil生成的公钥
    private static final String PUBLIC_KEY_STRING = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCK+iixS9k664H90OSrfS4iqWWOeU7JuAXRA9jUuu3em5mGppt0bdWb/tLqDPdocuCkmwH+mq4noGS6jSSRBvfXSxUS0D70LV+fxb5M5aj5RS5Qyucij3dC+iqLWcF/o3isi2j4OLhP6wGc/xpizu6qBsy8Vj+OEpd6kWuFHez3GwIDAQAB";

    /**
     * 私钥加密方法
     *
     * @param content 加密内容
     * @return
     */
    public static String encrypt(String content) {
        try {
            return ConfigTools.encrypt(PRIVATE_KEY_STRING, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 公钥解密方法
     *
     * @param encryptStr
     * @return
     */
    public static String decrypt(String encryptStr) {
        try {
            return ConfigTools.decrypt(PUBLIC_KEY_STRING, encryptStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * MD5 加密
     *
     * @param content
     * @return
     */
    public static String md5(String content) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(content.getBytes());
            String md5 = new BigInteger(1, md.digest()).toString(16);
            return fillMD5(md5);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5加密错误:" + e.getMessage(), e);
        }
    }

    private static String fillMD5(String md5) {
        return md5.length() == 32 ? md5 : fillMD5("0" + md5);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(encrypt("123456"));
    }

}
