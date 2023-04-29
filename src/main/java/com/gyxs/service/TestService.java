package com.gyxs.service;

import com.gyxs.utils.ImageToByteArrayUtil;
import com.gyxs.utils.test;

public class TestService {
    private static String path;
    private static int height;
    private static int width;
    public static void test(String data) {
        //解析参数
        preData(data);
        test.CLibrary.INSTANCE.demo(ImageToByteArrayUtil.getByteArray(path), height, width, 3);
    }

    private static void preData(String data) {
        //连线关系
        String[] relationship = data.split("@");

        for (String s1 : relationship) {
            String[] s2 = s1.split("_");
            if(s2[0].contains("过程")){
                String[] params = s2[0].split(",");
                path=params[1];
                width=Integer.parseInt(params[2]);
                height=Integer.parseInt(params[3]);
            }
        }

    }
}
