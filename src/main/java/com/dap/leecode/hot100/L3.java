package com.dap.leecode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长字串
 */
public class L3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> strTmp = new HashMap<>();
        int length = 0;

        for (int end = 0, start = 0; end < s.length(); end++) {
            Character c = s.charAt(end);

            //
            if (strTmp.containsKey(c)) {
                start = Math.max(start, strTmp.get(c) + 1);
            }

            length = Math.max(length, end - start + 1);

            // key-> char, value -> char last index
            strTmp.put(c, end);
        }

        return length;
    }

}
