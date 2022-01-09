package com.test.other;
import java.util.concurrent.atomic.AtomicBoolean;
/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/6 11:58
 */
public class CASTest implements Runnable{
    public static AtomicBoolean exits = new AtomicBoolean(true);
    public static void main(String[] args) {
        CASTest abd = new CASTest();
        Thread t1 = new Thread(abd);
        Thread t2 = new Thread(abd);
        t1.start();
        t2.start();
    }
    @Override
    public void run() {
        System.out.println("begin run");
        System.out.println("real " + exits.get());
        if(exits.compareAndSet(true,false)){
            System.out.println(Thread.currentThread().getName() + "  " + exits.get() );
            exits.set(true);
        }else{
            run();
        }
    }
}



