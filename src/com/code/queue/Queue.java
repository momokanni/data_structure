package com.code.queue;

/**
 * 队列
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    /**
     * 入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     * @return
     */
    E dequeue();

    E getFront();
}
