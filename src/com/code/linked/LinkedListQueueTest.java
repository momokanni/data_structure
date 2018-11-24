package com.code.linked;

/**
 * 链表队列测试
 */
public class LinkedListQueueTest {

    public static void main(String[] args){
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 5; i++){
            linkedListQueue.enqueue(i);
        }
        System.out.println(linkedListQueue);

        System.out.println(linkedListQueue.isEmpty());

        System.out.println(linkedListQueue.getSize());

        linkedListQueue.dequeue();
        System.out.println(linkedListQueue);
    }
}
