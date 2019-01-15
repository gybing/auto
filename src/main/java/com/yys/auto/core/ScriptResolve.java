package com.yys.auto.core;

import com.alibaba.fastjson.JSONObject;
import com.yys.auto.entity.Action;
import com.yys.auto.entity.Process;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:脚本解析器
 *
 * @author lianying
 * @date 2019/01/15
 */
public class ScriptResolve {
    private ScriptResolve()
    {}

    /**
     * 将字符串解析成流程数组
     *
     * @param s
     * @return
     */
    public static List<Process> parseProcess(String s)
    {
        String [] strings = new String[0];
        strings = JSONObject.parseObject(s,strings.getClass());
        List<Process> processes=new ArrayList<>();
        for (String p:strings) {
            processes.add(new Process(parseAction(p)));
        }
        return processes;
    }

    /**
     * 将字符串解析成动作
     *
     * @param s
     * @return
     */
    public static List<Action> parseAction(String s)
    {
        List actionList=new ArrayList();
        String [] actionStrings=s.split(",");
        for (int i = 0; i < actionStrings.length; i++) {
            String actionString=actionStrings[i];
            String [] ss=actionString.split(":");
            String label=ss[0];
            String params=ss[1];
            Action action=new Action(label,params);
            actionList.add(action);
        }
        return actionList;
    }
}
