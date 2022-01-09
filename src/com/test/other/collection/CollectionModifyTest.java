package com.test.other.collection;

import java.util.*;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/27 15:45
 */
class single{}
public class CollectionModifyTest {
    public static <LinkHashMap> void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int c=1;
        while(c<=10)
            list.add(c++);


        /*Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            if(iterator.next()%3==0)
                iterator.remove();
        }*/

        /*for(Integer integer:list){
            if(integer%3 == 0)
                list.remove(integer);
        }*/


        /*for(int b=0; b<list.size(); ++b){
            if(list.get(b)%3 == 0)
                list.remove(list.get(b));
        }*/

        /*for(int i=0; i<list.size(); ++i)
            System.out.println(list.get(i));*/
        System.out.println(list);


        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("first", 1);
        hashMap.put("second", 2);
        hashMap.put("third", 3);
        hashMap.put("fourth", 4);
        hashMap.put("fourth", 5);

        Iterator<Map.Entry<String, Integer>> hashMapIterator = hashMap.entrySet().iterator();
        while(hashMapIterator.hasNext()){
            if(hashMapIterator.next().getValue()%3 == 0)
                hashMapIterator.remove();
        }

        /*for(String string:hashMap.keySet()){
            if(hashMap.get(string)%3 == 0)
                hashMap.remove(string);
        }*/


        System.out.println(hashMap);



    }
}
