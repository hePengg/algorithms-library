package com.dap.Test.activelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test3 {

    static Lock lock = new ReentrantLock();

    static class PrintThread extends Thread {

        private int i;

        PrintThread(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getId() + " : " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            new PrintThread(i).start();
        }
    }
}
