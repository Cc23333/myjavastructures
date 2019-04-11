package com.structures.linkedlist.mycollection;

import java.io.Serializable;

/**
 * @program: myjavastructures
 * @description: 排序list的简单实现
 * @author: Cc.
 * @create: 2019-04-11 16:17
 **/
public class SortMyLinkedList<T extends Comparable<? extends T>> extends MyLinkedList<T> implements Serializable {
    private static final long serialVersionUID = 7587101743354518365L;

    @Override
    public boolean add(T data){
        if(data == null){
            throw new NullPointerException();
        }
        //这里需要转一下类型
        Comparable cmp = data;
        if(this.isEmpty() || cmp.compareTo(this.last.pre.data) > 0){
            return super.add(data);//直接尾部添加，last不带数据的尾节点
        }
        Node<T> p = this.first.next;
        //查找节点
        while(p!=null && cmp.compareTo(p.data) > 0){
            p = p.next;
        }
        Node<T> q = new Node<T>(p.pre, data, p);
        p.pre.next = q;
        p.pre = q;
        size++;
        modCount++;
        return true;
    }

    //测试
    public static void main(String[] args){
        SortMyLinkedList<Integer> list=new SortMyLinkedList<>();
        list.add(50);
        list.add(40);
        list.add(80);
        list.add(20);
        print(list);
    }

    public static void print(SortMyLinkedList mylinkeList){
        for (int i=0;i<mylinkeList.size();i++) {
            System.out.println("i->"+mylinkeList.get(i));
        }
    }
}
