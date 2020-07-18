package com.dap.recursion;

/**
 * @Desc: 打印字母，n个长度，从a,b,c...z，打印到aaa...zzz
 * @Author: hepeng
 * @Date: 2020/7/17 23:57
 */
public class PrintAZ {

    static char[] chars;

    public static void main(String[] args) {
//        for (int i = 0; i < 26; i++) {
//            System.out.println((char) ('a' + i));
//        }
        int n = 4;
        int count = 1;

        String start = getLetters(n, "a");
        String end = getLetters(n, "z");

        chars = start.toCharArray();

//        System.out.println(start);

        while (true) {
            start = getNextStr(n);
//            System.out.println(start);
            count++;
            if (start.equals(end))
                break;
        }

        System.out.println("总数：" + count);
    }

     /**
      *  @Desc:  26个字母排列组合
      *     1、aaa->aab->......->aaz->aaa
      *     2、aba->abb->......->abz->aaa
      *     3、aca->......->aaa
      *     4、......
      *     5、aza->......->aaa
      *     6、baa->......->aaa
      *     7、......
      *     8、zaa->......->aaa
      *
      *     如果 最后一位不等于z，就对最后以为加1，生成新的字母
      *     如果 最后以为等于z，将末尾变成a，就将j往前移动一位，继续循环
      *  
      *  @Author:    hepeng
      *  @Date:  2020/7/18 16:21
      */
    public static String getNextStr(int n) {
        for (int i = 0, j = chars.length - 1; i < n; i++) {
            if (chars[j] != 'z') {
                chars[j]++;
                break;
            } else {
                chars[j] = 'a';
                j--;
                continue;
            }
        }
        return new String(chars);
    }

    public static String getLetters(int n, String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        for (int i = 0; i < n - 1; i++) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}
