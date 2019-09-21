package com.dap.leecode;

/**
 * @Desc: LeeCode题目7，整数反转
 *
 * 1、可考虑位运算
 * 2、反转
 *
 * @Author: hepeng
 * @Date: 2019/9/18 17:21
 */
public class Subject7 {

    static int MAX_VALUE = 0x7fffffff;
    static int MIN_VALUE = 0x80000000;

    public static void main(String[] args) {
        System.out.println(MAX_VALUE);
        System.out.println(reverse(2147483647));
    }

    /** 再比较一遍顺序*/
    public static int reverse(int x) {
        String y = String.valueOf(x);

        // 判断是否带符号
        boolean hasSigned = false;
        String[] splitArr = y.split("-");
        if (splitArr.length > 1) {
            hasSigned = true;
            y = splitArr[1];
        }

        int yLength = y.length();

        if (yLength == 0) {
            return x;
        }

        // 反转字符
        char[] yCharArr = y.toCharArray();
        char[] zCharArr = new char[yLength];
        int index1 = yLength - 1;
        for (char c : yCharArr) {
            zCharArr[index1] = c;
            index1--;
        }

        String z = new String(zCharArr);
        int result;
        try {
            result = Integer.valueOf(z);
        } catch (NumberFormatException e) {
            return 0;
        }

        return hasSigned ? 0 - result : result;
    }
}
