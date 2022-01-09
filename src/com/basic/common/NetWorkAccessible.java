package com.basic.common;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/7 20:45
 */
public interface NetWorkAccessible {

    public boolean isNetWorkAccessibleReady();

    public boolean allowNetworkAccess(int port) throws Exception;


}

