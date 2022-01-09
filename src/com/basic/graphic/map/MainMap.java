package com.basic.graphic.map;

import com.basic.common.ConfigStateListener;
import com.basic.common.ConfigAccessListener;
import com.basic.common.TmpTestRule;
import com.basic.event.ActionEvent;
import com.basic.event.CommonListener;
import com.basic.event.StateListener;
import com.basic.event.AccessListener;
import com.basic.message.Message;
import com.basic.network.SimpleAccessibleMapServer;

import java.io.*;
import java.util.*;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/11/25 9:26
 */
public class MainMap extends AbstractNetWorkAccessibleMap implements ConfigAccessListener, ConfigStateListener, TmpTestRule {

    //单例
    private static MainMap mainMap;

    //地图的表示，只需要存储特殊的点即可(暂时使用这种结构存储，事实上改为添加了一些自定义状态的set更加合适)
    private HashMap<String, Message> map;


    private MainMap(){
        //即便都知道不显式调用也会默认调用父类无参构造，但显式注明可增加代码可读性
        super();
        setState(getState() | 0x01);
        if(initMap()){
            setState(getState() | 0x03);
            System.out.println("主世界地图MainMap已生成......");
        }
        else{

            // TODO: 2021/12/21 后续换成自定义的异常在上层捕获做处理

            System.out.println("主世界地图MainMap初始化失败，资源加载异常...");
            System.exit(1);
        }
            

    }

    /**
     * 采用线程安全的懒汉式加载方式
     * @return MainMap
     */
    public static MainMap getInstance(){
        if(mainMap == null){
            synchronized (MainMap.class){
                if(mainMap == null)
                    mainMap = new MainMap();
            }
        }
        return mainMap;
    }


    @Override
    protected boolean initMap() {
        if((getState() & 0x03) == 0x03) {
            System.out.println("不可重复初始化");
            return false;
        }
        if((getState() & 0x01) == 0x01){
            //设置边界
            setBound_x(MapMaxBounds.MAX_M_X);
            setBound_y(MapMaxBounds.MAX_M_Y);
            setBound_z(MapMaxBounds.MAX_M_Z);

            //初始化成员
            map = new HashMap<String, Message>();


            //期待下个版本加入自定义异常，在此处抛出，上层处理则终止mainMap的创建，并实时写入日志或控制台
            if(listenerCollector == null | accessNodeList == null | map == null)
                return false;

            //用于测试的插入
            map.put("100,99,99",new Message("有未知事件被触发，请注意!"));

            return true;
        }
        return false;

    }

    @Override
    protected boolean destroyMap() {

        // TODO: 2021/12/12 此处需要考虑的逻辑极其复杂，在一些相关的前置条件没有做好前，不做具体实现

        return false;
    }

    @Override
    public String getStateDescribeMessage() {
        int statesGroup = getState();
        StringBuilder sb = new StringBuilder();

        if(statesGroup != 0){
            sb.append(this.getClass().getSimpleName()+"[STATE]:");
            sb.append("[");

            if((statesGroup & 0x03) == 3)
                sb.append("初始化状态:资源初始化成功");
            else
                sb.append("初始化状态:未完成初始化");

            if((statesGroup & 0x04) == 4)
                sb.append(", 网络状态:网络状态连通，可接入访问");
            else
                sb.append(", 网络状态:网络状态未连通");

            // TODO: 2021/12/16 后续定义了其他状态再补充

            sb.append("]");
        }

        return sb.toString();
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

    @Override
    protected void removeAllListeners(){
        //互换位置的空指针异常要小心哦，吃多了的话，加个NullPointException也可以互换位置。
        if(listenerCollector ==null | listenerCollector.isEmpty())
            return;
        listenerCollector.clear();
    }

    @Override
    protected void fireStateChanged(){
        if(listenerCollector == null){
            return;
        }
        //this.getClass().getSimpleName()+"."+
        ActionEvent event = new ActionEvent(this,"StateListener", getStateDescribeMessage());
        notifyListeners(event);
    }


    @Override
    public void setAccessListener(AccessListener listener){
        HashSet accessListeners= this.listenerCollector.get("AccessListener");
        if(accessListeners == null){
            accessListeners = new HashSet<AccessListener>();
            listenerCollector.put("AccessListener",accessListeners);
        }
        accessListeners.add(listener);
    }

    @Override
    public void removeAccessListener(AccessListener listener){
        HashSet userConnectListeners = this.listenerCollector.get("AccessListener");
        if(userConnectListeners == null){
            return;
        }
        listenerCollector.remove("AccessListener");
    }


    @Override
    public void setStateListener(StateListener listener) {
        HashSet stateListeners = this.listenerCollector.get("StateListener");
        if(stateListeners == null){
            stateListeners = new HashSet<StateListener>();
            listenerCollector.put("StateListener", stateListeners);
        }
        stateListeners.add(listener);
    }

    @Override
    public void removeStateListener(StateListener listener) {
        HashSet mapStateListeners = this.listenerCollector.get("StateListener");
        if(mapStateListeners == null){
            return;
        }
        listenerCollector.remove("StateListener");
    }


    @Override
    public boolean allowNetworkAccess(int port) throws IOException {
        userConnectServer = new SimpleAccessibleMapServer(accessNodeList, listenerCollector, port, this);
        userConnectServer.setClassType("MainMap");
        new Thread(userConnectServer).start();

        setState(getState() | 0x04);
        return true;
    }

    @Override
    public boolean isNetWorkAccessibleReady() {
        //资源初始化后，则网络连接状态就绪
        if((getState() & 0x03) == 3)
            return true;
        return false;
    }


    @Override
    public boolean checkCoordinatesValidity(int[] coordinates) {
        if(coordinates != null){
            if(coordinates.length == 3){
                //负值和超出范围的值均会被过滤
                if((coordinates[0]>>>16 | coordinates[1]>>>16 | coordinates[2]>>>16) != 0)
                    return false;
                return true;
            }
        }
        return false;
    }


    @Override
    public void testStateChange(){
        setState((byte) 0x01);
    }

    @Override
    public void testBattle(){
        Collection<String> values = accessNodeList.keySet();
        for(String user:values){
            System.out.println(user);
        }
    }
}


