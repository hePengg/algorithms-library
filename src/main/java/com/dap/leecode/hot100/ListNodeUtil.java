package com.dap.leecode.hot100;

import java.util.Random;

public class ListNodeUtil {

    /**
     * 创建随机长度的链表
     * @param length
     * @return
     */
    public static ListNode createRandomListNode(int length) {
        ListNode listNode = new ListNode(new Random().nextInt(10));
        ListNode tmp = listNode;
        while (length != 1) {
            tmp.next = new ListNode(new Random().nextInt(10));
            tmp = tmp.next;
            length--;
        }
        return listNode;
    }

    public static ListNode createAscendingListNode(int length) {
        ListNode listNode = new ListNode(randomAsc(5));
        ListNode tmp = listNode;
        while (length != 1) {
            tmp.next = new ListNode(randomAsc(tmp.val));
            tmp = tmp.next;
            length--;
        }
        return listNode;
    }

    private static int randomAsc(int val) {
        return new Random().nextInt(100) + val;
    }
}
