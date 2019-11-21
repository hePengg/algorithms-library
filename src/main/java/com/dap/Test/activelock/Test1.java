package com.dap.Test.activelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {

    static class People {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        for (int i = 0; i < 5; i++) {
            lock.lock();
        }

        for (int i = 0; i < 5; i++) {
            lock.unlock();
        }

        System.out.println("end ....");
    }
}
