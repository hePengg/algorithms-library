package com.dap.leecode.hot100;

import java.util.Random;

/**
 * Merge Two Lists
 */
public class L21 {

    public static void main(String[] args) {
        ListNode listNode1 = createListNode(3);
        listNode1.print();

        ListNode listNode2 = createListNode(5);
        listNode2.print();

        mergeTwoLists(listNode1, listNode2).print();
    }

    /**
     * ASC
     * @param listNode1
     * @param listNode2
     * @return
     */
    static ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        }

        if (listNode2 == null) {
            return listNode1;
        }

        if (listNode1.val > listNode2.val) {
            listNode2.next = mergeTwoLists(listNode1, listNode2.next);
            return listNode2;
        } else {
            listNode1.next = mergeTwoLists(listNode2, listNode1.next);
            return listNode1;
        }
    }

    static public class ListNode {
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

    static ListNode createListNode(int length) {
        ListNode listNode = new ListNode(randomAsc(5));
        ListNode tmp = listNode;
        while (length != 0) {
            tmp.next = new ListNode(randomAsc(tmp.val));
            tmp = listNode.next;
            length--;
        }
        return listNode;
    }

    static int randomAsc(int val) {
        return new Random().nextInt(100) + val;
    }
}
