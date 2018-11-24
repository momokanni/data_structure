package com.code.binaryTree;

public class BSTTest {

    public static void main(String[] args){
        int[] arr = {5,4,3,6,5,8,6};
        BST<Integer> bst = new BST<>();
        for (int num:arr){
            bst.add(num);
        }

        bst.preOrder();

        System.out.println();

        /*bst.inOrder();

        System.out.println();

        bst.postOrder();

        System.out.println();

        System.out.println(bst);

        System.out.println();

        bst.preOrderNR();

        System.out.println();

        bst.levelOrder();

        System.out.println();

        bst.removeMin();
        System.out.println(bst);

        System.out.println();

        bst.removeMax();
        System.out.println(bst);

        System.out.println(bst.minimum());*/

        bst.remove(4);
        System.out.println(bst);
    }
}
