package com.structures.Stack;

import java.io.Serializable;
import java.util.EmptyStackException;

/**
 * @program: myjavastructures
 * @description: 顺序栈的实现
 * @author: Cc.
 * @create: 2019-04-11 10:43
 **/
public class SeqStack<T> implements Stack<T>, Serializable {
    private static final long serialVersionUID = -6313047243330900619L;

    /**
     * @Description: 栈顶指针，-1代表空栈 
     * @Param:  
     * @return:  
     * @Author: Cc.
     * @Date: 19-4-11 上午10:44
     */
    private int top = -1;
    
    /**
     * @Description: 默认容量10 
     * @Param:  
     * @return:  
     * @Author: Cc.
     * @Date: 19-4-11 上午10:45
     */
    private int capacity = 10;
    
    /**
     * @Description: 存放元素的数组
     * @Param:  
     * @return:  
     * @Author: Cc.
     * @Date: 19-4-11 上午10:45
     */
    private T[] array;

    private int size;

    public SeqStack(int capacity){
        array = (T[]) new Object[capacity];
    }
    public SeqStack(){
        array = (T[]) new Object[this.capacity];
    }
    public int size(){
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * @Description: 添加元素，从栈顶（数组尾部）插入
     * @Param: [data]
     * @return: void
     * @Author: Cc.
     * @Date: 19-4-11 上午10:48
     */
    @Override
    public void push(T data) {
        //判断容量是否充足
        if(array.length == size){
            //扩容
            ensureCapacity(size*2+1);
        }
        //从栈顶添加元素
        array[++top] = data;
        size++;
    }

    /**
     * @Description: 获取栈顶元素的值，不删除
     * @Param: []
     * @return: T
     * @Author: Cc.
     * @Date: 19-4-11 上午10:51
     */
    @Override
    public T peek() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return array[top];
    }

    /**
     * @Description: 从栈顶（顺序表）删除
     * @Param: []
     * @return: T
     * @Author: Cc.
     * @Date: 19-4-11 上午10:52
     */
    @Override
    public T pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        size--;
        return array[top--];
    }
    public void ensureCapacity(int capacity){
        //如果需要扩容的容量比现在数组的容量还小，则无需扩容
        if(capacity < size){
            return;
        }
        T[] old = array;
        array = (T[]) new Object[capacity];
        //复制元素
        for(int i=0; i<size; i++){
            array[i] = old[i];
        }
    }

    public static void main(String[] args){
        SeqStack<String> s=new SeqStack<>();
        s.push("A");
        s.push("B");
        s.push("C");
        System.out.println("size->"+s.size());
        int l=s.size();//size 在减少,必须先记录
        for (int i=0;i<l;i++){
            System.out.println("s.pop->"+s.pop());
        }

        System.out.println("s.peek->"+s.peek());
    }
}
