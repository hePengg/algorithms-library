package com.dap.Test.activelock;

import com.dap.Test.ThreadExample;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test2 {

    static Lock lock = new ReentrantLock();

    static class Holder extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class TryLock implements Callable<Boolean> {

        @Override
        public Boolean call() throws Exception {
            if (lock.tryLock(6000, TimeUnit.MILLISECONDS)) {
                try{
                    return true;
                }finally {
                    lock.unlock();
                }
            }
            return false;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Holder holder = new Holder();
        holder.start();

        FutureTask<Boolean> futureTask = new FutureTask<>(new TryLock());
        Thread tryThread = new Thread(futureTask);
        tryThread.start();
        Boolean result = futureTask.get();
        System.out.println("result :" + result);
    }
}
