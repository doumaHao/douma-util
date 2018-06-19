package com.douma.util.oss;

import com.aliyun.oss.OSSClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 * Copyright (c) 2017. douma.cn, All Rights Reserved
 * Description:
 * User: douma haoxijun
 * Date: 2018-06-14
 * Time: 9:36
 */
public class OSSClientUtil {

    private static final Logger logger = LoggerFactory.getLogger(OSSClientUtil.class);

    private static final String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
    private static final String accessKeyId = "LTAIUwCHHejtv6Qx";
    private static final String accessKeySecret = "NbTj17bgAhF7hymSrdZzUkysvzYQ7x";
    private static final String requestUrl = "https://haoxijun-demo2018.oss-cn-hangzhou.aliyuncs.com/";

    /**
     * 上传文件
     *
     * @param file
     * @param bucket
     * @return
     * @throws Exception
     */
    public static String upload(File file, String bucket) throws Exception {
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        String fileKey = new Date().getTime() + ".pdf";
        InputStream inputStream = new FileInputStream(file);
        ossClient.putObject(bucket, fileKey, inputStream);
        ossClient.shutdown();
        String url = requestUrl + fileKey;
        return fileKey;
    }

    /**
     * 获取动态url
     *
     * @param key
     * @return
     */
    public static String url(String key, String bucket) {
        // 设置URL过期时间为10年  3600l* 1000*24*365*10
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        // 生成URL
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        URL url = ossClient.generatePresignedUrl(bucket, key, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\Administrator\\Desktop\\9821b9ba-9e84-4dfa-8a73-057a0743bd5e.pdf");
        String key = upload(file, "haoxijun-demo2018");
        String url = url(key, "haoxijun-demo2018");


        URL url_ = new URL(url);
        URLConnection urlConn = url_.openConnection();
        InputStream netFileInputStream = urlConn.getInputStream();
        if (null != netFileInputStream) {
            System.out.println("文件存在");
        } else {
            System.out.println("文件不存在");
        }
        System.out.println(url);
    }


}
