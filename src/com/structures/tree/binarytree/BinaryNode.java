package com.structures.tree.binarytree;

import java.io.Serializable;

/**
 * @program: javastructures
 * @description: 树节点BinaryNode
 * @author: Cc.
 * @create: 2019-04-03 21:33
 **/
public class BinaryNode<T extends Comparable> implements Serializable {

    private static final long serialVersionUID = -2780124852399112890L;

    /**
     * @Description: 左节点
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/3
     */
    public BinaryNode<T> left;

    /**
     * @Description: 右节点
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    public BinaryNode<T> right;

    public T data;

    public BinaryNode(T data, BinaryNode left, BinaryNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(T data) {
        this(data, null, null);
    }

    /**
     * @Description: 判断是否为叶子节点
     * @Param: []
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
}
