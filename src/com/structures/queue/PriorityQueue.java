package com.structures.queue;

import com.structures.linkedlist.mycollection.SortMyLinkedList;

import java.io.Serializable;
import java.util.NoSuchElementException;

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

    public PriorityQueue(boolean asc) {
        this.list = new SortMyLinkedList<T>();
        this.asc = asc;// 默认升序
    }

    public void setMaxSize(int maxSize) {
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
        if (data == null) {
            throw new NullPointerException("The data can\'t be null");
        }

        if (list.size() >= maxSize) {
            throw new IllegalArgumentException("The capacity of PriorityQueue has reached its maxSize:128");
        }
        return add(data);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return this.asc ? this.list.get(0) : this.list.get(size() - 1);

    }

    @Override
    public T element() {

        if (isEmpty()) {
            throw new NoSuchElementException("The PriorityQueue is empty");
        }
        return peek();
    }

    @Override
    public T poll() {

        if (isEmpty()) {
            return null;
        }
        return this.asc ? this.list.remove(0) : this.list.remove(list.size() - 1);
    }

    @Override
    public T remove() {

        if (isEmpty()) {
            throw new NoSuchElementException("The PriorityQueue is empty");
        }
        return poll();
    }

    @Override
    public void clearQueue() {
        this.list.clear();
    }
    //测试
    public static void main(String[] args){
        PriorityQueue<Process> priorityQueue=new PriorityQueue<>(false);

        System.out.println("初始化队列");
        priorityQueue.add(new Process("进程1",10));
        priorityQueue.add(new Process("进程2",1));
        priorityQueue.add(new Process("进程3",8));
        priorityQueue.add(new Process("进程4",3));
        priorityQueue.add(new Process("进程5"));
        System.out.println("队列中的进程执行优先级:");
        while (!priorityQueue.isEmpty()){
            System.out.println("process:"+priorityQueue.poll().toString());
        }

    }
}
