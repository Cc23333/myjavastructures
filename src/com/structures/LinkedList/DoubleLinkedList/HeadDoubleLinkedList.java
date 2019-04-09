package com.structures.LinkedList.DoubleLinkedList;

import com.structures.LinkedList.ILinkedList;

/**
 * @program: myjavastructures
 * @description: 双链表的实现，带头结点（不带数据）的双链表，为了更高的效率该类包含指向尾部的指针tail
 * @author: Cc.
 * @create: 2019-04-09 10:02
 **/
public class HeadDoubleLinkedList<T> implements ILinkedList<T> {

    /**
     * @Description: 不带数据的头节点
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/9
     */
    protected DNode<T> head;

    /**
     * @Description: 指向尾部的指针
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/9
     */
    protected DNode<T> tail;

    public HeadDoubleLinkedList() {
        //初始化头节点
        this.head = this.tail = new DNode<>();
    }

    /**
     * @Description: 传入一个数组，转换成链表
     * @Param: [array]
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/9
     */
    public HeadDoubleLinkedList(T[] array) {
        this();
        if (array != null && array.length > 0) {
            this.head.next = new DNode<T>(array[0]);
            tail = this.head.next;
            tail.pre = this.head;
            int i = 1;
            while (i < array.length) {
                tail.next = new DNode<T>(array[i++]);
                tail.next.pre = tail;
                tail = tail.next;
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
        return this.head.next == null;
    }

    /**
     * @Description: 获得当前链表长度
     * @Param: []
     * @return: int
     * @Author: Cc.
     * @Date: 2019/4/9
     */
    @Override
    public int length() {
        int length = 0;
        DNode<T> pre = this.head.next;
        while (pre != null) {
            length++;
            pre = pre.next;
        }
        return length;
    }

    /**
     * @Description: 根据索引获取元素值
     * @Param: [index]
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/9
     */
    @Override
    public T get(int index) {
        if (index > 0) {
            int j = 0;
            //注意起始结点为this.head.next
            //如果起始点为this.head时，j的判断为j<=index，
            //因为需要寻找的是当前结点而不是前一个结点。
            DNode<T> pre = this.head.next;
            while (pre != null && j < index) {
                j++;
                pre = pre.next;
            }
            if (pre != null) {
                return pre.data;
            }
        }
        return null;
    }

    /**
     * @Description: 根据索引修改元素值
     * @Param: [index, data]
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/9
     */
    @Override
    public T set(int index, T data) {
        T old = null;
        if (index > 0 && data != null) {
            int j = 0;
            DNode<T> pre = this.head.next;
            //查找要替换的位置
            while (pre != null && j < index) {
                j++;
                pre = pre.next;
            }
            if (pre != null) {
                old = pre.data;
                //替换数据
                pre.data = data;
            }
        }
        return old;
    }

    /**
     * @Description: 插入节点
     * @Param: [index, data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/9
     */
    @Override
    public boolean add(int index, T data) {
        if (index < 0 || data == null) {
            throw new NullPointerException("index < 0 || data == null");
        }
        int j = 0;
        DNode<T> front = this.head;
        //查找要插入节点位置的前一个节点
        while (front.next != null && j < index) {
            j++;
            front = front.next;
        }
        //创建需要插入的节点，并让其前继指针指向front,后继指针指向front.next
        DNode<T> q = new DNode<T>(data, front, front.next);
        //空双链表插入，需要确保front.next不为空
        if (front.next != null) {
            //更改front.next的前继指针
            front.next.pre = q;
        }
        //更改front的后继指针
        front.next = q;
        //在尾部插入时需要注意更新tail指向
        if (front == this.tail) {
            this.tail = q;
        }
        return true;
    }

    /**
     * @Description: 尾部添加
     * @Param: [data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/9
     */
    @Override
    public boolean add(T data) {
        if (data == null) {
            return false;
        }
        //创建新节点，并把其前继指针指向tail
        DNode<T> q = new DNode<T>(data, tail, null);
        tail.next = q;
        //更新尾部节点
        this.tail = q;
        return true;
    }

    /**
     * @Description: 根据下标删除节点
     *                1.头删除
     *                2.中间删除
     *                3.尾部删除，更新tail指向
     * @Param: [index]
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/9
     */
    @Override
    public T remove(int index) {
        int size = length();
        T temp = null;
        if(index < 0 || index >= size || isEmpty()){
            return temp;
        }
        DNode<T> p = this.head;
        int j = 0;
        //需要查找要删除的节点（要删除当前的节点 因此 i<=index）
        while (p != null && j < index){
            j++;
            p = p.next;
        }
        //当链表只有一个节点时，无需此步
        if(p.next != null){
            p.next.pre = p.pre;
        }
        p.pre.next = p.next;
        //如果是尾节点
        if(p == this.tail){
            //更新尾节点的指向
            this.tail = p.pre;
        }
        temp = p.data;

        return temp;
    }

    /**
    * @Description: 根据data删除节点，无需像单链表那样去存储要删除节点的前一个节点
    * @Param: [data]
    * @return: boolean
    * @Author: Cc.
    * @Date: 2019/4/9
    */
    @Override
    public boolean removeAll(T data) {
        boolean isRemove = false;
        if(data == null || isEmpty()){
            return isRemove;
        }
        //注意这里的起点，如果起点为this.head,那么情况区别如同前面的根据index的删除的实现
        DNode<T> p = this.head.next;
        //查找所有需要删除的节点
        while(p != null){
            if(data.equals(p.data)){
                if(p == this.tail){
                    //如果是尾节点
                    //更新尾节点的指向
                    this.tail = p.pre;
                    this.tail.next = null;
                }else{
                    //如果是中间删除，更新前继和后继指针指向
                    p.pre.next = p.next;
                    p.next.pre = p.pre;
                }
                isRemove = true;
                //继续查找
                p = p.next;
            }else{
                p = p.next;
            }
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
        this.head.next = null;
        this.tail = this.head;
    }

    /**
    * @Description: 判断是否包含某个元素
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
        while(p != null){
            if(data.equals(p.data)){
                return true;
            }else{
                p = p.next;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String str="(";
        DNode<T> pre = this.head.next;
        while (pre!=null)
        {
            str += pre.data;
            pre = pre.next;
            if (pre!=null) {
                str += ", ";
            }
        }
        return str+")";
    }
}
