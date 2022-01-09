package com.test.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/8 10:28
 */
class Father{
    int a;

    public Father(int a){this.a = a;}

    public Father() {
        a = 10;
    }
}
//不显式地调用父类地构造方法，默认会在调用构造方法前自动调用默认地无参构造方法（创建实例的时候）
class Son extends Father{
    int b;
    public Son(int b){
        this.b = b;
    }
}
public class ConstructorTest {
    public static void main(String[] args) {

        Son son = new Son(1);
        System.out.println(son.a);
        Integer ia = 10;
        Integer ib = 10;
        String sa = "a";
        String sb = "a";
        if(ia == ib)
            System.out.println(true);
        if(ia.equals(ib))
            System.out.println(true+" equals");
        if(sa == sb)
            System.out.println(true);
        if(sa.equals(sb))
            System.out.println(true+" equals");
        final int[] a = new int[]{1,2,3};
        List list = Arrays.asList(a);
        list.add(21);

    }
}
