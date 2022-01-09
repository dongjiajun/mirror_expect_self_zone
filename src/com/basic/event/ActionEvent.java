package com.basic.event;

import java.io.Serializable;
import java.util.EventObject;

/**
 * @author yd
 * @version 1.0
 * @date 2021/12/3 11:23
 */
public class ActionEvent extends EventObject{
    //额外的想要追加的一些提示信息
    private String extraStatement;

    //监听器响应时的类型检测
    private String type;


    public ActionEvent(Object source,String type, String extraStatement) {
        super(source);
        this.type = type;
        this.extraStatement = extraStatement;
    }

    public String getType() {
        return type;
    }

    public String getExtraStatement() {
        return "extraStatement:{["+getSource().getClass().getSimpleName()+"]->"+getType()+"}=>\t"+extraStatement;
    }
}
