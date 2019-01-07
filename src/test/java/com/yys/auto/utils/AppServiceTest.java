package com.yys.auto.utils;

import com.yys.auto.entity.Coordinate;
import org.junit.Test;

import java.awt.image.BufferedImage;

/**
 * describe:应用业务流程测试部分
 *
 * @author lianying
 * @date 2019/1/6
 */
public class AppServiceTest {
    @Test
    public void yaoqi() {
        go("images/test3.png");
        goTeam();
    }

    /**
     * 进入组队
     */
    private void goTeam() {
        go("images/zd.png");
    }

    private void go(String name) {
        BufferedImage bufferedImage = ImageUtils.getScreen();
        BufferedImage bufferedImage1 = ImageUtils.getBufferedImage(name);
        Coordinate coordinate = ImageUtils.find(bufferedImage, bufferedImage1);
        if (coordinate != null) {
            System.out.println("x:" + coordinate.getX() + "-- y:" + coordinate.getY());
            MouseUtils.moveAndOnclickLeft(coordinate.getX(), coordinate.getY());
        } else {
            System.out.println("未识别到内容");
        }
    }
}
