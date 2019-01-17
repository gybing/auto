package com.yys.auto.core;

import com.alibaba.fastjson.JSONObject;
import com.yys.auto.entity.Action;
import com.yys.auto.entity.Process;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * describe: 脚本运行器
 *
 * @author lianying
 * @date 2019/01/15
 */
public class ScriptExecutor {
    /**
     * log4j
     */
    private static final Logger logger= Logger.getLogger(ScriptExecutor.class);
    public static void run(String script)
    {
        List<Process> list=ScriptResolve.parseProcess(script);
        logger.info("查到到了 "+list.size()+" 个流程块");
        //遍历执行每个流程块
        for (Process process:list) {
            //遍历执行每个流程块里的动作
            logger.info("当前流程块有 "+process.getActions().size()+" 个动作");
            for (Action action:process.getActions()) {
                //只要有一个运行出错就直接break这个流程块。停止
                if(!ActionExecutor.exeAction(action))
                {
                    logger.error("当前动作执行失败，退出当前流程:"+JSONObject.toJSONString(action));
                    break;
                }
            }
        }
    }
}
