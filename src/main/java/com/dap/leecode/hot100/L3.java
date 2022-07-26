package com.dap.leecode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长字串
 * <p>给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。</p>
 */
public class L3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    /**
     * 滑动窗口
     * <li>start, end 两个指针移动，不重复子串长度为 end - start + 1</li>
     * <li>用length保留最大长度</li>
     * @param s
     * @return
     */
    static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> strTmp = new HashMap<>();
        int length = 0;

        for (int end = 0, start = 0; end < s.length(); end++) {
            Character c = s.charAt(end);

            // 遇到相同字符，start地址更新至上一个c + 1 位置
            if (strTmp.containsKey(c)) {
                // 保证start不会左移，比如 abaab这种字符串
                start = Math.max(start, strTmp.get(c) + 1);
            }

            // 每轮都计算最长长度
            length = Math.max(length, end - start + 1);

            // key-> char, value -> char last index
            strTmp.put(c, end);
        }

        return length;
    }

}
