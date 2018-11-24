package com.code.linked.leetcode;

public class ListNode {

    int val;

    ListNode next;

    ListNode(int x){
        val = x;
    }

    /**
     * 通过传入数组创建链表节点
     * @param arr
     */
    public ListNode(int[] arr) {

        if (arr == null || arr.length == 0){
            throw new IllegalArgumentException("arr can not be empty");
        }

        this.val = arr[0];

        ListNode cur = this;
        for (int i = 1; i < arr.length; i++){
            // 还是涉及到 对象引用和堆栈内存管理
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("top: ");
        for (ListNode cur = this; cur != null; cur = cur.next){
            sb.append(cur.val).append(" ->");
        }
        sb.append("NULL");
        return sb.toString();
    }
}
