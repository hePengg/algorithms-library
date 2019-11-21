package com.dap.Test;

import com.sun.org.apache.xalan.internal.utils.FeatureManager;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadExample {

    static class ThreadTest extends Thread{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "， Thread example.....");
        }
    }

    static class RunnableTest implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "， Runnable example.....");
        }
    }

    static class CallableTest implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName() + "， Callable example.....");
            return "call result";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();

        Thread runnableTest = new Thread(new RunnableTest());
        runnableTest.start();

        FutureTask<String> futureTask = new FutureTask<String>(new CallableTest());
        Thread callableTest = new Thread(futureTask);
        callableTest.start();
        String result = futureTask.get();
        System.out.println("callable result :" + result);
    }
}
