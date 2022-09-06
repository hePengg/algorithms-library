package com.base.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * 多线程交替顺序打印奇偶数
 *
 * @author hep
 */
public class MultiThreadPrint1 {

    static Thread thread1, thread2;

    /**
     * LockSupport实现
     * @param args
     */
    public static void main(String[] args) {
        thread1 = new Thread(() -> {
            for (int i = 0; i < 100; ) {
                System.out.println(Thread.currentThread().getName() + " :" + i);
                i = i + 2;
                LockSupport.unpark(thread2);
                LockSupport.park();
            }
        });

        thread1 = new Thread(() -> {
            for (int i = 1; i < 100; ) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + " :" + i);
                i = i + 2;
                LockSupport.unpark(thread1);
            }
        });

        thread1.start();
        thread2.start();
    }
}
