package com.dap.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class CarryCargo {

    /** 货物个数*/
    static int cargoNum = 1000000;
//    static AtomicInteger cargoNum = new AtomicInteger(1000000);

    static class Carry extends Thread{

        /** 搬运人*/
        private String peopleName;
        /** 搬运次数*/
        private Integer carryNum = 0;

        public Carry(String peopleName) {
            this.peopleName = peopleName;
        }

        @Override
        public void run() {
            while (!isInterrupted()) {
//                synchronized (cargoNum) {
                    if (cargoNum > 0) {
                        cargoNum--;
                        carryNum++;
                    } else {
                        System.out.println("搬运完成，员工：" + peopleName + "，搬运：[" + carryNum + "]次");
                        interrupt();
                    }

//                if (cargoNum.get() > 0) {
//                    cargoNum.addAndGet(-1);
//                    carryNum++;
//                } else {
//                    System.out.println("搬运完成，员工：" + peopleName + "，搬运：[" + carryNum + "]次");
//                    interrupt();
//                }
//                }
            }
        }
    }

    public static void main(String[] args) {
        Carry carry1 = new Carry("甲");
        Carry carry2 = new Carry("乙");

        carry1.start();
        carry2.start();
    }
}
