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
     * 通过 ^，亦或运算
     * <li>n ^ 0 = n</li>
     * <li>n ^ n = 0</li>
     * <li>a ^ a ^ b ^ b ^ c ^ 0 = c</li>
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
