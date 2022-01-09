package com.basic.role;

import com.basic.graphic.map.MapMaxBounds;
import com.basic.network.SimpleClient;

import java.io.*;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/11/25 11:56
 */
public class HumanPlayer extends AbstractHuman{

    public HumanPlayer() {
        super();

        //目前均为测试方便，使用定值
        setName("haha");
        setState((byte)0x01);
        setSpecies(0x80000000);

        setSite("MainMap");
        setMapBounds(new int[]{MapMaxBounds.MAX_M_X, MapMaxBounds.MAX_M_Y, MapMaxBounds.MAX_M_Z});
        setCoordinates(new int[]{(int)Math.random()*MapMaxBounds.MAX_M_X, (int)Math.random()*MapMaxBounds.MAX_M_Y, (int)Math.random()*MapMaxBounds.MAX_M_Z});
        setHumanId(-1);
    }


    @Override
    public void setName(String name) {
        /**
         * 合法性检测的逻辑
         */
        super.setName(name);
    }

    @Override
    public void setSpecies(Object obj, int species) {
        if(isExistSpecies(getSpecies()))
            return;

        if(obj == null){

            // TODO: 2021/12/12  根据种族，创建实际的查找生成器对象的逻辑

        }

        // TODO: 2021/12/12  根据查找生成器完成对应的要做的一些逻辑

        super.setSpecies(null, species);
    }

    @Override
    public String toString() {

        // TODO: 2021/12/16 实际的逻辑

        return "HumanPlayer{}";
    }


    @Override
    public boolean checkCoordinatesValidity(int[] coordinates) {
        if(coordinates.length == 3){
            //负值和超出范围的值均会被过滤
            if((coordinates[0]>>>16 | coordinates[1]>>>16 | coordinates[2]>>>16) != 0)
                return false;
            return true;
        }
        return false;

    }


    @Override
    public boolean isNetWorkedReady() {
        return true;
    }

    @Override
    public void connectTo(String host, int port) throws IOException {
        if(suc != null)
            return;
        suc = new SimpleClient(host, port);
        new Thread(suc).start();
    }


    /**
     * 内部可能要使用到的一些非公有的方法
     */
    private boolean isExistSpecies(int speciesId){

        // TODO: 2021/12/12  查找逻辑并返回实际的判断结果

        //暂时用于测试的区间
        if(speciesId > 0)
            return true;
        return false;

    }
}
