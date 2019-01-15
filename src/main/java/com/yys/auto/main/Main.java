package com.yys.auto.main;

import com.yys.auto.core.ScriptRunner;


/**
 * describe:
 *
 * @author lianying
 * @date 2019/1/5
 */
public class Main {

    public static void main(String[] args){
        String jiaoben ="[\"fac:/images/wwy.png,s:500,fac:/images/wwy.png\"]";
        //运行脚本
        ScriptRunner.run(jiaoben);
    }
}
