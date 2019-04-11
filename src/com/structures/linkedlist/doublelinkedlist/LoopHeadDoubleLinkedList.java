package com.structures.linkedlist.doublelinkedlist;

import com.structures.linkedlist.ILinkedList;

/**
 * @program: myjavastructures
 * @description: 循环双链表，带空头节点（不含数据），循环链表可以不需要尾指针
 * @author: Cc.
 * @create: 2019-04-09 13:31
 **/
public class LoopHeadDoubleLinkedList<T> implements ILinkedList<T> {

    /**
     * @Description: 不带数据的头节点
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/9
     */
    protected DNode<T> head;

    public LoopHeadDoubleLinkedList() {
        //初始化头节点
        this.head = new DNode<T>();
        this.head.next = head;
        this.head.pre = head;
    }

    /**
     * @Description: 传入一个数组，转换成链表
     * @Param: [array]
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/9
     */
    public LoopHeadDoubleLinkedList(T[] array) {
        this();
        if (array != null && array.length > 0) {
            DNode<T> p = new DNode<T>(array[0]);
            head.next = p;
            head.pre = p;
            p.pre = head;
            p.next = head;

            int i = 1;
            while (i < array.length) {
                p.next = new DNode<T>(array[i++], p, head);
                head.pre = p.next;
                p = p.next;
            }
        }
    }

    /**
     * @Description: 判断链表是否为空
     * @Param: []
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/9
     */
    @Override
    public boolean isEmpty() {
        //循环双链表的后继指针指向自己说明是空链表
        return this.head.next == head;
    }

    /**
     * @Description: 获取链表长度
     * @Param: []
     * @return: int
     * @Author: Cc.
     * @Date: 2019/4/9
     */
    @Override
    public int length() {
        int length = 0;
        DNode<T> p = this.head.next;
        while (p != this.head) {
            length++;
            p = p.next;
        }
        return length;
    }

    /**
     * @Description: 通过索引获取元素
     * @Param: [index]
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/9
     */
    @Override
    public T get(int index) {
        if (index >= 0) {
            int j = 0;
            DNode<T> p = this.head.next;
            while (p != head && j < index) {
                j++;
                p = p.next;
            }
            if (p != head) {
                return p.data;
            }
        }
        return null;
    }

    /**
     * @Description: 根据index修改data
     * @Param: [index, data]
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/9
     */
    @Override
    public T set(int index, T data) {
        if (data == null) {
            return null;
        }
        if (index >= 0) {
            int j = 0;
            DNode<T> p = this.head.next;
            while (p != head && j < index) {
                j++;
                p = p.next;
            }
            //如果不是头节点
            if (p != head) {
                T old = p.data;
                p.data = data;
                return old;
            }
        }
        return null;
    }

    /**
     * @Description: 根据index添加
     *                循环链表中无论是pre还是next都不存在空的情况，因此添加时
     *                无论是头部还是尾部还是中间都视为一种情况对待
     * @Param: [index, data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/9
     */
    @Override
    public boolean add(int index, T data) {
        int size = this.length();
        if(data == null || data == null || index >= size){
            return false;
        }
        int j = 0;
        DNode<T> p = this.head;
        //寻找插入点的地址
        while(p.next != head && j < index){
            p = p.next;
            j++;
        }
        //创建新节点
        DNode<T> q = new DNode<T>(data, p, p.next);
        p.next = q;
        p.next.pre = q;
        return true;
    }

    /**
    * @Description: 尾部追加
    * @Param: [data]
    * @return: boolean
    * @Author: Cc.
    * @Date: 2019/4/9
    */
    @Override
    public boolean add(T data) {
        if(data == null){
            return false;
        }
        //创建新节点，让前继指针指向head.pre,后继指针指向head
        DNode<T> p = new DNode<T>(data, head.pre, head);
        //更新tail后继指针指向
        this.head.pre.next = p;
        this.head.pre = p;
        return true;
    }

    /**
    * @Description: 根据索引移除元素
    * @Param: [index]
    * @return: T
    * @Author: Cc.
    * @Date: 2019/4/9
    */
    @Override
    public T remove(int index) {
        T old = null;
        int size = this.length();
        if(index <0 || index >= size){
            return old;
        }
        int j = 0;
        DNode<T> p = this.head.next;

        while(p != head && j < index){
            j++;
            p = p.next;
        }
        if(p != head){
            old = p.data;
            p.pre.next = p.next;
            p.next.pre = p.pre;
        }
        return old;
    }

    /**
    * @Description: 根据索data移除所有相关元素
    * @Param: [data]
    * @return: boolean
    * @Author: Cc.
    * @Date: 2019/4/9
    */
    @Override
    public boolean removeAll(T data) {
        boolean isRemove = false;
        if(data == null){
            return isRemove;
        }
        DNode<T> p = this.head.next;
        while(p != head){
            if(data.equals(p.data)){
                p.pre.next = p.next;
                p.next.pre = p.pre;
                isRemove = true;
            }
            p = p.next;
        }
        return isRemove;
    }

    /**
    * @Description: 清空链表
    * @Param: []
    * @return: void
    * @Author: Cc.
    * @Date: 2019/4/9
    */
    @Override
    public void clear() {
        this.head.pre = this.head;
        this.head.next = this.head;
    }

    /**
    * @Description: 判断链表是否包含某个值
    * @Param: [data]
    * @return: boolean
    * @Author: Cc.
    * @Date: 2019/4/9
    */
    @Override
    public boolean contains(T data) {
        if(data == null){
            return false;
        }
        DNode<T> p = this.head.next;
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
        DNode<T> p = this.head.next;
        while (p!=head)
        {
            str += p.data.toString();
            p = p.next;
            if (p!=head) {
                str += ", ";
            }
        }
        return str+")";
    }
}
