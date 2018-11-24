package com.code.stack;

import com.code.arrays.GenericArrays;

/**
 * 数组栈
 * @param <E>
 */
public class ArraysStack<E> implements Stack<E> {

    private GenericArrays<E> arrays;

    public ArraysStack(int capacity) {
        this.arrays = new GenericArrays<>(capacity);
    }

    public ArraysStack() {
        this.arrays = new GenericArrays();
    }

    @Override
    public int getSize() {
        return arrays.getSize();
    }

    @Override
    public boolean isEmpty() {
        return arrays.isEmpty();
    }

    @Override
    public void push(E e) {
        arrays.addLast(e);
    }

    /*
     * 出栈
     */
    @Override
    public E pop() {
        return arrays.removeLast();
    }
    
    /**
     * 查看栈顶值
     */
    @Override
    public E peek() {
        return arrays.getLast();
    }

    /**
     * 该方法数组类特有，栈不需要
     * @return
     */
    public int getCapacity(){
        return arrays.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: ");
        sb.append("[");
        for (int i=0; i < arrays.getSize(); i++){
            sb.append(arrays.getIndex(i));
            if (i != arrays.getSize() -1){
                sb.append(",");
            }
        }
        sb.append("] top");
        return sb.toString();
    }
}
