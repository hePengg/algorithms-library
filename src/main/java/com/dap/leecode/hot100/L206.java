package com.dap.leecode.hot100;

/**
 * 反转链表
 * <p> 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class L206 {

    public static void main(String[] args) {
        // test
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        reverseList(head).print();
    }

    /**
     * <p>solution 1 ：迭代，将下个节点的next，指向当前节点，需要用到临时节点存储
     * @param head
     * @return
     */
    static ListNode reverseList(ListNode head) {
        ListNode currNode = head;
        ListNode preNode = null;
        ListNode nextNode = null;

        while (currNode != null) {
            // 1 先正向取下个节点临时存储
            nextNode = currNode.next;
            // 2 反转当前节点的下个节点
            currNode.next = preNode;
            // 3 pre指针移动到当前节点
            preNode = currNode;
            // 4 当前节点向后移动
            currNode = nextNode;
        }

        return preNode;
    }
}
