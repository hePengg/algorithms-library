package com.dap.Test.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class CountDownLatchDemo {

    static CountDownLatch countDownLatch = new CountDownLatch(4);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println("线程ID：" + Thread.currentThread().getId() + ", countDown");
            }).start();
        }

        countDownLatch.await(2000, TimeUnit.MILLISECONDS);
//        countDownLatch.await();

        System.out.println("pass...");
    }
}
