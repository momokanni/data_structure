package com.code.stack;

public class StackTest {

    public static void main(String[] args){
        ArraysStack<String> arraysStack = new ArraysStack<>();
        arraysStack.push("A");
        arraysStack.push("B");
        arraysStack.push("C");
        arraysStack.push("D");

        System.out.println(arraysStack);

        System.out.println(arraysStack.getCapacity());

        System.out.println(arraysStack.getSize());

        System.out.println(arraysStack.isEmpty());

        arraysStack.peek();
        System.out.println(arraysStack);

        arraysStack.pop();
        System.out.println(arraysStack);


    }
}
