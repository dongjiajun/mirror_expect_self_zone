package com.basic.graphic;

import com.basic.common.ListenerCollector;
import com.basic.event.ActionEvent;


/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/11/25 8:09
 */
public abstract class Graphic {
    /**
     * 32位的状态位：0000 0000 0000 0000 0000 0000 0000 0000
     *
     * 31，32位作为就绪状态位：
     * 00 还未初始化
     * 01 就绪
     * 11 完成
     *
     * 29，30位作为网络状态位:
     * 00 不允许接入网络
     * 01 已允许联网
     */
    private int state;

    //监听器容器
    protected ListenerCollector listenerCollector;

    public Graphic(){
        this.state = 0x00000000;
        listenerCollector = new ListenerCollector();
    }

    protected void setState(int state) {
        this.state = state;
        fireStateChanged();
    }

    protected int getState() {
        return state;
    }

    abstract public String getStateDescribeMessage();

    //在本项目中，任何图形都应该允许被监听状态(注意是允许，是否监听取决于可插拔式配置)
    abstract protected void fireStateChanged();

    abstract protected void removeAllListeners();

    abstract protected void notifyListeners(ActionEvent event);



}
