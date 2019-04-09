package com.structures.LinkedList.SingleLinkedList;

/**
 * @program: javastructures
 * @description: 单向链表节点
 * @author: Cc.
 * @create: 2019-04-06 13:15
 **/
public class Node<T> {
    /**
     * @Description: 数据域
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    public T data;

    /**
     * @Description: 当前节点的下个节点
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    public Node<T> next;

    public Node(){

    }

    public Node(T data){
        this.data = data;
    }

    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }
}
