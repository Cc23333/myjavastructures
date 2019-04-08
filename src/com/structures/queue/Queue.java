package com.structures.queue;

/**
 * @program: javastructures
 * @description: 队列抽象数据类型
 * @author: Cc.
 * @create: 2019-04-05 17:09
 **/
public interface Queue<T> {
    
    /**
     * @Description: 返回队列的长度 
     * @Param: [] 
     * @return: int 
     * @Author: Cc.
     * @Date: 2019/4/5 
     */
    int size();
    
    /**
     * @Description: 判断队列是否为空 
     * @Param: [] 
     * @return: boolean 
     * @Author: Cc.
     * @Date: 2019/4/5 
     */
    boolean isEmpty();
    
    /**
     * @Description: 入队，添加成功返回 true ，否则返回 false , 可扩容 
     * @Param: [data] 
     * @return: boolean 
     * @Author: Cc.
     * @Date: 2019/4/5 
     */
    boolean add(T data);
    
    /**
     * @Description: offer 方法可插入一个元素，这与 add 方法不同，
     *               该方法只能通过抛出未经检查的异常使添加元素失败。
     *               而不是出现异常的情况，例如在容量固定（有界）的队列中。
     *               NullPointerException:data==null 时抛出
     * @Param: [data] 
     * @return: boolean 
     * @Author: Cc.
     * @Date: 2019/4/5 
     */
    boolean offer(T data);

    /**
     * @Description: 返回对头元素，不执行删除操作，若队列为空，则返回 null
     * @Param: []
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    T peek();

    /**
     * @Description: 返回对头元素，不执行删除操作，若队列为空，抛出异常：NoSuchElemntException
     * @Param: []
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    T element();

    /**
     * @Description: 出队，执行删除操作，返回对头元素，若队列为空，返回 null
     * @Param: []
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    T poll();

    /**
     * @Description: 出队，执行删除操作，若队列为空，抛出异常：NoSuchElementException 
     * @Param: [] 
     * @return: T 
     * @Author: Cc.
     * @Date: 2019/4/5 
     */
    T remove();
    
    /**
     * @Description: 清空队列
     * @Param: [] 
     * @return: void 
     * @Author: Cc.
     * @Date: 2019/4/5 
     */
    void clearQueue();
}
