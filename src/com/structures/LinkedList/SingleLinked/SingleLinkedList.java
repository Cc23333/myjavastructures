package com.structures.LinkedList.SingleLinked;

import com.structures.LinkedList.ILinkedList;

/**
 * @program: javastructures
 * @description: 单链表的实现，不包含独立头节点，不含尾部指针
 * @author: Cc.
 * @create: 2019-04-06 13:28
 **/
public class SingleLinkedList<T> implements ILinkedList<T> {

    /**
     * @Description: 带数据的头节点
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    protected Node<T> head;

    public SingleLinkedList(Node<T> head){
        this.head = head;
    }

    public SingleLinkedList(){

    }

    /**
     * @Description: 传入一个数组，转换成链表
     * @Param: [array]
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    public SingleLinkedList(T[] array){
        this.head = null;
        if(array != null && array.length > 0){
            this.head = new Node<T>(array[0]);
            Node<T> rear = this.head;
            int i = 1;
            while(i < array.length){
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
    public SingleLinkedList(SingleLinkedList<T> list){
        this.head = null;
        if(list != null && list.head != null){
            this.head = new Node<T>(list.head.data);
            Node<T> p = list.head.next;
            Node<T> rear = this.head;
            while(p != null){
                rear.next = new Node<T>(p.data);
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
        return this.head == null;
    }

    /**
     * @Description: 获取链表长度
     * @Param: []
     * @return: int
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    @Override
    public int length() {
        int length = 0;
        Node<T> p = head;
        while(p != null){
            length++;
            p = p.next;
        }
        return length;
    }

    /**
     * @Description: 根据索引 index 获取值
     * @Param: [index]
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    @Override
    public T get(int index) {
        if(this.head != null && index >=0 && index<this.length()){
            int count = 0;
            Node<T> p = this.head;
            while(p != null && count < index){
                p = p.next;
                count++;
            }

            if(p != null){
                return p.data;
            }
        }
        return null;
    }

    /**
     * @Description: 根据索引替换对应节点的 data
     * @Param: [index, data]
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    @Override
    public T set(int index, T data) {
        if(this.head != null && index >=0 && data != null && index<this.length()){
            Node<T> pre = this.head;
            int count = 0;
            while(pre != null && count < index){
                pre = pre.next;
                count++;
            }

            if(pre != null){
                T oldData = pre.data;
                pre.data = data;
                return oldData;
            }
        }
        return null;
    }

    /**
     * @Description: 根据下标添加节点
     *               1.头部插入
     *               2.中间插入
     *               3.尾部插入
     * @Param: [index, data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    @Override
    public boolean add(int index, T data) {
        if(data == null){
            return false;
        }

        //在头部插入
        if(this.head == null || index <=1){
            this.head = new Node<T>(data, this.head);
        }else{
            //在尾部或中间插入
            int count = 0;
            Node<T> front = this.head;
            //找到要插入节点位置的前一个节点
            while(front.next != null && count < index-1){
                front = front.next;
                count++;
            }
            //尾部添加和中间插入属于同种情况，毕竟当 front 为尾节点时 front.next = null
            front.next = new Node<T>(data, front.next);
        }
        return true;
    }

    /**
     * @Description: 默认尾部插入
     * @Param: [data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    @Override
    public boolean add(T data) {
        return add(Integer.MAX_VALUE, data);
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
        if(this.head != null && index >=0 && index <this.length()){
            old = this.head.data;
            this.head = this.head.next;
        }else{
            Node<T> front = this.head;
            int count = 0;

            //查找需要删除节点的前一个节点
            while(front.next != null && count < index-1){
                front = front.next;
                count++;
            }

            //获取到要删除的节点
            Node<T> r = front.next;
            if( r != null){
                //获取旧值
                old = r.data;
                //更改指针指向
                front.next = r.next;
                //释放
                r = null;
            }
        }
        return old;
    }

    /*public T remove(int index){
        T old = null;
        if(this.head != null && index >=0 && index<this.length()){
            //直接删除的是头节点
            if(index == 0){
                old = this.head.data;
                this.head = this.head.next;
            }else{
                Node<T> front = this.head;
                int count = 0;
                //查找需要删除节点的前一个节点
                while(front.next != null && count < index-1){
                    front = front.next;
                    count++;
                }

                if(front.next != null){
                    //获取旧值
                    old = front.next.data;
                    //更改指针指向
                    front.next = front.next.next;
                }
            }
        }
        return old;
    }*/

    /**
     * @Description: 根据 data 移除所有数据形同的节点
     * @Param: [data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    @Override
    public boolean removeAll(T data) {
        boolean isRemove = false;

        if(this.head != null && data != null){
            //如果移除的是头节点
            if(data.equals(this.head.data)){
                this.head = this.head.next;
                isRemove = true;
            }

            Node<T> front = this.head;
            Node<T> pre = front.next;
            //查找所有数据相同的节点并删除
            while(pre != null){
                if(data.equals(pre.data)){
                    front.next = pre.next;
                    pre = front.next;
                    isRemove = true;
                }else {
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
        this.head = null;
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
        if(this.head != null && data !=null){
            Node<T> pre = this.head;
            while(pre != null){
                if(data.equals(head.data)){
                    return true;
                }
                pre = pre.next;
            }
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
    public void concat(SingleLinkedList<T> list){
        if(this.head == null){
            this.head = list.head;
        }else{
            Node<T> pre = this.head;
            while(pre.next != null){
                pre = pre.next;
            }
            pre.next = list.head;
        }
    }

    @Override
    public String toString(){
        String str = "(";
        Node<T> pre = this.head;
        while(pre != null){
            str += pre.data;
            pre = pre.next;
            if(pre != null){
                str += ",";
            }
        }
        return str + ")";
    }

    /*public static void main(String[] args){

        String[] letters={"A","B","C","D","E","F"};
        ILinkedList<String> list=new SingleLinkedList<>(letters);

        System.out.println("list.get(3)->"+list.get(3));
        System.out.println("list:"+list.toString());

        System.out.println("list.add(4,Y)—>"+list.add(4,"Y"));
        System.out.println("list.add(Z)—>"+list.add("Z"));
        System.out.println("list:"+list.toString());


        System.out.println("list.contains(Z)->"+list.contains("Z"));
        System.out.println("list.set(4,P)-->"+list.set(4,"P"));
        System.out.println("list:"+list.toString());


        System.out.println("list.removeAll(Z)->"+list.removeAll("Z"));
        System.out.println("list.remove(4)-->"+list.remove(4));
        System.out.println("list:"+list.toString());
    }*/
}
