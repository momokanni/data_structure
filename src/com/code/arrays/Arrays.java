package com.code.arrays;

/**
 * int 数组
 */
public class Arrays {

    private int[] data;

    private int size;

    /**
     * 有参构造
     * @param capacity
     */
    public Arrays(int capacity){
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参构造，默认size = 10;
     */
    public Arrays() {
        this(10);
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
    public void addLast(int e){
        add(size,e);
    }

    /**
     * 添加元素到第0个位置
     * @param e
     */
    public void addFirst(int e){
        add(0,e);
    }

    /**
     * 在第index个位置插入一个元素e
     * @param index
     * @param e
     */
    public void add(int index,int e){
        if (size == data.length){
            throw new IllegalArgumentException("add failed. Arrays is full");
        }

        if (index < 0 || index > size){
            throw new IllegalArgumentException("add failed. Require index >=0 and index <= size");
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
    public int getIndex(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("getIndex failed. Index is Illegal.");
        }
        return data[index];
    }

    /**
     * 替换第index元素值为e
     * @param index
     * @param e
     */
    public void set(int index, int e){
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
    public boolean contains(int e){
        for (int i = 0; i<size; i++){
            if (data[i] == e){
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
    public int findElementIndex(int e){
        for (int i = 0; i<size; i++){
            if (data[i] == e){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除指定索引位置的元素
     * @param index
     */
    public int remove(int index){

        if (index < 0 || index >= size){
            throw new IllegalArgumentException("remove failed. Index is Illegal.");
        }

        int ret = data[index];
        for (int i = index + 1; i < size; i++){
            data[i-1] = data[i];
        }
        size --;
        return ret;
    }

    /**
     * 移除第一个元素
     * @return
     */
    public int removeFirst(){
        return remove(0);
    }

    /**
     * 移除最后一个元素
     * @return
     */
    public int removeLast(){
        return remove(size -1);
    }

    /**
     * 移除某个元素，返回boolean
     * @param e
     * @return
     */
    public boolean removeElement(int e){
        int index = findElementIndex(e);
        if (index != -1){
            int ret = remove(index);
            int find_against = findElementIndex(ret);
            return find_against == -1;
        }
        return false;
    }

    /**
     * 移除某个元素，无返回值
     * @param e
     */
    public void removeElementNoRet(int e){
        int index = findElementIndex(e);
        if (index != -1){
            remove(index);
        }
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
