package com.dap.recursion;

import java.util.HashMap;

/**
 * 实现简单的青蛙跳台阶问题
 * 1、有n阶楼梯，青蛙一次只能跳1层或2层，求有多少种跳法
 * 2、有n阶楼梯，青蛙一次只能调1，2，3，......n阶，求有多少种跳法
 *
 * @author hepeng
 * @date 2018/12/11 16:29
 */
public class Jump {

    private static HashMap<Integer, Integer> jumpTimeMap = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        int n = 32;
        System.out.println("青蛙按照【暴力递归】方式跳跃 " + n + "层，有：" + jump1(n) + " 种方法");
        System.out.println("青蛙按照【递归+缓存】方式跳跃 " + n + "层，有：" + jump2(n) + " 种方法");
        System.out.println("青蛙按照【斐波那契】方式跳跃 " + n + "层，有：" + jump3(n) + " 种方法");
        System.out.println("青蛙按照【jump4】方式跳跃 " + n + "层，有：" + jump4(n) + " 种方法");
    }

    /**
     * 暴力递归
     * 1、n阶台阶，有n中方式跳跃
     * 2、青蛙一次能跳1层或2层
     * 3、第一次跳一层，剩下f(n-1)种方法
     * 4、第一次跳两层，剩下f(n-2)种方法
     * 5、则，f(n) = f(n-1) + f(n-2)
     */
    public static int jump1(int n) {
        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return jump1(n - 1) + jump1(n - 2);
        }
    }

    /**
     * 重复数据不再递归
     * 通过画图发现，在f(n-1)与f(n-2)的递归中，会计算相同数据
     * 已计算过的则保存在map，不再计算
     * 以空间换时间
     */
    public static int jump2(int n) {
        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return getJumpTime(n);
        }
    }

    /**
     * 保存计算过的数据
     */
    public static int getJumpTime(int n) {
        if (jumpTimeMap.containsKey(n)) {
            return jumpTimeMap.get(n);
        } else {
            int jumpTime = jump2(n - 1) + jump2(n - 2);
            jumpTimeMap.put(n, jumpTime);
            return jumpTime;
        }
    }

    /**
     * 利用斐波那契数列方式
     * 后一个数等于前两个数相加，1,1,2,3,5,8....
     * f(n) = f(n-1) + f(n-2)
     * 实现方式，略
     */
    public static int jump3(int n) {
        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return fibonacci(n);
        }
    }

    /**
     * 斐波那契数列
     * 1,1,2,3,5,8,11....
     * 则求斐波那契数列第n-1与第n-2的和
     */
    public static int fibonacci(int n) {
        int sum = 0;
        int n1 = 0;
        int n2 = 1;
        for (int i = 1; i <= n; i++) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        return sum;
    }


    /**
     * 问题2
     */
    public static int jump4(int n) {
        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return getJumpTime2(n);
        }
    }

    /**
     * 根据公式计算
     * 1、f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(1)
     * 2、f(n-1) = f(n-2) + f(n-3) + f(n-3) + ... + f(1)
     * 3、f(n) = 2*f(n-1)
     */
    public static int getJumpTime2(int n) {
        return jump4(n - 1) * 2;
    }
}
