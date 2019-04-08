package com.structures.LinkedList.SingleLinked;

import com.structures.LinkedList.ILinkedList;

/**
 * @program: javastructures
 * @description: 循环单链表
 * @author: Cc.
 * @create: 2019-04-07 20:06
 **/
public class CircularHeadSingleLinkedList<T> implements ILinkedList<T> {
    /**
     * @Description: 不带数据的头节点
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/7
     */
    protected Node<T> head;

    /**
     * @Description: 指向尾部的指针
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/7
     */
    protected Node<T> tail;

    public CircularHeadSingleLinkedList(){
        //初始化头节点和尾指针
        this.head = new Node<T>(null);
        this.head.next = head;
        this.tail = head;
    }

    public CircularHeadSingleLinkedList(T[] array){
        this();
        if(array != null && array.length >0){
            this.head.next = new Node<T>(array[0], head);
            tail = this.head.next;
            int i = 1;
            while(i < array.length){
                tail.next = new Node<T>(array[i++]);
                tail.next.next = head;
                tail = tail.next;
            }
        }
    }

    /**
     * @Description: 判断链表是否为空
     * @Param: []
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/7
     */
    @Override
    public boolean isEmpty() {
        return this.head.next == head;
    }

    /**
     * @Description: 获取链表长度
     * @Param: []
     * @return: int
     * @Author: Cc.
     * @Date: 2019/4/7
     */
    @Override
    public int length() {
        int length = 0;
        Node<T> p = this.head.next;
        while(p != head){
            p = p.next;
            length++;
        }
        return length;
    }

    /**
     * @Description: 根据索引获取元素值
     * @Param: [index]
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/7
     */
    @Override
    public T get(int index) {
        if(index > 0){
            int j = 0;
            Node<T> pre = this.head.next;
            while (pre != null && j < index){
                j++;
                pre = pre.next;
            }
            if(pre != null){
                return pre.data;
            }
        }
        return null;
    }

    /**
     * @Description: 根据索引设置元素值
     * @Param: [index, data]
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/7
     */
    @Override
    public T set(int index, T data) {
        if(data == null){
            return null;
        }
        if(index > 0){
            int j = 0;
            Node<T> p = this.head.next;
            while(p != null && j < index){
                j++;
                p = p.next;
            }
            //如果不是头节点
            if(p != head){

            }
        }
        return null;
    }

    @Override
    public boolean add(int index, T data) {
        return false;
    }

    @Override
    public boolean add(T data) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean removeAll(T data) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(T data) {
        return false;
    }
}
