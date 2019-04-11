package com.structures.linkedlist;

/**
 * @program: javastructures
 * @description: 顺序表顶级接口
 * @author: Cc.
 * @create: 2019-04-05 19:12
 **/
public interface ISeqList<T> {

    /**
     * @Description: 判断顺序表是否为空
     * @Param: []
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    boolean isEmpty();

    /**
     * @Description: 顺序表长度
     * @Param: []
     * @return: int
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    int length();


    /**
     * @Description: 获取元素
     * @Param: [index]
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    T get(int index);

    /**
     * @Description: 设置某个元素值
     * @Param: [index, data]
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    T set(int index, T data);

    /**
     * @Description: 根据 index 添加元素
     * @Param: [index, data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    boolean add(int index, T data);

    /**
     * @Description: 添加元素
     * @Param: [data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    boolean add(T data);

    /**
     * @Description: 根据 index 移除元素
     * @Param: [index]
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    T remove(int index);

    /**
     * @Description: 根据 data 移除元素
     * @Param: [data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    boolean remove(T data);

    /**
     * @Description: 根据 data 移除元素
     * @Param: [data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    boolean removeAll(T data);

    /**
     * @Description: 清空链表
     * @Param: []
     * @return: void
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    void clear();

    /**
     * @Description: 是否包含 data 元素
     * @Param: [data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    boolean contains(T data);

    /**
     * @Description: 根据值查询下标
     * @Param: [data]
     * @return: int
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    int indexOf(T data);

    /**
     * @Description: 根据 data 值查询最后一个出现在顺序表中的下标
     * @Param: [data]
     * @return: int
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    int lastIndexOf(T data);

    /**
     * @Description: 输出格式
     * @Param: [] 
     * @return: java.lang.String 
     * @Author: Cc.
     * @Date: 2019/4/5 
     */
    @Override
    String toString();
}
