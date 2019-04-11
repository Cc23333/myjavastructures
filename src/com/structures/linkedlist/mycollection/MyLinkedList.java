package com.structures.linkedlist.mycollection;

import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * @program: myjavastructures
 * @description: 改良的双链表（带头节点和尾节点）类似java集合类 linkedlist
 * @author: Cc.
 * @create: 2019-04-10 19:59
 **/
public class MyLinkedList<T> implements Serializable, IList<T>,Iterable<T> {

    private static final long serialVersionUID = 317330972501784786L;

    /**
     * @Description: 链表size,优化计算过程，无需遍历链表
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/10
     */
    protected int size = 0;

    /**
     * @Description: 修改记录符
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/10
     */
    protected int modCount = 0;

    /**
     * @Description: 头部指向节点，不带数据，排除特殊情况，优化代码量
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/10
     */
    protected Node<T> first;

    /**
     * @Description: 尾部指向节点，不带数据，排除特殊情况，优化代码量
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/10
     */
    protected Node<T> last;

    public MyLinkedList(){
        first = new Node<T>(null, null, null);
        last = new Node<T>(first, null, null);
        first.next = last;
        size = 0;
        modCount++;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    /**
     * @Description: 清空数据，GC更容易回收
     * @Param: []
     * @return: void
     * @Author: Cc.
     * @Date: 2019/4/10
     */
    @Override
    public void clear() {
        for(Node<T> x=first.next; x!=null;){
            Node<T> next = x.next;
            x.data = null;
            x.next = null;
            x.pre = null;
            x = next;
        }
        //初始化链表
        first = new Node<T>(null, null, null);
        last = new Node<T>(first, null, null);
        first.next = last;
        size = 0;
        modCount++;
    }

    @Override
    public T get(int index) {
        checkElementIndex(index);
        return getNode(index).data;
    }

    @Override
    public T set(int index, T data) {
        //检测下标是否越界
        checkElementIndex(index);
        Node<T> x = getNode(index);
        T oldVal = x.data;
        x.data = data;
        return oldVal;
    }

    @Override
    public boolean add(T data) {
        linkLast(data);
        return true;
    }

    @Override
    public void add(int index, T data) {
        checkElementIndex(index);
        if(index == size){
            //尾部直接添加
            linkLast(data);
        }else{
            //找到要插入节点并在其前插入
            linkBefore(data, getNode(index));
        }
    }

    @Override
    public boolean remove(T data) {
        if(data == null){
            for(Node<T> x=first.next; x!=null;){
                if(x.data == null){
                    unlink(x);
                    return true;
                }
            }
        }else{
            for(Node<T> x=first.next; x!=null;){
                if(data.equals(x.data)){
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        checkElementIndex(index);
        //移除
        return unlink(getNode(index));
    }

    @Override
    public int indexOf(T data) {
        int index = 0;
        if(data == null){
            //注意起始节点
            for(Node<T> x=first.next; x!=null; x=x.next){
                if(x.data == null){
                    return index;
                }
                index++;
            }
        }else{
            for(Node<T> x=first.next; x!=null; x=x.next){
                if(data.equals(x.data)){
                    return index;
                }
                index++;
            }
        }
        return -1;
    }
    
    @Override
    public int lastIndexOf(T data) {
        int index = size;
        if(data == null){
            for(Node<T> x=last.pre; x!=null; x=x.pre){
                index--;
                if(x.data == null){
                    return index;
                }
            }
        }else{
            for(Node<T> x=last.pre; x!=null; x=x.pre){
                index--;
                if(data.equals(x.data)){
                    return index;
                }
            }
        }
        return -1;
    }

    /**
     * @Description: 删除x节点
     * @Param: [x] 
     * @return: T 
     * @Author: Cc.
     * @Date: 2019/4/10 
     */
    T unlink(Node<T> x){
        x.next.pre = x.pre;
        x.pre.next =x.next;
        size--;
        modCount++;
        return x.data;
    }

    /**
     * @Description: 在succ节点前插入
     * @Param: [T, succ]
     * @return: void
     * @Author: Cc.
     * @Date: 2019/4/10
     */
    void linkBefore(T T, Node<T> succ){
        final Node<T> newNode = new Node<T>(succ.pre, T, succ);
        succ.pre.next = newNode;
        succ.pre = newNode;
        size++;
        modCount++;
    }

    /**
     * @Description: 链表头部添加，由于拥有头节点和尾节点，无需判断插入情况
     * @Param: [data]
     * @return: void
     * @Author: Cc.
     * @Date: 2019/4/10
     */
    private void linkFirst(T data){
        //头节点的下一个节点
        final Node<T> f = first.next;
        final Node<T> newNode = new Node<T>(first, data, f);
        f.pre = newNode;
        first.next = newNode;
        size++;
        modCount++;
    }

    /**
     * @Description: 链表尾部添加，用于拥有头节点和尾节点，无需判断插入情况
     * @Param: [data]
     * @return: void
     * @Author: Cc.
     * @Date: 2019/4/10
     */
    void linkLast(T data){
        //尾部节点的前一个节点
        final Node<T> l = last.next;
        final Node<T> newNode = new Node<T>(l, data, last);
        l.next = newNode;
        last.pre = newNode;
        size++;
        //记录修改
        modCount++;
    }

    Node<T> getNode(int index){
        //如果index小于size的一半，则从头节点开始查找，否则从尾部开始查找(右移2位相当于除以2)
        if(index < (size >> 1)){
            Node<T> x = first.next;
            for(int i=0; i<index; i++){
                x = x.next;
            }
            return x;
        }else{
            Node<T> x = last.pre;
            for(int i=size-1; i>index; i--){
                x = x.pre;
            }
            return x;
        }
    }

    /**
     * @Description: 判断index是否越界
     * @Param: [index]
     * @return: void
     * @Author: Cc.
     * @Date: 2019/4/10
     */
    private void checkElementIndex(int index){
        if(!(index >=0 && index < size)){
            throw new IndexOutOfBoundsException("index" + index + ", size:" + size);
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T>{

        /**
         * @Description: 指向下一个节点的下标
         * @Param:
         * @return:
         * @Author: Cc.
         * @Date: 2019/4/10
         */
        int cursor = 0;

        /**
         * @Description: 当前需要返回节点的下标
         * @Param:
         * @return:
         * @Author: Cc.
         * @Date: 2019/4/10
         */
        int lastRet = -1;

        /**
         * @Description: 用于判断是否集合被修改
         * @Param:
         * @return:
         * @Author: Cc.
         * @Date: 2019/4/10
         */
        int expectedModCount = modCount;
        /**
         * @Description: 是否还有下一个节点
         * @Param: []
         * @return: boolean
         * @Author: Cc.
         * @Date: 2019/4/10
         */
        @Override
        public boolean hasNext(){
            return cursor != size;
        }

        /**
         * @Description: 获取当前节点的值
         * @Param: []
         * @return: T
         * @Author: Cc.
         * @Date: 2019/4/10
         */
        @Override
        public T next(){
            checkForComodification();
            try{
                int i = cursor;
                T next = get(i);
                //指向当前节点
                lastRet = i;
                //更新，指向下一个还未访问的节点
                cursor = i + 1;
                return next;
            }catch (IndexOutOfBoundsException T){
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove(){
            if(lastRet < 0){
                throw new IllegalStateException();
            }
            checkForComodification();
            try{
                MyLinkedList.this.remove(lastRet);
                if(lastRet < cursor){
                    //回撤一位
                    cursor--;
                }
                //复原
                lastRet = -1;
                expectedModCount = modCount;
            }catch (IndexOutOfBoundsException T){
                throw new ConcurrentModificationException();
            }
        }

        /**
         * @Description: 检测是否集合已变更，快速失败机制
         * @Param: []
         * @return: void
         * @Author: Cc.
         * @Date: 2019/4/10
         */
        final void checkForComodification(){
            if(modCount != expectedModCount){
                throw new ConcurrentModificationException();
            }
        }
    }
    public ListIterator<T> listIterator(int index){
        checkElementIndex(index);
        return new ListItr(index);
    }

    /**
     * @Description: 含前后指向的迭代器，支持遍历过程添加元素，删除元素
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/10
     */
    private class ListItr implements ListIterator<T>{
        //指向当前正在被访问的节点
        private Node<T> lastReturned;
        //还未访问的节点
        private Node<T> next;
        //还未被访问的节点下标
        private int nextIndex;
        //用于判断集合是否被修改
        private int expectedModCount = modCount;

        /**
         * @Description: 返回指向传入index的节点
         * @Param: [index]
         * @return:
         * @Author: Cc.
         * @Date: 2019/4/10
         */
        ListItr(int index){
            next = (index == size) ? null : getNode(index);
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public T next() {
            checkForComodification();
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            //当前正在被访问的节点
            lastReturned = next;
            //更新还未被访问的节点
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        /**
         * @Description: 功能和next()一样，但previous()是向前遍历
         * @Param: []
         * @return: T
         * @Author: Cc.
         * @Date: 2019/4/10
         */
        @Override
        public T previous() {
            checkForComodification();
            if(!hasPrevious()){
                throw new NoSuchElementException();
            }
            lastReturned = next = (next == null) ? last.pre : next.pre;
            nextIndex--;
            return lastReturned.data;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            checkForComodification();
            if(lastReturned == null){
                throw new IllegalStateException();
            }
            Node<T> lastNext = lastReturned.next;
            unlink(lastReturned);
            //如果next还未更新，则直接执行lastNext
            if(next == lastReturned){
                next = lastNext;
            }else{
                //如果next已更新，那么nextIndex必定执行了nextIndex++操作了，此时由于删除节点
                //所以必须执行nextIndex--，才能使nextIndex与next相对应
                nextIndex--;
            }
            //复原
            lastReturned = null;
            expectedModCount++;
        }

        @Override
        public void set(T t) {
            if(lastReturned == null){
                throw new IllegalStateException();
            }
            checkForComodification();
            lastReturned.data = t;
        }

        @Override
        public void add(T t) {
            checkForComodification();
            lastReturned = null;
            if(next == null){
                linkLast(t);
            }else{
                linkBefore(t, next);
            }
            nextIndex++;
            expectedModCount++;
        }
        /**
         * @Description: 检测是否集合已变更，快速失败机制
         * @Param: []
         * @return: void
         * @Author: Cc.
         * @Date: 2019/4/10
         */
        final void checkForComodification(){
            if(modCount != expectedModCount){
                throw new ConcurrentModificationException();
            }
        }
    }
    /**
     * @Description: 双向节点类
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/10
     */
    protected static class Node<T>{
        T data;
        Node<T> next;
        Node<T> pre;

        Node(Node<T> pre, T data, Node<T> next){
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }

    /*//测试
    public static void main(String[] args){
        System.out.println("------init-------");
        MyLinkedList<Integer> mylinkeList=new MyLinkedList<>();
        mylinkeList.add(2);
        mylinkeList.add(10);
        mylinkeList.add(1);
        mylinkeList.add(9);
        mylinkeList.add(20);
        mylinkeList.add(555);

        print(mylinkeList);
        System.out.println("------remove(2)-------");
        mylinkeList.remove(2);
        print(mylinkeList);
        System.out.println("------indexOf(10)&set(0,0)-------");
        System.out.println("index-->"+mylinkeList.indexOf(10));
        mylinkeList.set(0,0);
        print(mylinkeList);

        System.out.println("-------------iterator--------------");
        Iterator<Integer> iterator=mylinkeList.iterator();
        while (iterator.hasNext()){
            System.out.println("iterator.next-->"+iterator.next());
        }

        System.out.println("-------------iteratorList--------------");
        ListIterator<Integer> iteratorList=mylinkeList.listIterator(0);
        iteratorList.add(88);
        while (iteratorList.hasNext()){
            System.out.println("iteratorList.next-->"+iteratorList.next());
        }
        iteratorList.add(100);
        System.out.println("-------------iteratorList1.add--------------");
        //使用完后必须重新new
        ListIterator<Integer> iteratorList1=mylinkeList.listIterator(0);
        while (iteratorList1.hasNext()){
            int i=iteratorList1.next();
            if(i==555){
                System.out.println("i==555");
                iteratorList1.remove();
            }else {
                System.out.println("iteratorList.next-->" +i);
            }
        }


        System.out.println("-------------foreach--------------");
        for(Integer data : mylinkeList){
            System.out.println("data-->"+data);
        }

        System.out.println("-------------iterator--------------");
        //抛异常:java.util.ConcurrentModificationException
        //在迭代时删除元素必须使用iterator自身的删除方法,使用mylinkeList的
        //删除方法将会触发快速失败机制
        Iterator<Integer> it = mylinkeList.iterator();
        while (it.hasNext()) {
            mylinkeList.remove(new Integer(100));
            Integer value = it.next();
            if (value==100) {
                System.out.println("该集合含100!");
            }else {
                System.out.println("该集合不含100!");
            }
        }
    }

    public static void print(MyLinkedList mylinkeList){
        for (int i=0;i<mylinkeList.size();i++) {
            System.out.println("i->"+mylinkeList.get(i));
        }
    }*/

}
