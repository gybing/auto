package com.yys.auto.entity;

import java.util.List;

/**
 * describe:脚本流程实体。
 *
 * @author lianying
 * @date 2019/01/15
 */
public class Process {
    /**
     * 一个流程包含了多个动作。
     */
    private List<Action> actions;

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public Process(List<Action> actions)
    {
        this.actions=actions;
    }
}
