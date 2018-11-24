package com.code;

import com.code.arrays.Arrays;

public class Main {

    public static void main(String[] args) {
        Arrays arrays = new Arrays(20);
        for (int i = 0; i < 10; i++){
            arrays.addLast(i);
        }
        System.out.println(arrays.toString());

        arrays.addFirst(1);
        System.out.println(arrays.toString());

        arrays.remove(0);
        System.out.println(arrays.toString());

        arrays.add(2,6);
        System.out.println(arrays.toString());

        boolean ret = arrays.removeElement(3);
        System.out.println("返回结果"+ret+","+arrays.toString());
    }
}
