package com.code.stack;

/**
 * 栈
 * @param <E>
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    /**
     * 入栈
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     * @return
     */
    E pop();

    /**
     * 查看栈顶
     * @return
     */
    E peek();
}
