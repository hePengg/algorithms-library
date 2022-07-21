package com.dap.leecode.hot100;

/**
 * 环形链表
 *
 * <p>
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递。仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * </p>
 */
public class L141 {

    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        System.out.println(isCycle(root));
    }

    /**
     * 快慢指针
     * <li>快指针走2，慢指针走1</li>
     * <li>注意校验快指针，避免空指针</li>
     * @param head
     * @return
     */
    static boolean isCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fastNode = head.next;
        ListNode slowNode = head;

        while (fastNode != slowNode) {
            if (fastNode == null || fastNode.next == null) {
                return false;
            }

            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        return true;
    }

}
