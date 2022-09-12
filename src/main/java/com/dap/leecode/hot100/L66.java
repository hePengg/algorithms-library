package com.dap.leecode.hot100;

import java.util.Arrays;

/**
 * 加一
 *
 * <p>给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * </p>
 */
public class L66 {

    public static void main(String[] args) {
        int[] digits = new int[]{9, 9, 9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    /**
     * 从末尾判断是否为9，知道前推到不为9的位置，加1返回，如果digits都是9，那就是在原数组加1长度，返回1,0，.....
     * @param digits
     * @return
     */
    static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            // 9，置位0，不为9，加1
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}
