package com.basic.event;


import java.util.EventListener;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/7 11:27
 */
public interface CommonListener extends EventListener {

    public void doEvent(ActionEvent eventObject);

}
