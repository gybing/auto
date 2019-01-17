package com.yys.auto.core;

import com.alibaba.fastjson.JSONObject;
import com.yys.auto.entity.Coordinate;
import com.yys.auto.utils.ImageUtils;
import com.yys.auto.utils.KeyboardUtils;
import com.yys.auto.utils.MouseUtils;
import org.apache.log4j.Logger;

import java.awt.image.BufferedImage;

/**
 * describe: 这里提供自动化的核心
 *
 * @author lianying
 * @date 2019/01/15
 */
public class AutoCore {
    /**
     * log4j
     */
    private static final Logger logger= Logger.getLogger(AutoCore.class);

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
            logger.info("寻找到了小图坐标并点击："+ JSONObject.toJSONString(coordinate));
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
        logger.info("输入字符串："+ s);
        try {
            KeyboardUtils.write(s);
        }catch (Exception e)
        {
            logger.error("输入失败："+s);
            return false;
        }
        return true;
    }


}
