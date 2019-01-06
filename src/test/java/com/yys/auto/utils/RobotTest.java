package com.yys.auto.utils;

import org.junit.Test;

import java.awt.*;

/**
 * describe:
 *
 * @author lianying
 * @date 2019/1/5
 */
public class RobotTest {
    @Test
    public void test() throws AWTException {
        Robot rb = null;
        rb = new Robot();
        rb.setAutoDelay(200);
        rb.mouseMove(100, 100);

    }
}
