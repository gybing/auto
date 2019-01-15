package com.yys.auto.core;

import com.yys.auto.entity.Action;
import com.yys.auto.entity.Process;

import java.util.List;

/**
 * describe: 脚本运行器
 *
 * @author lianying
 * @date 2019/01/15
 */
public class ScriptRunner {
    public static void run(String script)
    {
        List<Process> list=ScriptResolve.parseProcess(script);
        for (Process process:list) {
            for (Action action:process.getActions()) {
                //只要有一个运行出错就直接break这个流程块。停止
                if(!ActionRunner.exeAction(action))
                {
                    break;
                }
            }
        }
    }
}
