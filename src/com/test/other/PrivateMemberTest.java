package com.test.other;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/6 23:23
 */
class T{
    private void f1(){
        System.out.println("T1");
    }
    public void f2(){f1();}
};
class U extends T{
    private void f1(){
        System.out.println("T2");
    }
    public void f2(){f1();}
}
public class PrivateMemberTest {
    public static void main(String []args){
        /*((T)new U()).f2();
        new U().f2();*/
        Integer a = 10;
        System.out.println(a.toString().length());
    }
}
