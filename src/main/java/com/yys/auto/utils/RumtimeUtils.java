package com.yys.auto.utils;

import java.io.File;
import java.io.IOException;

/**
 * describe: 运行工具类
 *
 * @author lianying
 * @date 2019/1/5
 */
public class RumtimeUtils {
    private static Runtime runtime = Runtime.getRuntime();

    /**
     * 运行指定程序
     *
     * @param exeFile
     * @throws IOException
     */
    public static void exec(File exeFile) throws IOException {
        runtime.exec(exeFile.getAbsolutePath());
    }
}
