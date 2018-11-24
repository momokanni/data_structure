package com.code.linked.leetcode;

public class SolutionDummyHead {

    public ListNode removeElement(ListNode head,int val){
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        while (dummyNode.next != null){
            if (dummyNode.next.val == val){
                ListNode delNode = dummyNode.next;
                dummyNode.next = delNode.next;
                delNode.next = null;
            } else {
                dummyNode = dummyNode.next;
            }
        }

        return dummyNode.next;
    }
}
