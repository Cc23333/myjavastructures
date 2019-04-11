package com.structures.queue;

import com.structures.linkedlist.singlelinkedlist.Node;

import java.io.Serializable;

/**
 * @program: javastructures
 * @description: 链式队列的实现
 * @author: Cc.
 * @create: 2019-04-05 17:07
 **/
public class LinkedQueue<T> implements Queue<T>, Serializable {


    private static final long serialVersionUID = 5009379795191408121L;

    /**
     * @Description: 指向对头和队尾的节点
     *               front==null && rear==null时，队列为空
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    private Node<T> front,rear;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean add(T data) {
        return false;
    }

    @Override
    public boolean offer(T data) {
        return false;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public T element() {
        return null;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public void clearQueue() {

    }
}
