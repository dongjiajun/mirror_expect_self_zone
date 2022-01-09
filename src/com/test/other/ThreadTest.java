package com.test.other;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/9 14:55
 */

class Space implements Runnable{

    @Override
    public void run() {
        new Thread(new Galaxy()).start();
        System.out.println("space end.");
    }
}
class Galaxy implements Runnable{
    @Override
    public void run() {
        new Thread(new Planet()).start();
        System.out.println("Galaxy end.");
    }
}
class Planet implements Runnable{
    @Override
    public void run() {
        int i=10;
        for(;;){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("is alive");
            if(--i == 0)
                break;
        }
        System.out.println("Planet end.");
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        new Thread(new Space()).start();
    }
}
