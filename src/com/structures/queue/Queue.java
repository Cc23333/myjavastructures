package com.structures.Queue;

/**
 * @program: myjavastructures
 * @description: 队列抽象数据类型
 * @author: Cc.
 * @create: 2019-04-11 14:35
 **/
public interface Queue<T> {
    /**
     * @Description: 返回队列的长度 
     * @Param: [] 
     * @return: int 
     * @Author: Cc.
     * @Date: 19-4-11 下午2:36
     */
    int size();
    
    /**
     * @Description: 判断队列是否为空 
     * @Param: [] 
     * @return: boolean 
     * @Author: Cc.
     * @Date: 19-4-11 下午2:36
     */
    boolean isEmpty();
    
    /**
     * @Description: data入队，可扩容 
     * @Param: [data] 
     * @return: boolean 
     * @Author: Cc.
     * @Date: 19-4-11 下午2:37
     */
    boolean add(T data);
    
    /**
     * @Description: offer方法可插入一个元素，这点和add不同
     *                该方法只能通过抛出未经检查的异常使添加元素失败
     *                而不是出现异常情况，例如在容量固定（有界）的队列中
     * @Param: [data] 
     * @return: boolean 
     * @Author: Cc.
     * @Date: 19-4-11 下午2:37
     */
    boolean offer(T data);
    
    /**
     * @Description: 返回队头元素，不执行删除操作，若队列为空，返回null 
     * @Param: [] 
     * @return: T 
     * @Author: Cc.
     * @Date: 19-4-11 下午2:39
     */
    T peek();
    
    /**
     * @Description: 返回队头元素，不执行删除操作，若队列为空，抛出异常：NoSuchElementException 
     * @Param: [] 
     * @return: T 
     * @Author: Cc.
     * @Date: 19-4-11 下午2:40
     */
    T element();
    
    /**
     * @Description: 出队，执行删除操作，返回对头元素，若队列为空，返回null
     * @Param: [] 
     * @return: T 
     * @Author: Cc.
     * @Date: 19-4-11 下午2:41
     */
    T poll();
    
    /**
     * @Description: 出队，执行删除操作，若队列为空，抛出异常：NOSuchElementException 
     * @Param: [] 
     * @return: T 
     * @Author: Cc.
     * @Date: 19-4-11 下午2:42
     */
    T remove();
    
    /**
     * @Description: 清空队列
     * @Param: [] 
     * @return: void 
     * @Author: Cc.
     * @Date: 19-4-11 下午2:53
     */
    void clearQueue();
}
