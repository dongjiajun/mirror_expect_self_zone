package com.basic.graphic.map;

import com.basic.graphic.Graphic;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/11/25 10:25
 */
public abstract class AbstractMap extends Graphic {

    private int bound_x;

    private int bound_y;

    private int bound_z;


    public void setBound_x(int bound_x) {
        this.bound_x = bound_x;
    }

    public int getBound_x() {
        return bound_x;
    }

    public int getBound_y() {
        return bound_y;
    }

    public void setBound_y(int bound_y) {
        this.bound_y = bound_y;
    }

    public int getBound_z() {
        return bound_z;
    }

    public void setBound_z(int bound_z) {
        this.bound_z = bound_z;
    }


    /**
     * 初始化图
     */
    abstract  protected  boolean initMap();

    /**
     * 销毁图
     */
    abstract  protected boolean destroyMap();





}
