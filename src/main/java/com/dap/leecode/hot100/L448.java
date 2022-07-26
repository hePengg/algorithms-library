package com.dap.leecode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到所有数组中小时的数字
 * <p>给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 */
public class L448 {

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(findDisappearedNumbers(nums));

        // 复原
        recover(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     *
     * @param nums
     * @return
     */
    static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        // 把存在的数据，通过数据下标来标记
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }

        // 再次遍历，如果当前i下标对应的数据 小于或等于 n，那说明该下标没标记过
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                result.add(i + 1);
            }
        }
        return result;
    }

    static void recover(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > n) {
                nums[i] %= n;
            }
        }
    }
}
