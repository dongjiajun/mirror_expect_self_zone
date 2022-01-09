package com.test.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntConsumer;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/22 17:06
 */
class Test{
    public void test(int ...params){
        for(int i:params)
            System.out.println(i);
    }
}
public class StringMultiTest {

    public static void main(String[] args) {
        Test t = new Test();
        //t.test(1,2,3,4,5,6);
        t.test();
        ArrayList<Integer> list = new ArrayList();
        list.add(21126);
        list.add(28);
        list.add(2);
        list.add(1998);
        list.add(2);
        System.out.println(list);
        Collections.sort(list, (Integer a, Integer b)->{return a>b?1:-1;});
        System.out.println(list);

    }
}
