package com.structures.stack;

import com.structures.linkedlist.mycollection.MyArrayList;

import java.io.Serializable;
import java.util.EmptyStackException;

/**
 * @program: myjavastructures
 * @description: 顺序栈的实现（利用循序表实现）
 * @author: Cc.
 * @create: 2019-04-11 14:27
 **/
public class StackByArrayList<T> implements Stack<T>, Serializable {
    private static final long serialVersionUID = 8984431574215976503L;

    private MyArrayList<T> list;

    public StackByArrayList(int capacity){
        list = new MyArrayList<T>(capacity);
    }

    public StackByArrayList(){
        list = new MyArrayList<T>();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    /**
     * @Description: 添加元素，从栈顶（顺序表的尾部）插入
     * @Param: [data]
     * @return: void
     * @Author: Cc.
     * @Date: 19-4-11 下午2:31
     */
    @Override
    public void push(T data) {
        this.list.add(data);
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return this.list.get(list.size()-1);
    }

    @Override
    public T pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return this.list.remove(list.size()-1);
    }
}
