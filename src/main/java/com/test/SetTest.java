package com.test;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);

        // 已存在，返回false
        System.out.println(set.add(1));
        // 不存在，返回true
        System.out.println(set.add(5));
    }
}
