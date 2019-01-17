package com.yys.auto.core;

import com.yys.auto.entity.Action;

/**
 * describe:动作执行者
 *
 * @author lianying
 * @date 2019/01/15
 */
public class ActionExecutor {
    /**
     * 动作执行
     *
     * @param action
     * @return
     */
    public static boolean exeAction(Action action)
    {
        boolean result;
        switch (action.getLabel())
        {
            case "fac":
                //寻找，然后鼠标移动并点击
                result=AutoCore.findImageAndOnclick(action.getParams());
                break;
            case "i":
                //输入
                result=AutoCore.input(action.getParams());
                break;
            case "s":
                //睡眠
                try {
                    Thread.sleep(Integer.valueOf(action.getParams()));
                    result=true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    result=false;
                }
                break;
                default:
                    result=false;
        }
        return result;
    }

}
