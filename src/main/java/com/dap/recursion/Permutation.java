package com.dap.recursion;

import java.util.Stack;

/**
 * @Desc: 排列组合
 * @Author: hepeng
 * @Date: 2020/7/18 18:00
 */
public class Permutation {

    public static Stack<Integer> stack = new Stack<Integer>();
    static int count = 0;

    public static void main(String[] args) {
        // 集合
        int sets[] = {1, 2, 3, 4};
        select1(sets, 2, 0);
        System.out.println("总共有 :" + count);
    }

    /**
     * 可重复排列
     *
     * @param sets        从哪个集合中选取
     * @param selectCount 选取的次数
     * @param current     当前选择的是第几次
     */
    private static void select1(int[] sets, int selectCount, int current) {
        if (current == selectCount) {
            System.out.println(stack);
            count++;
            return;
        }

        for (int i = 0; i < sets.length; i++) {
            stack.push(sets[i]);
            select1(sets, selectCount, current + 1);
            stack.pop();
        }
    }

    /**
     * @Desc: 无重复
     *
     * @param sets        从哪个集合中选取
     * @param selectCount 选取的次数
     * @param current     当前选择的是第几次
     */
    private static void select2(int[] sets, int selectCount, int current) {
        if (current == selectCount) {
            System.out.println(stack);
            count++;
            return;
        }

        for (int i = 0; i < sets.length; i++) {
            // 如果栈中存在，则不操作
            if (!stack.contains(sets[i])) {
                stack.push(sets[i]);
                select2(sets, selectCount, current + 1);
                stack.pop();
            }
        }
    }

    /**
     * @Desc: 无重复选n个元素
     *
     * @param sets        从哪个集合中选取
     * @param selectCount 选取的次数
     * @param current     当前选择的是第几次
     * @param curIndex 当前坐标
     *
     */
    private static void select3(int[] sets, int selectCount, int current, int curIndex) {
        if (current == selectCount) {
            System.out.println(stack);
            count++;
            return;
        }

        for (int i = curIndex; i < sets.length; i++) {
            if (!stack.contains(sets[i])) {
                stack.push(sets[i]);
                select3(sets, selectCount, current + 1, i);
                stack.pop();
            }
        }
    }


}
