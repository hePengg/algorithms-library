package com.dap.leecode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 */
public class L234 {

    public static void main(String[] args) {
        // test
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(isPalindrome(head));
    }

    /**
     * <li>solution 1 : 放入数组，两头下表比对</li>
     * <li>solution 2 : 快慢指针，找到链表的中间点，然后反转一半，两头对比，对比完，恢复链表</li>
     * <li></li>
     * @param head
     * @return
     */
    static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode tmp = head;

        // 放入数组
        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }

        int headIndex = 0;
        int tailIndex = list.size() - 1;
        while (headIndex < tailIndex) {
            if (list.get(headIndex) != list.get(tailIndex)) {
                return false;
            }
            headIndex++;
            tailIndex--;
        }
        return true;
    }
}
