package com.test.other;

import java.lang.reflect.Method;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/7 18:10
 */

class MySub{


    private int a;
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
    public void show(){
        System.out.println("mySub");
    }
}
public class LoaderTest {
    public static void main(String[] args) throws Exception {
        String str = "com.test.common.MySub";
        Class clazz = Class.forName(str);
        Object obj = clazz.newInstance();
        Method show = clazz.getMethod("show");
        show.invoke(obj);

    }
}
