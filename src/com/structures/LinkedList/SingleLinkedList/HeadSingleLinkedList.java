package com.structures.LinkedList.SingleLinkedList;

import com.structures.LinkedList.ILinkedList;

/**
 * @program: javastructures
 * @description: 带头结点并含有尾指针的链表
 * @author: Cc.
 * @create: 2019-04-06 15:22
 **/
public class HeadSingleLinkedList<T> implements ILinkedList<T> {

    /**
     * @Description: 不带数据的头节点
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    protected  Node<T> headNode;

    /**
     * @Description: 指向尾部的指针
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    protected  Node<T> rear;

    public HeadSingleLinkedList(){
        //初始化头节点和尾指针
        this.headNode = rear = new Node<T>(null);
    }

    public HeadSingleLinkedList(Node<T> head){
        this();
        this.headNode.next = rear = head;
        //更新末尾指针指向
        rear = rear.next;
    }

    /**
     * @Description: 传入一个数组，转换成链表
     * @Param: [array]
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    public HeadSingleLinkedList(T[] array){
        this();
        if(array != null && array.length > 0){
            this.headNode.next = new Node<T>(array[0]);
            rear = this.headNode.next;
            int i = 1;
            while (i < array.length){
                rear.next = new Node<T>(array[i++]);
                rear = rear.next;
            }
        }
    }

    /**
     * @Description: 通过传入的链表构造新的链表
     * @Param: [list]
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    public HeadSingleLinkedList(HeadSingleLinkedList<T> list){
        this();
        if(list != null && list.headNode.next != null){
            this.headNode.next = new Node(list.headNode.next.data);
            Node<T> p = list.headNode.next;
            rear = this.headNode.next;
            while(p != null){
                rear.next = new Node<T>(p.next.data);
                rear = rear.next;
                p = p.next;
            }
        }
    }

    /**
     * @Description: 判断链表是否为空
     * @Param: []
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    @Override
    public boolean isEmpty() {
        return this.headNode.next == null;
    }

    /**
     * @Description: 获得链表长度
     * @Param: []
     * @return: int
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    @Override
    public int length() {
        int length = 0;
        Node<T> currentNode = headNode.next;
        while(currentNode != null){
            length++;
            currentNode = currentNode.next;
        }
        return length;
    }

    /**
     * @Description: 根据 index 获取值
     * @Param: [index]
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    @Override
    public T get(int index) {
        if(index >=0 && index <this.length()){
            int j = 0;
            Node<T> pre = this.headNode.next;
            //找到对应索引的节点
            while(pre != null && j < index){
                pre = pre.next;
                j++;
            }

            if(pre != null){
                return pre.data;
            }
        }
        return null;
    }

    /**
     * @Description: 根据索引 index 替换对应节点的 data
     * @Param: [index, data]
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    @Override
    public T set(int index, T data) {
        if(index >= 0 && data != null && index < this.length()){
            Node<T> pre = this.headNode.next;
            int j = 0;
            while(pre != null && j < index){
                pre = pre.next;
                j++;
            }

            if(pre != null){
                T oldData = pre.data;
                //设置新值
                pre.data = data;
                return oldData;
            }
        }
        return null;
    }

    /**
     * @Description: 根据下标添加节点
     * @Param: [index, data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    @Override
    public boolean add(int index, T data) {
        if(data == null){
            throw new NullPointerException("data can\'t be empty!");
        }
        if(index < 0){
            throw new NullPointerException("data can\'t less than 0");
        }

        //无需区分位置操作，中间/头部/尾部插入
        int j = 0;
        Node<T> pre = this.headNode;
        while(pre.next != null && j < index){
            pre = pre.next;
            j++;
        }

        //将新插入的节点的后继指针指向 pre.next
        Node<T> q = new Node<T>(data, pre.next);
        //更改指针指向
        pre.next = q;
        //如果是末尾指针
        if(pre == this.rear){
            this.rear = q;
        }
        return true;
    }

    /**
     * @Description: 尾部插入
     * @Param: [data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    @Override
    public boolean add(T data) {
        if(data == null){
            throw new NullPointerException("data can\'t be empty!");
        }
        this.rear.next = new Node<T>(data);
        //更改尾指针指向
        this.rear = this.rear.next;
        return true;
    }

    /**
     * @Description: 根据索引删除节点
     * @Param: [index]
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    @Override
    public T remove(int index) {
        T old = null;
        //包含了头删除或中间删除或尾部删除的情况
        if(index >= 0){
            Node<T> pre = this.headNode;
            int j = 0;
            //查找需要删除位置的前一个节点
            while(pre.next != null && j < index){
                pre = pre.next;
                j++;
            }
            //获取到要删除的节点
            Node<T> r = pre.next;
            if(r != null){
                //获取jiuzh
                old = r.data;
                //如果恰好为尾部节点，则更新 rear 的指向
                if(r == this.rear){
                    this.rear = pre;
                }
                //更改指针指向
                pre.next = r.next;
            }
        }
        return old;
    }

    /**
     * @Description: 根据 data 移除所有数据相同的节点
     * @Param: [data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    @Override
    public boolean removeAll(T data) {
        boolean isRemove = false;
        if(data != null){
            //用于记录要删除节点的前一个节点
            Node<T> front = this.headNode;
            //当前遍历的节点
            Node<T> pre = front.next;
            //查找所有数据相同的节点并删除
            while(pre != null){
                if(data.equals(pre.data)){
                    //如果恰好是尾部节点，则更新 rear 的指向
                    if(data.equals(rear.data)){
                        this.rear = front;
                    }
                    //相等则删除 pre 并更改指针取向
                    front.next = pre.next;
                    pre = front.next;
                    isRemove = true;
                }else{
                    front = pre;
                    pre = pre.next;
                }
            }
        }
        return isRemove;
    }

    /**
     * @Description: 清空链表 
     * @Param: [] 
     * @return: void 
     * @Author: Cc.
     * @Date: 2019/4/6 
     */
    @Override
    public void clear() {
        this.headNode.next = null;
        this.rear = this.headNode;
    }

    /**
     * @Description: 判断是否包含某个值
     * @Param: [data] 
     * @return: boolean 
     * @Author: Cc.
     * @Date: 2019/4/6 
     */
    @Override
    public boolean contains(T data) {
        if(data != null){
            Node<T> pre = this.headNode.next;
            while(pre != null){
                if(data.equals(pre.data)){
                    return true;
                }
            }
            pre = pre.next;
        }
        return false;
    }

    /**
     * @Description: 从末尾连接两个链表
     * @Param: [list]
     * @return: void
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    public void concat(HeadSingleLinkedList<T> list){
        if(this.headNode.next == null){
            this.headNode.next = list.headNode.next;
        }else{
            Node<T> pre = this.headNode.next;
            while(pre.next != null){
                pre = pre.next;
            }
            pre.next = list.headNode.next;
            //更新尾部指针指向
            this.rear = list.rear;
        }
    }

    @Override
    public String toString(){
        String str = "(";
        Node<T> pre = this.headNode.next;
        while(pre != null){
            str += pre.data;
            pre = pre.next;
            if(pre != null){
                str += ",";
            }
        }
        return str+")";
    }

    /*public static void main(String[] args){

        String[] letters={"A","B","C","D","E","F"};
        ILinkedList<String> list=new HeadSingleLinkedList<>(letters);

        System.out.println("list.get(3)->"+list.get(3));
        System.out.println("list:"+list.toString());

        System.out.println("list.add(4,Y)—>"+list.add(4,"Y"));
        System.out.println("list:"+list.toString());
        System.out.println("list.add(Z)—>"+list.add("Z"));
        System.out.println("list:"+list.toString());


        System.out.println("list.contains(Z)->"+list.contains("Z"));
        System.out.println("list.set(4,P)-->"+list.set(4,"P"));
        System.out.println("list:"+list.toString());

        System.out.println("list.remove(Z)->"+list.removeAll("Z"));
        System.out.println("list.remove(4)-->"+list.remove(4));
        System.out.println("list:"+list.toString());
    }*/
}
