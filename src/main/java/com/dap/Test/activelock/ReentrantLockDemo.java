package com.dap.Test.activelock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    static class AddThead extends Thread {

        private Counter counter;

        AddThead(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                counter.Add();
            }
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        for (int i = 0; i < 2; i++) {
            new AddThead(counter).start();
        }

        while(Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println("结果：" + counter.getN());
    }
}
