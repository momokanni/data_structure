package com.code.arrays;

/**
 * 泛型数组
 */
public class GenericArrays<E> {

    private E[] data;

    private int size;

    /**
     * 有参构造
     * @param capacity
     */
    public GenericArrays(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造，默认size = 10;
     */
    public GenericArrays() {
        this(5 );
    }

    /**
     * 获取数组中元素个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 判断数组是否为空
     * @return
     */
    public boolean isEmpty(){

        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 添加元素到第0个位置
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 在第index个位置插入一个元素e
     * @param index
     * @param e
     */
    public void add(int index,E e){

        if (index < 0 || index > size){
            throw new IllegalArgumentException("add failed. Require index >=0 and index <= size");
        }

        if (size == data.length){
            // 数组更改容量，可以是增加 or 减少
            resize(2 * data.length);
        }

        for(int i = size -1; i>=index; i--){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    /**
     * 获取index索引位置的元素
     * @param index
     * @return
     */
    public E getIndex(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("getIndex failed. Index is Illegal.");
        }
        return data[index];
    }

    /**
     * 获取第一个元素
     * @return
     */
    public E getFirst(){

        return getIndex(0);
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public E getLast(){

        return getIndex(size - 1);
    }

    /**
     * 替换第index元素值为e
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("set failed. Index is Illegal.");
        }
        data[index] = e;
    }

    /**
     * 判断数组中是否存在元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        for (int i = 0; i<size; i++){
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组元素e所在的索引值，如果不存在元素e，返回-1
     * @param e
     * @return
     */
    public int findElementIndex(E e){
        for (int i = 0; i<size; i++){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除指定索引位置的元素
     * @param index
     */
    public E remove(int index){

        if (index < 0 || index >= size){
            throw new IllegalArgumentException("remove failed. Index is Illegal.");
        }

        E ret = data[index];
        for (int i = index + 1; i < size; i++){
            data[i-1] = data[i];
        }
        size --;
        // loitering object  涉及到垃圾回收
        data[size] = null;

        if (size == data.length /4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 移除第一个元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 移除最后一个元素
     * @return
     */
    public E removeLast(){
        return remove(size -1);
    }

    /**
     * 移除某个元素，返回boolean
     * @param e
     * @return
     */
    public boolean removeElement(E e){
        int index = findElementIndex(e);
        if (index != -1){
            E ret = remove(index);
            int find_against = findElementIndex(ret);
            return find_against == -1;
        }
        return false;
    }

    /**
     * 移除某个元素，无返回值
     * @param e
     */
    public void removeElementNoRet(E e){
        int index = findElementIndex(e);
        if (index != -1){
            remove(index);
        }
    }

    public void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i =0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }



    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("Array size = %s ,capacity = %s \n",size,data.length));
        result.append('[');
        for (int i = 0; i<size; i++){
            result.append(data[i]);
            if (i != size -1){
                result.append(',');
            }
        }
        result.append(']');
        return result.toString();
    }
}
