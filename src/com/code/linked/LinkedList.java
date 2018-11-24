package com.code.linked;

/**
 * 链表
 */
public class LinkedList<E> {

    private Node dummyHead; //虚拟头节点
    private int size;

    public LinkedList() {
        dummyHead = new Node(null,null);
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 返回链表是否为空
     * @return
     */
    public boolean isEmpty(){

        return size == 0;
    }

    /**
     * 在链表中不固定位置添加新元素
     * 但刚方法在链表的实操中 "不常用"，因为链表没有索引，练习用
     * @param index
     * @param e
     */
    public void add(int index, E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add faild. Illegal index");
        }

        /**
         * 解释一下该遍历：
         * 通过不断的遍历，从dummyHead节点一直遍历到要找节点的前一个节点
         */
        Node prev = dummyHead;
        for (int i = 0; i < index; i--){
            prev = prev.next;
        }
        /**
         * Node node = new Node();
         * node.next = prev.next;
         * prev.next = node;
         */
        prev.next = new Node(e, prev.next);
        size ++;
    }

    /**
     * 在链表头添加新的元素
     * @param e
     */
    public void addFirst(E e){
        /**
         * Node node = new Node(e);
         * node.next = head;
         * head = node;
         */
        /*dummyHead = new Node(e,dummyHead);

        size ++;*/

        add(0,e);
    }

    /**
     * 在链表末尾添加新元素
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 获取链表元素
     * @param index
     * @return
     */
    public E get(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("get faild. Illegal index");
        }

        Node curr = dummyHead;
        for (int i = 0; i < index; i++){
            curr = curr.next;
        }

        return curr.e;
    }

    /**
     * 获取链表头元素
     * @return
     */
    public E getFirst(){

        return get(0);
    }

    /**
     * 获取链表尾节点元素
     * @return
     */
    public E getLast(){

        return get(size -1);
    }

    /**
     * 修改某个节点下的元素
     * @param index
     * @param e
     */
    public void set(int index, E e){

        if (index < 0 || index > size){
            throw new IllegalArgumentException("set faild. Illegal index");
        }

        Node setNode = dummyHead;
        for (int i = 0; i < index; i++){
            setNode = setNode.next;
        }

        setNode.e = e;
    }

    /**
     * 判断某个元素是否存在
     * @param e
     * @return
     */
    public boolean contains(E e){

        Node node = dummyHead.next;
        while (node != null){
            if (node.e.equals(e)){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**
     * 通过序号移除元素
     * @param index
     * @return
     */
    public E remove(int index){

        Node prev = dummyHead;
        for (int i = 0; i < index; i++){
            prev = prev.next;
        }

        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;

        size --;
        return prev.e;

    }

    /**
     * 按已知元素删除节点
     * @param e
     */
    public void removeByObject(E e){
        Node prev = dummyHead;
        Node delNode = dummyHead;
        for (int i = 0; i < size; i++){
            if (prev.next.e.equals(e)){
                delNode = prev.next;
                break;
            }
            prev = prev.next;
        }
        prev.next = delNode.next;
        delNode.next = null;
        size --;
    }

    /**
     * 移除第一个节点
     * @return
     */
    public E removeFirst(){

        return remove(0);
    }

    public E removeLast(){

        return remove(size);
    }

    private class Node{

        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e,null);
        }

        public Node() {
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        /*Node cur = dummyHead.next;
        while (cur != null){
            sb.append(cur + "->");
            cur = cur.next;
        }*/
        for (Node cur = dummyHead.next; cur != null; cur = cur.next){
            sb.append(cur + "->");
        }
        sb.append("NULL");
        return sb.toString();
    }
}
