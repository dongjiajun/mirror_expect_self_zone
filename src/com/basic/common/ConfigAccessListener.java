package com.basic.common;

import com.basic.event.AccessListener;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/6 21:45
 */

/**
 * 实现了此接口的类可以同时设置多个具有不同功能的用户连接状态监听器
 */
public interface ConfigAccessListener {

    public void setAccessListener(AccessListener listener);

    public void removeAccessListener(AccessListener listener);


}
