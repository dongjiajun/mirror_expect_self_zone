package com.test.other;

import javax.swing.text.html.HTMLDocument;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/11 12:37
 */

class DefineType{

    public int var;

    public DefineType() {
        var = 10;
    }

    @Override
    public boolean equals(Object obj) {
        return var == ((DefineType)obj).var ? true:false;
    }

    @Override
    public int hashCode() {
        return 2147483647;
    }
}
public class HashTest {
    public static void main(String[] args) {
        HashSet<DefineType> hs = new HashSet<>();
        HashSet<Integer> hsi = new HashSet<>();
        hsi.add(10);
        hsi.add(10);
        DefineType a = new DefineType();
        DefineType b = new DefineType();
        if(a == b)
            System.out.println("== true");
        if(a.equals(b))
            System.out.println("equals true");
        hs.add(a);
        hs.add(b);
        Iterator iter = hs.iterator();
        while(iter.hasNext())
            System.out.println(((DefineType)iter.next()).var);
        Iterator iteri = hsi.iterator();
        while(iteri.hasNext())
            System.out.println(iteri.next().toString());
    }
}
