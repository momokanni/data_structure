package com.code.linked;

public class LinkedListTest {

    public static void main(String[] args){

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++){
            linkedList.addFirst(i);
        }
        System.out.println(linkedList.toString());

        System.out.println(linkedList.contains(2));

        System.out.println(linkedList.getSize());

        System.out.println(linkedList.isEmpty());

        System.out.println(linkedList.getFirst());

        System.out.println(linkedList.getLast());

        linkedList.set(2,19);
        System.out.println(linkedList);

        linkedList.remove(1);
        //linkedList.removeByObject(2);
        System.out.println(linkedList);

    }
}
