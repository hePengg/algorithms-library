package com.dap.leecode.hot100;

/**
 * 只出现一次的数字
 */
public class L136 {

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    /**
     * 通过 ^
     * @see com.test.OROperationTest
     * @param nums
     * @return
     */
    static int singleNumber(int[] nums) {
        int single = 0;
        for (int i : nums) {
            single ^= i;
        }
        return single;
    }
}
