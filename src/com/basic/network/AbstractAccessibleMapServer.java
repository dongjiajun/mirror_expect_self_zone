package com.basic.network;

import com.basic.common.AccessNodeList;
import com.basic.common.ListenerCollector;
import com.basic.event.ActionEvent;


/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/8 17:20
 */
public abstract class AbstractAccessibleMapServer extends AbstractServer{

    //监听器
    protected ListenerCollector listenerCollector;

    //连接的用户列表
    protected AccessNodeList accessNodeList;


    abstract protected void fireAccessNodeListChanged(String identity);

    abstract protected void notifyListeners(ActionEvent event);
}
