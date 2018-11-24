package com.code.binaryTree;

import com.code.linked.LinkedListQueue;
import com.code.queue.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node{

        private E e;

        private Node left,right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 根节点
     */
    private Node root;

    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向二分搜索树中添加元素
     * @param e
     */
    public void add(E e){
        root = add(root,e);
    }

    private Node add(Node node,E e){
        /*if (e.equals(node.e)){
             return;
        } else if(e.compareTo(node.e) < 0 && node.left == null){
            node.left = new Node(e);
            size ++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null){
            node.right = new Node(e);
            size ++;
            return;
        }*/
        if (node == null){
            size ++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0){
            node.left = add(node.left,e);
        } else if (e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        }

        return node;
    }

    /**
     * 查看二分搜索树是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root,e);
    }

    public boolean contains(Node root,E e){
        if (root == null){
            return false;
        }
        if (e.compareTo(root.e) == 0){
            return true;
        } else if (e.compareTo(root.e) > 0){
            contains(root.left,e);
        } else {
            contains(root.right,e);
        }
        return false;
    }

    /**
     * 深度优先遍历
     * 【前序遍历】：因为在遍历之前先访问根节点
     * 遍历打印树节点的每一个元素，先从根节点开始打印
     *
     */
    public void preOrder(){
        preOrder(root);
    }

    public void preOrder(Node root){

        if (root != null){
            System.out.println(root.e);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 二分搜索树 【非递归】前序遍历
     * 借用栈来实现该功能
     */
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    /**
     * 深度优先遍历
     * 【中序遍历】 看测试BSTTest
     * 和【前序遍历】不同的是：打印输出的结果是排序后的结果
     */
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if (node == null){
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 深度优先遍历
     * 【后序遍历】
     * 应用：内存释放（手动释放），需要先释放孩子节点最终再释放根节点
     */
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if (node == null){
            return;
        }

        postOrder(node.left);
        preOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 层序遍历
     */
    public void levelOrder(){
        Queue<Node> queue = new LinkedListQueue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()){
            Node node = queue.dequeue();
            System.out.println(node.e);

            if (node.left != null){
                queue.enqueue(node.left);
            }
            if (node.right != null){
                queue.enqueue(node.right);
            }
        }
    }

    /**
     * 查找最小值
     * @return
     */
    public E minimum(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty");
        }

        return minimum(root).e;
    }

    public Node minimum(Node node){

        if (node.left == null){
            return node;
        }

        return minimum(node.left);
    }

    /**
     * 查找最大值
     * @return
     */
    public E maximum(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty");
        }

       return maximum(root).e;
    }

    private Node maximum(Node node){
        if (node.right == null){
            return node;
        }
        return maximum(node.right);
    }

    /**
     *移除最小值
     */
    public E removeMin(){
        E e = minimum();
        root = removeMin(root);
        return e;
    }


    /**
     * 【移除最小值】
     * 返回删除节点后新的二分搜索树的根root
     * 深度递归
     * @param node
     * @return
     */
    private Node removeMin(Node node){

        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 移除最大值
     * @return
     */
    public E removeMax(){
        E e = maximum();
        root = removeMax(root);
        return e;
    }

    /**
     * 返回删除节点后新的二分搜索树的根root
     *
     * 深度递归
     * @param node
     * @return
     */
    public Node removeMax(Node node){
        if (node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除任意元素
     */
    public void remove(E e){
        root = remove(root,e);
    }

    /**
     * 删除掉以root为根的二分搜索树中值为e的节点, 递归算法
     * 返回删除节点后新的二分搜索树的根
     */
    private Node remove(Node root,E e){
        if (root == null){
            return null;
        }

        if (e.compareTo(root.e) < 0){
            root.left = remove(root.left,e);
            return root;
        } else if (e.compareTo(root.e) > 0) {
            root.right = remove(root.right,e);
            return root;
        } else{
            // 待删除节点左子树为空的情况
            if (root.left == null){
                Node rightNode = root.right;
                root.right = null;
                size --;
                return rightNode;
            }
            // 待删除节点右子树为空的情况
            if (root.left == null){
                Node leftNode = root.left;
                root.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(root.right);
            successor.right = removeMin(root.right);
            successor.left = root.left;
            root.left = root.right = null;

            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root,0,sb);
        return sb.toString();
    }

    private void generateBSTString(Node node,int depth,StringBuilder sb){
        if (node == null){
            sb.append(generateDepthString(depth) + "null\n");
            return;
        }

        sb.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left,depth + 1,sb);
        generateBSTString(node.right,depth + 1,sb);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++){
            sb.append("--");
        }
        return sb.toString();
    }
}
