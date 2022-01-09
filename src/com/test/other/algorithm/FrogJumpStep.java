package com.test.other.algorithm;

import java.util.Scanner;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/26 15:31
 */
public class FrogJumpStep {
    /**
     * 青蛙跳台阶问题
     *
     * @param step 台阶数
     * @return
     */
    static long solution(int step) {
        if (step <= 2)
            return step;
        long[] nums = new long[step + 1];
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3; i <= step; ++i)
            nums[i] = nums[i - 1] + nums[i - 2];
        return nums[step];
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        System.out.print("please input step number:");
        int step = sc.nextInt();
        System.out.println(solution(step));
        System.out.println(factorial1(6));
    }

    static int frog(int n) {
        return n < 3 ? n : frog(n - 1) + frog(n - 2);
    }

    static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    static int factorial1(int n) {
        return n == 1 ? 1 : factorial1(--n) * n;
    }
}
