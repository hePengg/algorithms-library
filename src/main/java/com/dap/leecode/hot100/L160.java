package com.dap.leecode.hot100;

/**
 * 相交链表
 * <p>给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。</p>
 */
public class L160 {

    public static void main(String[] args) {
        // test

        ListNode headA = new ListNode(4);
        ListNode headB = new ListNode(5);

        ListNode nodeA2 = new ListNode(1);

        ListNode nodeB2 = new ListNode(6);
        ListNode nodeB3 = new ListNode(1);

        ListNode interSectionNode1 = new ListNode(8);
        ListNode interSectionNode2 = new ListNode(4);
        ListNode interSectionNode3 = new ListNode(5);

        // headA
        headA.next = nodeA2;
        nodeA2.next = interSectionNode1;

        // headB
        headB.next = nodeB2;
        nodeB2.next = nodeB3;
        nodeB3.next = interSectionNode1;

        // interSectionNode
        interSectionNode1.next = interSectionNode2;
        interSectionNode2.next = interSectionNode3;

        System.out.println(getIntersectionNode(headA, headB));
    }

    /**
     * solution 1 ：遍历，用Set或map集合判断是否存在
     * <p>将headA，放入Set，遍历headB，判断元素是否在A中存在，时间复杂度O(m+n)，空间复杂度O(m)</p>
     *
     * solution 2 ：指针移动
     * <p>headA移动完，指向headB，继续移动，直到相交或都指向null</p>
     * @param headA
     * @param headB
     * @return
     */
    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        // 交点 或 null
        return pA;
    }
}
