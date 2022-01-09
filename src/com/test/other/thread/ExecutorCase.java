package com.test.other.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/26 17:43
 */
public class ExecutorCase {
    private static Executor executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        for(int i=0; i<20; ++i)
            executor.execute(new Task());
    }
    static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
