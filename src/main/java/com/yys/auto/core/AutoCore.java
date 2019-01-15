package com.yys.auto.core;

import com.yys.auto.entity.Coordinate;
import com.yys.auto.utils.ImageUtils;
import com.yys.auto.utils.KeyboardUtils;
import com.yys.auto.utils.MouseUtils;

import java.awt.image.BufferedImage;

/**
 * describe: 这里提供自动化的核心
 *
 * @author lianying
 * @date 2019/01/15
 */
public class AutoCore {
    /**
     * 寻找图片并且点击
     *
     * @param name
     * @return
     */
    public static boolean findImageAndOnclick(String name) {
        BufferedImage bufferedImage = ImageUtils.getScreen();
        BufferedImage bufferedImage1 = ImageUtils.getBufferedImage(name);
        Coordinate coordinate = ImageUtils.find(bufferedImage, bufferedImage1);
        if (coordinate != null) {
            System.out.println("x:" + coordinate.getX() + "-- y:" + coordinate.getY());
            MouseUtils.moveAndOnclickLeft(coordinate.getX(), coordinate.getY());
            return true;
        }
        return false;
    }

    /**
     * 输入字符串
     *
     * @param s
     * @return
     */
    public static boolean input(String s)
    {
        try {
            KeyboardUtils.write(s);
        }catch (Exception e)
        {
            return false;
        }
        return true;
    }


}
