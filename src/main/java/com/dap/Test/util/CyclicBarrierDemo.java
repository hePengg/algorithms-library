package com.dap.Test.util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new BarrierAction());

    static class BarrierAction implements Runnable {

        @Override
        public void run() {
            System.out.println("barrierAction......");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    System.out.println("Thread id :" + Thread.currentThread().getId() + "await start...");
                    cyclicBarrier.await();
                    System.out.println("Thread id :" + Thread.currentThread().getId() + "await end...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    System.out.println("Thread id :" + Thread.currentThread().getId() + "await start...");
                    Thread.sleep(1000);
                    cyclicBarrier.await();
                    System.out.println("Thread id :" + Thread.currentThread().getId() + "await end...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
