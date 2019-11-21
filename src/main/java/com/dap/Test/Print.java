package com.dap.Test;

public class Print {

    public void print() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " print.....");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " print end.....");
    }
}
