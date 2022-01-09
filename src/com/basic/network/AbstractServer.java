package com.basic.network;

import java.net.ServerSocket;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/7 12:46
 */
public abstract class AbstractServer implements Runnable{
    /**
     * 暂时还没有确定是否所有服务器都要监测状态，因此监听器的定义只按照目前的需要定义在一些子类中
     */

    //基本的服务器插口
    protected ServerSocket serverSocket;

    //服务器端口号
    private int port;


    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    protected int getPort() {
        return port;
    }

    protected void setPort(int port) {
        this.port = port;
    }



}
