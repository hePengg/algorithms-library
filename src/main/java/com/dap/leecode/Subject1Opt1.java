package com.dap.leecode;

import java.util.*;

/**
  *  @Desc:  LeeCode题目1，两数相加，优化1
  *  
  */
public class Subject1Opt1 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println("result : " + Arrays.toString(twoSum(nums, 9)));
    }

    /**
     *  @Desc: 求数组中任意两个相加为target的数的下标，不包含自身
     *
     */
    public static int[] twoSum(int[] nums, int target) {
        // 判空
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return new int[0];
        }

        // 存储，k-值，v-下标
        Map<Integer, Integer> numCache = new HashMap<>(16);
        for (int i = 0; i < length; i++) {
            numCache.put(nums[i], i);
        }

        // 遍历
        int[] results = new int[2];
        for (int i = 0; i < length; i++) {
            int value = target - nums[i];
            if (numCache.containsKey(value)) {
                if (numCache.get(value) != i) {
                    results[0] = i;
                    results[1] = numCache.get(value);
                }
            }
        }

        return results;
    }
}
