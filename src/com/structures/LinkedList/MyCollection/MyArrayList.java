package com.structures.LinkedList.MyCollection;

import java.io.Serializable;
import java.util.Iterator;

/**
 * @program: myjavastructures
 * @description: 改良的顺序表类似Java结合类ArrayList
 * @author: Cc.
 * @create: 2019-04-09 16:32
 **/
public class MyArrayList<T> implements Serializable,IList<T>, Iterable<T> {

    private static final long serialVersionUID = -1600060407413403860L;

    /**
    * @Description: 默认大小
    * @Param:
    * @return:
    * @Author: Cc.
    * @Date: 2019/4/9
    */
    private static final int DEFAULT_CAPACITY = 10;

    /**
    * @Description: 空值数组
    * @Param:
    * @return:
    * @Author: Cc.
    * @Date: 2019/4/9
    */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    private int size;

    /**
    * @Description: 记录修改次数，适用于快速失败机制
    * @Param:
    * @return:
    * @Author: Cc.
    * @Date: 2019/4/9
    */
    private int modCount;

    /**
    * @Description: 存储数据的数据
    * @Param:
    * @return:
    * @Author: Cc.
    * @Date: 2019/4/9
    */
    private T[] elementData;

    public MyArrayList(int initialCapacity){
        if(initialCapacity > 0){
            this.elementData = (T[]) new Object[initialCapacity];
        }else if(initialCapacity == 0){
            this.elementData = (T[])EMPTY_ELEMENTDATA;
        }else{
            throw new IllegalArgumentException("Illegal Capacity:" + initialCapacity);
        }
    }

    public MyArrayList(){
        this.elementData = (T[])new Object[DEFAULT_CAPACITY];
    }

    public void ensureCapacity(int capacity){

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(T data) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T data) {
        return null;
    }

    @Override
    public boolean add(T data) {
        return false;
    }

    @Override
    public void add(int index, T data) {

    }

    @Override
    public boolean remove(T data) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(T data) {
        return 0;
    }

    @Override
    public int lastIndexOf(T data) {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
