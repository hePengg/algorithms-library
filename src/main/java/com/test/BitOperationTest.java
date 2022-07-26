package com.test;

/**
 * 位运算
 */
public class BitOperationTest {

    public static void main(String[] args) {
        // 移位，1 << 16 等价 2^16 次方
        System.out.println(1 << 16);
        System.out.println(Math.pow(2, 16));

        int n = 1 << 10;
        // n & (2的n次方 - 1) 等价 n % 2的n次方
        System.out.println(15 & (n - 1));
        System.out.println(15 % n);
    }
}
