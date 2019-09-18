package com.dap.leecode;

import java.util.*;

/**
 * @Desc: LeeCode题目，两数相加
 * 1、hashMap中containsKey也有循环遍历
 * @Author: hepeng
 * @Date: 2019/9/16 22:31
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] result = twoSum(nums, 5);
        System.out.println("result : " + Arrays.toString(result));
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

        // 存储
        Map<Integer, Integer> numCache = new HashMap<>(16);
        for (int i = 0; i < length; i++) {
            numCache.put(nums[i], i);
        }

        // 遍历
        Set<Integer> indexSet = new HashSet<>();
        for (int i = 0; i < length; i++) {
            int value = target - nums[i];
            if (numCache.containsKey(value)) {
                if (numCache.get(value) != i) {
                    indexSet.add(i);
                    indexSet.add(numCache.get(value));
                }
            }
        }

        // 返回结果
        int[] results = new int[indexSet.size()];
        int i = 0;
        for (int result : indexSet) {
            results[i] = result;
            i++;
        }
        return results;
    }

}
