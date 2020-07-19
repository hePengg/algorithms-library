package com.dap.recursion;

import java.util.Stack;

/**
 * @Desc: 打印n个aaa...zzz
 * @Author: hepeng
 * @Date: 2020/7/18 18:23
 */
public class PrintAZOpt1 {

    static char[] az = new char[26];
    static Stack<Character> stack = new Stack<>();
    static int count = 0;

    public static void main(String[] args) {
        initAZChars();
//        System.out.println(az);

        select(az, 3, 0);
        System.out.println("总数 ：" + count);
    }

     /**
      *  @Desc:  使用排列组合实现
      *  
      */
    public static void select(char[] az, int selectCount, int cur) {
        if(selectCount == cur) {
            Object[] objects = stack.toArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < selectCount; i++) {
                stringBuilder.append(objects[i]);
            }
            System.out.println(stringBuilder.toString());
            count++;
            return;
        }

        for (int i = 0; i < az.length; i++) {
            stack.push(az[i]);
            select(az, selectCount, cur + 1);
            stack.pop();
        }
        
    }

    public static void initAZChars() {
        char a = 'a';
        az[0] = a;
        for (int i = 1; i < 26; i++) {
            az[i] = ++a;
        }
    }
}
