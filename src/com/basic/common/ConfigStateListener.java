package com.basic.common;

import com.basic.event.StateListener;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/7 9:14
 */

/**
 * 实现了此接口的类可以同时设置多个具有不同功能的图状态改变监听器
 */
public interface ConfigStateListener {

    public void setStateListener(StateListener listener);

    public void removeStateListener(StateListener listener);


}
