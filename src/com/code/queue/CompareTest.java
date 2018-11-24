package com.code.queue;

import com.code.linked.LinkedListQueue;

import java.util.Random;

/**
 * 性能比较
 */
public class CompareTest {

    public static double test(Queue queue,int count){

        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i ++){
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i ++){
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args){
        int count = 1000000;
        ArraysQueue<Integer> arraysQueue = new ArraysQueue<>();
        double datetime = test(arraysQueue,count);
        System.out.println("ArraysQueue, time: "+ datetime + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double loopTime = test(loopQueue,count);
        System.out.println("loopQueue, time: "+ loopTime + " s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double linkTime = test(linkedListQueue,count);
        System.out.println("LinkedListQueue, time: "+ linkTime + " s");
    }
}
