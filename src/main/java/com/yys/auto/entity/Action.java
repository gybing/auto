package com.yys.auto.entity;

/**
 * describe:动作，标识一个执行动作
 *
 * @author lianying
 * @date 2019/01/15
 */
public class Action {
    /**
     * 脚本标签
     */
    private String label;
    /**
     * 参数
     */
    private String params;

    public Action(String label,String params)
    {
        this.label=label;
        this.params=params;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }
}
