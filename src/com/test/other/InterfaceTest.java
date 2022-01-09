package com.test.other;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/12 16:02
 */
interface MyInter {
    default void show(){
        System.out.println("show MyInter");
    }
}

class Impl implements MyInter{
    void test(){
        show();
    }
}
public class InterfaceTest {
    public static void main(String[] args){
        Impl impl = new Impl();
        impl.show();
        //MyInter.super.show(); 后续有空再继续测试
    }
}
