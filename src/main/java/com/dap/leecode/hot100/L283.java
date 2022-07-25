package com.dap.leecode.hot100;

import java.util.Arrays;

/**
 * 移动零
 * <p>给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。</p>
 */
public class L283 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12,0,4,5,0,0,1};
        System.out.println(Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 双指针，left指针指向0时，停，right指针继续移动，移动到不为0的位置，交换
     * @param nums
     */
    static void moveZeroes(int[] nums) {
        int n = nums.length;
        int leftIndex = 0;
        int rightIndex = 0;

        while (rightIndex < n) {
            if (nums[rightIndex] != 0) {
                swap(nums, leftIndex, rightIndex);
                leftIndex++;
            }
            rightIndex++;
        }
    }

    static void swap(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return;
        }

        int tmp = nums[rightIndex];
        nums[rightIndex] = nums[leftIndex];
        nums[leftIndex] = tmp;
    }
}
