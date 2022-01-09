package com.basic.role;

import com.basic.common.NetWorked;
import com.basic.common.CoordinatesProcessing;
import com.basic.network.SimpleClient;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/11/25 11:29
 */
public abstract class Role implements NetWorked, CoordinatesProcessing {

    protected SimpleClient suc;

    private String name;

    private byte  state;     //0x01 满状态,0x02 健康,0x03 濒死,0x04 死亡

    private int species;    //0x0001 人族，后续种族为动态添加，考虑建立映射，最多不超过2147483648*2-1个种族，留一个位置作为容错位

    //坐标
    private int[] coordinates;

    //当前所在地区地图的边界大小
    private int[] mapBounds;

    //所在的地区（地图），同步数据到服务器时要使用
    private String site;


    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public int[] getMapBounds() {
        return mapBounds;
    }

    public void setMapBounds(int[] mapBounds) {
        this.mapBounds = mapBounds;
    }

    public void setCoordinates(int[] coordinates) {
        if(coordinates.length != 3)
            return;
        if(!checkCoordinatesValidity(coordinates)){
            System.out.println("invalid coordinates");
            return;
        }
        this.coordinates = coordinates;
    }

    public String getCoordinates() {
        return coordinates[0]+","+coordinates[1]+","+coordinates[2];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public int getSpecies() {
        return species;
    }

    public void setSpecies(int species){
        setSpecies(null, species);
     }

    //预留，obj是一个为了可能存在的由于后续过于庞大的种族查找而创建的一个查找生成器(因为在查找的时候可能还有一些别的逻辑,如特殊的种族可能需要创建一些内部类来赋予特殊属性)
    public void setSpecies(Object obj, int species){
        this.species = species;
    }


}
