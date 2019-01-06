package com.yys.auto.utils;

import org.junit.Test;

/**
 * describe:
 *
 * @author lianying
 * @date 2019/1/5
 */
public class MouseUtilsTest {
    /**
     * 测试鼠标移动
     */
    @Test
    public void moveTest() {
        MouseUtils.move(619, 817);
        MouseUtils.move(1000, 100);
    }

    /**
     * 测试鼠标移动并点击左键
     */
    @Test
    public void moveAndOnclickLeftTest() {
        MouseUtils.moveAndOnclickLeft(100, 100);
    }

    /**
     * 测试鼠标移动并点击右键
     */
    @Test
    public void moveAndOnclickRightTest() {
        MouseUtils.moveAndOnclickRight(100, 100);
    }
}
