package com.code.queue;

import com.code.arrays.GenericArrays;

/**
 * 数组队列
 * @param <E>
 */
public class ArraysQueue<E> implements Queue<E> {

    private GenericArrays<E> queueArrays;

    public ArraysQueue(int capacity) {
        this.queueArrays = new GenericArrays<>(capacity);
    }

    public ArraysQueue() {
        this.queueArrays = new GenericArrays<>();
    }

    @Override
    public int getSize() {
        return queueArrays.getSize();
    }

    @Override
    public boolean isEmpty() {
        return queueArrays.isEmpty();
    }

    /**
     * 入队
     * @param e
     */
    @Override
    public void enqueue(E e) {
        queueArrays.addLast(e);
    }

    /**
     * 出队
     * @return
     */
    @Override
    public E dequeue() {
        return queueArrays.removeFirst();
    }

    @Override
    public E getFront() {
        return queueArrays.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: ");
        sb.append("front [");
        for (int i = 0; i < queueArrays.getSize(); i++){
            sb.append(queueArrays.getIndex(i));
            if (i != queueArrays.getSize() -1){
                sb.append(",");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
