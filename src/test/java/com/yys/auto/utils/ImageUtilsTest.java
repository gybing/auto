package com.yys.auto.utils;

import com.yys.auto.entity.Coordinate;
import org.junit.Assert;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * describe:
 *
 * @author lianying
 * @date 2019/1/5
 */
public class ImageUtilsTest {
    /**
     * 尝试在本机的屏幕截图上寻找testImage图像
     *
     * @throws URISyntaxException
     */
    @Test
    public void imageUtilsTest() throws URISyntaxException {
        BufferedImage bufferedImage = ImageUtils.getScreen();
        BufferedImage testImage = ImageUtils.getBufferedImage("images/wwy.png");
        Coordinate coordinate = ImageUtils.find(bufferedImage, testImage);
        if (coordinate != null) {
            System.out.println("x:" + coordinate.getX() + "-- y:" + coordinate.getY());
            MouseUtils.moveAndOnclickLeft(coordinate.getX(), coordinate.getY());
        } else {
            System.out.println("未识别到内容");
        }

    }

    /**
     * 测试两个int数组是否属于包含关系
     */
    @Test
    public void findTest() {
        int[] bytes = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] bytes2 = new int[]{13, 14, 15};
        int index = ImageUtils.find(bytes, bytes2);
        System.out.println(index);
    }

    @Test
    public void getScreenTest() {
        ImageUtils.getScreen();
    }

    /**
     * 测试图片转换成int数组
     *
     * @throws URISyntaxException
     */
    @Test
    public void getIntArrayTest() throws URISyntaxException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("wwy.png");
        BufferedImage bufferedImage1 = ImageUtils.getBufferedImage(new File(url.toURI()));
        int[] intArray = ImageUtils.getIntArray(bufferedImage1);
        System.out.println(intArray.length);
    }
}
