package com.structures.linkedlist.singlelinkedlist;

import com.structures.linkedlist.ILinkedList;

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
                T old = p.data;
                p.data = data;
                return old;
            }
        }
        return null;
    }

    /**
     * @Description: 根据索引追加数据
     * @Param: [index, data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/8
     */
    @Override
    public boolean add(int index, T data) {
        int size = length();
        if(data == null || index < 0 || index >= size){
            return false;
        }
        int j = 0;
        Node<T> p = this.head;
        //寻找插入点的位置的前一个节点
        while (p.next != head && j <index){
            p = p.next;
            j++;
        }

        //创建新的节点，如果 index = 3,则插入到第四个位置
        Node<T> q = new Node<T>(data, p.next);
        p.next = q;
        //更新尾部指向
        if(p == tail){
            this.tail = q;
        }
        return true;
    }

    /**
     * @Description: 尾部追加
     * @Param: [data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/8
     */
    @Override
    public boolean add(T data) {
        if(data == null){
            return false;
        }
        Node<T> q = new Node<T>(data, this.tail.next);
        this.tail.next = q;
        //更新尾部指向
        this.tail = q;

        return true;
    }

    /**
     * @Description: 根据索引移除元素
     * @Param: [index]
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/8
     */
    @Override
    public T remove(int index) {
        int size = length();
        if(index < 0 || index >= size || isEmpty()){
            return null;
        }
        int j = 0;
        Node<T> p = this.head.next;
        while(p != head && j < index){
            j++;
            p = p.next;
        }
        if(p != head){
            T old = p.data;

            if(tail == p.next){
                tail = p;
            }
            p.next = p.next.next;
            return old;
        }
        return null;
    }

    /**
     * @Description: 根据 data 移除所有相关元素
     * @Param: [data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/8
     */
    @Override
    public boolean removeAll(T data) {
        boolean isRemove = false;
        if(data == null){
            return isRemove;
        }

        //用于记录要删除节点的前一个节点
        Node<T> front = this.head;
        //当前遍历的节点
        Node<T> pre = front.next;
        //查找所有数据为 data 的节点并删除
        while(pre != head){
            if(data.equals(pre.data)){
                //如果恰好是尾部节点，则更新 rear 的指向
                if(data.equals(tail.data)){
                    this.tail = front;
                }

                //相等则删除 pre 并更改指针指向
                front.next = pre.next;
                pre = front.next;
                isRemove = true;
            }else{
                front = pre;
                pre = pre.next;
            }
        }
        return isRemove;
    }

    /**
     * @Description: 链表置空
     * @Param: []
     * @return: void
     * @Author: Cc.
     * @Date: 2019/4/8
     */
    @Override
    public void clear() {
        this.head.next = head;
        this.tail = head;
    }

    /**
     * @Description: 链表是否包含某个元素
     * @Param: [data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/8
     */
    @Override
    public boolean contains(T data) {
        if(data == null){
            return false;
        }
        Node<T> p = this.head.next;
        while(p != head){
            if(data.equals(p.data)){
                return true;
            }
            p = p.next;
        }
        return false;
    }

    @Override
    public String toString()
    {
        String str="(";
        Node<T> p = this.head.next;
        while (p!=head)
        {
            str += p.data.toString();
            p = p.next;
            if (p!=head){
                str += ", ";
            }
        }
        return str+")";
    }
}
