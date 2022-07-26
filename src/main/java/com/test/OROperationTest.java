package com.test;

/**
 * 异或运算，不带进位的加法
 */
public class OROperationTest {

    public static void main(String[] args) {
        // 1 ^ 0 = 1
        System.out.println(1 ^ 0);
        // 1 ^ 1 = 0
        System.out.println(1 ^ 1);
        // 0 ^ 0 = 0
        System.out.println(0 ^ 0);
        // 0 ^ 1 = 1
        System.out.println(0 ^ 1);

        // n ^ 0 = n
        System.out.println(10 ^ 0);
        // n ^ n = 0
        System.out.println(10 ^ 10);
    }
}
