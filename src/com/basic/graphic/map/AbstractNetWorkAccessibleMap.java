package com.basic.graphic.map;

import com.basic.common.CoordinatesProcessing;
import com.basic.common.NetWorkAccessible;
import com.basic.common.AccessNodeList;
import com.basic.network.SimpleAccessibleMapServer;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/8 10:48
 */
public abstract class AbstractNetWorkAccessibleMap extends AbstractMap implements NetWorkAccessible, CoordinatesProcessing {
    //接入到本地图的用户列表
    protected AccessNodeList accessNodeList;

    //监听连接的服务器(后续版本要改为nio的实现方式)
    protected SimpleAccessibleMapServer userConnectServer;

    public AbstractNetWorkAccessibleMap(){ accessNodeList = new AccessNodeList(); }


}
