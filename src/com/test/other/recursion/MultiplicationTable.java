package com.test.other.recursion;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/15 19:01
 */
public class MultiplicationTable {
    static void showMultiplicationTable(int bound){
        if(bound == 0)
            return;

        showMultiplicationTable(bound-1);

        for(int i=1; i<=bound; ++i)
            System.out.print(i+" * "+bound+" = "+i*bound+"\t");
        System.out.println();
    }

    public static void main(String[] args) {
        showMultiplicationTable(9);
    }
}
