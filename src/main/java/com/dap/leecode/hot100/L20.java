package com.dap.leecode.hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 */
public class L20 {

    public static void main(String[] args) {
        System.out.println(dict);
        System.out.println(isValid("}}"));
        System.out.println(isValid("{}"));
        System.out.println(isValid("{{}}"));
    }

    public static boolean isValid(String str) {
        if (str.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>(){};
        Character top = null;
        for (Character c : str.toCharArray()) {
            // first push
            if (stack.empty() || dict.containsKey(c)) {
                top = stack.push(c);
            } else if (c.equals(dict.get(top))){
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
