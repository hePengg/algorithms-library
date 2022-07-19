package com.test;

import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();

        stack.push('a');
        stack.push('b');
        stack.push('c');

        Object[] objects = stack.toArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            stringBuilder.append(objects[i]);
        }
        System.out.println(stringBuilder);

    }
}
