package com.basic.common;


/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/7 16:08
 */
public interface NetWorked {

    public boolean isNetWorkedReady();

    public void connectTo(String host, int port) throws Exception;
}
