package com.structures.Queue;

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * @program: myjavastructures
 * @description: 顺序队列的实现
 * @author: Cc.
 * @create: 2019-04-11 14:53
 **/
public class SeqQueue<T> implements Queue<T>, Serializable {
    private static final long serialVersionUID = 8468581641199006247L;

    private static final int DEFAULT_SIZE = 10;

    private  T elementData[];

    private int front, rear;

    private int size;

    public SeqQueue(){
        elementData = (T[]) new Object[DEFAULT_SIZE];
        front = rear = 0;
    }

    public SeqQueue(int capacity){
        elementData = (T[]) new Object[capacity];
        front = rear = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * @Description: 入队，可扩容
     * @Param: [data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 19-4-11 下午2:58
     */
    @Override
    public boolean add(T data) {
        //判断是否满队
        if(this.front == (this.rear+1)%this.elementData.length){
            ensureCapacity(elementData.length*2+1);
        }
        //添加data
        elementData[this.rear] = data;
        this.rear = (this.rear+1)%elementData.length;
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
     * @Date: 19-4-11 下午3:05
     */
    @Override
    public boolean offer(T data) {
        if(data == null){
            throw new NullPointerException();
        }
        //队列满抛出异常
        if(this.front==(this.rear+1)%this.elementData.length){
            throw new IllegalArgumentException();
        }
        //添加data
        elementData[this.rear] = data;
        //更新rear指向下一个空元素的位置
        this.rear = (this.rear+1) % this.elementData.length;
        size++;
        return true;
    }

    /**
     * @Description: 返回队头元素，不执行删除操作，若队列为空，返回null
     * @Param: []
     * @return: T
     * @Author: Cc.
     * @Date: 19-4-11 下午3:09
     */
    @Override
    public T peek() {
        return elementData[front];
    }

    /**
     * @Description: 返回队头元素，不执行删除操作，若队列为空，抛出异常NoSuchelementException
     * @Param: []
     * @return: T
     * @Author: Cc.
     * @Date: 19-4-11 下午3:10
     */
    @Override
    public T element() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return peek();
    }

    /**
     * @Description: 出队，执行删除操作，返回队头元素，若队列为空，返回null
     * @Param: []
     * @return: T
     * @Author: Cc.
     * @Date: 19-4-11 下午3:12
     */
    @Override
    public T poll() {
        T temp = this.elementData[this.front];
        this.front = (this.front+1)%this.elementData.length;
        size--;
        return temp;
    }

    /**
     * @Description: 出队，执行删除操作，若队列为空，抛出异常 NoSuchElementException
     * @Param: []
     * @return: T
     * @Author: Cc.
     * @Date: 19-4-11 下午3:13
     */
    @Override
    public T remove() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return poll();
    }

    @Override
    public void clearQueue() {
        for(int i=this.front; i!=this.rear; i=(i+1)%this.elementData.length){
            elementData[i] = null;
        }
        //复位
        this.front = this.rear = 0;
        size = 0;
    }

    /**
     * @Description: 扩容
     * @Param: [capacity]
     * @return: void
     * @Author: Cc.
     * @Date: 19-4-11 下午3:16
     */
    public void ensureCapacity(int capacity){
        //如果需要扩展的容量比现在数组还小，则无需扩容
        if(capacity < size){
            return;
        }
        T[] old = this.elementData;
        elementData = (T[]) new Object[capacity];
        int j = 0;
        //复制元素
        for(int i=this.front; i!=this.rear; i=(i+1)%old.length){
            elementData[j++] = old[i];
        }
        //恢复front,rear指向
        this.front = 0;
        this.rear = j;
    }
}
