package com.yys.auto.utils;

import org.junit.Test;

/**
 * describe:
 *
 * @author lianying
 * @date 2019/1/5
 */
public class KeyboardUtilsTest {
    @Test
    public void writeTest() {
        MouseUtils.moveAndOnclickLeft(800, 130);
        KeyboardUtils.write("AAABB");
    }
}
