package com.dap.Test;

public class ClzSync {

    static class PrintThread extends Thread {

        private Print print;

        PrintThread(Print print) {
            this.print = print;
        }

        @Override
        public void run() {
            synchronized (print) {
                try {
                    print.print();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Print print = new Print();

        PrintThread printThread1 = new PrintThread(print);
        PrintThread printThread2 = new PrintThread(print);

        printThread1.start();
        printThread2.start();
    }
}
