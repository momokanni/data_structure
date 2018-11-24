package com.code.linked;

import com.code.queue.Queue;

public class LinkedListQueue<E> implements Queue<E> {

    private Node head,tail;

    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {

        if (tail == null){
            // 当添加第一个值时，head和tail相等
            tail = new Node(e);
            head = tail;
        } else {
            // 这一句要从对象引用和堆栈分析
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        Node delNode = head;
        head = head.next;
        delNode.next = null;
        if (head == null){
            tail = null;
        }
        size --;
        return delNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedListQueue: top ");
        for (Node cur = head; cur != null; cur = cur.next){
            sb.append(cur.e).append("->");
        }
        sb.append("NULL");
        return sb.toString();
    }

    private class Node{
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
        }

        public Node() {

        }

        @Override
        public String toString() {

            return e.toString();
        }
    }

}
