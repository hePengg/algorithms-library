package com.dap.Test;

public class ThreadLocalDemo {

    static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> {return 1;});

    static class Get extends Thread {

        @Override
        public void run() {
            threadLocal.get();
            Thread thread = Thread.currentThread();
            System.out.println(threadLocal);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Get get1 = new Get();
        get1.start();
        get1.join();

        Get get2 = new Get();
        get2.start();
    }
}
