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
public class ScriptExecutor {
    public static void run(String script)
    {
        List<Process> list=ScriptResolve.parseProcess(script);
        //遍历执行每个流程块
        for (Process process:list) {
            //遍历执行每个流程块里的动作
            for (Action action:process.getActions()) {
                //只要有一个运行出错就直接break这个流程块。停止
                if(!ActionExecutor.exeAction(action))
                {
                    break;
                }
            }
        }
    }
}
