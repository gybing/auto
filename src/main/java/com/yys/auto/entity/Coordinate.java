package com.yys.auto.entity;

/**
 * describe: 坐标对象
 *
 * @author lianying
 * @date 2019/1/5
 */
public class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        //这里进行修正偏移量
        this.x = x + 20;
        this.y = y + 20;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
