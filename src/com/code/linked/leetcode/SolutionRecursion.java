package com.code.linked.leetcode;

public class SolutionRecursion {

    public ListNode removeElement(ListNode head,int val){
        if (head == null){
            return null;
        }
        // 该段代码通过递归，实现删除元素
        // 也就是 通过调用removeElement方法，把head后节点传入进去
        // 通过head.next = 各个节点返回值，从而达到各个节点的连接。
        /**
         * 例如：
         *  node: [1,2,6,4,5,6] 移除6
         *  result: 1,2,4,5
         *
         */
        head.next = removeElement(head.next,val);
        return head.val == val ? head.next : head;
    }
}
