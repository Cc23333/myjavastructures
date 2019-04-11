package com.structures.stack;

import com.structures.linkedlist.singlelinkedlist.Node;

import java.io.Serializable;
import java.util.EmptyStackException;

/**
 * @program: myjavastructures
 * @description: 栈的链式实现
 * @author: Cc.
 * @create: 2019-04-11 11:02
 **/
public class LinkedStack<T> implements Stack<T>, Serializable {
    private static final long serialVersionUID = -1365314102267203926L;

    private Node<T> top;

    private int size;

    public LinkedStack(){
        this.top = new Node<T>();
    }

    public int size(){
        return this.size;
    }
    @Override
    public boolean isEmpty() {
        return top == null || top.data == null;
    }

    @Override
    public void push(T data) {
        if(data == null){
            throw new RuntimeException("data can\'t be null");
        }
        if(this.top == null){
            this.top = new Node<T>(data);
        }else if(this.top.data == null){
            this.top.data = data;
        }else{
            Node<T> p = new Node<T>(data, this.top);
            top = p;//更新栈顶
        }
        size++;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T old = top.data;
        top = top.next;
        size--;
        return old;
    }
    public static void main(String[] args){
        LinkedStack<String> sl=new LinkedStack<>();
        sl.push("A");
        sl.push("B");
        sl.push("C");
        int length=sl.size();
        for (int i = 0; i < length; i++) {
            System.out.println("sl.pop->"+sl.pop());
        }
    }
}
