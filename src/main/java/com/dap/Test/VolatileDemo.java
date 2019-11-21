package com.dap.Test;

public class VolatileDemo {

    private int i = 0;
    private boolean flag = false;

    public void write() {
        // 操作1
        i = 1;
        // 操作2
        flag = true;
        System.out.println("更新完成...");
    }

    public void read() {
        // 操作3
        if (flag) {
            // 操作4
            System.out.println("i 被更新为, i -> " + i);
        }
    }
}
