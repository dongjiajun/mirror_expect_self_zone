package com.basic.network;

import com.basic.common.AccessNodeList;
import com.basic.common.ListenerCollector;
import com.basic.common.AccessProcessing;
import com.basic.event.ActionEvent;
import com.basic.event.CommonListener;
import com.basic.graphic.map.AbstractNetWorkAccessibleMap;
import com.basic.network.handler.UserConnectHandler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/11/25 20:45
 */

public class SimpleAccessibleMapServer extends AbstractAccessibleMapServer implements AccessProcessing {

    private String classType;

    private AbstractNetWorkAccessibleMap map;


    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public SimpleAccessibleMapServer(AccessNodeList accessNodeList, ListenerCollector listenerCollector, int port, AbstractNetWorkAccessibleMap map) throws IOException {
        setPort(port);

        this.listenerCollector = listenerCollector;
        this.accessNodeList = accessNodeList;
        this.map = map;
        setClassType(null);

        serverSocket = new ServerSocket(port);
    }

    public SimpleAccessibleMapServer(AccessNodeList accessNodeList, ListenerCollector listenerCollector, AbstractNetWorkAccessibleMap map) throws IOException {
        setPort(-1);

        this.listenerCollector = listenerCollector;
        this.accessNodeList = accessNodeList;
        this.map = map;
        setClassType(null);

        serverSocket = new ServerSocket(6666);
    }

    private void execute() throws IOException {
        System.out.println(getClassType()+"的用户服务器已启动....");
        for (;;) {
            Socket sock = serverSocket.accept();
            addToAccessNodeList(sock.getInetAddress().toString() + ":" + sock.getPort(), sock);
            new Thread(new UserConnectHandler(sock, classType, this, map)).start();
        }
    }


    @Override
    public void run() {
        try {
            execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean addToAccessNodeList(String identity, Socket socket){
        accessNodeList.putIfAbsent(identity, socket);
        fireAccessNodeListChanged("新用户(" + identity + ")加入" + "(" + classType + ")");
        return true;
    }

    @Override
    public boolean removeFromAccessNodeList(String identity) {
        accessNodeList.remove(identity);
        fireAccessNodeListChanged("用户(" + identity + ")" + "离开" + "(" + classType + ")");
        return true;
    }

    @Override
    public boolean updateWhenExistIn(String identity, Socket socket) {
        accessNodeList.put(identity, socket);

        fireAccessNodeListChanged("用户(" + identity + ")" + "连接已更新" + "(" + classType + ")");
        return true;
    }


    @Override
    protected void fireAccessNodeListChanged(String identity){
        if(listenerCollector == null){
            return;
        }
        ActionEvent event = new ActionEvent(this,"AccessListener", identity);
        notifyListeners(event);
    }

    @Override
    protected void notifyListeners(ActionEvent event){
        HashSet affectListeners = listenerCollector.get(event.getType());

        if(affectListeners == null)
            return;
        Iterator iter = affectListeners.iterator();
        while(iter.hasNext()){
            CommonListener commonListener =(CommonListener)iter.next();
            commonListener.doEvent(event);
        }

    }
}

