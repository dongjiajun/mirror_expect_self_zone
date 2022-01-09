package com.test.other.recursion;

import java.util.Scanner;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/23 15:39
 */
public class PascalTriangle {
    /**
     *
     * @param high  三角的最大高度，影响和边界的距离
     * @param floor 实际创建的三角高度，不得大于high
     * @param array 伴随数组，存储上层数据
     */
    static void getPascalTriangle(int high, int floor, int []array){
        if(floor == 0)
            return;

        getPascalTriangle(high, floor-1, array);

        int i, ml, pre = 1, cur;
        for(i = 0; i < floor; ++i){
            if(i == 0 || i == floor-1){
                array[i] = 1;
                if(i == 0){
                    ml = high - floor;
                    while(ml-- > 0)
                        System.out.print("     ");
                }
                System.out.format("%10d", array[i]);
                continue;
            }
            cur = array[i];
            array[i] = pre +cur;
            pre = cur;
            System.out.format("%10d", array[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int level;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("input Level of the Pascal Triangle:");
            level = sc.nextInt();
            getPascalTriangle(level, level, new int[level]);
        }while(level != 0);


    }
}
