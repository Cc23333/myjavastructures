package com.structures.tree.binarytree;

/**
 * @program: javastructures
 * @description: Tree接口
 * @author: Cc.
 * @create: 2019-04-03 21:06
 **/
public interface Tree<T extends Comparable> {
    /**
     * @Description: 判空
     * @Param: []
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/3
     */
    boolean isEmpty();

    /**
     * @Description: 二叉树节点的个数
     * @Param: []
     * @return: int
     * @Author: Cc.
     * @Date: 2019/4/3
     */
    int size();

    /**
     * @Description: 返回二叉树的高度或者深度，即节点的最大层次
     * @Param: []
     * @return: int
     * @Author: Cc.
     * @Date: 2019/4/3
     */
    int height();

    /**
     * @Description: 先序遍历
     * @Param: []
     * @return: java.lang.String
     * @Author: Cc.
     * @Date: 2019/4/3
     */
    String preOrder();

    /**
     * @Description: 中序遍历
     * @Param: []
     * @return: java.lang.String
     * @Author: Cc.
     * @Date: 2019/4/3
     */
    String inOrder();

    /**
     * @Description: 后序遍历
     * @Param: []
     * @return: java.lang.String
     * @Author: Cc.
     * @Date: 2019/4/3
     */
    String postOrder();

    /**
     * @Description: 层次遍历
     * @Param: []
     * @return: java.lang.String
     * @Author: Cc.
     * @Date: 2019/4/3
     */
    String levelOrder();

    /**
     * @Description: 将 data 插入
     * @Param: [data]
     * @return: void
     * @Author: Cc.
     * @Date: 2019/4/3
     */
    void insert(T data);

    /**
     * @Description: 删除
     * @Param: [data]
     * @return: void
     * @Author: Cc.
     * @Date: 2019/4/3
     */
    void remove(T data);

    /**
     * @Description: 查找最大值
     * @Param: []
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/3
     */
    T findMax();

    /**
     * @Description: 查找最小值
     * @Param: []
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/3
     */
    T findMin();

    /**
     * @Description: 根据值找到节点
     * @Param: [data]
     * @return: BinaryNode
     * @Author: Cc.
     * @Date: 2019/4/3
     */
    BinaryNode findNode(T data);

    /**
     * @Description: 是否包含某个值
     * @Param: [data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/3
     */
    boolean contains(T data) throws Exception;

    /**
     * @Description: 清空
     * @Param: []
     * @return: void
     * @Author: Cc.
     * @Date: 2019/4/3
     */
    void clear();
    
}
