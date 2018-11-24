package com.code.linked.leetcode;

public class LeetCodeTest {

    public static void main(String[] args){

        ListNode node = new ListNode(new int[]{1,2,3,4,5,6,3});

        SolutionRecursion solution = new SolutionRecursion();
        ListNode result = solution.removeElement(node,3);
        System.out.println(result);

    }
}
