package com.test.project;

import com.basic.event.ActionEvent;
import com.basic.graphic.map.MainMap;
import org.junit.Test;

import java.io.IOException;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/11/25 5:30
 */
public class MapTest {
    @Test
    public void test(){
        //无法进行多线程测试
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        MainMap om = MainMap.getInstance();

        om.setAccessListener((ActionEvent eventObject) -> System.out.println(eventObject.getExtraStatement()));
        om.setStateListener((ActionEvent eventObject) -> System.out.println(eventObject.getExtraStatement()));

        if(om.isNetWorkAccessibleReady())
            om.allowNetworkAccess(7001);
        om.checkCoordinatesValidity(null);
    }
}
