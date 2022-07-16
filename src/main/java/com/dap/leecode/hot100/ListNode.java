package com.dap.leecode.hot100;

public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    void print() {
        System.out.print(val + " ");

        ListNode nextTmp = next;
        while (nextTmp != null) {
            System.out.print(nextTmp.val + " ");
            nextTmp = nextTmp.next;
        }

        System.out.println();
    }
}
