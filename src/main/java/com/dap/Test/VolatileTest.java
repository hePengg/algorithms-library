package com.dap.Test;

public class VolatileTest {

    static volatile int i = 0;

    static class AddThread extends Thread {

        @Override
        public void run() {
            for (int j = 0; j < 100000; j++) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        AddThread add1 = new AddThread();
        AddThread add2 = new AddThread();

        add1.start();
        add2.start();

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println("i 最终为 " + i);
    }
}
