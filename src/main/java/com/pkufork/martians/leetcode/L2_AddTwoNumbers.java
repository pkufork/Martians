package com.pkufork.martians.leetcode;

/**
 * Created by pkufork on 16/7/11.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class L2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode ll1 = l1;
        ListNode ll2 = l2;
        int res = 0;
        ListNode cur = null;
        while (true) {
            int curval = 0;
            curval += res;
            if (ll1 == null && ll2 == null) {
                if (curval != 0) {
                    cur.next = new ListNode(curval);
                }
                break;
            }
            if (ll1 != null) {
                curval += ll1.val;
                ll1 = ll1.next;
            }
            if (ll2 != null) {
                curval += ll2.val;
                ll2 = ll2.next;
            }
            if (curval >= 10) {
                res = 1;
                curval -= 10;
            } else {
                res = 0;
            }
            if (cur == null) {
                head = cur = new ListNode(curval);
            } else {
                cur.next = new ListNode(curval);
                cur = cur.next;
            }
        }
        return head;
    }
}
