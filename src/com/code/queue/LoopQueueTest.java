package com.code.queue;

public class LoopQueueTest {

    public static void main(String[] args){
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++){
            loopQueue.enqueue(i);
        }

        System.out.println(loopQueue + "\n");
        loopQueue.dequeue();
        System.out.println(loopQueue + "\n");

        System.out.println(loopQueue.getFront());

        loopQueue.dequeue();
        System.out.println(loopQueue + "\n");

        loopQueue.dequeue();
        System.out.println(loopQueue + "\n");

        loopQueue.dequeue();
        System.out.println(loopQueue + "\n");

        loopQueue.enqueue(12);
        loopQueue.enqueue(13);
        loopQueue.enqueue(14);
        loopQueue.enqueue(15);
        System.out.println(loopQueue + "\n");
    }
}
