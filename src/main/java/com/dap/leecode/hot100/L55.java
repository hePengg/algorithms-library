package com.dap.leecode.hot100;

/**
 * 最大子数组和
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 */
public class L55 {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    /**
     * 动态规划
     * f(i) = nums[0 ~ i] 最大和
     * f(i) = Max(f(i-1) + nums[i], f(i-1))
     *
     * @param nums
     * @return
     */
    static int maxSubArray(int[] nums) {
        int pre = 0;
        int maxSub = nums[0];
        for (int val : nums) {
            pre = Math.max(pre + val, val);
            maxSub = Math.max(maxSub, pre);
        }
        return maxSub;
    }
}
