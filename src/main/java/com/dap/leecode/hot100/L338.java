package com.dap.leecode.hot100;

import java.util.Arrays;

/**
 * 比特位计数
 * <p>给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。</p>
 */
public class L338 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }

    /**
     * 动态规划，奇偶数
     * <li>0 = 0， 0个1</li>
     * <li>1 = 1， 1个1</li>
     * <li>2 = 10，1个1</li>
     * <li>3 = 11，2个1</li>
     * <li>4 = 100，1个1</li>
     * <li>......</li>
     * <li>n > 0，奇数，1的个数等于前一个数的和 + 1</li>
     * <li>n > 0，偶数，1的个数等于n/2 的1的个数</li>
     *
     * @param n
     * @return
     */
    static int[] countBits(int n) {
        int[] result = new int[n + 1];
        // 0 二进制 0 个 1
        result[0] = 0;

        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 1) {
                // 奇数
                result[i] = result[i - 1] + 1;
            } else {
                // 偶数
                result[i] = result[i / 2];
            }
        }

        return result;
    }
}
