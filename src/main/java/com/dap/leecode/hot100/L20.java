package com.dap.leecode.hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 */
public class L20 {

    public static void main(String[] args) {
        System.out.println(dict);
        System.out.println(isValid("}}"));
    }

    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>(){};
        Character top = null;
        for (Character c : str.toCharArray()) {
            // first push
            if (stack.empty() || dict.containsKey(c)) {
                top = stack.push(c);
            } else if (c == dict.get(top)){
                stack.pop();
                // length == 0 , will exception
                top = stack.empty() ? null : stack.peek();
            } else {
                return false;
            }
        }

        return stack.size() == 0;
    }

    final static Map<Character, Character> dict = new HashMap<>() {
        {
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }
    };

}
