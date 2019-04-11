package com.structures.Stack;

/**
 * @program: myjavastructures
 * @description: 站接口抽象数据类型
 * @author: Cc.
 * @create: 2019-04-11 10:31
 **/
public interface Stack<T> {
    /**
     * @Description: 栈是否为空
     * @Param: []
     * @return: boolean
     * @Author: Cc.
     * @Date: 19-4-11 上午10:39
     */
    boolean isEmpty();

    /**
     * @Description: data元素入栈
     * @Param: [data]
     * @return: void
     * @Author: Cc.
     * @Date: 19-4-11 上午10:39
     */
    void push(T data);

    /**
     * @Description: 返回栈顶元素，未出栈
     * @Param: []
     * @return: T
     * @Author: Cc.
     * @Date: 19-4-11 上午10:39
     */
    T peek();

    /**
     * @Description: 出栈，返回栈顶元素，同时从栈中移除该元素
     * @Param: []
     * @return: T
     * @Author: Cc.
     * @Date: 19-4-11 上午10:40
     */
    T pop();
}
