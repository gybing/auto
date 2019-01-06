package com.yys.auto.utils;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * describe:
 *
 * @author lianying
 * @date 2019/1/5
 */
public class RuntimeUtilsTest {

    @Test
    public void runtimeTest() {
        try {
            File file = new File("D:\\Program Files (x86)\\Onmyoji\\Launch.exe");
            RumtimeUtils.exec(file);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("运行失败");
        }
    }
}
