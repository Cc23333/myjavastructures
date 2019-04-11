package com.structures.LinkedList.DoubleLinkedList;

/**
 * @program: myjavastructures
 * @description: 升序排序双链表，继承LoopHeadDoubleLinkedList
 * @author: Cc.
 * @create: 2019-04-09 14:29
 **/
public class SortLoopHeadDoubleLinkedList<T extends Comparable<? extends T>> extends LoopHeadDoubleLinkedList<T> {
    /**
    * @Description: 出入元素按升序排序
    * @Param: [data]
    * @return: boolean
    * @Author: Cc.
    * @Date: 2019/4/9
    */
    @Override
    public boolean add(T data) {
        if(data == null || !(data instanceof Comparable)){
            throw new NullPointerException("data can\'t be null or data instanceof Comparable must be true");
        }
        //这里需要转一下类型，负责idea检验不通过
        Comparable cmp = data;
        //如果data值比最后一个节点大，那么直接调用父类方法，在尾部添加
        if(this.isEmpty() || cmp.compareTo(this.head.pre.data) > 0){
            return super.add(data);
        }
        DNode<T> p = this.head.next;
        //查找插入点
        while(p != head && cmp.compareTo(p.data) > 0){
            p = p.next;
        }
        DNode<T> q = new DNode<T>(data, p.pre, p);
        p.pre.next = q;
        p.pre = q;

        return true;
    }

    /*public static void main(String[] args){
        ILinkedList<Integer> list=new SortLoopHeadDoubleLinkedList<>();
        list.add(50);
        list.add(40);
        list.add(80);
        list.add(20);
        System.out.println("init list-->"+list.toString());
    }*/
}
