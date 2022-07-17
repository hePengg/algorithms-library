package com.dap.leecode.hot100;

/**
 * 爬楼梯
 *
 * <li>假设你正在爬楼梯。需要 n 阶你才能到达楼顶。</li>
 * <li>每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？</li>
 *
 */
public class L70 {

    public static void main(String[] args) {
        System.out.println(climbStairs2(45));
    }

    /**
     * 暴力递归，Leetcode 提交 n = 45时超时，也可以考虑缓存
     * <li>动态规划，每次只能爬1 或 2 个台阶，所以 ： f(n) = f(n-1) + f(n-2)</li>
     * @param n
     * @return
     */
    static int climbStairs(int n) {
        switch (n) {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    /**
     * 时间复杂度O(n)
     * <li>斐波那契数列，1，2，3，5，8，11......</li>
     * @param n
     * @return
     */
    static int climbStairs2(int n) {
        // sum -> f(n)
        int sum = 1;
        // n1 -> f(n-2)
        int n1 = 0;
        // n1 -> f(n-1)
        int n2 = 0;
        for (int i = 1; i <= n; i++) {
            n1 = n2;
            n2 = sum;
            sum = n1 + n2;
        }
        return sum;
    }
}
