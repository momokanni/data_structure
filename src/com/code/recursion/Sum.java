package com.code.recursion;

public class Sum {

    public static int sum(int[] arr){

        return sum(arr,0);
    }

    public static int sum(int[] arr,int left){
        if (arr.length == left){
            return 0;
        }
        return arr[left] + sum(arr, left + 1);
    }

    public static void main(String[] args){

        int[] arr = {1,2,3,4,5,6,7,8,9};
        int result = sum(arr);
        System.out.println(result);
    }
}
