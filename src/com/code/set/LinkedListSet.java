package com.code.set;

import com.code.linked.LinkedList;

/**
 * 线性结构不需要可比性
 * LinkedListSet<E extends Comparable<E>>
 * @param <E>
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> linkedList;

    public LinkedListSet() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        linkedList.addLast(e);
    }

    @Override
    public void remove(E e) {
        linkedList.removeByObject(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
