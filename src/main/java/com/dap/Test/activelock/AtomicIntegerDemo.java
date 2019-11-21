package com.dap.Test.activelock;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    static AtomicInteger n = new AtomicInteger(0);

    static class AddThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                n.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new AddThread().start();
        }

        while(Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println("n :" + n.get());
    }
}
