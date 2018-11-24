package com.code.stack;

import com.code.linked.LinkedListStack;

public class CompareTest {

    public static double test(Stack<Integer> stack,int count){
        long startTime = System.nanoTime();

        for (int i = 0; i < count; i++){
            stack.push(i);
        }
        for (int i = 0; i < count; i++){
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args){

        int count = 10000000;

        ArraysStack<Integer> arraysStack = new ArraysStack<>();
        double arraysTime = test(arraysStack, count);
        System.out.println("ArraysStac计算时间： "+ arraysTime);

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double linkListTime = test(linkedListStack,count);
        System.out.println("LinkLIstStack计算所需时间: "+ linkListTime);
    }
}
