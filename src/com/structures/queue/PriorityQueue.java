package com.structures.queue;

import com.structures.linkedlist.mycollection.SortMyLinkedList;

import java.io.Serializable;

/**
 * @program: myjavastructures
 * @description: 优先级队列的简单实现，采用排序双链表，T必须实现Comparable接口口
 * @author: Cc.
 * @create: 2019-04-11 16:13
 **/
public class PriorityQueue<T extends Comparable<? extends T>> implements Queue<T>, Serializable {
    private static final long serialVersionUID = -1676930973567714941L;
    
    /**
     * @Description: 排序循环双链表 
     * @Param:  
     * @return:  
     * @Author: Cc.
     * @Date: 19-4-11 下午4:32
     */
    private SortMyLinkedList<T> list;
    
    /**
     * @Description: true表示升序，false表示降序 
     * @Param:  
     * @return:  
     * @Author: Cc.
     * @Date: 19-4-11 下午4:33
     */
    private boolean asc;
    
    /**
     * @Description: 用于控制最大容量，默认128，offer方法使用
     * @Param:  
     * @return:  
     * @Author: Cc.
     * @Date: 19-4-11 下午4:34
     */
    private int maxSize = 128;

    public PriorityQueue(boolean asc){
        this.list = new SortMyLinkedList<T>();
        this.asc = asc;//默认升序
    }

    public void setMaxSize(int maxSize){
        this.maxSize = maxSize;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean add(T data) {
        return list.add(data);
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
