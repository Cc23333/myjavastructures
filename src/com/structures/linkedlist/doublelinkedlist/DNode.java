package com.structures.linkedlist.doublelinkedlist;

/**
 * @program: myjavastructures
 * @description: 双链表节点
 * @author: Cc.
 * @create: 2019-04-09 10:07
 **/
public class DNode<T> {

    public T data;

    /**
    * @Description: 前继指针和后继指针
    * @Param:
    * @return:
    * @Author: Cc.
    * @Date: 2019/4/9
    */
    public DNode<T> pre, next;

    public DNode(T data, DNode<T> pre, DNode<T> next){
        this.data = data;
        this.pre = pre;
        this.next = next;
    }

    public DNode(T data){
        this(data, null, null);
    }

    public DNode(){
        this(null, null, null);
    }

    @Override
    public String toString(){
        return this.data.toString();
    }
}
