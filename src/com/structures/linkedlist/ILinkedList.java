package com.structures.LinkedList;

/**
 * @program: javastructures
 * @description: 链表顶级接口
 * @author: Cc.
 * @create: 2019-04-06 13:20
 **/
public interface ILinkedList<T> {

    /**
     * @Description: 判断链表是否为空
     * @Param: []
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    boolean isEmpty();

    /**
     * @Description: 链表长度
     * @Param: []
     * @return: int
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    int length();

    /**
     * @Description: 获取元素
     * @Param: []
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    T get(int index);

    /**
     * @Description: 设置某个节点的值
     * @Param: [index, data]
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    T set(int index, T data);

    /**
     * @Description: 根据 index 添加节点
     * @Param: [index, data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    boolean add(int index, T data);

    /**
     * @Description: 添加节点
     * @Param: [data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    boolean add(T data);

    /**
     * @Description: 根据 index 移除节点
     * @Param: [index]
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    T remove(int index);

    /**
     * @Description: 根据 data 移除节点
     * @Param: [data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    boolean removeAll(T data);

    /**
     * @Description: 清空链表
     * @Param: []
     * @return: void
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    void clear();

    /**
     * @Description: 是否包含 data 节点
     * @Param: [data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    boolean contains(T data);

    /**
     * @Description: 输出格式
     * @Param: []
     * @return: java.lang.String
     * @Author: Cc.
     * @Date: 2019/4/6
     */
    @Override
    String toString();
}
