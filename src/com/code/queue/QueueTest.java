package com.code.queue;

public class QueueTest {

    public static void main(String[] args){
        ArraysQueue<Integer> arraysQueue = new ArraysQueue<>();
        for (int i = 0; i < 10; i++){
            arraysQueue.enqueue(i);
        }
        System.out.println(arraysQueue);

        System.out.println(arraysQueue.isEmpty());

        System.out.println(arraysQueue.getSize());

        arraysQueue.dequeue();
        System.out.println(arraysQueue);
    }
}
