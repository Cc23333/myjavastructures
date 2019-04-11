package com.structures.Queue;

import com.structures.linkedlist.singlelinkedlist.Node;

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * @program: myjavastructures
 * @description: 链式队列的实现
 * @author: Cc.
 * @create: 2019-04-11 15:30
 **/
public class LinkedQueue<T> implements Queue<T>, Serializable {
    private static final long serialVersionUID = 9486613274569218L;

    /**
     * @Description: 指向对头对尾的节点
     *                front==null&&rear==null时，队列为空
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 19-4-11 下午3:32
     */
    private Node<T> front, rear;

    private int size;
    /**
     * @Description: 用于控制最大容量，默认128，offer方法使用
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 19-4-11 下午3:33
     */
    private int maxSize = 128;

    public LinkedQueue(){
        //初始化队列
        this.front = this.rear = null;
    }

    @Override
    public int size() {
        return this.size;
    }

    public void setMaxSize(int maxSize){
        this.maxSize = maxSize;
    }

    @Override
    public boolean isEmpty() {
        return this.front==null&&this.rear==null;
    }

    /**
     * @Description: 入队，可扩容
     * @Param: [data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 19-4-11 下午3:55
     */
    @Override
    public boolean add(T data) {
        Node<T> q = new Node<T>(data, null);
        if(this.front == null){
            //空队列插入
            this.front = q;
        }else{
            //非空队列，尾部插入
            this.rear.next = q;
        }
        this.rear = q;
        size++;
        return true;
    }

    /**
     * @Description: offer 方法可插入一个元素,这与add 方法不同，
     *                该方法只能通过抛出未经检查的异常使添加元素失败。
     *                而不是出现异常的情况，例如在容量固定（有界）的队列中
     *                NullPointerException:data==null时抛出
     *                IllegalArgumentException:队满,使用该方法可以使Queue的容量固定
     * @Param: [data] 
     * @return: boolean 
     * @Author: Cc.
     * @Date: 19-4-11 下午3:59
     */
    @Override
    public boolean offer(T data) {
        if(data == null){
            throw new NullPointerException();
        }
        if(size >= maxSize){
            throw new IllegalArgumentException();
        }
        Node<T> q = new Node<T>(data, null);
        if(this.front == null){
            //空队列插入
            this.front = q;
        }else{
            this.rear.next = q;
        }
        this.rear = q;
        size++;
        return true;
    }

    /**
     * @Description: 返回对头元素，不执行删除操作，队列为空返回null
     * @Param: []
     * @return: T
     * @Author: Cc.
     * @Date: 19-4-11 下午4:03
     */
    @Override
    public T peek() {
        return this.isEmpty() ? null : this.front.data;
    }

    /**
     * @Description: 返回队头元素，不执行删除操作，为空抛异常
     * @Param: []
     * @return: T
     * @Author: Cc.
     * @Date: 19-4-11 下午4:04
     */
    @Override
    public T element() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return this.front.data;
    }

    @Override
    public T poll() {
        if(this.isEmpty()){
            return null;
        }
        T x = this.front.data;
        this.front = this.front.next;
        if(this.front==null){
            this.rear=null;
        }
        size--;
        return x;
    }

    /**
     * @Description: 出队，执行删除操作，队列为空，抛异常
     * @Param: []
     * @return: T
     * @Author: Cc.
     * @Date: 19-4-11 下午4:06
     */
    @Override
    public T remove() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        T x = this.front.data;
        this.front = this.front.next;
        if(this.front==null){
            this.rear = null;
        }
        size--;
        return x;
    }

    @Override
    public void clearQueue() {
        this.front = this.rear = null;
        size = 0;
    }
}
