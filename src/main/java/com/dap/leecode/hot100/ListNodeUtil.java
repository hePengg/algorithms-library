package com.dap.leecode.hot100;

import java.util.Random;

public class ListNodeUtil {

    public static ListNode createAscendingListNode(int length) {
        ListNode listNode = new ListNode(randomAsc(5));
        ListNode tmp = listNode;
        while (length != 0) {
            tmp.next = new ListNode(randomAsc(tmp.val));
            tmp = listNode.next;
            length--;
        }
        return listNode;
    }

    public static int randomAsc(int val) {
        return new Random().nextInt(100) + val;
    }
}
