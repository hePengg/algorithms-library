package com.dap.leecode.hot100;

/**
 * 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class L21 {

    public static void main(String[] args) {
        ListNode listNode1 = ListNodeUtil.createAscendingListNode(3);
        listNode1.print();

        ListNode listNode2 = ListNodeUtil.createAscendingListNode(5);
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

}
