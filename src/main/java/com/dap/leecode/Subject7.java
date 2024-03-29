package com.dap.leecode;

/**
 * @Desc: LeeCode题目7，整数反转
 *
 * 1、可考虑位运算
 * 2、反转
 *
 */
public class Subject7 {

    static int MAX_VALUE = 0x7fffffff;
    static int MIN_VALUE = 0x80000000;

    public static void main(String[] args) {
//        System.out.println(MAX_VALUE);
        int n = 124141241;
        System.out.println(n);
        System.out.println(reverse1(n));
    }

    /**
     * 题解1，字符串反转，暴力
     * @param x
     * @return
     */
    public static int reverse1(int x) {
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

    /**
     * 题解2
     *   1、末位求余
     *   2、剩余位求整
     *   3、考虑int长度，2的31次方 -1 >= int.length >= - 2的31次方
     * @param x
     * @return
     */
    public static int reverse2(int x) {
        return 0;
    }
}
