package com.dap.leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
  *  @Desc:  LeeCode题目1，两数相加，优化2
  *  
  *  @Author:    hepeng
  *  @Date:  2020/7/18 16:55
  */
public class Subject1Opt2 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println("result : " + twoSum(nums, 9));
    }

    /**
     *  @Desc: 求数组中任意两个相加为target的数的下标，不包含自身
     *
     */
    public static Stack<Integer> twoSum(int[] nums, int target) {
        // 判空
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return null;
        }

        // 存储，k-值，v-下标
        Map<Integer, Integer> numCache = new HashMap<>(16);
        for (int i = 0; i < length; i++) {
            numCache.put(nums[i], i);
        }

        // 遍历
        Stack<Integer> results = new Stack<>();
        for (int i = 0; i < length; i++) {
            int value = target - nums[i];
            if (numCache.containsKey(value)) {
                if (numCache.get(value) != i) {
                    results.add(i);
                    results.add(numCache.get(value));
                    break;
                }
            }
        }

        return results;
    }
}
