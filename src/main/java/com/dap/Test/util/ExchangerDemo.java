package com.dap.Test.util;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {

    static Exchanger exchanger = new Exchanger();

    static class ExchangeThread extends Thread {

        private int n;

        ExchangeThread(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread() + " 原值 " + n);
                this.n = (int) exchanger.exchange(n);
                System.out.println(Thread.currentThread() + " 交换后值 " + n);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExchangeThread thread1 = new ExchangeThread(5);
        ExchangeThread thread2 = new ExchangeThread(10);

        thread1.start();
        thread2.start();
    }
}
