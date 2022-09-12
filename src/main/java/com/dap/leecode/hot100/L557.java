package com.dap.leecode.hot100;

/**
 * 反转字符串中的单词 III
 * <p>给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。</p>
 */
public class L557 {

    public static void main(String[] args) {
        String s = "abc a'b ccde o13";
        System.out.println(reverseWords(s));
    }

    /**
     * solution 1 :
     * <li>由于String不可变，必须要开辟新的空间</li>
     * @param s
     * @return
     */
    static String reverseWords(String s) {
        String[] strArray = s.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = new StringBuffer(strArray[i]).reverse().toString();
        }
        return String.join(" ", strArray);
    }
}
