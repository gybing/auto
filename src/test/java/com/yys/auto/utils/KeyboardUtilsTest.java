package com.yys.auto.utils;

import org.junit.Test;

/**
 * describe:
 *
 * @author lianying
 * @date 2019/1/5
 */
public class KeyboardUtilsTest {
    /**
     * 测试字符串输入，目前只支持字母和数字组合
     */
    @Test
    public void writeTest() {
        MouseUtils.moveAndOnclickLeft(800, 130);
        KeyboardUtils.write("AAABB");
    }
}
