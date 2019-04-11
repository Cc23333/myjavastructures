package com.structures.stack;

import com.structures.linkedlist.singlelinkedlist.SingleLinkedList;

import java.io.Serializable;
import java.util.EmptyStackException;

/**
 * @program: myjavastructures
 * @description: 链式栈的实现
 * @author: Cc.
 * @create: 2019-04-11 14:19
 **/
public class LinkedStackBySingleLinkedList<T> implements Stack<T>, Serializable {

    private static final long serialVersionUID = 8149545043053903880L;

    private SingleLinkedList<T> linkedList;

    public LinkedStackBySingleLinkedList(){
        linkedList = new SingleLinkedList<T>();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    /**
     * @Description: 栈顶插入（单链表尾部）
     * @Param: [data]
     * @return: void
     * @Author: Cc.
     * @Date: 19-4-11 下午2:22
     */
    @Override
    public void push(T data) {
        linkedList.add(data);
    }

    /**
     * @Description: 获取元素，不删除
     * @Param: []
     * @return: T
     * @Author: Cc.
     * @Date: 19-4-11 下午2:22
     */
    @Override
    public T peek() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return linkedList.get(linkedList.length()-1);
    }

    /**
     * @Description: 栈顶移除 
     * @Param: [] 
     * @return: T 
     * @Author: Cc.
     * @Date: 19-4-11 下午2:27
     */
    @Override
    public T pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return linkedList.remove(linkedList.length()-1);
    }
}
