package com.dap.leecode.hot100;

/**
 * 整数反转，简单
 *
 * <p>给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。</p>
 *
 * @author hep
 */
public class L7 {

    public static void main(String[] args) {
        int n = -123;
        System.out.println(n);
        System.out.println(reverse(n));
    }

    /**
     * <li>1234 / 10 = 123</li>
     * <li>1234 % 10 = 4</li>
     * @param n
     * @return
     */
    static int reverse(int n) {
        int result = 0;
        while (n != 0) {
            // 下面要 * 10 ，所以做校验，避免溢出
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            result = result * 10 + n % 10;
            n = n / 10;
        }
        return result;
    }
}
