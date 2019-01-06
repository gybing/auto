package com.yys.auto.utils;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * describe:路径工具类
 *
 * @author lianying
 * @date 2019/1/6
 */
public class PathUtils {
    /**
     * 获得class路径,如果获取失败就默认D盘根目录
     *
     * @return
     */
    public static String getClassPath() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("");
        try {
            File file = new File(url.toURI());
            return file.getAbsolutePath()+"/";
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return "D:/";
    }
}
