package com.yys.auto;

import com.yys.auto.view.MainView;
import org.apache.log4j.Logger;


/**
 * describe:启动类
 *
 * @author lianying
 * @date 2019/1/5
 */
public class AppStarter {
    /**
     * log4j
     */
    private static final Logger logger=Logger.getLogger(AppStarter.class);

    public static void main(String[] args){
        //启动主视图
        logger.info("程序启动");
        new MainView();
    }
}
