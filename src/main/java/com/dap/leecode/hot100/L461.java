package com.dap.leecode.hot100;

/**
 * 汉明距离
 * <p>两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。</p>
 */
public class L461 {

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

    /**
     * 两个数二进制不同的位置的个数，则只有 1、0 时不同，1 ^ 0 = 1，所以就是求bit count
     * <li>x ^ y = z, Integer.bitCount(z)</li>
     * <li>不使用编程语言库函数，则自己通过移位运算，求1出现的次数</li>
     *
     * @param x
     * @param y
     * @return
     */
    static int hammingDistance(int x, int y) {
        int z = x ^ y;
        int result = 0;

        while (z != 0) {
            result += z & 1;
            z >>= 1;
        }
        return result;
    }
}
