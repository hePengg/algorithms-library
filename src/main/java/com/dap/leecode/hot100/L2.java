package com.dap.leecode.hot100;

/**
 * 两数相加
 * <p>给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * </p>
 */
public class L2 {

    public static void main(String[] args) {
        ListNode listNode1 = ListNodeUtil.createRandomListNode(3);
        listNode1.print();

        ListNode listNode2 = ListNodeUtil.createRandomListNode(6);
        listNode2.print();

        addTwoNumbers(listNode1, listNode2).print();
    }

    /**
     * 两个逆序单向链表，除了数字0，不会以0开头
     *
     * @param listNode1
     * @param listNode2
     * @return
     */
    static ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {
        ListNode preNode = new ListNode(0);

        // move
        ListNode tmp = preNode;
        int addTmp = 0;
        while (listNode1 != null || listNode2 != null) {
            // current node value
            int sum = (listNode1 == null ? 0 : listNode1.val) + (listNode2 == null ? 0 :listNode2.val) + addTmp;

            // next add value
            addTmp = sum / 10;

            sum = sum % 10;

            tmp.next = new ListNode(sum);
            // tmp -> current node
            tmp = tmp.next;

            if (listNode1 != null) {
                listNode1 = listNode1.next;
            }
            // TODO [9,9,9,9,9,9,9] [9,9,9,9] -> [8,9,9,9,0,0,0,1]  边界案例，不断往前进一位

            if (listNode2 != null) {
                listNode2 = listNode2.next;
            }

        }

        if (addTmp == 1) {
            tmp.next = new ListNode(1);
        }

        return preNode.next;
    }
}
