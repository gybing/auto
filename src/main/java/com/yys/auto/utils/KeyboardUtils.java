package com.yys.auto.utils;

import org.apache.log4j.Logger;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * describe: 键盘工具
 *
 * @author lianying
 * @date 2019/1/5
 */
public class KeyboardUtils {
    private static Robot robot;
    /**
     * log4j
     */
    private static final Logger logger=Logger.getLogger(KeyboardUtils.class);

    static {
        try {
            robot = new Robot();
            double ms = Math.random() * 100;
            robot.setAutoDelay((int) ms);
        } catch (AWTException e) {
            logger.error("获取Robot失败",e);
        }
    }

    /**
     * 输入字符串
     *
     * @param s
     */
    public static void write(String s) {
        char[] chars = s.toCharArray();
        for (char c : chars) {
            write(c);
        }
    }

    /**
     * 输入字符
     *
     * @param c
     */
    public static void write(Character c) {
        //保存按键的键值
        int event = 0;
        boolean isLower = true;
        switch (c) {
            case 'A':
                event = KeyEvent.VK_A;
                isLower = false;
                break;
            case 'B':
                event = KeyEvent.VK_B;
                isLower = false;
                break;
            case 'C':
                event = KeyEvent.VK_C;
                isLower = false;
                break;
            case 'D':
                event = KeyEvent.VK_D;
                isLower = false;
                break;
            case 'E':
                event = KeyEvent.VK_E;
                isLower = false;
                break;
            case 'F':
                event = KeyEvent.VK_F;
                isLower = false;
                break;
            case 'G':
                event = KeyEvent.VK_G;
                isLower = false;
                break;
            case 'H':
                event = KeyEvent.VK_H;
                isLower = false;
                break;
            case 'I':
                event = KeyEvent.VK_I;
                isLower = false;
                break;
            case 'J':
                event = KeyEvent.VK_J;
                isLower = false;
                break;
            case 'K':
                event = KeyEvent.VK_K;
                isLower = false;
                break;
            case 'L':
                event = KeyEvent.VK_L;
                isLower = false;
                break;
            case 'M':
                event = KeyEvent.VK_M;
                isLower = false;
                break;
            case 'N':
                event = KeyEvent.VK_N;
                isLower = false;
                break;
            case 'O':
                event = KeyEvent.VK_O;
                isLower = false;
                break;
            case 'P':
                event = KeyEvent.VK_P;
                isLower = false;
                break;
            case 'Q':
                event = KeyEvent.VK_Q;
                isLower = false;
                break;
            case 'R':
                event = KeyEvent.VK_R;
                isLower = false;
                break;
            case 'S':
                event = KeyEvent.VK_S;
                isLower = false;
                break;
            case 'T':
                event = KeyEvent.VK_T;
                isLower = false;
                break;
            case 'U':
                event = KeyEvent.VK_U;
                isLower = false;
                break;
            case 'V':
                event = KeyEvent.VK_V;
                isLower = false;
                break;
            case 'W':
                event = KeyEvent.VK_W;
                isLower = false;
                break;
            case 'X':
                event = KeyEvent.VK_X;
                isLower = false;
                break;
            case 'Y':
                event = KeyEvent.VK_Y;
                isLower = false;
                break;
            case 'Z':
                event = KeyEvent.VK_Z;
                isLower = false;
                break;
            case 'a':
                event = KeyEvent.VK_A;
                break;
            case 'b':
                event = KeyEvent.VK_B;
                break;
            case 'c':
                event = KeyEvent.VK_C;
                break;
            case 'd':
                event = KeyEvent.VK_D;
                break;
            case 'e':
                event = KeyEvent.VK_E;
                break;
            case 'f':
                event = KeyEvent.VK_F;
                break;
            case 'g':
                event = KeyEvent.VK_G;
                break;
            case 'h':
                event = KeyEvent.VK_H;
                break;
            case 'i':
                event = KeyEvent.VK_I;
                break;
            case 'j':
                event = KeyEvent.VK_J;
                break;
            case 'k':
                event = KeyEvent.VK_K;
                break;
            case 'l':
                event = KeyEvent.VK_L;
                break;
            case 'm':
                event = KeyEvent.VK_M;
                break;
            case 'n':
                event = KeyEvent.VK_N;
                break;
            case 'o':
                event = KeyEvent.VK_O;
                break;
            case 'p':
                event = KeyEvent.VK_P;
                break;
            case 'q':
                event = KeyEvent.VK_Q;
                break;
            case 'r':
                event = KeyEvent.VK_R;
                break;
            case 's':
                event = KeyEvent.VK_S;
                break;
            case 't':
                event = KeyEvent.VK_T;
                break;
            case 'u':
                event = KeyEvent.VK_U;
                break;
            case 'v':
                event = KeyEvent.VK_V;
                break;
            case 'w':
                event = KeyEvent.VK_W;
                break;
            case 'x':
                event = KeyEvent.VK_X;
                break;
            case 'y':
                event = KeyEvent.VK_Y;
                break;
            case 'z':
                event = KeyEvent.VK_Z;
                break;
            case '0':
                event = KeyEvent.VK_Z;
                break;
            case '1':
                event = KeyEvent.VK_1;
                break;
            case '2':
                event = KeyEvent.VK_2;
                break;
            case '3':
                event = KeyEvent.VK_3;
                break;
            case '4':
                event = KeyEvent.VK_4;
                break;
            case '5':
                event = KeyEvent.VK_5;
                break;
            case '6':
                event = KeyEvent.VK_6;
                break;
            case '7':
                event = KeyEvent.VK_7;
                break;
            case '8':
                event = KeyEvent.VK_8;
                break;
            case '9':
                event = KeyEvent.VK_9;
                break;
            case '.':
                event = KeyEvent.VK_PERIOD;
                break;
        }
        //小写的话直接按一次
        if (isLower) {
            robot.keyPress(event);
            robot.keyRelease(event);
        } else {
            //大写的话要先按着shift变成大写再放开
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(event);
            robot.keyRelease(event);
            robot.keyRelease(KeyEvent.VK_SHIFT);
        }
    }
}
