package com.yys.auto.main;

import com.yys.auto.entity.Coordinate;
import com.yys.auto.utils.ImageUtils;
import com.yys.auto.utils.MouseUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * describe:
 *
 * @author lianying
 * @date 2019/1/5
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
//        JFrame frame = new JFrame("MainForm");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(600,500);
//        frame.setPreferredSize(new Dimension(600,500));
//        frame.pack();
//        frame.setVisible(true);
        yaoqi();
    }

    public static void yaoqi() {
        go("images/wwy.png");
        goTeam();
    }

    /**
     * 进入组队
     */
    private static void goTeam() {
        go("images/zd.png");
    }

    private static void go(String name) {
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
