package com.test.other;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/9 10:12
 */
public class BasicStringTest {
    public static void main(String[] args) {
        String a = "aa";
        String b = "aa";
        String c = new String("aa");
        if(a == b)
            System.out.println("true");
        if(a == c)
            System.out.println("true");
        else
            System.out.println("false");
        if(a.equals(c))
            System.out.println("true");
        else
            System.out.println("false");
        //System.out.println(Integer.parseInt("rtes"));

    }
}
