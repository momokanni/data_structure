package com.code.queue;

/**
 * 循环队列
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int front,tail;

    private int size;

    public LoopQueue(int capacity) {
        // capacity + 1 有意识浪费一个空间
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity(){
        // 因为声明时，有意识浪费一个位置，所以真实容量应该减1
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        // 首尾在一个位置上即为空
        return front == tail;
    }

    /**
     * 入队
     * @param e
     */
    @Override
    public void enqueue(E e) {
        // 队尾 + 1（有意识浪费的那一个位置）%取余 队列长度  == front 即为满队
        if ((tail + 1) % data.length == front ){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    /**
     * 出队
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new RuntimeException("cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if (size == getCapacity() / 4 && getCapacity() /2 != 0 ){
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new RuntimeException("cannot dequeue from an empty queue.");
        }
        return data[front];
    }

    /**
     * 扩容 or 减容
     *
     * @param newCapacity
     */
    public void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++){
            newData[i] = data[(i+front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("LoopQueue size = %s ,capacity = %s \n",size,getCapacity()));
        result.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length){
            result.append(data[i]);
            if ((i + 1) % data.length != tail){
                result.append(',');
            }
        }
        result.append("] tail");
        return result.toString();
    }
}
