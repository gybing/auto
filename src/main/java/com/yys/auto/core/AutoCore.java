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
        //获得屏幕截图
        BufferedImage bufferedImage = ImageUtils.getScreen();
        //获得素材小图
        BufferedImage bufferedImage1 = ImageUtils.getBufferedImage(name);
        //寻找小图坐标
        Coordinate coordinate = ImageUtils.find(bufferedImage, bufferedImage1);
        if (coordinate != null) {
            //如果coordinate对象不为空说明有查找到内容，鼠标移动并点击
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
