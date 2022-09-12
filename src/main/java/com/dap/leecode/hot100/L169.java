package com.dap.leecode.hot100;

/**
 * 多数元素
 * <p>给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * </p>
 */
public class L169 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    /**
     * 采用solution 3
     * <p> solution 1 ：遍历，存入哈希表，相同的计数加1
     * <p> solution 2 ：排序，取n[n/2]，采用空间复杂度为O(1)的排序
     * <p> solution 3 ：Boyer-Moore投票算法，多数元素的个数大于n[n/2]，最终票数最多的为多数元素
     *
     * @param nums
     * @return
     */
    static int majorityElement(int[] nums) {
        // 候选人，默认空，-1表示
        int candidate = -1;
        // 票数
        int count = 0;

        for (int n : nums) {
            // 票数为0，更选当前元素为候选人
            if (count == 0) {
                candidate = n;
            }

            // 候选人为自己，投自己，不为自己，投反对票
            if (candidate == n) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
