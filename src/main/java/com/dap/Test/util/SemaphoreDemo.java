package com.dap.Test.util;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static void main(String[] args) {
        Token token = new Token();
        token.init(1);

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    token.acquire();
                    System.out.println("线程ID： " + Thread.currentThread().getId() + "获取令牌");

                    Thread.sleep(1000);

                    System.out.println("线程ID： " + Thread.currentThread().getId() + "放回令牌");
                    token.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

    static class Token {

        private Semaphore semaphore;

        public void init(int n) {
            semaphore = new Semaphore(n);
        }

        public void acquire() throws InterruptedException {
            semaphore.acquire();
        }

        public void release() throws InterruptedException {
            semaphore.release();
        }
    }
}
