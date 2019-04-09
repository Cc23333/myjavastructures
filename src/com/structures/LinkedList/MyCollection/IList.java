package com.structures.LinkedList.MyCollection;

/**
 * @program: myjavastructures
 * @description: 改良List顶级接口
 * @author: Cc.
 * @create: 2019-04-09 15:14
 **/
public interface IList<T> {

    /**
    * @Description: list大小
    * @Param: []
    * @return: int
    * @Author: Cc.
    * @Date: 2019/4/9
    */
    int size();

    /** 
    * @Description: 是否为空
    * @Param: []
    * @return: boolean
    * @Author: Cc.
    * @Date: 2019/4/9
    */ 
    boolean isEmpty();
    
    /** 
    * @Description: 是否包含data
    * @Param: [data]
    * @return: boolean
    * @Author: Cc.
    * @Date: 2019/4/9
    */ 
    boolean contains(T data);
    
    /** 
    * @Description: 清空数据
    * @Param: []
    * @return: void
    * @Author: Cc.
    * @Date: 2019/4/9
    */ 
    void clear();
    
    /** 
    * @Description: 根据index获取数据
    * @Param: [index]
    * @return: T
    * @Author: Cc.
    * @Date: 2019/4/9
    */ 
    T get(int index);
    
    /** 
    * @Description: 替换数据
    * @Param: [index, data]
    * @return: T
    * @Author: Cc.
    * @Date: 2019/4/9
    */ 
    T set(int index, T data);
    
    /** 
    * @Description: 尾部添加数据
    * @Param: [data]
    * @return: boolean
    * @Author: Cc.
    * @Date: 2019/4/9
    */ 
    boolean add(T data);
    
    /** 
    * @Description: 根据index添加数据
    * @Param: [index, data]
    * @return: void
    * @Author: Cc.
    * @Date: 2019/4/9
    */ 
    void add(int index, T data);
    
    /** 
    * @Description: 移除数据
    * @Param: [data]
    * @return: boolean
    * @Author: Cc.
    * @Date: 2019/4/9
    */ 
    boolean remove(T data);
    
    /** 
    * @Description: 根据index移除数据
    * @Param: [index]
    * @return: T
    * @Author: Cc.
    * @Date: 2019/4/9
    */ 
    T remove(int index);
    
    /** 
    * @Description: 根据data获取下标
    * @Param: [data]
    * @return: int
    * @Author: Cc.
    * @Date: 2019/4/9
    */ 
    int indexOf(T data);
    
    /** 
    * @Description: 根据data获取最后一个下标
    * @Param: [data]
    * @return: int
    * @Author: Cc.
    * @Date: 2019/4/9
    */ 
    int lastIndexOf(T data);
}
