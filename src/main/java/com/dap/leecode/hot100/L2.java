package com.dap.leecode.hot100;

public class L2 {

    public static void main(String[] args) {
        ListNode listNode1 = ListNodeUtil.createRandomListNode(3);
        listNode1.print();

        ListNode listNode2 = ListNodeUtil.createRandomListNode(6);
        listNode2.print();

        addTwoNumbers(listNode1, listNode2).print();
    }

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
//            else {
//                tmp.next = listNode2.next;
//                break;
//            }

            if (listNode2 != null) {
                listNode2 = listNode2.next;
            }
            // TOTO
//            else {
//                tmp.next = listNode1.next;
//                break;
//            }
        }

        if (addTmp == 1) {
            tmp.next = new ListNode(1);
        }

        return preNode.next;
    }
}
